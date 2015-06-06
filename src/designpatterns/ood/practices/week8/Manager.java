package designpatterns.ood.practices.week8;

import java.util.HashMap;

public class Manager {

	private HashMap<String, Product> showcase = new HashMap<String, Product>();

	void register(String name, Product proto) {
		showcase.put(name, proto);
	}

	Product create(String protoname) {
		Product p = showcase.get(protoname);
		return p.createClone();
	}
}
