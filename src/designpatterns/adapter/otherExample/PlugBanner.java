package designpatterns.adapter.otherExample;

public class PlugBanner {

	private Banner banner;

	public PlugBanner(String text) {
		super();
		this.banner = new Banner(text);
	}
	
	public void ShowLocal(){
		banner.printWeek();
	}
	
	public void ShowStrong(){
		banner.printStrong();
	}
	
}
