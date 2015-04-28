package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadTimeCountTest {

	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	private static void tearDown(){
		try {
			br.close();System.out.println("close");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	    public void gets(){
	        Timer timer=new Timer();
	        timer.schedule(new TimerTask(){
	            @Override
	            public void run() {
	            		System.out.println("waiting for you");
	            }
	        }, 0, 5000);
	    }
	    public static void main(String[] str){
	        new ThreadTimeCountTest().gets();
	        tearDown();
	    }
}
