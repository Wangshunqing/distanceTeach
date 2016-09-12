package Mybean;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class HandleRegister extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");// ��mysql���ݿ�����
		} catch (Exception e) {
			System.out.println("10000 com.mysql.jdbc.Driver");
		}
	}

	public String handleString(String s) {// ����Ƿ�Ϊ��׼���룬�ַ�����
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
		Connection con = null;// ����
		PreparedStatement sql = null;// ����

		Register reg = new Register();
		request.setAttribute("register", reg); // setArrtibute��Ӷ���request�Ի��ڼ�����Ч
		String logname = request.getParameter("logname").trim();
		String password = request.getParameter("password").trim();// ��register.jsp�л���û�������

		String uri = "jdbc:mysql://localhost/distanceteach";

		if (logname == null) {// ��ֹ���ִ���
			logname = "";
		}
		if (password == null) {
			password = "";
		}
		boolean isLD = true;
		for (int i = 0; i < logname.length(); i++) {// �ж��Ƿ�����ĸ�������
			char c = logname.charAt(i);
			if (!((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0')))
				isLD = false;
		}
		boolean boo = logname.length() > 0 && password.length() > 0 && isLD;// �ж�ע����Ϣ�Ƿ�ϸ�
		String backNews = "";
		try {
			con = DriverManager.getConnection(uri, "root", "");// ��¼���ݿ�
			String s = new String(request.getParameter("id")); // �ж�����ʦ����ѧ��
			String insertCondition = "";
			if (s.equals("t")) {
				insertCondition = "insert into teachers(tid,password) values(?,?)";
			}
			if (s.equals("s")) {
				insertCondition = "insert into students(sid,password) values(?,?)";
			}
			// String insertCondition = "insert into customer(logname,password) values(?,?)";
			sql = con.prepareStatement(insertCondition);
			int m11 = 0; // �ж����ݸ��²����Ƿ�ɹ�
			if (boo) {
				sql.setString(1, logname);
				sql.setString(2, password);
				m11 = sql.executeUpdate();// �˾�������ݿ�
			}
			if (m11 != 0) {
				backNews = "ע��ɹ�";

				reg.setBackNews(backNews);
				reg.setLogname(logname);
				reg.setPassword(handleString(password));
			} else {
				backNews = "��Ϣ��д���������зǷ��ַ�";
				reg.setBackNews(backNews);
			}
			con.close();
		} catch (SQLException exp) {
			backNews = "���û����ѱ�ʹ�ã�������û���" + exp;
			reg.setBackNews(backNews);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("showRegisterMess.jsp");// ת��
		dispatcher.forward(request, response);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
