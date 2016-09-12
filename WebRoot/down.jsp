<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="user.file.*" %>
<%@ page import="java.io.*" %>
<jsp:useBean id="downFile" class="user.file.DownLoad" scope="page"/>
<html><body><p>选择要下载的文件：
<Form action="">
<Select name="fileName" >
<Option value="book.zip">book.zip
<Option value="a.java">a.java
<Option value="b.jsp">b.jsp
</Select>
<INPUT TYPE="submit" value="提交你的选择" name="submit">
</Form>
<% downFile.setResponse(response);
%>
<jsp:setProperty name="downFile" property="fileName" param="fileName"/>
</body></html>






