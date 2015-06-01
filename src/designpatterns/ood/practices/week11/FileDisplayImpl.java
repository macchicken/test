package designpatterns.ood.practices.week11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDisplayImpl extends DisplayImpl {

	private String filePath;
	private BufferedReader reader;
	
	public FileDisplayImpl(String filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	public void rawOpen() {
		try {
			reader=new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rawPrint() {
		try {
			String str=reader.readLine();
			if (str!=null) {
				System.out.println("|" + str + "|");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rawClose() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
