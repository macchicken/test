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
		System.out.println("part address: "+this.part);
		System.out.println("part content: "+this.part.printCotent());
	}

	@Override
	public void setPart() {
		this.part.changePart();
	}

	@Override
	public void createNewPart() {
		this.part=new Part();
	}

	public ConcretePrototype() {
		this.part = new Part();
	}

	@Override
	public Object shallowClone() throws CloneNotSupportedException{
		return super.clone();
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

	


}
