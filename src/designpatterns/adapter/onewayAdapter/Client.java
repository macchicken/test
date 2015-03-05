package designpatterns.adapter.onewayAdapter;

public class Client {

	public static void main(String[] args) {
		PegAdapter pegAdapter=new PegAdapter(new SquarePeg());
		pegAdapter.insert("hello");
	}

}
