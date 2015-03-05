package designpatterns.composite.safe;

public class People {

	public static void main(String args[]){
		 	IProduct singleProduct = new SingleProduct("ice cream", 1.5f);
	        singleProduct.pay();
	 
	        IProduct allProduct = new MultiProducts();              
	        IProduct one = new MultiProducts();
	        ((MultiProducts) allProduct).addProduct(one);
	        ((MultiProducts) one).addProduct(new SingleProduct("biscuit", 28.5f));
	        ((MultiProducts) one).addProduct(new SingleProduct("sugar", 38.0f));
	        ((MultiProducts) one).addProduct(new SingleProduct("cole", 8.5f));
	 
	        IProduct two = new MultiProducts();
	        ((MultiProducts) allProduct).addProduct(two);
	        ((MultiProducts) two).addProduct(new SingleProduct("cloth", 130.5f));
	        ((MultiProducts) two).addProduct(new SingleProduct("socks", 10f));       
	        IProduct bao = new MultiProducts();
	        ((MultiProducts) two).addProduct(bao);
	        ((MultiProducts) bao).addProduct(new SingleProduct("watch", 100f));
	       
	        ((MultiProducts) one).addProduct(new SingleProduct("apple", 10.0f));
	        ((MultiProducts) one).addProduct(new SingleProduct("pear", 3.0f));
	        ((MultiProducts) one).removeProduct(new SingleProduct("cole", 8.5f));
	        allProduct.pay();
	}
}
