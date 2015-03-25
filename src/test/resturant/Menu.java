package test.resturant;

import java.util.ArrayList;

public class Menu {

	public String[] items;
	private ArrayList<Pizza> pizzas;
	
	public Menu() {
		super();
		this.pizzas=new ArrayList<Pizza>();
	}
	
	public void addItem(Pizza pizza){
		this.pizzas.add(pizza);
	}
	
	public String[] getItems(){
		items=new String[pizzas.size()];
		int i=0;
		for (Pizza pizza:pizzas){
			items[i]=pizza.name;
			i++;
		}
		return items;
	}
	
	public Pizza getItem(String name){
		for (Pizza p:pizzas){
			if (p.name.equals(name)){
				Pizza newp=new Pizza(p.name);
				newp.setToppings(p.getToppings());
				return newp;}
		}
		return null;
	}
	
}
