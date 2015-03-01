package designpatterns.builder;

public class FatPersonBuilder extends Builder {

	private Product product=new Product();
	@Override
	public void BuildHead() {
		product.Add("fat head");
	}

	@Override
	public void BuildBody() {
		product.Add("fat body");
	}

	@Override
	public void BuildHand() {
		product.Add("fat hand");
	}

	@Override
	public void BuildFeet() {
		product.Add("fat feet");
	}

	@Override
	public Product GetResult() {
		return product;
	}

}
