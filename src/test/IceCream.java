package test;

import test.element.Cone;

public class IceCream {

	public static void main(String[] args) {
		Cone cone=new Cone(1, 10, 2);
		for (int i = 2; i < 5; i++) {
			cone.addScoop(i);
		}
		
	}

}
