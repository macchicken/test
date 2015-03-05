package designpatterns.composite.transparency;

public class People {

	public static void main(String args[]){
		 	IProduct singleProduct = new SingleProduct("ice cream", 1.5f);
		 	singleProduct.addProduct(singleProduct);
		 	singleProduct.removeProduct(singleProduct);
	        singleProduct.pay();
	 
	        IProduct allProduct = new MultiProducts();              
	        IProduct one = new MultiProducts();
	        allProduct.addProduct(one);
	        one.addProduct(new SingleProduct("biscuit", 28.5f));
	        one.addProduct(new SingleProduct("sugar", 38.0f));
	        one.addProduct(new SingleProduct("cole", 8.5f));
	 
	        IProduct two = new MultiProducts();
	        allProduct.addProduct(two);
	        two.addProduct(new SingleProduct("cloth", 130.5f));
	        two.addProduct(new SingleProduct("socks", 10f));       
	        IProduct bao = new MultiProducts();
	        two.addProduct(bao);
	        bao.addProduct(new SingleProduct("watch", 100f));
	       
	        one.addProduct(new SingleProduct("apple", 10.0f));
	        one.addProduct(new SingleProduct("pear", 3.0f));
	        one.removeProduct(new SingleProduct("cole", 8.5f));
	        allProduct.pay();
	}
}
