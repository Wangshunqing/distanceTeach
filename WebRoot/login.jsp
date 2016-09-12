<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href = "style1.css"  type ="text/css" rel="stylesheet" > 
</head>
<body>
<form action = "helpLogin" method = "post"  class="t">
<table border = 1  >
<tr><th><h3>请您登录</h3></th></tr>
<tr><td>登录名称: <input type = text name = "logname"></td></tr>
<tr><td>输入密码: <input type = password name = "password"></td></tr>
</table>
<br><input  type = submit name= "g" value = "登录">
<input type = button name="" value= "注册" onclick="javascript:top.location.href='register.jsp'"/>
</form>
</font>
</body>
</html>