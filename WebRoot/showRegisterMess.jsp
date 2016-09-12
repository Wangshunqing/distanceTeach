<%@ page language="java" contentType="text/html; charset=utf-8"
   %>
<%@ page import = "Mybean.*" %>
<jsp:useBean id ="register" class="Mybean.Register" scope="request"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href = "style1.css"  type ="text/css" rel="stylesheet" > 
<title>show register infomation</title>
</head>
<body bgcolor="cyan" class = "t">
<center>
<font size=4 color=blue>
<br><h1>恭喜<jsp:getProperty name="register" property="backNews"/></h1>
</font>
<table>
<tr><td>用户名：
</td><td><h3><jsp:getProperty name="register" property="logname"/></h3></td></tr>
<tr><td>密码为：
</td><td><h3><jsp:getProperty name="register" property="password"/></h3></td></tr>
<script type="text/javascript">
setTimeout(function() {
  window.location.href='chooselogin.jsp';
}, 2000);
</script>
</table>
</center>
</body>
</html>