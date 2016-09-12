<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <title>teacherPage</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
    <div>
<%--     <%session.getAttribute("logname") %> --%>
    <frameset rows="22%,*" border="2">
        <frame name="top" src="top.jsp"  scrolling="auto"  noresize>
            <frameset cols="15%,*">
                <frame name="left" src="left.jsp"  scrolling="auto"  noresize>
                <frame name="right" src="right.jsp"  scrolling="auto"  noresize>
            </frameset>
    </frameset>
    </div>
</html>
