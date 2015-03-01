package designpatterns.builder;

public class Director {

	public void Construct(Builder builder){
		builder.BuildHead();
		builder.BuildBody();
		builder.BuildHand();
		builder.BuildFeet();
	}
}
