<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>

<a href="bookController/findBook">查询图书</a>
<a href="bookController/saveBook">添加图书</a>
<a href="goodController/findGood">查询商品</a>
<a href="goodController/deleteGood">删除商品</a>
<a href="bookController/updateBook">修改图书</a>
<a href="bookController/deleteBook">删除图书</a>
<a href="goodController/saveGood">添加商品</a>
<a href="goodController/updateGood">修改商品</a>
</body>
</html>
