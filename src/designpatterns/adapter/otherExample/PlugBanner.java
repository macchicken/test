package designpatterns.adapter.otherExample;

public class PlugBanner implements Print{

	private Banner banner;

	public PlugBanner(String text) {
		super();
		this.banner = new Banner(text);
	}
	
	@Override
	public void printWeak() {
		banner.showWithParen();
	}

	@Override
	public void printStrong() {
		banner.showWithAster();
	}
	
}
