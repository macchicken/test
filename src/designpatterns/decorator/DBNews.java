package designpatterns.decorator;

import java.util.ArrayList;

public class DBNews implements ComponentNews {

	@Override
	public ArrayList getListOfNews() {
		ArrayList<News> news = new ArrayList<News>();
		System.out.println("read news from database");
		return news;
	}

}
