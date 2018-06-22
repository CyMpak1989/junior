<%@ page import="ru.job4j.model.User" %>
<%@ page import="ru.job4j.service.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List users</title>
</head>
<body>
<h2><a href="<%=request.getContextPath()%>/create">Add a new user.</a></h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Name</th>
        <th>Email</th>
        <th>Date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <tr>
            <% for (User user : ValidateService.getInstance().findAllValidate()){ %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getCreateDate().getTime()%></td>
        <td>
            <form method="GET" action="<%=request.getContextPath()%>/edit">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <button type="submit">Edit</button>
            </form>
        </td>
        <td>
            <form method="POST" action="<%=request.getContextPath()%>/delete">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <% }%>
    </tr>
</table>
</body>
</html>
