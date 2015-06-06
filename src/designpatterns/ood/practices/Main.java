package designpatterns.ood.practices;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String worDir=System.getProperty("user.dir");
		String path=worDir+"\\src\\designpatterns\\ood\\practices\\";
		FileIO f=new FileProperties(path);
		try {
			f.readFromFile("file.txt");
			f.setValue("year", "2015");
	        f.setValue("month", "04");
	        f.setValue("day", "21");
	        f.writeToFile("newfile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
