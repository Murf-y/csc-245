package Assignment1;

public class Book {
	private String title;
	private String author;
	private int nbPages;
	private String genre;
	private int nbCopies;
	private float price;
	public Book(String t, String a, int pa, String g,
			int c, float p) {
		title = t;
		author = a;
		nbPages = pa;
		genre = g;
		nbCopies = c;
		price = p;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String t) {
		title = t;
	}
	public String getAuthor() {
		return author;
	}
	public boolean equals(Book b) {
		if(title.equalsIgnoreCase(b.getTitle()) && author.equalsIgnoreCase(b.getAuthor())&& nbPages==b.getNbPages() && genre.equalsIgnoreCase(b.getGenre()) && nbCopies==b.getNbCopies() &&price==b.getPrice()){
			return true;
		}
		return false;
	}
	public String toString() {
		return "Title: " + title + " Author: " + author + " Number of Pages: "
				+ nbPages + " Genre: " + genre + " Number of Copies: " + nbCopies
				+ " Price: " + price;
	}
	public void setAuthor(String a) {
		author = a;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int pa) {
		nbPages = pa;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String g) {
		genre = g;
	}
	public int getNbCopies() {
		return nbCopies;
	}
	public void setNbCopies(int c) {
		nbCopies = c;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float p) {
		price = p;
	}
	
}
