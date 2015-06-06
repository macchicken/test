package designpatterns.ood.practices.week8;

class IDCard extends Product {

	private String owner;
	private int serialNumber;
	
	IDCard(String owner) {
		super();
		this.owner = owner;
	}

	
	IDCard(String owner, int serialNumber) {
		this(owner);
		this.serialNumber = serialNumber;
	}


	@Override
	protected void use() {
		  System.out.println("using " + owner + "'s card with serial number "+serialNumber);
	}

	String getOwner() {
		return owner;
	}


	int getSerialNumber() {
		return serialNumber;
	}

}
