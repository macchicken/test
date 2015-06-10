package designpatterns.ood.practices.week10;

class File extends Entry {

    private String name;
    private int size;

    File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }

	@Override
	protected void printFullPath() {
		StringBuffer temp=new StringBuffer();
		temp.append("/"+this.name);
		Entry ent=this.parentNode;
		while(ent!=null){
			temp.insert(0, "/"+ent.getName());
			ent=ent.parentNode;
		}
		System.out.println(temp.toString());
	}

}
