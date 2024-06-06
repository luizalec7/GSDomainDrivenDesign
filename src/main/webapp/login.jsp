<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="dashboard.jsp" method="post">
    Email: <input type="email" name="email"><br>
    Senha: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
