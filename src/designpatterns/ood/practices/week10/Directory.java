package designpatterns.ood.practices.week10;

import java.util.ArrayList;
import java.util.Iterator;

class Directory extends Entry {

//	private String name;
    private ArrayList<Entry> directory = new ArrayList<Entry>();
    
    public Directory(String name) { 
        this.name = name;
    }

	@Override
	String getName() {
		  return name;
	}

	@Override
	int getSize() {
		 int size = 0;
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
           Entry entry = (Entry)it.next();
           entry.printList(prefix + "/" + name);
        }
	}

	@Override
	Entry add(Entry entry) throws FileTreatmentException {
		 directory.add(entry);
		 entry.parentNode=this;
		 return this;
	}

	
}
