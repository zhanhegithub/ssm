<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0">
    <c:forEach items="${roleList}" var="role">
        <tr>
            <td>${role.rid}</td>
            <td>${role.rolename}</td>
            <td><a href="roleController/configureAuth?rid=${role.rid}">配置权限</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
