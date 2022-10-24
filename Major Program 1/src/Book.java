
public class Book {
	/* Details the creation of a Book object that with title, publisher, genre,
	 * Author, year, rating, and price attributes.
	 * Used in the BookDatabase object.
	 * Print info method prints out detailed information about the Book's attributes.
	 */
	private Author author;
	private String title, publisher, genre;
	private int year;
	private double rating, price;
	
	public Book() {
		author = null;
		title = "";
		publisher = "";
		genre = "";
		year = 0;
		rating = 0.0;
		price = 0.0;
	}
	public Book(Author bookAuthor, String bookTitle, String bookPublisher, String bookGenre, int bookYear, double bookRating, double bookPrice) {
		author = bookAuthor;
		title = bookTitle;
		publisher = bookPublisher;
		genre = bookGenre;
		year = bookYear;
		rating = bookRating;
		price = bookPrice;
	}
	
	public void setAuthor(Author userAuthor) {
		author = userAuthor;
	}
	public Author getAuthor() {
		return author;
	}
	
	public void setTitle(String userTitle) {
		title = userTitle;
	}
	public String getTitle() {
		return title;
	}
	
	public void setPublisher(String userPublisher) {
		publisher = userPublisher;
	}
	public String getPublisher() {
		return publisher;
	}

	public void setGenre(String userGenre) {
		genre = userGenre;
	}
	public String getGenre() {
		return genre;
	}
	
	public void setYear(int userYear) {
		year = userYear;
	}
	public int getYear() {
		return year;
	}
	
	public void setRating(double userRating) {
		rating = userRating;
	}
	public double getRating() {
		return rating;
	}
	
	public void setPrice(double userPrice) {
		price = userPrice;
	}
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return String.format("%s, by %s", title, author);
	}
	public void printInfo() {
		/* Prints out the full set of a Book's attributes
		 */
		String str = String.format("""
				%s
				by %s
				Published in %d by %s
				Genre: %s
				Price: $%.2f
				Rating: %.1f
				""", title, author, year, publisher, genre, price, rating);
		System.out.println(str);
	}
}
