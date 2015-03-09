package designpatterns.decorator;

import java.util.ArrayList;

public class ConcreteDecortorAddAmount extends DecoratorNews {

	public ConcreteDecortorAddAmount(ComponentNews componentNews) {
		super(componentNews);
	}
	
	private String AddAmount(){
		System.out.println("add amount for news");
		return "add amount for news";
	}

	@Override
	public ArrayList getListOfNews() {
		AddAmount();
		return super.getListOfNews();
	}
	
	

}
