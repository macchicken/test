package designpatterns.state;

interface EngineState {

	void up(Engine eng);
	void down(Engine eng);
	void currentState();

}
