package designpatterns.ood.practices.week8;

public class UnderlinePen extends Product {

	private char ulchar;
	
	protected UnderlinePen(char ulchar) {
		super();
		this.ulchar = ulchar;
	}

	@Override
	protected void use(String s) {
		int length = s.getBytes().length;
		System.out.println("\"" + s + "\"");
		System.out.println("");
		for (int i = 0; i < length; i++) {
			System.out.print(ulchar);
		}
		System.out.println("");

	}

	@Override
	protected void use() {}

}
