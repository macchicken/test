package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActionTimeCount {

	private static final long MAXTIME=10*1000;
	private static long timeCount=0;
	private static String str="";
	
	public static void main(String[] args) {
		
		String str = null;BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(timeCount<MAXTIME){
			long sysDate = System.currentTimeMillis();
			try{
				while("".equals((str = br.readLine()))){
					
				};
				}catch(IOException e){
				System.out.println("Input error:" + e.getMessage());
				}finally{
					timeCount+=(System.currentTimeMillis()-sysDate);
					if (timeCount>=MAXTIME){str="";break;}
				}
				System.out.println("input: '" + str + "'");
				str="";
				System.out.println("timeCount: '" + timeCount + "'");
		}
	}


}
