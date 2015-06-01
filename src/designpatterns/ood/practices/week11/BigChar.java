package designpatterns.ood.practices.week11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {

	private char charname; // char to display

	private String fontdata; // large character composed of ('#' '.' '\n')
	private String workDir=System.getProperty("user.dir")+"/src/designpatterns/ood/practices/week11/";
	
	public BigChar(char charname) {
		this.charname = charname;
		try {

			BufferedReader reader = new BufferedReader(new FileReader(workDir+"big" + charname + ".txt"));
			String line;
			StringBuffer buf = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buf.append(line);
				buf.append("\n");
			}
			reader.close();
			this.fontdata = buf.toString();

		} catch (IOException e) {
			this.fontdata = charname + "?";
		}

	}

	// display a large font.
	public void print() {
		System.out.print(fontdata);
	}

}
