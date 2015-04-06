package test;

public abstract class SimulateBehaviour{

	protected QuackBehaviour quackBehaviour;
	protected FlyBehaviour flyBehaviour;

	public abstract void mimic(String name);

	public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
		this.quackBehaviour = quackBehaviour;
	}

	public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
		this.flyBehaviour = flyBehaviour;
	}
}
