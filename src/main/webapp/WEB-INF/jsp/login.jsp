<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/login", method="post">
      <label for="email">Email:
        <input type="text" name="email" id="email" value="${param.email}" required>
      </label>
      <br>
      <label for="password">password:
        <input type="password" name="password" id="password" required>
      </label>
      <button type="submit">Login</button>
      <a href="${pageContext.request.contextPath}/registration">
        <button type="button">Registration</button>
      </a>
    </form>

    <c:if test="${param.error != null}">
        <div style="color: red">
            <span>Email or password is nor correct</span>
        </div>
    </c:if>
</body>
</html>
