package test.resturant;

public class Client {

	public static void main(String[] args) {
		PizzaRestaurant pizzaRestaurant=new PizzaRestaurant("Tim's Pizzaria","London");
		pizzaRestaurant.address="212 B Baker St.";
		pizzaRestaurant.setPhoneOperator(new Operator("Taylor",20));
		pizzaRestaurant.recruitPeople(new Cook("Kaydee",30));
		pizzaRestaurant.recruitPeople(new Cook("Amy",30));
		pizzaRestaurant.recruitPeople(new Cook("Rob",30));
		Menu pizzaMenu=new Menu();
		Pizza mage=new Pizza("Mixed Mage Pizza");
		Cheese cheese=new Cheese();cheese.name=CheeseTypes.Asiago;
		mage.addTopping(cheese);
		pizzaMenu.addItem(mage);
		Customer tyler=new Customer("Tyler","1111111111");
		Pizza porder=pizzaMenu.getItem("Mixed Mage Pizza");
		if (porder!=null) {
			Order one = new Order("1", porder, 2, tyler);
			Operator taylor = pizzaRestaurant.getPhoneOperator();
			System.out.println("start process order "+porder);
			taylor.placeOrder(one);
			Cook kaydee = pizzaRestaurant.getCook("Kaydee");
			kaydee.getOrder(one);
			one = kaydee.cookPizza();
			if (one.isDone()) {tyler.receiveOrder(one);}
		}
	}

}
