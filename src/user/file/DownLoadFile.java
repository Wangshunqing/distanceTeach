package user.file;
import java.io.*;   
import javax.servlet.http.*;
import javax.servlet.*;
public class DownLoadFile extends HttpServlet
{
	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		String s=request.getParameter("fileName");
		File file=new File(s);
		String  []fs=file.list();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<p>选择要下载的文件:");
		out.println("<Form action=\"\">");
		out.println("<Select name=\"fileName\" >");
		int i=0;
		while(i<fs.length){
			out.println("<Option value="+fs[i]+">"+fs[i]);
			i++;
		}
		out.println("<Select>");
		out.println("</Form>");
		out.println("</body></html>");
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
			{
		doPost(request,response); 
			}
/*HttpServletResponse response;
String fileName;
public void setResponse(HttpServletResponse response)
{ this.response=response;
}
public String getFileName()
{ return fileName;}
public void setFileName(String s)
{ fileName=s;
File fileLoad=new File("f:/2000",fileName);
response.setHeader("Content-disposition","attachment;filename="+fileName);
try{
FileInputStream in=new FileInputStream(fileLoad);
OutputStream out=response.getOutputStream();
byte[] buffer=new byte[1024];
int n=-1;
while((n=in.read(buffer))!=-1)
out.write(buffer,0,n);
out.close();
in.close();
}
catch(Exception e){}
}*/
}