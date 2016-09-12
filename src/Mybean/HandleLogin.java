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
			Class.forName("com.mysql.jdbc.Driver");// 与mysql数据库连接
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String handleString(String s) {// 检查是否为标准输入，字符类型
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
		Connection con = null;// 连接
		PreparedStatement sql = null;// 对象
		Login loginBean = null;// 声明Login

		String backNews = "";
		HttpSession session = request.getSession(true);// 声明session对象
		try {
			loginBean = (Login) session.getAttribute("login");
			if (loginBean == null) {// 空对象的处理
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
		String s = new String(request.getParameter("id"));//判断是教师还是学生
		if (ok == true && logname.equals(loginBean.getLogname())) {// 检查是否已经登陆
			backNews = logname + "已经登录了";
			loginBean.setBackNews(backNews);
		} else {// 如果没有登陆
			String uri = "jdbc:mysql://localhost/distanceteach";
			boolean boo = (logname.length() > 0 && password.length() > 0);
			 
			try {
				con = DriverManager.getConnection(uri, "root", "");//创建连接
				String condition = "";
				if(s.equals("t")){
					condition = "select * from teachers where tid=? and password=?";	
				}
				if(s.equals("s")){
					condition = "select * from students where sid=? and password=?";	
				}
//				String condition = "select * from customer where logname=? and password=?";
				sql = con.prepareStatement(condition);//创建连接语句
				if (boo) {
					sql.setString(1, logname);// 填补问号位置的数据
					sql.setString(2, password);
				}
				ResultSet rs = sql.executeQuery();// 返回结果集，使用条件对象prepareStatement创建的数据库对象
				boolean m = rs.next();// 存在用户信息
				if (m == true) {
					backNews = "登陆成功";
					cn.hhu.Final.usename = logname;
					loginBean.setBackNews(backNews);
					loginBean.setSuccess(true);
					loginBean.setLogname(logname);

				} else {
					backNews = "您的用户名不存在或密码不匹配";
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
				.getRequestDispatcher("showLoginMesst.jsp");// 转发
		dispatcher.forward(request, response);
		}
		if(s.equals("s")){
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("showLoginMesss.jsp");// 转发
			dispatcher.forward(request, response);
			}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
