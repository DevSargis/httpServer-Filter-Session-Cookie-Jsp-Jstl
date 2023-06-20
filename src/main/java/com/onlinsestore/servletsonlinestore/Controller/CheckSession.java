package com.onlinsestore.servletsonlinestore.Controller;

import com.onlinsestore.servletsonlinestore.Entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/checkSession")
public class CheckSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User s = (User) req.getSession().getAttribute("user");
        if(s == null){
            System.out.println("our session is expired or we already do logout");
        }else{
            System.out.println(s.getUserName());
        }
    }
}
