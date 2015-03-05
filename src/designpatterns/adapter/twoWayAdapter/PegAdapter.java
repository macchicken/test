package designpatterns.adapter.twoWayAdapter;

public class PegAdapter implements IRoundPeg, ISquarePeg {

	private RoundPeg roundPeg;
	private SquarePeg squarePeg;

	public PegAdapter(RoundPeg roundPeg,SquarePeg squarePeg) {
		super();
		this.roundPeg = roundPeg;
		this.squarePeg = squarePeg;
	}


	@Override
	public void insert(String pegName) {
		if (roundPeg!=null) {
			roundPeg.insert(pegName);
		}
		if (squarePeg!=null) {
			squarePeg.insert(pegName);
		}
	}

}
