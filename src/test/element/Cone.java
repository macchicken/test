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
			this.scoop.addScoop(flavour);
			this.scoop=this.scoop.getTop();
		}
		System.out.println("current "+this.scoop);
		System.out.println("bottom of current: "+this.scoop.getBottom());
	}
	
	public void removeScoop(){
		if (this.scoop!=null){
			if (this.scoop.getBottom()==null){
				this.scoop=null;
			}else{
				this.scoop.getBottom().setTop(null);
				this.scoop=this.scoop.getBottom();
			}
		}
	}

	public Scoop getScoop() {
		return scoop;
	}

}
