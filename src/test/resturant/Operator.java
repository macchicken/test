package test.resturant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Operator extends Employee implements Runnable{

	private HashMap<String,Order> orders=new HashMap<String,Order>();
	private ArrayList<Cook> cook=new ArrayList<Cook>();

	
	public Operator() {
		super();
	}

	public Operator(String name, double salary) {
		super(name, salary);
	}

	public void placeOrder(Order order,Cook cook) throws CloneNotSupportedException{
		orders.put(order.getOrderId(), (Order) order.clone());
		this.cook.add(cook);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Order> getOrders() {
		return (HashMap<String, Order>) orders.clone();
	}

	@Override
	public void run() {
		int count=0;LinkedList<Order> completedOrders=null;
		while(count<orders.size()){
			for (Cook ck:cook){
				try {
					completedOrders = ck.getCompletedOrders();
					if (completedOrders==null){continue;}
					for (Order order : completedOrders) {
						try {
							if (!orders.get(order.getOrderId()).isDone()) {
								orders.put(order.getOrderId(), order);
								order.getCustomer().receiveOrder(order);
								System.out.println(order.getCustomer().getName()+ " received order " + order);
								count++;
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
				}
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Operator thread error " + e.getMessage());
			}
		}
	}}

	@Override
	public String toString() {
		return "Operator [orders=" + orders + ", cook=" + cook + "]";
	}
	

}
