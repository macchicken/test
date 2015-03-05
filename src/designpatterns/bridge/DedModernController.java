package designpatterns.bridge;

public class DedModernController extends ModernConnectionController {

	public DedModernController(ModernImplementation dialImp,
			ModernImplementation hangupImp, ModernImplementation sendImp,
			ModernImplementation receiveImp) {
		super(dialImp, hangupImp, sendImp, receiveImp);
	}

	@Override
	public void Dial() {
		System.out.println("Dedicated Modern Controller Dial simulate connection state");
	}

	@Override
	public void Hangup() {
		System.out.println("Dedicated Modern Controller Hangup simulate connection state");
	}

	@Override
	public void Send() {
		System.out.println("Dedicated Modern Controller Send");
		this.sendImp.Send();
	}

	@Override
	public void Receive() {
		System.out.println("Dedicated Modern Controller Receive");
		this.receiveImp.Receive();
	}

}
