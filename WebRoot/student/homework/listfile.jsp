<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
    <%@ page import="user.file.ReadFile" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body bgcolor=cyan><font size=2>
<jsp:useBean id="file" class="user.file.ReadFile" scope="session" />
<jsp:setProperty name="file" property="fileDir" param="fileDir" />
<p>该目录下<jsp:getProperty name="file" property="fileDir" />
有如下文件:<br>
<jsp:getProperty name="file" property="listFile" />
<form action="" method=post name=form1>
输入一个文件名字:<input type="text" name="fileName">
<input type=submit value="提交">
</form>
<jsp:setProperty name="file" property="fileName" param="fileName" />
文件：<jsp:getProperty name="file" property="fileName" />
内容如下：<br>
<jsp:getProperty name="file" property="readContent" />
<br>
所有的路径如下：
<jsp:getProperty name="file" property="pathcss" />
<br>
m的值为：
<jsp:getProperty name="file" property="m" />
<A href="selectDir.jsp" >重新选择目录</A>
</font>
</body>
</html>