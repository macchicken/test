package designpatterns.decorator;

import java.util.ArrayList;

public abstract class DecoratorNews implements ComponentNews {

	private ComponentNews componentNews;
	
	@Override
	public ArrayList getListOfNews() {
		return componentNews.getListOfNews();
	}

	public DecoratorNews(ComponentNews componentNews) {
		super();
		this.componentNews = componentNews;
	}
	
	

}
