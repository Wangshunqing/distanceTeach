<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
   
    <%@page import="user.file.*"  %>
    <jsp:useBean id="upFile" class="user.file.UpFile" scope="session" />
<html>
<head>
<link rel="stylesheet" href="b.css" type="text/css">
</head>
<body bgcolor=#e4dcdc>
<p>选择要发布的课件:<br>
<form action="" method="post" ENCTYPE="multipart/form-data">
<input  type="file" name="boy" size="5">
<p><br><input type="submit" name="g" value="提交">
</form>
<%
upFile.setRequest(request);
upFile.setSession(session);
%> 
<jsp:getProperty name="upFile" property="upFileMessage" />
</body>
</html> 