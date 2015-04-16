package designpatterns.iterator;

public class BookShelfItertor implements MyIterator {

	private BookShelf bsh;
	private int cur;
	
	public BookShelfItertor(BookShelf bsh){
		super();
		this.bsh=bsh;
		cur=0;
	}


	@Override
	public boolean hasNext() {
		return cur<bsh.getLength();
	}

	@Override
	public Object next() {
		if (hasNext()){return bsh.getBookAt(cur++);}
		return null;
	}

}
