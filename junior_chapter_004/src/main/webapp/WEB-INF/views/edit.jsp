<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit user!</title>
</head>
<body>
<form method="POST" action="${pageContext.servletContext.contextPath}/edit">
    <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
    Login : <input type="text" name="login" value="<c:out value="${user.login}"></c:out>">
    Name : <input type="text" name="name" value="<c:out value="${user.name}"></c:out>">
    E-mail : <input type="text" name="email" value="<c:out value="${user.email}"></c:out>">
    Password : <input type="text" name="email" value="<c:out value="${user.password}"></c:out>">
    <button type="submit">Edit</button>
</form>
<h2><a href="${pageContext.servletContext.contextPath}/list">Back</a></h2></body>
</body>
</html>
