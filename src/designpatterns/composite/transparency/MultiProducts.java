package designpatterns.composite.transparency;

import java.util.ArrayList;
import java.util.Iterator;

public class MultiProducts implements IProduct{

	private ArrayList trolley = new ArrayList();
	private static float total = 0.0f;

	@Override
	public void pay() {
		if (trolley.isEmpty()){
			System.out.println("empty, just go");
			return;
		}
		Shopping();
		System.out.println("total "+total+" dollar");
	}

	public void Shopping(){
		 if (trolley != null || !trolley.isEmpty()) {
	            Iterator<?> it = trolley.iterator();
	            SingleProduct res = null;
	            Object temp = null;// ¡Ÿ ±∂‘œÛ
	            while (it.hasNext()) {
	                temp = it.next();
	                if (temp instanceof MultiProducts) {
	                    ((MultiProducts) temp).Shopping();
	                } else {
	                    res = (SingleProduct) temp;
	                    synchronized (this) {total += res.getPrice();}
	                    System.out.println(res.getName() + " " + res.getPrice()+ " dollar");
	                }
	            }
	     }
	}
	
	public void addProduct(IProduct pro){
		trolley.add(pro);
	}
	
	public void removeProduct(IProduct pro){
		trolley.remove(pro);
	}

}
