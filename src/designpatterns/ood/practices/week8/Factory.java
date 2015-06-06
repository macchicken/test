package designpatterns.ood.practices.week8;

abstract class Factory {

	Factory() {
	}

	final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}

	protected abstract Product createProduct(String owner);

	protected abstract void registerProduct(Product product);
}
