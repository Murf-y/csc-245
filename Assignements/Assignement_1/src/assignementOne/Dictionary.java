/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: FEB 1, 2022
 * LastModified: Feb 3, 2022
 * FileName: Dictionary.java
 *****************************************************
 */

package assignementOne;

public class Dictionary extends Book {
	
	// Instance variables  --------------------------------------------
	
	private int number_of_volumes;
	//-----------------------------------------------------------------
	
	
	// Getters  -------------------------------------------------------
	
	public int getNumberOfVolumes() {
		return number_of_volumes;
	}
	//----------------------------------------------------------------
	
	
	// Setters  ------------------------------------------------------
	public void setNumberOfVolumes(int number_of_volumes) {
		this.number_of_volumes = number_of_volumes;
	}
	//----------------------------------------------------------------
	
	
	// Constructor ---------------------------------------------------
	
	public Dictionary(String title) {
		// Dictionaries does not have a single author
		super(title);
		this.author = "Multiple Authors";
		this.number_of_volumes = 0; 
	}
	//----------------------------------------------------------------
	
	@Override
	public boolean equals(Book other_book) {
		// If the otherBook is not a dictionary return false
		if(!(other_book instanceof Dictionary)) {
			return false;
		}
		else {
		// Returns true if the two dictionaries have the same title
		// Which mean they are equal
			return super.isSameTitleAs(other_book);
		}
	}
	
	@Override
	public String toString() {
		
		// Use the base class toString method, we dont need to write it here
		// Add E at the beginning of the string to indicate that this is a Dictionary
		return String.format("E ,"+
							"%s ,"+
							"Number of volumes: %d .", super.toString(), this.number_of_volumes);
	}
	
}
