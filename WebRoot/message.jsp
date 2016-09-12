
<%@ page language="java" contentType="text/html; charset=utf-8"
    %>

    <%@page import="user.file.*" %>
    <jsp:useBean id="ok" class="user.file.WriteFile" scope="session"/>
    <jsp:setProperty name="ok" property="filepath" value="F:/codes/Java/web/MyJsp/WebContent/example/message" />
    <jsp:setProperty name="ok" property="filename" value="message.txt" />
    <jsp:setProperty name="ok" property="fileContent" param="fileContent" />
<html>
<head>
<link rel="stylesheet" href="b.css" type="text/css">

</head>
<body bgcolor=#e4dcdc>
<font size=2>
<h1>输入发布的通知:<h1><br>
<form action="upMessage"  method=post>
<textArea name="fileContent" rows="20%" cols="100%" ></textArea>
<br>
<input type="reset" value="清空">
<input type="submit" value="提交">

</form>
<% if(ok.isSuccess()==true){

/* 	通知发布成功，通知保存目录:
	<jsp:getProperty name="ok" property="filePath" />
	<br>文件名：
	<jsp:getProperty name="ok" property="fileName" />
<} */
ok.setSuccess(false);
response.sendRedirect("success.jsp");

}

%>
</font>

</body>
</html>