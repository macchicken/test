package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testCommandLine {

	public static void main(String[] args) {
		String input=null;int max=5;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
				System.out.println("waiting for you");
				while ((input=br.readLine())!=null){
					System.out.println("input "+input);
					max--;
					if (max==0){break;}
				}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				br.close();System.out.println("close");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
