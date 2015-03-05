package designpatterns.adapter.twoWayAdapter;

public class client {

	public static void main(String[] args) {
		PegAdapter pegAdapter=new PegAdapter(new RoundPeg(), new SquarePeg());
		pegAdapter.insert("hello two way");
	}

}
