package designpatterns.flyweight;

public class Client {

	public static void main(String args[]){
		ShoeFactory sf=ShoeFactory.getInstance();
		Shoe shoe=sf.getShoe("blue", 42, "china");
		Shoe shoe2=sf.getShoe("blue", 42, "china");
		System.out.println(shoe);
		System.out.println(shoe2);
		System.out.println(shoe==shoe2);
		System.out.println(shoe.equals(shoe2));
	}
}
