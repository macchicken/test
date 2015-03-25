package test.resturant;


public class Cook extends Employee{

	private Order workingOn;;

	public Cook() {
		super();
	}

	public Cook(String name, double salary) {
		super(name, salary);
	}

	public void getOrder(Order order){
		workingOn=order;
	}
	
	public Order cookPizza(){
		workingOn.setDone(true);
		return workingOn;
	}
}
