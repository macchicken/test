package designpatterns.decorator;

public class News {

	private String titles;
	private String content;

	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public News(String titles, String content) {
		super();
		this.titles = titles;
		this.content = content;
	}
	
	public News() {
		this.titles="default title";
		this.content="default content";
	}
	
	
}
