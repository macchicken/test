package test.ticksold;

public class TicketSoldSystem {

	private Keyboard actionKeyboard;
	private Keyboard ticketKindKeyboard;
	private Keyboard destinnationKeyboard;

	public Keyboard getActionKeyboard() {
		return actionKeyboard;
	}
	
	public void setActionKeyboard(Keyboard actionKeyboard) {
		this.actionKeyboard = actionKeyboard;
	}
	
	public Keyboard getTicketKindKeyboard() {
		return ticketKindKeyboard;
	}
	
	public void setTicketKindKeyboard(Keyboard ticketKindKeyboard) {
		this.ticketKindKeyboard = ticketKindKeyboard;
	}
	
	public Keyboard getDestinnationKeyboard() {
		return destinnationKeyboard;
	}
	
	public void setDestinnationKeyboard(Keyboard destinnationKeyboard) {
		this.destinnationKeyboard = destinnationKeyboard;
	}

	private MyComponent screen;
	private MyComponent carDriver;
	private MyComponent cashSlot;
	private MyComponent printer;

	public MyComponent getScreen() {
		return screen;
	}


	public void setScreen(MyComponent screen) {
		this.screen = screen;
	}

	public MyComponent getCarDriver() {
		return carDriver;
	}

	public void setCarDriver(MyComponent carDriver) {
		this.carDriver = carDriver;
	}

	public MyComponent getCashSlot() {
		return cashSlot;
	}

	public void setCashSlot(MyComponent cashSlot) {
		this.cashSlot = cashSlot;
	}

	public MyComponent getPrinter() {
		return printer;
	}

	public void setPrinter(MyComponent printer) {
		this.printer = printer;
	}

	public TicketSoldSystem(Keyboard actionKeyboard,
			Keyboard ticketKindKeyboard, Keyboard destinnationKeyboard,
			MyComponent screen, MyComponent carDriver, MyComponent cashSlot,
			MyComponent printer) {
		super();
		this.actionKeyboard = actionKeyboard;
		this.ticketKindKeyboard = ticketKindKeyboard;
		this.destinnationKeyboard = destinnationKeyboard;
		this.screen = screen;
		this.carDriver = carDriver;
		this.cashSlot = cashSlot;
		this.printer = printer;
	}

	public boolean verifyCredit(){
		return true;
	}
	
	public double calculateFare(){
		return 0;
	}
	
	public static void main(String[] args) {
		TicketSoldSystem sys = new TicketSoldSystem(new ActionKeyboard(),
				new TicketKindKeyboard(), new DestinnationKeyboard(),
				new Screen(), new CardDriver(), new CashSlot(), new Printer());
		((Screen)sys.getScreen()).showText();
	}

}
