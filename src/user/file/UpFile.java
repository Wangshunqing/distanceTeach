package user.file;
import java.io.*;   
import javax.servlet.http.*;

public class UpFile {
	HttpServletRequest request;
	HttpSession session;
	String upFileMessage="";
	StringBuffer sb=new StringBuffer();
	public void setRequest(HttpServletRequest request){
		this.request=request;
	}
	public void setSession(HttpSession session){
		this.session=session;
	}
	public String getUpFileMessage()
	{
		String fileName=null;
		try{
			String tempFileName=(String)session.getId();
			File fl=new File("D:/webWorkspace/distanceTeach4/WebRoot/teacher","tempFileName");
			FileOutputStream o=new FileOutputStream(fl);
			
			InputStream in=request.getInputStream();
			byte []b=new byte[10000];
			int n;
			while((n=in.read(b))!=-1){
				o.write(b,0,n);
			}
			o.close();
			in.close();
			RandomAccessFile random=new RandomAccessFile(fl,"r");
			random.seek(0);
			String s0;
			while((s0=random.readLine())!=null){
				sb.append(s0+"<br>");
			}
			random.seek(0);
			int second=1;
			String secondLine=null;
			while(second<=2)
			{
				secondLine=random.readLine();
				second++;
			}
			int position=secondLine.lastIndexOf("\"");
			fileName=secondLine.substring(0,position);
			position=fileName.lastIndexOf("\"");
			fileName=secondLine.substring(position+1,fileName.length());
			byte []cc=fileName.getBytes("ISO-8859-1");
			fileName=new String(cc,"utf-8");
			session.setAttribute("Name",fileName);
			random.seek(0);
			long forthEndPosition=0;
			int forth=1;
			while((n=random.readByte())!=-1&&(forth<=4)){
				if(n=='\n'){
					forthEndPosition=random.getFilePointer();
					forth++;
				}
			}
			File f2=new File("D:/webWorkspace/distanceTeach4/WebRoot/teacher",fileName);
			RandomAccessFile random2=new RandomAccessFile(f2,"rw");
			random.seek(random.length());
			long endPosition=random.getFilePointer();
			long mark=endPosition;
			int j=1;
			while((mark>=0)&&(j<=6)){
				mark--;
				random.seek(mark);
				n=random.readByte();
				if(n=='\n'){
					endPosition=random.getFilePointer();
					j++;
				}		
			}
			random.seek(forthEndPosition);
			long startPoint=random.getFilePointer();
			while(startPoint<endPosition-1){
				n=random.readByte();
				random2.write(n);
				startPoint=random.getFilePointer();
			}
			random2.close();
			random.close();
			fl.delete();
			upFileMessage="文件上传成功";
			return upFileMessage;
			
		}
		catch(Exception exp){
			if(fileName!=null){
				upFileMessage=fileName+" Fail to Upload";
				return upFileMessage;
			}
			else{
				upFileMessage="";
				return upFileMessage;
			}
		}

		
	}
	public StringBuffer getSb(){
		return sb;
	}
}
