package designpatterns.adapter.otherExample;

public class Client {

	public static void main(String[] args) {
		LocalBanner llb=new LocalBanner("hello world");
		llb.ShowLocal();
		llb.ShowStrong();
		PlugBanner pgb=new PlugBanner("hello world");
		pgb.ShowLocal();
		pgb.ShowStrong();
	}

}
