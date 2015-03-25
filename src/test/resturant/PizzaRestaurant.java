package test.resturant;

import java.util.ArrayList;

public class PizzaRestaurant implements Restaurant {

	public String name;
	public String address;
	private Operator phoneOperator;

	public Operator getPhoneOperator() {
		return phoneOperator;
	}

	public void setPhoneOperator(Operator phoneOperator) {
		this.phoneOperator = phoneOperator;
	}

	private Part part;
	private Menu menu;
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public ArrayList<Cook> getCook() {
		if (employees!=null){
			ArrayList<Cook> cook=new ArrayList<Cook>();
			for (Employee em:employees){
				if (em instanceof Cook){cook.add((Cook) em);}
			}
		}
		return null;
	}

	public Cook getCook(String name) {
		if (employees!=null&&employees.size()!=0){
			for (Employee c:employees){
				if (c instanceof Cook) {
					if (c.name.equals(name)) {return (Cook) c;}
				}
			}
		}
		return null;
	}

	public ArrayList<DeliveryMan> getDeliveryMan() {
		if (employees!=null){
			ArrayList<DeliveryMan> deliveryMan = new ArrayList<DeliveryMan>();
			for (Employee em:employees){
				if (em instanceof DeliveryMan){
					deliveryMan.add((DeliveryMan) em);
				}
			}
		}
		return null;
	}

	public DeliveryMan getDeliveryMan(String name){
		if (employees!=null&employees.size()!=0){
			for (Employee dman:employees){
				if (dman instanceof DeliveryMan) {
					if (dman.name.equals(name)) {return (DeliveryMan) dman;}
				}
			}
		}
		return null;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	private ArrayList<Employee> employees;

	public void recruitPeople(Employee em){
		employees.add(em);
	}

	public PizzaRestaurant(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.employees=new ArrayList<Employee>();
	}

	public PizzaRestaurant() {
		super();
	}
	
	
}
