<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Weather</title>
</head>
<body>
<h1>Weather Details</h1>
<p>City: ${weather.name}</p>
<p>Temperature: ${weather.main.temp} K</p>
<p>Weather: ${weather.weather[0].description}</p>
<a href="users">Back to Users</a>
</body>
</html>