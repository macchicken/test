package designpatterns.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ConcretePrototype implements Prototype, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Part part;
	@Override
	public void printPart() {
		System.out.println(part);
	}

	public ConcretePrototype() {
		part = new Part();
	}

	@Override
	public Object flatClone() {
		ConcretePrototype cp = new ConcretePrototype();
        cp.part = this.part;
        return cp;
	}

	@Override
	public Object deepClone() throws Exception {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
	}

	class Part implements Serializable {
		private static final long serialVersionUID = 1L;}
}
