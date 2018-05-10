<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User ?</title>
</head>
<body>
<h3> Do you want to remove user ID = <%=request.getParameter("id")%> ?</h3>
<br>
<table>
    <tr>
        <td>
            <form method="POST" action="<%=request.getContextPath()%>/delete">
                <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
                <button type="submit">Yes</button>
            </form>
        </td>
        <td>
            <form method="GET" action="<%=request.getContextPath()%>/list.jsp">
                <button type="submit">No</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
