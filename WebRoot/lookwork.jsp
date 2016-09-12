<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
   <%@page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<link rel="stylesheet" href="b.css" type="text/css">

</head>
<body bgcolor=#e4dcdc>
<font size=4>
提交的作业如下:<br>
<%
File file=new File("F:/codes/Java/web/MyJsp/WebContent/example/student/homework");
String fs[]=file.list();
int i=0;
String s;
out.println("<ul>");
while(i<fs.length){
	s=fs[i];
	out.println("<li><a href=/student/homework"+fs[i]+" download="+fs[i]+"></a>"+fs[i]+"</li>");
	i++;
	
}	

out.println("</ul>");
%>
<!-- <a href="message.jsp" title="通知发布" target="right" >通知发布</a> -->
</font>
</body>
</html>