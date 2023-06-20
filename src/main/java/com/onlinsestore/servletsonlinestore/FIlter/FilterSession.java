package com.onlinsestore.servletsonlinestore.FIlter;

import com.onlinsestore.servletsonlinestore.Entity.User;
import com.onlinsestore.servletsonlinestore.util.JspHelper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//This filter work every time when we send some request and it is check if I have user in my session I forward to next page, if no I redirect to /login
@WebFilter("/*")
public class FilterSession implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestedUrl = request.getRequestURI();

        if (requestedUrl.equals("/login")) {
            // Skip the filter for the /login URL
            filterChain.doFilter(request, response);
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(request, response);
        } else {
            request.getRequestDispatcher(JspHelper.getPath("login")).forward(request, response);
        }
    }
}