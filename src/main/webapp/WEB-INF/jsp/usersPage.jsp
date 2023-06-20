<%@ page import="com.onlinsestore.servletsonlinestore.Services.UsersService" %>
<%@ page import="com.onlinsestore.servletsonlinestore.Entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--In this way we include our header.jsp to java  userPage.jsp--%>
<%@include file="header.jsp"%>
<%@include file="logOut.jsp"%>
<ul>
    <%
        UsersService usersService = UsersService.getInstance();
        List<User> users = usersService.findAllUsers();
        for (User user : users) {
            out.write("<li>" + user.getUserName() + "</li>");
        }
    %>
</ul>
</body>
</html>