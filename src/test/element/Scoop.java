package test.element;

public class Scoop {

	private int flavour;
	private Scoop bottom;
	private String topping;
	private Scoop top;

	public Scoop(int flavour) {
		super();
		this.flavour = flavour;
	}

	public int getFlavour() {
		return flavour;
	}

	public void setFlavour(int flavour) {
		this.flavour = flavour;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public Scoop getBottom() {
		return bottom;
	}
	
	private void setBottom(Scoop bottom){
		this.bottom=bottom;
	}

	public Scoop getTop(){
		return top;
	}
	
	public void addScoop(int flavour){
		this.top=new Scoop(flavour);
		this.top.setBottom(this);
	}

	@Override
	public String toString() {
		return "flavour: "+flavour;
	}
	
	
}
