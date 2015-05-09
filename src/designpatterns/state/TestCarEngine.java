package designpatterns.state;

class TestCarEngine {

	public static void main(String[] args) {
		Engine eng=new Engine();
		eng.currentState();
		eng.down();
		eng.down();
		eng.up();
		eng.up();
	}

}
