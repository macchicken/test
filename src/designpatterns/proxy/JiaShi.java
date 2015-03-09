package designpatterns.proxy;

public class JiaShi implements KindWoman {

	@Override
	public void makeEyesWithMan() {
		System.out.println("JiaShi make eyes with man");
	}

	@Override
	public void happyWithMan(int price) {
		System.out.println("JiaShi happy with man at $"+price);
	}

}
