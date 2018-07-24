<%--
  Created by IntelliJ IDEA.
  User: CyMpak
  Date: 24.07.2018
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${error !=''}">
    <div style="background-color: red">
        <c:out value="${error}"></c:out>
    </div>
</c:if>
<form method="POST" action="${pageContext.servletContext.contextPath}/signin">
    Login : <input type="text" name="login"><br/>
    Password : <input type="password" name="password"><br/>
    <input type="submit">
</form>
</body>
</html>
