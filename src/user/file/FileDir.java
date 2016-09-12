package user.file;
import java.io.*;
public class FileDir {
	
	String newWebDirName,oldWebDirName;
	StringBuffer allFiles;
	public FileDir(){
		allFiles=new StringBuffer();
	}
	public void setNewWebDirName(String s){
		newWebDirName=s;
		if(newWebDirName!=null){
			File dir=new File("F:/codes/Java/web/MyJsp/WebContent",newWebDirName);
			dir.mkdir();			
		}
	}
	public String getNewWebDirName(){
		return newWebDirName;
	}
	public void setOldWebDirName(String s){
		oldWebDirName=s;
	}
	public String getOldWebDirName(){
		return oldWebDirName;
	}
	public StringBuffer getAllFiles(){
		if(oldWebDirName!=null){
			File dir=new File("F:/codes/Java/web/MyJsp/WebContent",oldWebDirName);
			File a[]=dir.listFiles();
			for(int k=0;k<a.length;k++){
				if(a[k].isDirectory()){
					allFiles.append("<br>子目录:"+a[k].getName());
				}
			}
			for(int k=0;k<a.length;k++){
				if(a[k].isFile())
					allFiles.append("<br>文件:"+a[k].getName());
			}
		}
		return allFiles;
	}
	
}
