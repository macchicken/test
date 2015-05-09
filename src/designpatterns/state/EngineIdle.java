package designpatterns.state;

class EngineIdle implements EngineState {

	public EngineIdle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void up(Engine eng) {
		System.out.println("Idle->Low");
		eng.changeState(new EngineLow());
	}

	@Override
	public void down(Engine eng) {
		System.out.println("No Change");
		eng.changeState(new EngineIdle());
	}

	@Override
	public void currentState() {
		System.out.println("State:Idle");
	}

}
