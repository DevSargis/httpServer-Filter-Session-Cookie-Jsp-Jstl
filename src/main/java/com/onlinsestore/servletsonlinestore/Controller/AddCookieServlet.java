package com.onlinsestore.servletsonlinestore.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/addCookie")
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies(); //get all cookies on request
//        add cookies to the request
        var cookie = new Cookie("Sargis", "1");
        cookie.setPath("/login");
        cookie.setMaxAge(15*60);
        resp.addCookie(cookie);
    }
}
