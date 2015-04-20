package designpatterns.ood.practices;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5440596350665586183L;
	private FileReader reader;
	private String parentPath;
	
	public FileProperties(String parentPath){
		this.parentPath=parentPath;
	}

	@Override
	public void readFromFile(String filename) throws IOException {
		try {
			this.reader = new FileReader(this.parentPath + filename);
			this.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if (reader!=null){reader.close();}
		}
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		PrintStream fos=null;
		try {
			fos=new PrintStream("D:\\hc105\\workspace\\test\\src\\designpatterns\\ood\\practices\\"+filename);
			this.store(fos, "written by FileProperties");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (fos!=null) {fos.close();}
		}
	}

	@Override
	public void setValue(String key, String value) {
		if (reader!=null){
			this.setProperty(key, value);
		}
	}

	@Override
	public String getValue(String key) {
		if (reader!=null){
			return this.getProperty(key);
		}
		return null;
	}

}
