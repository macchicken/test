package test.resturant;

import java.util.ArrayList;


public class Cook extends Employee implements Runnable{

	private ThreadLocal<Order> workingOrder = new ThreadLocal<Order>(){};
	private ArrayList<Order> assignedOrders=new ArrayList<Order>();
	private int time;
	
	public Cook(String name, double salary) {
		super(name, salary);
	}

	public void getOrder(Order order,int time) throws CloneNotSupportedException{
		this.assignedOrders.add((Order) order.clone());
		this.time=time<=0?1:time;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Order> getCompletedOrders(){
			return (ArrayList<Order>) assignedOrders.clone();
	}
	
	public ArrayList<Order> getCompletedOrders(int start){
		return new ArrayList<Order>(assignedOrders.subList(start, assignedOrders.size()));
}

	// actual cook process
	@Override
	public void run() {
		for (Order woo:assignedOrders) {
			try {
				workingOrder.set(woo);
				System.out.println(this.name + " doing preparation "+ woo);
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				System.out.println(" Cook thread error " + e1.getMessage());
			}
			Order order = workingOrder.get();
			if (order != null && !order.isDone()) {
				try {
					System.out.println(this.name + " start to cook pizza "+ order.getName());
					Thread.sleep(5000 * time);
				} catch (InterruptedException e) {
					System.out.println("Cook thread error " + e.getMessage());
				}
				order.setDone(true);
				workingOrder.set(order);
				System.out.println(this.name + " done the order "+ order.getName());
			}
		}
	}
}
