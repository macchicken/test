package designpatterns.decorator;

import java.util.ArrayList;

public class ConcreteDecortorAddRss extends DecoratorNews {

	public ConcreteDecortorAddRss(ComponentNews componentNews) {
		super(componentNews);
	}

	private String AddRss(){
		System.out.println("add rss for news");
		return "add rss for news";
	}

	@Override
	public ArrayList getListOfNews() {
		AddRss();
		return super.getListOfNews();
	}
	
	
}
