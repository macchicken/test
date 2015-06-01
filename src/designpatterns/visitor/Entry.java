package designpatterns.visitor;

import java.util.Iterator;

public abstract class Entry implements Element {

	public abstract String getName(); // get a name
	public abstract int getSize(); // get a size

	public abstract Entry add(Entry entry) throws FileTreatmentException;
	public abstract Iterator<Entry> iterator() throws FileTreatmentException;
	public abstract void accept(Visitor v);
	
	@Override
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}

}
