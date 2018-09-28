<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olivier
  Date: 28.09.2018
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>


<form method="post" action="register">
    Username:<br>
    <input type="text" name="username" value="<c:out value="${param.username}"/>" >
    <span>${erreurs['username']}</span>
    <br>
    Password:<br>
    <input type="password" name="password" value="<c:out value="${param.password}"/>" >
    <span>${erreurs['password']}</span>
    <br>
    Mail:<br>
    <input type="text" name="mail" value="<c:out value="${param.mail}"/>" >
    <span>${erreurs['mailEmpty']}</span>
    <span>${erreurs['mailIncorrect']}</span>
    <br><br>
    <input type="submit" value="Register">
    <br><br>
    <span>${erreurs['status']}</span>
</form>


</body>
</html>
