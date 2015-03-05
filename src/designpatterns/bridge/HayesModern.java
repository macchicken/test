package designpatterns.bridge;

public class HayesModern implements ModernImplementation {

	private String name="HayesModern";
	@Override
	public void Dial() {
		System.out.println(name+" Dial ");
	}

	@Override
	public void Hangup() {
		System.out.println(name+" Hangup ");
	}

	@Override
	public void Send() {
		System.out.println(name+" Send ");
	}

	@Override
	public void Receive() {
		System.out.println(name+" Receive ");
	}

}
