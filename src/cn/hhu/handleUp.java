package cn.hhu;
import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.junit.Test;
import org.junit.runner.Request;

import java.util.Date;
import java.text.SimpleDateFormat;

public class handleUp extends HttpServlet {
public void init(ServletConfig config)throws ServletException{
	super.init(config);
	try{
		 Class.forName("com.mysql.jdbc.Driver");//与mysql数据库连接
	}
	catch(Exception e){
	System.out.println("10000 com.mysql.jdbc.Driver");
	}
}
public String handleString(String s){//检查是否为标准输入，字符类型
	try{
		byte bb[]=s.getBytes("iso-8859-1");
		s = new String(bb);
	}
	catch(Exception ee){};
	return s;
}

public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	Connection con = null;//连接
	PreparedStatement sql = null;//对象
	
	Uploads up = new Uploads();
	request.setAttribute("uploads",up);	//setArrtibute添加对象，request对话期间内有效
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	String date = df.format(new Date());// new Date()为获取当前系统时间
	String logname = cn.hhu.Final.usename;

	String fileContent = request.getParameter("fileContent").trim();//从message中获得fileContent
	System.out.println("文件内容"+fileContent);
	String uri = "jdbc:mysql://localhost/distanceteach?useUnicode=true&characterEncoding=UTF-8";
	if(logname ==null){//防止出现错误
		logname="";
	}
	if(fileContent ==null){
		fileContent ="";
	}
	boolean isLD = true;
	for(int i = 0;i<logname.length();i++){//判断是否由字母数字组成
		char c = logname.charAt(i);
		if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')))
			isLD = false;
	}
	boolean boo = logname.length()>0&&fileContent.length()>0&&isLD;//判断信息是否合格
	String backNews="";
	try{
		con = DriverManager.getConnection(uri,"root","");//登录数据库
		String insertCondition = "";
			insertCondition = "insert into notification(date,tid,filecontent) values(?,?,?)";				
		sql = con.prepareStatement(insertCondition);  
		int m11 = 0;  //判断数据更新操作是否成功
		if(boo)
		{
			sql.setString(1,date);
			 sql.setString(2,logname);
			 sql.setString(3,fileContent);
			 m11 = sql.executeUpdate();//此句更新数据库
		}
		if(m11!=0){
			backNews = "通知发布成功";
			
			up.setBackNews(backNews);
			up.setLogname(logname);
			up.setFileContent(fileContent);
//			up.setPassword(handleString(password));
		}
		 else{
			backNews = "通知填写不完整或有非法字符";
					up.setBackNews(backNews);
		}
		con.close();
	}
	catch(SQLException exp){
		backNews = "通知发布失败！"+exp;
		up.setBackNews(backNews);
	}
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("message.jsp");//转发
	dispatcher.forward(request,response);

}

public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	request.setCharacterEncoding("utf-8");
	doPost(request,response);
}
}

