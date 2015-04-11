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
		Pizza porder=pizzaMenu.getItem("Mixed Mage Pizza");
		Pizza porder2=pizzaMenu.getItem("Warrior Mixed Mage Pizza");
		if (porder!=null&&porder2!=null) {
			Operator taylor = ((PizzaRestaurant)pizzaRestaurant).getPhoneOperator();
			Order one = new Order("1", porder, 2, tyler);
			Order two = new Order("2", porder2, 2, tyler);
			Cook kaydee = ((PizzaRestaurant)pizzaRestaurant).getCook("Kaydee");
			System.out.println(taylor.name+" is dealing with order "+porder);
			taylor.placeOrder(one,kaydee);
			taylor.placeOrder(two,kaydee);
			kaydee.getOrder(one,1);
			kaydee.getOrder(two,2);
			new Thread(kaydee).start();
			new Thread(taylor).start();
		}
	}

}
