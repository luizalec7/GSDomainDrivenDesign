<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Address</title>
</head>
<body>
<h1>Address Details</h1>
<p>CEP: ${address.cep}</p>
<p>Street: ${address.logradouro}</p>
<p>Neighborhood: ${address.bairro}</p>
<p>City: ${address.localidade}</p>
<p>State: ${address.uf}</p>
<a href="users">Back to Users</a>
</body>
</html>