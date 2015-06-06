package designpatterns.ood.practices.week8;


class Main {

	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("Masa");
		Product card2 = factory.create("John");
		card1.use();
		card2.use();
		
		TicketMaker tm=TicketMaker.getInstance();
		TicketMaker tm2=TicketMaker.getInstance();
		System.out.println(tm);
		System.out.println(tm2);
		
		System.out.println(Triple.getInstance(0));
		System.out.println(Triple.getInstance(1));
		System.out.println(Triple.getInstance(2));
		System.out.println(Triple.getInstance(0));
		
		Manager manager = new Manager();
		UnderlinePen upen = new UnderlinePen('-');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("strong message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);
		Product p1 = manager.create("strong message");
		p1.use("Hello, world");
		Product p2 = manager.create("warning box");
		p2.use("Hello, world");
		Product p3 = manager.create("slash box");
		p3.use("Hello, world");
	}

}
