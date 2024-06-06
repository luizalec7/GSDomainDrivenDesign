<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
</head>
<body>
<h1>Cadastro</h1>
<form action="user" method="post">
    <input type="hidden" name="action" value="add">
    Nome: <input type="text" name="name"><br>
    Email: <input type="email" name="email"><br>
    Senha: <input type="password" name="password"><br>
    <input type="submit" value="Cadastrar">
</form>
</body>
</html>