package test.resturant;

public class Client {

	private static Menu pizzaMenu;
	private static Restaurant pizzaRestaurant;
	
	private static void initRestaurant(){
		pizzaRestaurant=new PizzaRestaurant("Tim's Pizzaria","London");
		((PizzaRestaurant)pizzaRestaurant).address="212 B Baker St.";
		((PizzaRestaurant)pizzaRestaurant).setPhoneOperator(new Operator("Taylor",20));
		((PizzaRestaurant)pizzaRestaurant).recruitPeople(new Cook("Kaydee",30));
		((PizzaRestaurant)pizzaRestaurant).recruitPeople(new Cook("Robin",30));
		((PizzaRestaurant)pizzaRestaurant).recruitPeople(new Cook("Amy",30));
		((PizzaRestaurant)pizzaRestaurant).recruitPeople(new Cook("Rob",30));
	}

	private static void initMenu(){
		pizzaMenu=new Menu();
		Pizza mage=new Pizza("Mixed Mage Pizza");
		Cheese cheese=new Cheese();cheese.name=CheeseTypes.Asiago;
		mage.addTopping(cheese);
		Pizza warrior=new Pizza("Warrior Mixed Mage Pizza");
		Cheese cheeseR=new Cheese();cheeseR.name=CheeseTypes.Ricotta;
		warrior.addTopping(cheeseR);
		pizzaMenu.addItem(mage);
		pizzaMenu.addItem(warrior);
	}

	public static void main(String[] args) throws Exception {
		initRestaurant();initMenu();
		Customer tyler=new Customer("Tyler","13825259516");
		Pizza p1=pizzaMenu.getItem("Mixed Mage Pizza");
		Pizza p2=pizzaMenu.getItem("Warrior Mixed Mage Pizza");
		if (p1!=null&&p2!=null) {
			Operator taylor = ((PizzaRestaurant)pizzaRestaurant).getPhoneOperator();
			Cook kaydee = ((PizzaRestaurant)pizzaRestaurant).getCook("Kaydee");
			Cook robin = ((PizzaRestaurant)pizzaRestaurant).getCook("Robin");
			Order one = new Order("1", p1, 2, tyler);
			Order two = new Order("2", p2, 2, tyler);
			Order three = new Order("3", p1, 2, tyler);
			Order four = new Order("4", p2, 2, tyler);
			taylor.placeOrder(one,kaydee);
			taylor.placeOrder(two,robin);
			taylor.placeOrder(three,kaydee);
			taylor.placeOrder(four,robin);
			kaydee.getOrder(one,1);
			kaydee.getOrder(three,1);
			robin.getOrder(two,2);
			robin.getOrder(four,2);
			new Thread(kaydee).start();
			new Thread(robin).start();
			new Thread(taylor).start();
		}
	}

}
