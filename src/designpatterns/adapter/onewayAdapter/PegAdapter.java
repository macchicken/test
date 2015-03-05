package designpatterns.adapter.onewayAdapter;

public class PegAdapter extends RoundPeg {

	private SquarePeg squarePeg;

	public PegAdapter(SquarePeg squarePeg) {
		super();
		this.squarePeg = squarePeg;
	}

	@Override
	public void insert(String pegName) {
		super.insert(pegName);
		squarePeg.insert(pegName);
	}
	
	
	
}
