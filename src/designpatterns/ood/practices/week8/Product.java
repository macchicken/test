package designpatterns.ood.practices.week8;


abstract class Product implements Cloneable{

	protected abstract void use();
	protected void use(String s){}
 
	protected final Product createClone(){
		Product p = null;
		try {
			p = (Product) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}

}
