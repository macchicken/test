package test.element;

public class Cone {

	private int flavour;
	private int size;
	private int type;
	private Scoop scoop;

	public Cone(int flavour, int size, int type) {
		super();
		this.flavour = flavour;
		this.size = size;
		this.type = type;
	}

	public int getFlavour() {
		return flavour;
	}

	public void setFlavour(int flavour) {
		this.flavour = flavour;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void addScoop(int flavour){
		if (this.scoop==null){this.scoop=new Scoop(flavour);}
		else{
			while(this.scoop.getTop()!=null){
				this.scoop=this.scoop.getTop();
			}
			this.scoop.addScoop(flavour);
		}
		System.out.println("current "+this.scoop);
		System.out.println("top of current: "+this.scoop.getTop());
		System.out.println("bottom of current: "+this.scoop.getBottom());
	}

}
