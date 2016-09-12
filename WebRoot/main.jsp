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
<div align="right"> 
<font color = yellow >
<form action = "helpExitLogin">
<div style="margin-left:1120px; margin-top:5px; position:absolute;"><input type = submit value = "退出"></div>
</form>

<h4><%=session.getAttribute("username") %>
已登陆</h4>
</font>
</div>
</body>
</html>