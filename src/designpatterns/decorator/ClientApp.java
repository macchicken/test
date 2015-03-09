package designpatterns.decorator;

public class ClientApp {

	public static void main(String[] args) {
		ComponentNews news=new XmlNews();
		DecoratorNews decorator=new ConcreteDecortorAddRss(news);
		decorator.getListOfNews();
		decorator=new ConcreteDecortorAddAmount(news);
		decorator.getListOfNews();

	}

}
