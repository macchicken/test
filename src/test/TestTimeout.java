package test;

import java.io.IOException;
import java.io.InputStream;

public class TestTimeout {

	public int readInputStreamWithTimeout(InputStream is, byte[] buf, int timeoutMillis)
			throws IOException {
		int bufferOffset = 0;    //the internal storage buffer offset
		long maxTimeMillis = System.currentTimeMillis() + timeoutMillis;//actual waiting time
		while (System.currentTimeMillis() < maxTimeMillis && bufferOffset < buf.length) { //til read sth from input
			int readLength = Math.min(is.available(), buf.length - bufferOffset); //calculate the acutal read length according to what actual read
			int readResult = is.read(buf, bufferOffset, readLength);
			if (readResult == -1) {// input closed
				break;
			}
			bufferOffset += readResult;
			if (readResult > 0) { //has read sth
				break;
			}
			try {
				Thread.sleep(1000);  //wait 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return bufferOffset;
	}
	
	public String readInput(int timeoutMillis) {
		
		System.out.println("Waiting for you");
		byte[] inputData = new byte[10240];//set 10KB, should be enought for a simple console application
		int readLength = 0;
		try {
			readLength = readInputStreamWithTimeout(System.in, inputData, timeoutMillis);// wait input
		} catch (IOException e) {
			e.printStackTrace();
		}
		String input=null;
		if (readLength > 0) {input=new String(inputData);input=input.trim();}
		return input;
	}


	public static void main(String[] args) {
        final TestTimeout testTimeout = new TestTimeout();
        String input=null;
        boolean continued=true;
        int max=5;
        while(continued){
        	input=testTimeout.readInput(6000);
        	max--;
        	System.out.println(input);
        	if (max==0){continued=false;}
        }
    }


}
