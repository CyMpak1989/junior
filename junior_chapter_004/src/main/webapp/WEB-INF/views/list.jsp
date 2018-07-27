<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List users</title>
</head>
<body>
<h2><a href="${pageContext.servletContext.contextPath}/create">Add a new user.</a></h2>
<form method="get" action="${pageContext.servletContext.contextPath}/signout">
    <input type="submit" value="Выход">
</form>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Name</th>
        <th>Email</th>
        <th>Date</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Edit role</th>
    </tr>
    <tr>
        <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.id}"></c:out></td>
        <td><c:out value="${user.login}"></c:out></td>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td><c:out value="${user.getCreateDate().getTime()}"></c:out></td>
        <td>
            <form method="get" action="${pageContext.servletContext.contextPath}/edit">
                <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
                <button type="submit">Edit</button>
            </form>
        </td>
        <td>
            <form method="post" action="${pageContext.servletContext.contextPath}/delete">
                <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
                <button type="submit">Delete</button>
            </form>
        </td>
        <td>
            <form method="get" action="${pageContext.servletContext.contextPath}/editrole">
                <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
                <button type="submit">Edit role</button>
            </form>
        </td>
    </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
