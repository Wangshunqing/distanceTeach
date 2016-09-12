package cn.hhu;

import java.io.*;
public class Control {
	
	private StringBuffer currentRecord=new StringBuffer();
	private BufferedReader file;
	private String path;
	
	public Control (){
	}
	
	public StringBuffer ReaderFile(String filepath)throws FileNotFoundException{
		path=filepath;
		File file=new File(filepath);
		if(!file.exists()){
			try{
				file.createNewFile();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		String str= null;
		
		try{
			while((str=bufferedReader.readLine())!=null){
				currentRecord.append(str);
				currentRecord.append("<br>");
			 
			}
		}
		catch(IOException e){
			System.out.println("��ȡ���ݴ���");
		}
		return currentRecord;
	}
//	public void WriteFile(String filepath,String count)
}
