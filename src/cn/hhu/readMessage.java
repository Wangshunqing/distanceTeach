package cn.hhu;

import cn.hhu.*; 

import javax.servlet.http.*; 
import javax.servlet.*;

import java.io.*;
public class readMessage extends HttpServlet {
	ServletContext application=this.getServletContext();
	public void init(ServletConfig config)throws
	ServletException
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse 
			response)throws ServletException,IOException
			{
		
				Control cl=new Control();
				request.setAttribute("look",cl);
				//cl.setFilepath(application.getRealPath("/")+"message/message.txt");
				
			}
}
