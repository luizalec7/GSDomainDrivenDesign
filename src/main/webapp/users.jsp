<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>
<h2>Create User</h2>
<form action="users" method="post">
    <input type="hidden" name="action" value="create">
    Username: <input type="text" name="username"><br>
    Email: <input type="text" name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Create">
</form>
</body>
</html>