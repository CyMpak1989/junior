<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user!</title>
</head>
<body>
<form method="POST" action="${pageContext.servletContext.contextPath}/create">
    Login : <input type="text" name="login">
    Name : <input type="text" name="name">
    E-mail : <input type="text" name="email">
    Password : <input type="password" name="password">
    <button type="submit">Create</button>
</form>
<h2><a href="${pageContext.servletContext.contextPath}/list">Back</a></h2>
</body>
</html>
