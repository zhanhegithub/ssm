<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
<h1>配置你需要的角色</h1>
<form method="post" action="userController/saveUserRoleMapping">
    <c:forEach items="${roleList}" var="role">
        <input type="checkbox" name="rid" value="${role.rid}">${role.rolename}<br/>
    </c:forEach>
    <input type="hidden" name="uid" value="${uid}">
    <input type="submit" value="提交">
</form>
</body>
</html>
<script src="script/jquery-1.7.2.js"></script>
<script>
    $(function (){
        $("input[name=rid]").val(${rids});
    })
</script>
