package designpatterns.ood.practices.week11;

public class BigMain {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);
		}
		Runtime.getRuntime().gc(); // run the Garbage Collector
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		BigString bs = new BigString(args[0]);
		bs.print();
		BigString bs2 = new BigString(args[0],false);
		bs2.print();
		System.out.println("used memory = " + used);
		
	}

}
