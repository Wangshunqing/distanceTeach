package user.file;
import java.io.*;
public class ReadFile {

	String fileDir="F:/",fileName="";
	String listFile,readContent;
	
	public String getFileDir() {
		return fileDir;
	}
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
		
	}
	


	StringBuffer pathcss=new StringBuffer();
	public StringBuffer getPathcss() {
		File dir=new File(fileDir);
		File file_name[]=dir.listFiles();
		for(int i=0;i<file_name.length;i++)
			if((file_name[i]!=null)&&(file_name[i].isFile()))
			pathcss.append("<br>"+file_name[i].toString());
		return pathcss;
	}
	int m;
	
	public int getM() {
		File dir=new File(fileDir);
		File file_name[]=dir.listFiles();
		String temp=file_name[0].toString();
		 m=temp.lastIndexOf("\\");
		return m;
	}
	public String getListFile(){
		File dir=new File(fileDir);
		File file_name[]=dir.listFiles();
		StringBuffer list=new StringBuffer();
		for(int i=0;i<file_name.length;i++){
			if((file_name[i]!=null)&&(file_name[i].isFile())){
				String temp=file_name[i].toString();
				int n=temp.lastIndexOf("\\");//\是转义字符，所以要两个\才能达到一个\的效果
				temp=temp.substring(n+1);
				list.append(" "+temp);
			}
		}
		listFile=new String(list);
		return listFile;
	}
	public String getReadContent(){
		try{
			File  file=new File(fileDir,fileName);
			FileReader in=new FileReader(file);
			BufferedReader inTwo=new BufferedReader(in);
			StringBuffer stringbuffer=new StringBuffer();
			String s=null;
			while((s=inTwo.readLine())!=null){
				byte bb[]=s.getBytes();
				s=new String(bb);
				stringbuffer.append("\n"+s);
			}
			String temp=new String(stringbuffer);
			readContent="<textarea rows=8 cols=62>"+temp+"</textarea>";
		}
		catch(IOException e){
			readContent="<textarea rows=8 cols=62></textarea>";
		}
		return readContent;
	}
}
