package test.ticksold;

public class Printer implements MyComponent {

	private String ticket;

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Printer(){
		init();
	}

	@Override
	public void init() {
		ticket="";
	}

	@Override
	public void doSelfTest() {

	}

	public void printTicket(){
		System.out.println(ticket);
	}
	
	public void ejectTicket(){
		ticket="";
	}
}
