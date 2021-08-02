<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/addFile" enctype="multipart/form-data" method="post">
    <select multiple="multiple">
        <option value="File1"></option>
    </select>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
