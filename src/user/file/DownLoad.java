package user.file;
import java.io.*;  
import javax.servlet.http.*;
public class DownLoad
{
HttpServletResponse response;
String fileName;
public void setResponse(HttpServletResponse response)
{ this.response=response;
}
public String getFileName()
{ return fileName;}
public void setFileName(String s)
{
	
fileName=s;
File fileLoad=new File("D:/webWorkspace/distanceTeach4/WebRoot/teacher",fileName);
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
}
}