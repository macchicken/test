package designpatterns.builder;

public class Client {

	public static void main(String args[]){
		Director director=new Director();
		Builder p1=new FatPersonBuilder();
		Builder p2=new ThinPersonBuilder();
		director.Construct(p1);
		p1.GetResult().Show();
		director.Construct(p2);
		p2.GetResult().Show();
	}
}
