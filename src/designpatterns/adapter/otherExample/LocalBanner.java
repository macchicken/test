package designpatterns.adapter.otherExample;

public class LocalBanner extends Banner {

	public LocalBanner(String text) {
		super(text);
	}

	public void ShowLocal(){
		super.printWeek();
	}
	
	public void ShowStrong(){
		super.printStrong();
	}
}
