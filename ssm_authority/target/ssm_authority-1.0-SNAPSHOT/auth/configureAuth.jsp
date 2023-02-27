<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
<h1>配置你需要的角色</h1>
<form method="post" action="roleController/saveRoleAuthMapping">
    <c:forEach items="${authList}" var="auth">
        <input type="checkbox" name="aid" value="${auth.aid}">${auth.name}-${auth.path}<br/>
    </c:forEach>
    <input type="hidden" name="rid" value="${rid}">
    <input type="submit" value="提交">
</form>
</body>
</html>
<script src="script/jquery-1.7.2.js"></script>
<script>
    $(function (){
        $("input[name=aid]").val(${aids});
    })
</script>
