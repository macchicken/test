package test.ticksold;

public class CashSlot implements MyComponent {

	private String credit;

	public CashSlot() {
		init();
	}

	@Override
	public void init() {
		credit="0";
	}

	@Override
	public void doSelfTest() {
	}

	public String getCredit(){
		return credit;
	}
}
