package designpatterns.Singleton;

import java.util.concurrent.CountDownLatch;

// CountDownLatch to test concurrent inilialize singleton
public class SingletonTest {

	private static final CountDownLatch latch=new CountDownLatch(1);
	private static int threads=10;
	
	public static void main(String args[]){
		for (int i=0;i<threads;i++){
			new Thread(){
				@Override
				public void run() {
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(SingletonInternal.getInstance());
				}
			}.start();
		}
		latch.countDown();
	}
}
