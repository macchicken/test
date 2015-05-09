package designpatterns.state;

class EngineHigh implements EngineState {

	public EngineHigh() {
	}

	@Override
	public void up(Engine eng) {
		System.out.println("No Change");
		eng.changeState(new EngineHigh());
	}

	@Override
	public void down(Engine eng) {
		System.out.println("High->Low");
		eng.changeState(new EngineLow());
	}

	@Override
	public void currentState() {
		System.out.println("State:High");
	}

}
