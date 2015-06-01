package designpatterns.ood.practices.week11;

public class Main {

	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hello, Japan."));
		Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
		CountDisplay d4 = new CountRandomDisplay(new StringDisplayImpl("Hello, Universe."));
		CountDisplay d5 = new CountDisplay(new FileDisplayImpl(System.getProperty("user.dir")+"/src/designpatterns/ood/practices/week11/file.txt"));
		CountDisplay d6 = new CountRandomDisplay(new FileDisplayImpl(System.getProperty("user.dir")+"/src/designpatterns/ood/practices/week11/file.txt"));
		d1.display();
		d2.display();
		d3.display();
		d3.multiDisplay(5);
		d4.multiDisplay(5);
		d5.multiDisplay(5);
		d6.multiDisplay(5);
	}

}
