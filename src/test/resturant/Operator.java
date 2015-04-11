package test.resturant;

import java.util.ArrayList;
import java.util.HashMap;

public class Operator extends Employee implements Runnable{

	private HashMap<String,Order> orders=new HashMap<String,Order>();
	private Cook cook;
	
	public Operator() {
		super();
	}

	public Operator(String name, double salary) {
		super(name, salary);
	}

	public void placeOrder(Order order,Cook cook) throws CloneNotSupportedException{
		orders.put(order.getOrderId(), (Order) order.clone());
		this.cook=cook;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Order> getOrders() {
		return (HashMap<String, Order>) orders.clone();
	}

	@Override
	public void run() {
		int count=0;
		ArrayList<Order> completedOrders=null;
		while (count<orders.size()) {
				completedOrders = cook.getCompletedOrders(count);
				for (Order order : completedOrders) {
					if (!order.isDone()) {
						System.out.println(order.getName() + " is still cooking");
					} else {
						orders.put(order.getOrderId(), order);
						order.getCustomer().receiveOrder(order);
						System.out.println(order.getCustomer().getName()+ " received order " + order);
						count++;
					}
				}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Operator thread error " + e.getMessage());
			}
		}
	}

	@Override
	public String toString() {
		return "Operator [orders=" + orders + ", cook=" + cook + "]";
	}
	

}
