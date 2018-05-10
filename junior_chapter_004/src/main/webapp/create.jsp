<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user!</title>
</head>
<body>
<form method="POST" action="<%=request.getContextPath()%>/create">
    Login:
    <input type="text" name="login">
    Name:
    <input type="text" name="name">
    E-mail:
    <input type="text" name="email">
    <button type="submit">Create</button>
</form>
<h2><a href="<%=request.getContextPath()%>/list.jsp">Back</a></h2>
</body>
</html>
