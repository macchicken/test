package designpatterns.ood.practices.week11;

public class StringDisplayImpl extends DisplayImpl {

	private String string;  // String to display

    private int width;     // string's width

	public StringDisplayImpl(String string) {
		super();
		this.string = string;
		this.width = string.getBytes().length;
	}

	@Override
	public void rawOpen() {
		printLine();
	}

	@Override
	public void rawPrint() {
		System.out.println("|" + string + "|"); //ad "|" before and after the string
	}

	@Override
	public void rawClose() {
		printLine();
	}

	private void printLine() {
		System.out.print("+"); // "+" represnt the corner of the frame.
		for (int i = 0; i < width; i++) { // display "-" to draw a horizontal line
			System.out.print("-");
		}
		System.out.println("+"); // display the corner mark.
	}

}
