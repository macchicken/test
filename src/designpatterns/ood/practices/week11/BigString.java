package designpatterns.ood.practices.week11;

public class BigString {

	private BigChar[] bigchars; // array for the large font.

	public BigString(String string) {
		this(string,false);
	}

	public BigString(String string,boolean shared){
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i] = factory.getBigChar(string.charAt(i),shared);
		}
	}

	// display
	public void print() {
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i].print();
		}
	}

}
