<%@ page language="java" contentType="text/html; charset=utf-8" %>
    <head>
   <title> studentPage</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<html>
    <div>
    <frameset rows="20%,*" border="2">
        <frame name="top" src="top.jsp"  scrolling="auto"  noresize>
            <frameset cols="15%,*">
                <frame name="left" src="studentLeft.jsp"  scrolling="auto"  noresize>
                <frame name="right" src="studentRight.jsp"  scrolling="auto"  noresize>
            </frameset>
    </frameset>
    </div>
</html>