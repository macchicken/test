package test.resturant;

public class Cheese extends Topping {

	public CheeseTypes name;

	public Cheese() {
		super();
	}

	@Override
	public String toString() {
		return "Cheese [name=" + name.name() + "]";
	}
	
	
}
