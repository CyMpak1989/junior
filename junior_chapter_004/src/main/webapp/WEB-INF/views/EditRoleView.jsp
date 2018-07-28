<%--
  Created by IntelliJ IDEA.
  User: CyMpak
  Date: 27.07.2018
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit user role.</title>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/editrole">
    <select name="update_role">
        <c:forEach items="${allRole}" var="type">
            <c:if test="${type.key == role}">
                <option selected value="${type.key}">${type.value}</option>
            </c:if>
            <c:if test="${type.key != role}">
                <option value="${type.key}">${type.value}</option>
            </c:if>
        </c:forEach>
    </select>
    <input type="hidden" name="id" value="${id}">
    <br><br>
    <input type="submit" value="Изменить роль">
</form>
</body>
</html>
