/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Jan 31, 2022
 * LastModified: Jan 2, 2022
 * FileName: Book.java
 *****************************************************
 */

package assignementOne;

public class Book {
	
	// Instance Variables -------------------------------------------
	protected String title;
	protected String author;
	protected int number_of_pages;
	protected String genre;
	protected int number_of_copies;
	protected float price;
	//---------------------------------------------------------------
	
	// Getters ------------------------------------------------------
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getNumberOfPages() {
		return number_of_pages;
	}
	public String getGenre() {
		return genre;
	}
	public int getNumberOfCopies() {
		return number_of_copies;
	}
	// ---------------------------------------------------------------
	
	// Setters ------------------------------------------------------
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setNumberOfPages(int number_of_pages) {
		this.number_of_pages = number_of_pages;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setNumberOfCopies(int number_of_copies) {
		this.number_of_copies = number_of_copies;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	//----------------------------------------------------------------
	
	// Constructor ---------------------------------------------------
	
	// Used To instantiate a book with a title and an author
	// All other fields are set to default value
	public Book(String title, String author) {
		
		// number_of_copies Should start with 
		// because this book is a technically a copy
		
		this.title = title;
		this.author = author;
		this.number_of_pages = 0;
		this.genre = "Unknown";
		this.number_of_copies = 1;
		this.price = 0F;
	}
	
	// Used To instantiate a book with only a title
	// In this case it is used when instantiating a dictionary
	// The author field is handled in the dictionary constructor
	// All other fields are set to default value
	public Book(String title) {
		this.title = title;
		this.number_of_pages = 0;
		this.genre = "Unknown";
		this.number_of_copies = 1;
		this.price = 0F;
	}
	//----------------------------------------------------------------

	
	public boolean isSameTitleAs(Book other_book) {

		// Check if this book and the otherBook have the same title
		
		return (this.title.equalsIgnoreCase(other_book.title));
	}
	
	public void incrementNumberOfCopies() {
		this.number_of_copies++;
	}
	public void decrementNumberOfCopies() {
		// Only decrement when needed
		if(this.number_of_copies > 0) {
			number_of_copies--;
		}
	}

	public boolean equals(Book other_book) {
		
		// Make sure that the other_book fields are not null
		// This is useful when the other_book is a dictionary
		if(other_book.title.equals(null) || other_book.author.equals(null) ) {
			return false;
		}
		
		// Check if this book and the otherBook have the same title and same author
		return (this.title.equalsIgnoreCase(other_book.title)) && 
				(this.author.equalsIgnoreCase(other_book.author));
	}

	public String toString() {
		return String.format( "Title: %s,"
							+ " Author: %s,"
							+ " Number of pages: %d,"
							+ " Genre: %s,"
							+ " Number of copies: %d,"
							+ " Price: %f",
							title, author,number_of_pages, genre, number_of_copies, price);
	}
}
