package test.element;

public class Card {
	
	private int rank=1;
	private String auxRank="A";
	private boolean dealed = false;
	
	public Card(int rank, String auxRank) {
		this.rank = rank;
		this.auxRank = auxRank;
	}


	public void print() {
		System.out.print(String.valueOf(rank)+auxRank);
	}


	public void setDealed(boolean dealed) {
		this.dealed = dealed;
	}


	public boolean isDealed() {
		return dealed;
	}


	public int getRank() {
		return rank;
	}

}
