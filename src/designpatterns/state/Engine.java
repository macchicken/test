package designpatterns.state;

class Engine {

	private EngineState state;
	
	public Engine() {
		this.state = new EngineIdle();
	}

	public void up() {
		state.up(this);
	}

	public void down() {
		state.down(this);
	}

	public void changeState(EngineState newState) {
		state = newState;
	}

	public void currentState() {
		state.currentState();
	}

}
