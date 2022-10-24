import java.io.*;
import java.util.*;
import java.text.*;

public class bookClient {
	/* Demonstrates reading in a csv file and parsing it to create a BookDatabase and the 
	 * various Book and Author objects with their attributes.  Then demonstrates the various
	 * search methods from the BookDatabase class.
	 */

	public static void main(String[] args) throws IOException {
		/* Initialize variables for Scanner, fileByteStream,BookDatabase, NumberFormat, and
		 * FileInputStream objects.
		 */
		Scanner s = new Scanner(System.in);
	    FileInputStream fileByteStream = null;
	    Scanner inFS = null;
	    String fileName = "dataset.csv";

	    
	    BookDatabase bkDB = new BookDatabase();
	    NumberFormat nf = new DecimalFormat("$###.##");	//used to translate price string to double
	    
	    fileByteStream = new FileInputStream(fileName);
	    inFS = new Scanner(fileByteStream);
	    String header = inFS.nextLine(); //skip header line
	    
	    while(inFS.hasNext()) { // loops through entire csv file to add each Book to database
	    	String[] attributes = inFS.nextLine().split(","); // parse each comma separated line
	    	String auth1st = attributes[0]; // assign each cell to a different attribute
	    	String auth2nd = attributes[1];
	    	String bkTitle = attributes[2];
	    	int pubYear = Integer.parseInt(attributes[3]);
	    	String bkGenre = attributes[4];
	    	String bkPub = attributes[5];
	    	double bkRating = Double.parseDouble(attributes[6]);
	    	double bkPrice = 0.0;
			try {
				bkPrice = nf.parse(attributes[7]).doubleValue();
			} catch (ParseException e) { // exception handling in case price is incorrectly formatted
				e.printStackTrace();
			}
	    	Author author = new Author(auth1st, auth2nd); // Creates Author object
	    	Book book = new Book(author, bkTitle, bkPub, bkGenre, pubYear, bkRating, bkPrice); // Creates book object
	    	bkDB.addBook(book); // adds book to BookDatabase
	    }
	    
	    String menu = "Welcome to the Book Database," // menu of options
	    		+ "\nTo search for books by Author, enter \"a\""
	    		+ "\nTo search for books by published date, enter \"d\""
	    		+ "\nTo search for books by genre, enter \"g\""
	    		+ "\nTo print out a list of books in the database, enter \"p\""
	    		+ "\nTo quite, enter \"q\"";
	    System.out.println(menu);
	    while (true) { // infinite menu loop, executes search functions based on user input
			String str = s.nextLine();
			if (str.equals("q")) {
				System.out.println("Thank you for using our database, goodbye.");
				break;
			}
			else if (str.equals("a")) {
				System.out.println("Enter author name: ");
				String ath = s.nextLine();
				bkDB.searchAuthor(ath);
			}
			else if (str.equals("d")) {
				System.out.println("Enter date range, "
						+ "\nStarting date: ");
				int start = s.nextInt();
				System.out.println("End date: ");
				int end = s.nextInt();
				bkDB.searchYear(start, end);
			}
			else if (str.equals("g")) {
				System.out.println("Enter genre: ");
				String genre = s.nextLine();
				bkDB.searchGenre(genre);
			}
			else if (str.equals("p")) {
				System.out.println(bkDB.toString());
			}
			else if (str.equals("h")) {
				System.out.println(menu);
			}
			else {
				System.out.println("Invalid query");
			}
			System.out.println("Enter another query, enter \"h\" for help");
	    }

	    s.close();
	    inFS.close();
	    fileByteStream.close();
	}
}
