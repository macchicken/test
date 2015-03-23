package designpatterns.prototype.prototypeLevel;

import java.util.ArrayList;

public class PrototypeManager {

	private ArrayList<Object> objects;
	
	public PrototypeManager() {
		super();
		objects = new ArrayList<Object>();
	}

	public void add(Object obj){
		objects.add(obj);
	}
	
	public Object get(int index){
		return objects.get(index);
	}
	
	public int getSize(){
		return objects.size();
	}

}
