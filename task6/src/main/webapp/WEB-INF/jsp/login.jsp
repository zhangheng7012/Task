<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<p style="color:red">${msg}</p><hr>
用户注册<br>
<form action="register" name="user" method="post">
    用户名：<input type="text" name="name" /><br>
    密码：<input type="password" name="password" /><br>
    <input type="submit" value="提交"><br>
</form><hr>

用户登录<br>
<form action="login" name="user" method="post">
    用户名：<input type="text" name="name" /><br>
    密码：<input type="password" name="password" /><br>
    <input type="submit" value="提交"><br>
</form><hr>

</body>
</html>
