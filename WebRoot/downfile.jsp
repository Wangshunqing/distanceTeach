<%@ page contentType="text/html;charset=utf-8" %>
<%-- <%@ page import="user.file.*" %>
<%@ page import="java.io.*" %>
<jsp:useBean id="downFile" class="user.file.DownLoadFile" scope="page"/> --%>
<html><body><p>选择要下载的文件:
 <Form action="downfile" method=post>
<Select name="fileName" >
<Option value="F:/codes/Java/web/MyJsp/WebContent/example/teacher">
example/teacher
<Option value="a.java">a.java
<Option value="b.jsp">b.jsp
</Select>
<INPUT TYPE="submit" value="提交你的选择" name="submit">
</Form>
<%-- <% downFile.setResponse(response);
%>  --%>
<%-- <jsp:setProperty name="downFile" property="fileName" param="fileName"/> --%>
</body></html>

<!-- F:/codes/Java/web/MyJsp/WebContent/ -->




