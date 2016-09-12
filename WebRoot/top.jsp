<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
<html xmlns="http://www.w3.org/1999/xhtml">
<section id="portfolio" class="bg-light-gray" >
<body bgcolor=#e4dcdc>
		<link rel="stylesheet" href="basic.css" type="text/css">
 <link rel="stylesheet" href="b.css" type="text/css">
    <title>远程教学平台</title>
   		 <style>
   				 h1{
    					margin:5px auto;
    					text-shadow: 5px 5px 5px #a9a4a4;
   						 }
    
    	 </style>
   
    <div align="right">
<h4><%=session.getAttribute("username")%>
已登陆</h4>
</div>
    <h1 align="center" style ><div style="color:black">远程教学平台</div></h1>
    <div class="search">
 			<ul>
  <li><a href="./Index/index.html" target="_parent" >首页</a></li>
   <li><a href="#">导航1</a></li>
   <li><a href="#">导航2</a></li>
   <li><a href="#">导航3</a></li>
   <li><a href="#">导航4</a></li>
   <li><a href="#">导航5</a></li>
   <li><a href="#">导航6</a></li>
   <li>
   <a   href="./Index/index.html" target="_parent" onclick="<%session.invalidate();%>">退出</a>
   </li>
		 </ul>
</div>




</body>
</section>
</html>

