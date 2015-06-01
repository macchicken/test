package designpatterns.ood.practices.week11;

import java.util.Random;

public class CountRandomDisplay extends CountDisplay {

	public CountRandomDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	public void multiDisplay(int maxnum){
		super.multiDisplay(new Random().nextInt(maxnum));
	}

}
