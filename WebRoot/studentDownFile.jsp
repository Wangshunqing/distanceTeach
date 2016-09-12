<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="user.file.*" %>
<%@ page import="java.io.*" %>
<jsp:useBean id="downFile" class="user.file.DownLoad" scope="page"/>

<html>
<head>
<link rel="stylesheet" href="b.css" type="text/css">
</head>
<body><p>选择要下载的文件：
<Form action="">
<Select name="fileName" >
<%
File file=new File("D:/webWorkspace/distanceTeach4/WebRoot/teacher");//文件路径
String fs[]= file.list();
int i=0;
while(i<fs.length){
	out.println("<Option value="+fs[i]+">"+fs[i]);
	i++;
}

%>
</Select>
<INPUT TYPE="submit" value="提交你的选择" name="submit">
</Form>
<% downFile.setResponse(response);
%>
<jsp:setProperty name="downFile" property="fileName" param="fileName"/>
</body></html>
