package designpatterns.ood.practices.week10;

abstract class Entry {

	protected Entry parentNode;

	abstract String getName();                          

    abstract int getSize();                                 

    Entry add(Entry entry) throws FileTreatmentException {  
        throw new FileTreatmentException();
    }

    void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);
    protected abstract void printFullPath();
    
    public String toString() {             
        return getName() + " (" + getSize() + ")";
    }
}
