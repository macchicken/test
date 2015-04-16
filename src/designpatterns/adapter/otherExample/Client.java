package designpatterns.adapter.otherExample;

public class Client {

	public static void main(String[] args) {
		LocalBanner lba=new LocalBanner("hello world");
		lba.printWeak();
		lba.printStrong();
		
		PlugBanner pba=new PlugBanner("hello world, delegation");
		pba.printWeak();
		pba.printStrong();
	}

}
