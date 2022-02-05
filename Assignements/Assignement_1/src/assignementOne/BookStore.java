/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Jan 31, 2022
 * LastModified: Jan 2, 2022
 * FileName: BookStore.java
 *****************************************************
 */
package assignementOne;

// Imports --------------------------------------
import java.util.InputMismatchException;
import java.util.Scanner;
// ----------------------------------------------


public class BookStore {
	
	
	// Instance Variables ---------------------------------------------
	
	private int invalidChoiceAttempts = 0; // Current user invalid choice input attempts	
	private final int MAX_INVALID_ATTEMPTS = 5;// Maximum user invalid input attempts, When passed the user exit the program

	private Scanner input_scanner;
	private Book[] books;
	// ----------------------------------------------------------------
	
	
	
	// UI Related Methods ---------------------------------------------
	public void printDashedLine() {
		// Print a dashed line in the terminal
		System.out.println("\n-----------------------------------------------\n");
	}
	public void printBookMissingError() {
		System.out.println("This book does not exists in the Book Store!\nAre you missing something?");
		printDashedLine();
	}
	public int readValidMenuInt(String prompt) {
		/*
		 * Try to get a valid Menu choice from the user .
		 * Filters characters and out of bound integers.
		 * Checks for number of invalid attempts so far .
		 * 
		 * Note that we can use a do While loop to this job instad of try/catch
		 * but i think this is a good job of the try/catch.
		 */

		
		// Exit the program after MAX_INVALID_ATTEMPTS has been passed
		if (invalidChoiceAttempts >= MAX_INVALID_ATTEMPTS) {
			this.close();
		}

		// Ask the user to enter their choice
		System.out.print(prompt);

		// Try catch block to catch any InputMismatch
		try {
			// Read the input from the user
			// @throws InputMismatchException
			int inputInt = input_scanner.nextInt();
			
			// Re put the scanner cursor on the new line
			input_scanner.nextLine();
			
			
			// Check if the input is between the range of the menu options
			if (inputInt < 1 || inputInt > 5) {
				
				invalidChoiceAttempts++;
				System.out.println("Invalid input. Please enter a number between 1 and 5, Attempts left: "
						+ (MAX_INVALID_ATTEMPTS - invalidChoiceAttempts));
				
				// Re ask the user to enter a choice
				return readValidMenuInt(prompt);
			}else {
				
				// Ensure that the scanner instance state is re seted
				input_scanner = new Scanner(System.in);
				// Return the valid input response of the user
				return inputInt;
			}
		}

		// Thrown when the input is not an integer
		catch (InputMismatchException e) {
			
			invalidChoiceAttempts++;
			System.out.println("Invalid input. Please enter an Integer, Attempts left: "
					+ (MAX_INVALID_ATTEMPTS - invalidChoiceAttempts));
			
			// Instantiate a new scanner instance to 
			// ensure that the next input is only typed by the user
			input_scanner = new Scanner(System.in);
			
			// Re ask the user to enter a choice
			return readValidMenuInt(prompt);
		}
	}
	public void displayChoicesMenu() {
		printDashedLine();
		final String menu = "1.Add book\r\n" +
							"2.Delete book\r\n" +
							"3.Sell book\r\n" +
							"4.List all\r\n" +
							"5.Exit\r\n"+
							"----------------------\r\n";
		System.out.print(menu);
	}
	public void displayBookTypeMenu() {
		printDashedLine();
		String displayMessage = "Please Choose A Book Type:\n"+
								"1. Book\n"+
								"2. Dictionary\n"+
								"---------------------------\n"+
								"Enter your choice [1 - 2]: ";
		System.out.print(displayMessage);
	}
	public int getMenuResponseAsInt() {

		// Display the menu for the user
		displayChoicesMenu();

		// Prompt the user to enter a Response
		// Validate the response entered by the user
		int response = readValidMenuInt("Enter your choice: ");

		return response;
	}
	public MenuChoice getMenuResponseAsChoice() {
		// Get the starting response from the user AS ENTERED
		int responseInt = getMenuResponseAsInt();

		// Get the MenuChoice value of that response and return it
		return MenuChoice.getChoice(responseInt);
	}
	
