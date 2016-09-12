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
		 Class.forName("com.mysql.jdbc.Driver");//��mysql���ݿ�����
	}
	catch(Exception e){
	System.out.println("10000 com.mysql.jdbc.Driver");
	}
}
public String handleString(String s){//����Ƿ�Ϊ��׼���룬�ַ�����
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
	Connection con = null;//����
	PreparedStatement sql = null;//����
	
	Uploads up = new Uploads();
	request.setAttribute("uploads",up);	//setArrtibute��Ӷ���request�Ի��ڼ�����Ч
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	String date = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
	String logname = cn.hhu.Final.usename;

	String fileContent = request.getParameter("fileContent").trim();//��message�л��fileContent
	System.out.println("�ļ�����"+fileContent);
	String uri = "jdbc:mysql://localhost/distanceteach?useUnicode=true&characterEncoding=UTF-8";
	if(logname ==null){//��ֹ���ִ���
		logname="";
	}
	if(fileContent ==null){
		fileContent ="";
	}
	boolean isLD = true;
	for(int i = 0;i<logname.length();i++){//�ж��Ƿ�����ĸ�������
		char c = logname.charAt(i);
		if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')))
			isLD = false;
	}
	boolean boo = logname.length()>0&&fileContent.length()>0&&isLD;//�ж���Ϣ�Ƿ�ϸ�
	String backNews="";
	try{
		con = DriverManager.getConnection(uri,"root","");//��¼���ݿ�
		String insertCondition = "";
			insertCondition = "insert into notification(date,tid,filecontent) values(?,?,?)";				
		sql = con.prepareStatement(insertCondition);  
		int m11 = 0;  //�ж����ݸ��²����Ƿ�ɹ�
		if(boo)
		{
			sql.setString(1,date);
			 sql.setString(2,logname);
			 sql.setString(3,fileContent);
			 m11 = sql.executeUpdate();//�˾�������ݿ�
		}
		if(m11!=0){
			backNews = "֪ͨ�����ɹ�";
			
			up.setBackNews(backNews);
			up.setLogname(logname);
			up.setFileContent(fileContent);
//			up.setPassword(handleString(password));
		}
		 else{
			backNews = "֪ͨ��д���������зǷ��ַ�";
					up.setBackNews(backNews);
		}
		con.close();
	}
	catch(SQLException exp){
		backNews = "֪ͨ����ʧ�ܣ�"+exp;
		up.setBackNews(backNews);
	}
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("message.jsp");//ת��
	dispatcher.forward(request,response);

}

public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	request.setCharacterEncoding("utf-8");
	doPost(request,response);
}
}

