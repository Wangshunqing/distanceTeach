<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import ="Mybean.Login" %>
<jsp:useBean id ="login" class="Mybean.Login" scope = "session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href = "style1.css"  type ="text/css" rel="stylesheet" > 
</head>
<body bgcolor = yellow class="t">
<center>
<font size = 4 color = blue >
<br><h1><jsp:getProperty name="login" property = "backNews"/></h1>
</font></center>
<%if(login.getSuccess()==true) {%>
<br><h3>登录用户名称：<jsp:getProperty name = "login" property = "logname"/></h3>
<%
String s=login.getLogname();%>

<%session.setAttribute("username",s); %>
<script type="text/javascript">
setTimeout(function() {
  window.location.href='main.jsp';
}, 3000);
</script>

<%}
else{%>
<br>登录用户名称：<jsp:getProperty name = "login" property = "logname"/>
<br>登录会员密码：<jsp:getProperty name = "login" property = "password"/>
<%} %>

</body>
</html>