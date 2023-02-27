<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0">
    <c:forEach items="${userList}" var="user">
    <tr>
        <td>${user.uid}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.age}</td>
        <td>${user.sex}</td>
        <td><a href="userController/configureRole?uid=${user.uid}">配置角色</a></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
