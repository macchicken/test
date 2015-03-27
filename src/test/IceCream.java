package test;

import test.element.Cone;
import test.element.Scoop;

public class IceCream {

	private static void eat(Cone cone){
		Scoop scoop=cone.getScoop();
			for (int i = 1; i <= 2; i++) {
				if (scoop!=null) {
					scoop.setState(ScoopState.Just);
					if (scoop.getState().equals(ScoopState.Just)) {
						System.out.println("start to eat "+scoop);
						cone.removeScoop();scoop = cone.getScoop();
						System.out.println("finish");
					} else {
						System.out.println("can eat scoop "+ scoop);
					}
				}
		}
		System.out.println(scoop);
	}

	public static void main(String[] args) {
		Cone cone=new Cone(1, 10, 2);
		for (int i = 2; i < 5; i++) {
			cone.addScoop(i);
		}
		eat(cone);
	}

}