	public String getBookTitleFromUser(BookType book_type) {
		if(book_type == BookType.BOOK) {
			System.out.print("\t>>> Enter the Book title: ");
		}
		else {
			System.out.print("\t>>> Enter the Dictionary title: ");
		}
		
		
		// scan for new input
		String enteredResponse = input_scanner.nextLine();
		
		return enteredResponse;
	}
	public String getBookAuthorFromUser() {
		
		// No need to check for book type
		// because only Books of Type BOOK can have an author.
		
		System.out.print("\t>>> Enter the Book author: ");

				
		// scan for new input	
		String enteredResponse = input_scanner.nextLine();

		return enteredResponse;
	}
	public boolean bookWithSameTitleExists(Book book) {
		// Check if a book with the same title exists
		
		BookType book_type = getBookType(book);
		for(int i = 0; i < books.length; i++){
			if(books[i] != null) {
				BookType current_book_type = getBookType(books[i]);
				if(book_type.equals(current_book_type) && book.isSameTitleAs(books[i])) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean bookAlreadyExists(Book book) {
		
		// Check if a book with the same title and author exists IN CASE OF A BOOK
		// Check if a book with the same title exists 			 IN CASE OF A DICTIONARY
		
		BookType book_type = getBookType(book);
		for(int i = 0; i < books.length; i++){
			if(books[i] != null) {
				BookType current_book_type = getBookType(books[i]);
				if(book_type.equals(current_book_type) && book.equals(books[i])) {
					return true;
				}
			}
		}
		return false;
	}
	public void updateBookStateInBooks(Book book) {
		for(int i =0; i< books.length; i++) {
			if(books[i] != null) {
				if(book.equals(books[i])) {
					books[i] = book;
					break;
				}
			}
		}
	}
	public Book getBookFromUserInput(BookType book_type) {
		// Check each Book type individually 
		
		
		// Instantiate a book object with title from the user and return it
		// If a book with the same title already exist 
		// return a Book object with a title and an author.
		Book book;
		if(book_type == BookType.BOOK) {
			String enteredTitle = getBookTitleFromUser(BookType.BOOK);	
			String enteredAuthor = getBookAuthorFromUser();
			book = new Book(enteredTitle, enteredAuthor);
			return book;
		}
		
		// Instantiate a Dictionary object with title from the user and return it
		else {
			String enteredTitle = getBookTitleFromUser(BookType.DICTIONARY);
			book = new Dictionary(enteredTitle);
			return book;
		}
		
		
	}
	public BookType getBookType(Book book) {
		return book instanceof Dictionary ? BookType.DICTIONARY : BookType.BOOK;
	}
	public Book getBookFromBooks(Book book) {
		for(int i =0; i< books.length; i++) {
			if(books[i] != null) {
				if(book.equals(books[i])) {
					return books[i];
				}
			}
		}
		return book;
	}
	public BookType userChooseBookType() {
		// Prompt the user to choose the book type:
		//	Book
		//	Dictionary
		
		// Display the menu so the user can choose a book type
		displayBookTypeMenu();
		
		// As per Assignment we dont validate user input here
		int response = input_scanner.nextInt();
		
		// Re put the cursor on a new line
		input_scanner.nextLine();
		
		// Return the appropriate book type as per user response
		return BookType.getBookType(response);
	}
	// ----------------------------------------------------------------
	
	
	// Events + Utils ----------------------------------------
	public void addBookToBooks(Book book) {
		
		// Check for empty Spaces in the array to add a book
		// Note that the books array elements are always left aligned
		// If no empty space is available, create a new array with lenght n+10
		// where n is the lenght of the original array
		
		
		// Check for available space in the array to put the book 
		for(int i =0; i<books.length; i++) {
			if(books[i] == null) {
				books[i] = book;
				return;
			}
		}
		
		// If this part of the code is reached then the array was full
		
		int old_array_size = books.length;
		Book[] new_books_array = new Book[old_array_size + 10];
		
		// Copy the old array into the new one
		for(int i=0; i<old_array_size; i++) {
			new_books_array[i] = books[i];
		}
		
		// Add the book
		new_books_array[old_array_size] = book;
		
		// Re update the state of books
		books = new_books_array;
	}
	public void handleAddBookEvent() {
		
		// Prompt the user which book type to add
		BookType book_type = userChooseBookType();
		
		Book book = getBookFromUserInput(book_type);
		
		// Check if a book equal to this book already exists in the store
		if(bookAlreadyExists(book)) {
			book = getBookFromBooks(book);
			book.incrementNumberOfCopies();
			updateBookStateInBooks(book);
		}else {					
			addBookToBooks(book);
		}
		printDashedLine();
	}


	public void deleteBookFromBooks(Book book) {
		
		// Loop through the array and copy each element into a new array, that will not contains the book
		
		int size = books.length;
		Book[] new_books_array = new Book[size-1];
		
		for(int i = 0, j=0; i< size; i++) {
			if(books[i] != null) {
				if(!books[i].equals(book)) {
					new_books_array[j] = books[i];
					j++;
				}
			}
		}
		
		// Re update the state of the books
		books = new_books_array;
	}
	public void handleDeleteBookEvent() {
		
		// Get the type of the Book that the user want to delete
		BookType book_type = userChooseBookType();
		
		// Get the book title that the user want to delete.
		String enteredTitle = getBookTitleFromUser(book_type);
		Book book;
		
		// If it is a BOOK get the author name
		if(book_type == BookType.BOOK) {
			String enteredAuthor = getBookAuthorFromUser();
			
			// Instantiate a book object with the same title and author
			book = new Book(enteredTitle, enteredAuthor);
		}
		else {
			// Instantiate a Dictionary object with the same title
			book = new Dictionary(enteredTitle);
		}
		
		// Check if the book already exists in the book store, if so, Delete it.
		if(bookAlreadyExists(book)) {
			
			deleteBookFromBooks(book);
		}
		// If it does not exists display an error message to the user.
		else {
			printBookMissingError();
		}
	}
	
	
	public void sellBookFromBooks(Book book) {
		// Decrease the number of copies of the book
		book = getBookFromBooks(book);
		book.decrementNumberOfCopies();
		
		// Check if its zero, if so delete the book from the book store
		if(book.getNumberOfCopies() == 0) {
			deleteBookFromBooks(book);
		}
	}
	public void handleSellBookEvent() {
		// Get the type of the Book that the user want to delete
		BookType book_type = userChooseBookType();
		
		// Get the book title that the user want to delete.
		String enteredTitle = getBookTitleFromUser(book_type);
		Book book;
			
		// If it is a BOOK get the author name
		if(book_type == BookType.BOOK) {
			String enteredAuthor = getBookAuthorFromUser();
				
			// Instantiate a book object with the same title and author
			book = new Book(enteredTitle, enteredAuthor);
		}
		else {
			// Instantiate a Dictionary object with the same title
			book = new Dictionary(enteredTitle);
		}
				
		// Check if the book already exists in the book store, if so, Try to sell it.
		if(bookAlreadyExists(book)) {
			
			sellBookFromBooks(book);
		}
		
		// If it does not exists display an error message to the user.
		else {
			printBookMissingError();
			
		}
		
	}
	
	
	public boolean isBookStoreEmpty() {
		boolean empty = true;
		for (int i=0; i<books.length; i++) {
		  if (books[i] != null) {
		    empty = false;
		    break;
		  }
		}
		return empty;
	}
	public void handleListAllBooksEvent() {
		
		// Print all books using their own implemantation of the toString method
		// Dictionaries will have an Extra "E" in front of them.
		
		// Check if books array is empty, if so ddisplay a special message
		if(isBookStoreEmpty()) {
			printDashedLine();
			System.out.println("Book Store is empty, Consider adding a Book!");
			printDashedLine();
		}else {
			printDashedLine();
			System.out.println("List of Books in our Store:\n");
			for(int i = 0; i< books.length; i++) {
				if(books[i] != null) {				
					System.out.println(books[i].toString());
				}
			}
			printDashedLine();
		}
		
	}

	// Event Handler depending on the user choice
	public void handleChoice(MenuChoice choice) {
		// Handle each event for each user choice.
		// Default case is EXIT, Even though the user input is filtered.
		switch(choice) {
			case ADD_BOOK:{
				handleAddBookEvent();
				break;
			}
			case DELETE_BOOK:{
				handleDeleteBookEvent();
				break;
			}
			case SELL_BOOK:{
				handleSellBookEvent();
				break;
			}
			case LIST_ALL_BOOKS:{
				handleListAllBooksEvent();
				break;
			}
			default:{
				this.close();
				break;
			}
		}
	}
	// ----------------------------------------------------------------
	
	
	
	
	// Main Methods ---------------------------------------------------
	
	// Open the BookStore
	public void open() {
		
		// This is usually where we retrive the books from the database
		// and initialize all variables;
		books = new Book[10];
		input_scanner = new Scanner(System.in);
		
		MenuChoice user_choice;

		do {
			user_choice = getMenuResponseAsChoice();
			handleChoice(user_choice);
			
		}while(user_choice != MenuChoice.EXIT);
		
		// When this part of code is reach the user Choose EXIT
		this.close();
	}
	
	//Close the BookStore
	public void close() {
		
		// Exits the program with a good bye message
		printDashedLine();
		System.out.println("Exiting the program, Beep Boop . . .");
		System.exit(0);
	}
	
	// Main entry point of the program
	public static void main(String[] args) {
		
		BookStore my_book_store = new BookStore();
		my_book_store.open();
	}
	// ----------------------------------------------------------------

	
}
