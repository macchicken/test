package designpatterns.prototype.prototypeLevel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConcretePrototype implements Prototype {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConcretePrototype() {
		super();
	}

	@Override
	public Object clone() {
		ObjectInputStream oi;
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(this);
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			oi = new ObjectInputStream(bi);
			return (oi.readObject());
		} catch (Exception e) {
			System.out.println("clone failed");
		}
		return null;
	}


}
