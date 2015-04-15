package designpatterns.iterator;

public class Client {

	public static void main(String[] args) {
		Book[] books=new Book[3];
		books[0]=new Book("Design Patterns","Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides");
		books[1]=new Book("Web application architecture","Leon Shklar and Rich Rosen");
		books[2]=new Book("Internet and WWW How To Program","PaulDeitel, Harvey Deitel and Abbey Deitel");
		BookShelf bsh=new BookShelf(books);
		MyIterator it=bsh.createIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
