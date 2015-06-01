package designpatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {

	private String name; // directory¡¯s name
	private ArrayList<Entry> dir = new ArrayList<Entry>();// the list of sub-dir
	
	public Directory(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		int size=0;
		Iterator<Entry> it=dir.iterator();
		while(it.hasNext()){
			Entry entry=it.next();
			size+=entry.getSize();
		}
		return size;
	}

	@Override
	public Entry add(Entry entry) throws FileTreatmentException {
		dir.add(entry);
		return entry;
	}

	@Override
	public Iterator<Entry> iterator() throws FileTreatmentException {
		return dir.iterator();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
