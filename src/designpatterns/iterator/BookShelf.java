package designpatterns.iterator;

public class BookShelf implements MyComponent {

	private Book[] books;

	public BookShelf(Book[] books) {
		super();
		this.books = books;
	}

	public Book[] getBooks() {
		return books;
	}

	@Override
	public MyIterator createIterator() {
		return new BookShelfItertor(this);
	}
	
	
}
