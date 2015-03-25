package test.resturant;

import java.util.HashMap;

public class Operator extends Employee{

	private HashMap<String,Order> orders=new HashMap<String,Order>();

	public Operator() {
		super();
	}

	public Operator(String name, double salary) {
		super(name, salary);
	}

	public void placeOrder(Order order){
		orders.put(order.getOrderId(), order);
	}
	

}
