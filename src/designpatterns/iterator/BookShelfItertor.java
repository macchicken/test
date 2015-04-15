package designpatterns.iterator;

public class BookShelfItertor implements MyIterator {

	private Book[] books;
	private int cur;
	
	public BookShelfItertor(BookShelf bsh){
		super();
		books=bsh.getBooks();
		cur=0;
	}

	@Override
	public boolean hasNext() {
		return cur<books.length;
	}

	@Override
	public Object next() {
		if (hasNext()){return books[cur++];}
		return null;
	}

}
