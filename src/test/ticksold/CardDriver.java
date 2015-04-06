package test.ticksold;

public class CardDriver implements MyComponent {

	private String credit;

	public CardDriver() {
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

	public double debitFare(){
		return 0;
	}
	
	public void ejectMCard(){
		
	}
	
}
