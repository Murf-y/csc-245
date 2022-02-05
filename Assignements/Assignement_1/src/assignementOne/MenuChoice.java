/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Jan 31, 2022
 * LastModified: Jan 3, 2022
 * FileName: Choice.java
 *****************************************************
 */
package assignementOne;

// Enum to represent a possible MenuChoice choosen by the user
public enum MenuChoice {
    ADD_BOOK,
    DELETE_BOOK,
    SELL_BOOK,
    LIST_ALL_BOOKS,
    EXIT;
    
	// This method should be static because we wont use a class instance to call it
    public static MenuChoice getChoice(int response) {
    	// Get the MenuChoice corresponding for a user response
    	// Note that response is a int between 1 - 5 
    	switch(response) {
	    	case 1:{
	    		return ADD_BOOK;
	    		
	    	}
	    	case 2:{
	    		return DELETE_BOOK;
	    		
	    	}
	    	case 3:{
	    		return SELL_BOOK;
	    		
	    	}
	    	case 4:{
	    		return LIST_ALL_BOOKS;
	    		
	    	}
	    	case 5:{
	    		return EXIT;
	    		
	    	}
	    	// Default case when the given response does not match any possible choice
		  	// This case is not supposed to happen since input is validated
		  	// but in case it happens, the program exit . . .
	    	default:{
	    		return EXIT;
	    	}
    	}
    }
}
