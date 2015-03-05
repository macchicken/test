package designpatterns.adapter.twoWayAdapter;

public class RoundPeg implements IRoundPeg {

	@Override
	public void insert(String pegName) {
		System.out.println("RoundPeg insert():"+pegName);
	}

}
