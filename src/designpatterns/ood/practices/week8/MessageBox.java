package designpatterns.ood.practices.week8;

class MessageBox extends Product {

	private char decochar;

	protected MessageBox(char decochar) {
		super();
		this.decochar = decochar;
	}

	@Override
	protected void use(String s) {
		int length = s.getBytes().length;
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println("");
		System.out.println(decochar + " " + s + " " + decochar);
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println("");
	}

	@Override
	protected void use() {}


}
