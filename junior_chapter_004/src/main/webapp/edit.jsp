<%@ page import="ru.job4j.model.User" %>
<%@ page import="ru.job4j.db.UserStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user = UserStore.getInstance().getUserLogin(request.getParameter("login"));%>
<html>
<head>
    <title>Edit user!</title>
</head>
<body>
<form method="POST" action="<%=request.getContextPath()%>/edit">
    <input type="hidden" name="id" value="<%=user.getId()%>">
    Login : <input type="text" name="login" value="<%=user.getLogin()%>">
    Name: <input type="text" name="name" value="<%=user.getName()%>">
    E-mail: <input type="text" name="email" value="<%=user.getEmail()%>">
    <button type="submit">Edit</button>
</form>
<h2><a href="<%=request.getContextPath()%>/list.jsp">Back</a></h2></body>
</body>
</html>
