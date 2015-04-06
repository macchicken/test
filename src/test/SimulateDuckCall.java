package test;

public class SimulateDuckCall extends SimulateBehaviour {


	public SimulateDuckCall(QuackBehaviour qb,FlyBehaviour fb){
		this.quackBehaviour=qb;
		this.flyBehaviour=fb;
	}

	public SimulateDuckCall() {
		super();
	}

	@Override
	public void mimic(String name) {
		System.out.println("mimic "+name+" call");
		this.quackBehaviour.quack();
		this.flyBehaviour.fly();
	}


}