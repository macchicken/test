package designpatterns.builder;

public abstract class Builder {

	public abstract void BuildHead();
	public abstract void BuildBody();
	public abstract void BuildHand();
	public abstract void BuildFeet();
	public abstract Product GetResult();
}
