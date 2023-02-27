<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
${msg}
    <form method="post" action="bookController/login">
        用户名<input type="text" name="username"><br/>
        密码<input type="text" name="password"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
