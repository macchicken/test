package designpatterns.composite.safe;

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

	
}
