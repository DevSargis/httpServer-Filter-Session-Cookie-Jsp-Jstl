package com.onlinsestore.servletsonlinestore.Controller;

import com.onlinsestore.servletsonlinestore.Entity.User;
import com.onlinsestore.servletsonlinestore.Services.UsersService;
import com.onlinsestore.servletsonlinestore.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UsersService usersService = UsersService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        usersService.login(email, password)
                .ifPresentOrElse(
                        user -> onLoginSuccess(user, req, resp),
                        ()-> onLoginFail(resp,req)
        );
    }

    private void onLoginFail(HttpServletResponse response, HttpServletRequest request){
        try {
            response.sendRedirect("/login?error&email="+ request.getParameter("email"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void onLoginSuccess(User user, HttpServletRequest request, HttpServletResponse response){
        try {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
