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

	public Book getBookAt(int index){
		return index<0?null:books[index];
	}

	public int getLength(){
		return books.length;
	}

	@Override
	public MyIterator createIterator() {
		return new BookShelfItertor(this);
	}
	
	
}
