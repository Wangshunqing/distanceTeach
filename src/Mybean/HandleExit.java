package Mybean;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class HandleExit extends HttpServlet
{  private ServletRequest request;
public void init(ServletConfig config) throws ServletException
	{ super.init(config);}
	public String handleString(String s)
	{ try{ byte bb[]=s.getBytes("iso-8859-1");
		s=new String(bb);}  
	catch(Exception ee){}
	return s;
	}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{ HttpSession session=request.getSession(true);
Login login=(Login)session.getAttribute("login"); 
//获取用户登陆时的Javabean
//boolean ok=true;
//if(login==null)
//{ ok=false;
//	response.sendRedirect("login.jsp");
//}
//if(ok==true)
//{  continueDopost(request,response);
//	}

session.invalidate();
RequestDispatcher dispatcher = 
request.getRequestDispatcher("./Index/index.html");// 转发
dispatcher.forward(request, response);
}

//public void continueDopost(HttpServletRequest request,HttpServletResponse response)
//		throws ServletException,IOException
//{ HttpSession session=request.getSession(true);
//session.invalidate();
//RequestDispatcher dispatcher = 
//request.getRequestDispatcher("login.jsp");// 转发
//dispatcher.forward(request, response);
//response.sendRedirect("main.jsp");
//response.sendRedirect("login.jsp");
//}


public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{doPost(request,response);}
}















