package designpatterns.builder;

public class ThinPersonBuilder extends Builder {

	private Product product=new Product();
	@Override
	public void BuildHead() {
		product.Add("thin head");
	}

	@Override
	public void BuildBody() {
		product.Add("thin body");
	}

	@Override
	public void BuildHand() {
		product.Add("thin hand");
	}

	@Override
	public void BuildFeet() {
		product.Add("thin feet");
	}

	@Override
	public Product GetResult() {
		return product;
	}

}
