<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
<h1 style="text-align: center">权限管理</h1>
<a href="javascript:void(0)" onclick="jump('userController/findAll')">用户管理</a>
<a href="javascript:void(0)" onclick="jump('roleController/findAll')">角色管理</a>
<a href="javascript:void(0)" onclick="jump('authController/findAll')">权限管理</a>
<hr>
<iframe id="fid" scrolling="no" style="background: lavender" width="100%" height="100%" frameborder="0"></iframe>
</body>
</html>
<script>
    function jump(path){
        var frameobj = document.getElementById("fid");
        frameobj.src = path;
    }
</script>
