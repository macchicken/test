package test.resturant;

public class Order implements Cloneable{

	private String orderId;
	private boolean done;

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getOrderId() {
		return orderId;
	}

	private Pizza name;
	private int amount;
	private Customer customer;
	
	public Order() {
		super();
	}

	public Pizza getName() {
		return name;
	}

	public void setName(Pizza name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Order(String orderId,Pizza name, int amount,Customer customer) {
		super();
		this.orderId=orderId;
		this.name = name;
		this.amount = amount;
		this.customer=customer;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", done=" + done + ", name="
				+ name + ", amount=" + amount + ", customer=" + customer + "]";
	}

	
}
