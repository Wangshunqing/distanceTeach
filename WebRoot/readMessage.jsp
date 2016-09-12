<span style="font-size:12px;"><span style="font-size:14px;"><%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@ page contentType="text/html;charset=utf-8"%>  
<%--     <% 
    	String filePath = application.getRealPath("/")+"message/message.txt";
    	StringBuffer count = control.ReaderFile(filePath);
    	
     %> --%>
     
     <head>
     <link rel="stylesheet" href="b.css" type="text/css">
     </head>
     <body>  
    <%  
        //驱动程序名   
        String driverName = "com.mysql.jdbc.Driver";  
        //数据库用户名   
        String userName = "root";  
        //密码   
        String userPasswd = "";  
        //数据库名   
        String dbName = "distanceteach";  
        //表名   
        String tableName = "notification";  
        //联结字符串   
        String url = "jdbc:mysql://localhost/" + dbName + "?user="  
                + userName + "&password=" + userPasswd;  
        Class.forName("com.mysql.jdbc.Driver").newInstance();  
        Connection connection = DriverManager.getConnection(url);  
        Statement statement = connection.createStatement();  
        String sql = "SELECT * FROM " + tableName;  
        ResultSet rs = statement.executeQuery(sql);  
    %>  
    <br>  
	<font size = "5">通知如下：</font>
    <br>  
        
    <table align="left">  
        <tr>  
            <th>  
                <%  
                    out.print("date");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("tid");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("filecontent");  
                %>  
            </th>  
<%--             <th>  
                <%  
                    out.print("班级");  
                %>  
            </th>  --%> 
        </tr>  
  
        <%  
            while (rs.next()) {  
        %>  
        <tr>  
            <td>  
                <%  
                    out.print(rs.getString(1));  
                %>  
            </td>  
            <td>  
                <%  
                    out.print(rs.getString(2));  
                %>  
            </td>  
            <td>  
                <%  
                    out.print(rs.getString(3));  
                %>  
            </td> 
            <br> 
<%--             <td>  
                <%  
                    out.print(rs.getString(4));  
                %>  
            </td>   --%>
        </tr>  
        <%  
            }  
        %>  
    </table>  
    <div align="left">  
<%--         <br> <br> <br>  <br>   <br> <br> 
        <%  
            out.print("数据查询成功，恭喜你");  
        %>   --%>
    </div>  
    <%  
        rs.close();  
        statement.close();  
        connection.close();  
    %>  
</body> 
<%-- <html>
  <body><font size=3>
通知如下: <br>
<%=count%>
<jsp:getProperty name="control" property="fileContent" />
  </font></body>
</html> --%>