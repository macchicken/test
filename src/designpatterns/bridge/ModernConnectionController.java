package designpatterns.bridge;

public class ModernConnectionController implements Modern,DedicatedModern{

	protected ModernImplementation dialImp;
	protected ModernImplementation hangupImp;
	protected ModernImplementation sendImp;
	protected ModernImplementation receiveImp;

	public ModernConnectionController(ModernImplementation dialImp,
			ModernImplementation hangupImp, ModernImplementation sendImp,
			ModernImplementation receiveImp) {
		super();
		this.dialImp = dialImp;
		this.hangupImp = hangupImp;
		this.sendImp = sendImp;
		this.receiveImp = receiveImp;
	}

	@Override
	public void Dial() {
	}
	@Override
	public void Hangup() {
	}
	@Override
	public void Send() {
	}
	@Override
	public void Receive() {
	}
	
	

}
