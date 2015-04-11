package test.resturant;

import java.util.ArrayList;

public class Pizza implements Cloneable{

	public String name;
	private ArrayList<Topping> toppings;
	
	public Pizza(String name) {
		super();
		this.name = name;
		this.toppings=new ArrayList<Topping>();
	}
	
	public void addTopping(Topping topping){
		toppings.add(topping);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Topping> getToppings() {
		return (ArrayList<Topping>) toppings.clone();
	}

	public void setToppings(ArrayList<Topping> toppings) {
		this.toppings = toppings;
	}

	@Override
	public String toString() {
		String str="";
		for (Topping t:toppings){
			str+=t.toString();
		}
		return "Pizza [name=" + name + ", toppings=" + str + "]";
	}
	
	
}
