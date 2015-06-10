package designpatterns.decorator;

public class ClientApp {

	public static void main(String[] args) {
		ComponentNews news=new ConcreteDecortorAddRss(new XmlNews());
		news.getListOfNews();
		news=new ConcreteDecortorAddAmount(news);
		news.getListOfNews();

	}

}
