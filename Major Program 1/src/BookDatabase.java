import java.util.ArrayList;

public class BookDatabase {
	/* Details the creation of a Book Database object that can contain multiple
	 * Book objects.  
	 * Contains methods for searching through the database for specific books
	 * based on search criteria.
	 */
	private ArrayList<Book> books;
	
	public BookDatabase() {
		books = new ArrayList<Book>();
	}
	public BookDatabase(ArrayList<Book> arrayBooks) {
		books = arrayBooks;
	}
	
	public void setBooks(ArrayList<Book> userBooks) {
		books = userBooks;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public void addBook(Book bk) {
		books.add(bk);
	}
	
	public void removeBook(Book bk) {
		books.remove(bk);
	}
	
	public String toString() {
		/* A method for printing out book information for all books in the database
		 */
		String bookList = "List of books in the database:";
		for(Book bk :	books) {
			bookList += ("\n" + bk.toString());
		}
		return bookList;
	}
	
	public void searchAuthor(String ath) {
		/* Loops through the database and prints the info for any book who's author
		 * matches the search criteria.
		 */
		for(Book bk	:	books) {
			if (bk.getAuthor().toString().equalsIgnoreCase(ath)) {
				bk.printInfo();
			}
		}
	}
	
	public void searchGenre(String gen) {
		/* Loops through the database and prints the info for any book who's genre
		 * matches the search criteria.
		 */
		for(Book bk	:	books) {
			if (bk.getGenre().equalsIgnoreCase(gen)) {
				bk.printInfo();
			}
		}
	}
	
	public void searchYear(int start, int end) {
		/* Loops through the database and prints the info for any book who's date
		 * lies between the search criteria.
		 */
		for(Book bk	:	books) {
			if ((bk.getYear() >= start) && (bk.getYear() <= end)) {
				bk.printInfo();
			}
		}
	}
}
