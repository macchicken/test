package designpatterns.adapter.otherExample;

public class Banner {

	private String text;

	public Banner(String text) {
		super();
		this.text = text;
	}
	
	public void printWeek(){
		System.out.println("<"+text+">");
	}
	
	public void printStrong(){
		System.out.println("<| "+text+" |>");
	}
	
}
