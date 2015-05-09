package designpatterns.state;

class EngineLow implements EngineState {

	public EngineLow() {
	}

	@Override
	public void up(Engine eng) {
		System.out.println("Low->High");
		eng.changeState(new EngineHigh());
	}

	@Override
	public void down(Engine eng) {
		System.out.println("Low->Idle");
		eng.changeState(new EngineIdle());
	}


	@Override
	public void currentState() {
		System.out.println("State:Low");
	}

}
