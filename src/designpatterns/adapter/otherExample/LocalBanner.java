package designpatterns.adapter.otherExample;

public class LocalBanner extends Banner implements Print {

	public LocalBanner(String text) {
		super(text);
	}

	@Override
	public void printWeak() {
		super.showWithParen();
	}

	@Override
	public void printStrong() {
		super.showWithAster();
	}
}
