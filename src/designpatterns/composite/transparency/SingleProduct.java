package designpatterns.composite.transparency;

public class SingleProduct implements IProduct {

	private String name;
	private float price;

	public SingleProduct(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public void pay() {
		System.out.println("bought product "+name+" at price "+price);
	}

	public float getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		SingleProduct pro=(SingleProduct) obj;
		return pro.getName().equals(name)&&pro.getPrice()==price;
	}

	@Override
	public void addProduct(IProduct res) {
		System.out.println("no add for one product");
	}

	@Override
	public void removeProduct(IProduct res) {
		System.out.println("no remove for one product");
	}

	
}
