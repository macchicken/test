package designpatterns.composite.transparency;

public interface IProduct {

	public void pay();
	public void addProduct(IProduct res);
	public void removeProduct(IProduct res);

}
