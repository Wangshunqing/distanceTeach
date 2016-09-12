<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<link rel="stylesheet" href="b.css" type="text/css">
</head>
<html>

<body bgcolor=cyan>
<%
Enumeration enum1=session.getAttributeNames();
while(enum1.hasMoreElements()){
	String key=(String)enum1.nextElement();
	String fileName=(String)session.getAttribute(key);
	out.println(fileName);
	session.removeAttribute(key);
	
}

%>
</body> 
</html>