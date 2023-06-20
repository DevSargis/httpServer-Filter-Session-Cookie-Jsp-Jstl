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

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private UsersService usersService = UsersService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.getRequestDispatcher(JspHelper.getPath("usersPage")).forward(req, resp);
    }
}
