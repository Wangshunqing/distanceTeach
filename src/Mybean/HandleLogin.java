package Mybean;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import cn.hhu.*;
public class HandleLogin extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");// ��mysql���ݿ�����
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String handleString(String s) {// ����Ƿ�Ϊ��׼���룬�ַ�����
		try {
			byte bb[] = s.getBytes("iso-8859-1");
			s = new String(bb);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return s;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;// ����
		PreparedStatement sql = null;// ����
		Login loginBean = null;// ����Login

		String backNews = "";
		HttpSession session = request.getSession(true);// ����session����
		try {
			loginBean = (Login) session.getAttribute("login");
			if (loginBean == null) {// �ն���Ĵ���
				loginBean = new Login();
				session.setAttribute("login", loginBean);
			}
		} catch (Exception ee) {
			loginBean = new Login();
			session.setAttribute("login", loginBean);
		}
		String logname = request.getParameter("logname").trim();
//		request.getSession().setAttribute("logname", logname);
		String s1 = (String)request.getSession().getAttribute("logname");
		String password = request.getParameter("password").trim();
		boolean ok = loginBean.getSuccess();
		logname = handleString(logname);
		password = handleString(password);
		String s = new String(request.getParameter("id"));//�ж��ǽ�ʦ����ѧ��
		if (ok == true && logname.equals(loginBean.getLogname())) {// ����Ƿ��Ѿ���½
			backNews = logname + "�Ѿ���¼��";
			loginBean.setBackNews(backNews);
		} else {// ���û�е�½
			String uri = "jdbc:mysql://localhost/distanceteach";
			boolean boo = (logname.length() > 0 && password.length() > 0);
			 
			try {
				con = DriverManager.getConnection(uri, "root", "");//��������
				String condition = "";
				if(s.equals("t")){
					condition = "select * from teachers where tid=? and password=?";	
				}
				if(s.equals("s")){
					condition = "select * from students where sid=? and password=?";	
				}
//				String condition = "select * from customer where logname=? and password=?";
				sql = con.prepareStatement(condition);//�����������
				if (boo) {
					sql.setString(1, logname);// ��ʺ�λ�õ�����
					sql.setString(2, password);
				}
				ResultSet rs = sql.executeQuery();// ���ؽ������ʹ����������prepareStatement���������ݿ����
				boolean m = rs.next();// �����û���Ϣ
				if (m == true) {
					backNews = "��½�ɹ�";
					cn.hhu.Final.usename = logname;
					loginBean.setBackNews(backNews);
					loginBean.setSuccess(true);
					loginBean.setLogname(logname);

				} else {
					backNews = "�����û��������ڻ����벻ƥ��";
					loginBean.setBackNews(backNews);
					loginBean.setSuccess(false);
					loginBean.setLogname(logname);
					loginBean.setPassword(password);
				}
				con.close();
			} catch (SQLException exp) {
				backNews = "" + exp;
				loginBean.setBackNews(backNews);
				loginBean.setSuccess(false);
			}
		}
//		String s =new String(request.getParameter("id"));
		if(s.equals("t")){
//			System.out.println(request.getSession().getAttribute("username"));
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("showLoginMesst.jsp");// ת��
		dispatcher.forward(request, response);
		}
		if(s.equals("s")){
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("showLoginMesss.jsp");// ת��
			dispatcher.forward(request, response);
			}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
