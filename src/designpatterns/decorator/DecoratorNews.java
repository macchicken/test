package designpatterns.decorator;

import java.util.ArrayList;

/**
 * it does not abstract the possible common methods for those decorators,
 * it may exist different functions for decorators, but it still good to abstract those common methods
 * 
 * @author Barry
 * @since 2015-06-10
 */
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
