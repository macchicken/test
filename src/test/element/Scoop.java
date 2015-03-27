package test.element;

import test.ScoopState;

public class Scoop {

	private int flavour;
	private Scoop bottom;
	private String topping;
	private Scoop top;
	private ScoopState state;
	
	public Scoop(int flavour) {
		super();
		this.flavour = flavour;
		this.state=ScoopState.Frozen;
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
	
	public void setTop(Scoop top) {
		this.top = top;
	}

	public void addScoop(int flavour){
		this.top=new Scoop(flavour);
		this.top.setBottom(this);
	}

	public ScoopState getState() {
		return state;
	}

	public void setState(ScoopState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "flavour: "+flavour+" state: "+state.name();
	}
	
	
}
