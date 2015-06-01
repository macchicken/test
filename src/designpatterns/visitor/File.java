package designpatterns.visitor;

import java.util.Iterator;

public class File extends Entry {

	private String name;
	private int size;

	public File(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Entry add(Entry entry) throws FileTreatmentException{
		throw new FileTreatmentException();
	}

	@Override
	public Iterator<Entry> iterator() throws FileTreatmentException{
		throw new FileTreatmentException();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
