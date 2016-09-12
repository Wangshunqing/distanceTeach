
<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
        <%@page import="user.file.*"  %>
    <jsp:useBean id="up" class="user.file.studentUpfile" scope="session" />
    <jsp:useBean id="ok" class="user.file.WriteFile" scope="session"/>
    <jsp:setProperty name="ok" property="filepath" value="D:/webWorkspace/distanceTeach4/WebRoot/student/homework" />
    <jsp:setProperty name="ok" property="filename" value="homework.txt" />
    <jsp:setProperty name="ok" property="fileContent" param="fileContent" />
<html>
<head>
<link rel="stylesheet" href="b.css" type="text/css">

</head>
<body bgcolor=#e4dcdc>
<font size=2>
<h2>写作业:<h2><br>
<form action=""  method=post>
<textArea name="fileContent" rows="15%" cols="100%" ></textArea>
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
response.sendRedirect("success1.jsp");

}

%>

<p>选择要提交的作业:<br>
<form action="" method="post" ENCTYPE="multipart/form-data">
<input  type="file" name="boy" size="5" >
<br><input type="submit" name="g" value="提交">
</form>
<%
up.setRequest(request);
up.setSession(session);
%> 
<jsp:getProperty name="up" property="upFileMessage" />

</font>

</body>
</html>