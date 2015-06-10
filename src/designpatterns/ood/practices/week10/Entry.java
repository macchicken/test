package designpatterns.ood.practices.week10;

abstract class Entry {

	protected Entry parentNode;
	protected String name;
	
	abstract String getName();                          

    abstract int getSize();                                 

    Entry add(Entry entry) throws FileTreatmentException {  
        throw new FileTreatmentException();
    }

    void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    protected void printFullPath(){
    	StringBuffer temp=new StringBuffer();
		temp.append("/"+this.name);
		Entry ent=this.parentNode;
		while(ent!=null){
			temp.insert(0, "/"+ent.getName());
			ent=ent.parentNode;
		}
		System.out.println(temp.toString());
    }
    
    public String toString() {             
        return getName() + " (" + getSize() + ")";
    }


}
