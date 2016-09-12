<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
   <%@page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<link rel="stylesheet" href="b.css" type="text/css">
   <!--  <style>
        a:link {
            color:#e6e0e0;
            text-decoration:none;

        }
        a:hover {
        color:black;
        text-decoration:none;
        }
      
        a:active {
        color:#050505;
        text-decoration:none;
        }
       a:visited {
            color:black;
            text-decoration:none;
        }
        
    </style> -->
</head>
<body bgcolor=#e4dcdc>
<font size=4>
提交的作业如下:<br>
<%
File file=new File("D:/webWorkspace/distanceTeach4/WebRoot/student/homework");
String fs[]=file.list();
int i=0;
String s;
String s1;
out.println("<ul>");
int k=0;
while(i<fs.length){
/* 	s1=new String(fs[i].getBytes("ISO-8859-1"),"");
	fs[i]=s1; */
	k=fs[i].lastIndexOf(".");
	if(k!=-1)
	s=new String(fs[i].substring(0,k));
	else{
		s=new String(fs[i]);
	}
	if((!fs[i].equals("lookwork.jsp"))&&(!fs[i].equals("b.css"))&&(!fs[i].equals("2.jpg")))
	out.println("<li><a href="+fs[i]+" download="+s+">"+ fs[i]+ "</a></li>" );
	
	
	
	
	i++;
	
}	

out.println("</ul>");
%>
<!-- <a href="message.jsp" title="通知发布" target="right" >通知发布</a> -->
</font>
</body>
</html>