package designpatterns.bridge;

public class DialModernController extends ModernConnectionController {

	public DialModernController(ModernImplementation dialImp,
			ModernImplementation hangupImp, ModernImplementation sendImp,
			ModernImplementation receiveImp) {
		super(dialImp, hangupImp, sendImp, receiveImp);
	}

	@Override
	public void Dial() {
		System.out.println("Dial Modern Controller Dial");
		this.dialImp.Dial();
	}

	@Override
	public void Hangup() {
		System.out.println("Dial Modern Controller Hangup");
		this.hangupImp.Hangup();
	}

	@Override
	public void Send() {
		System.out.println("Dial Modern Controller Send");
		this.sendImp.Send();
	}

	@Override
	public void Receive() {
		System.out.println("Dial Modern Controller Receive");
		this.receiveImp.Receive();
	}

}
