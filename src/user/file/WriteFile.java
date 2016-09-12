package user.file;
import java.io.*;
import java.util.Date;
public class WriteFile {
	
	String filepath,
	filename,
	fileContent;
	boolean success;
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String s) {
		filepath = s;
		try{
			File path = new File(filepath);
			path.mkdir();
		}
		catch(Exception e){}
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String s) {
		filename = s;
	}
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setFileContent(String s) {
		String s1;
		fileContent = s;
		//char content[]=fileContent.toCharArray();
		
		try{
			s1=new String(fileContent.getBytes("ISO-8859-1"),"utf-8");
			fileContent=s1;
			File file=new File(filepath,filename);
			FileWriter fw=new FileWriter(file,true);
			BufferedWriter bw=new BufferedWriter(fw);
			Date d=new Date();
			String s2;
			s1=d.toString();
			s2=new String(s1.substring(s1.length()-4)+s1.substring(3,10)+":");
			
			//s1=s1.substring(0, 10)+s2+":";
			bw.write(s2+fileContent);
			bw.write("\r\n");
			bw.close();
			fw.close();
			/*RandomAccessFile in = new RandomAccessFile(file, "rw");
			for(int i=0;i<content.length;i++)
			in.writeChar(content[i]);*/
			//in.close();
			success=true;
		}
		catch(Exception e){
			success=false;
		}
	}
	
	
}
