package designpatterns.proxy;

public class PanJinLian implements KindWoman {

	@Override
	public void makeEyesWithMan() {
		System.out.println("PanJinLian make eyes with man");
	}

	@Override
	public void happyWithMan(int price) {
		System.out.println("PanJinLian happy with man at $"+price);
	}

}
