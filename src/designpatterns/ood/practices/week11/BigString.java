package designpatterns.ood.practices.week11;

public class BigString {

	private BigChar[] bigchars; // array for the large font.

	public BigString(String string) {
		createBigChars(string);
	}

	private void createBigChars(String string){
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i] = factory.getBigChar(string.charAt(i));
		}
	}

	public BigString(String string,boolean shared){
		if (shared){
			if (bigchars==null){createBigChars(string);}
		}else{
			createBigChars(string);
		}
	}

	// display
	public void print() {
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i].print();
		}
	}

}
