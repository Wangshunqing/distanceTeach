package Mybean;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class HandleRegister extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");// 与mysql数据库连接
		} catch (Exception e) {
			System.out.println("10000 com.mysql.jdbc.Driver");
		}
	}

	public String handleString(String s) {// 检查是否为标准输入，字符类型
		try {
			byte bb[] = s.getBytes("iso-8859-1");
			s = new String(bb);
		} catch (Exception ee) {
		}
		;
		return s;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;// 连接
		PreparedStatement sql = null;// 对象

		Register reg = new Register();
		request.setAttribute("register", reg); // setArrtibute添加对象，request对话期间内有效
		String logname = request.getParameter("logname").trim();
		String password = request.getParameter("password").trim();// 从register.jsp中获得用户名密码

		String uri = "jdbc:mysql://localhost/distanceteach";

		if (logname == null) {// 防止出现错误
			logname = "";
		}
		if (password == null) {
			password = "";
		}
		boolean isLD = true;
		for (int i = 0; i < logname.length(); i++) {// 判断是否由字母数字组成
			char c = logname.charAt(i);
			if (!((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0')))
				isLD = false;
		}
		boolean boo = logname.length() > 0 && password.length() > 0 && isLD;// 判断注册信息是否合格
		String backNews = "";
		try {
			con = DriverManager.getConnection(uri, "root", "");// 登录数据库
			String s = new String(request.getParameter("id")); // 判断是老师还是学生
			String insertCondition = "";
			if (s.equals("t")) {
				insertCondition = "insert into teachers(tid,password) values(?,?)";
			}
			if (s.equals("s")) {
				insertCondition = "insert into students(sid,password) values(?,?)";
			}
			// String insertCondition = "insert into customer(logname,password) values(?,?)";
			sql = con.prepareStatement(insertCondition);
			int m11 = 0; // 判断数据更新操作是否成功
			if (boo) {
				sql.setString(1, logname);
				sql.setString(2, password);
				m11 = sql.executeUpdate();// 此句更新数据库
			}
			if (m11 != 0) {
				backNews = "注册成功";

				reg.setBackNews(backNews);
				reg.setLogname(logname);
				reg.setPassword(handleString(password));
			} else {
				backNews = "信息填写不完整或有非法字符";
				reg.setBackNews(backNews);
			}
			con.close();
		} catch (SQLException exp) {
			backNews = "该用户名已被使用，请更换用户名" + exp;
			reg.setBackNews(backNews);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("showRegisterMess.jsp");// 转发
		dispatcher.forward(request, response);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
