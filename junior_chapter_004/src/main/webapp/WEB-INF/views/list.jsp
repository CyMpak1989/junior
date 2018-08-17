<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Форма пользователей</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        #user-table {
            position: center;
            margin-left: 10px;
            margin-right: 10px;
        }

        #user-menu {
            margin-top: 10px;
            margin-left: 10px;
            margin-right: 10px;
        }

        .text {
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div id="user-menu" class="btn-group">
    <div class="btn-group">
        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            Пользователь <span class="caret"></span></button>
        <ul class="dropdown-menu" role="menu">
            <li><a href="${pageContext.servletContext.contextPath}/create">Создать пользователя</a></li>
        </ul>
    </div>
    <form class="btn-group" method="get" action="${pageContext.servletContext.contextPath}/signout">
        <input type="submit" class="btn btn-primary" value="Выход">
    </form>
</div>
<div id="user-table" class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Список пользователей</h3>
    </div>
    <table class="table table-striped table-bordered">
        <thead>
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
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <form method="get" action="${pageContext.servletContext.contextPath}/edit">
                <tr>
                    <td><c:out value="${user.id}"></c:out></td>
                    <td><c:out value="${user.login}"></c:out></td>
                    <td><c:out value="${user.name}"></c:out></td>
                    <td><c:out value="${user.email}"></c:out></td>
                    <td><c:out value="${user.getCreateDate().getTime()}"></c:out></td>
                    <td>
                        <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
                        <button class="btn btn-primary btn-xs" type="submit">Edit</button>
                    </td>
                    <td>
                        <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
                        <button class="btn btn-primary btn-xs" type="submit" formmethod="get"
                                formaction="${pageContext.servletContext.contextPath}/delete">Delete
                        </button>
                    </td>
                    <td>
                        <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
                        <button class="btn btn-primary btn-xs" type="submit" formmethod="get"
                                formaction="${pageContext.servletContext.contextPath}/editrole">Edit role
                        </button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
