package test.ticksold;

public class Screen implements MyComponent {

	private String text;

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void init() {
		text="welcome to ticket sold system";
	}

	public Screen() {
		init();
	}

	@Override
	public void doSelfTest() {

	}

	public void showText(){
		System.out.println(text);
	}
}
