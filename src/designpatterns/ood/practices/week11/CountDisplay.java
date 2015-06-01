package designpatterns.ood.practices.week11;

public class CountDisplay extends Display {

	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}

	public void multiDisplay(int times) {
		// display times
		open();
		for (int i = 0; i < times; i++) {
			print();
		}
		close();
	}

}
