package Mybean;

public class Login {
	String logname, password, backNews = "";
	boolean success = false;// 初始化为无人登陆

	public String getLogname() {
		 return logname;
	} 

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBackNews() {
		return backNews;
	}

	public void setBackNews(String backNews) {
		this.backNews = backNews;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean seccess) {
		this.success = seccess;
	}

}
