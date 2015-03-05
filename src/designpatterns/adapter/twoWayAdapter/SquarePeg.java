package designpatterns.adapter.twoWayAdapter;

public class SquarePeg implements ISquarePeg {

	@Override
	public void insert(String pegName) {
		System.out.println("SquarePeg insert():"+pegName);
	}

}
