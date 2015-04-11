package test.resturant;

public class Customer implements Cloneable{

	private String name;
	private String phone;
	private Order order;
	
	public Customer() {
		super();
	}

	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void receiveOrder(Order order) {
		this.order=order;
	}

	public Order eat() throws CloneNotSupportedException{
		Order order=(Order) this.order.clone();
		this.order=null;
		return order;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone+"]";
	}
}
