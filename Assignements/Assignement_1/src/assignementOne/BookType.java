/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 2, 2022
 * LastModified: Feb 2, 2022
 * FileName: BookType.java
 *****************************************************
 */
package assignementOne;


// Enum to represent possible Book Types
public enum BookType {
	BOOK,
	DICTIONARY;
	
	// Get the book type base on user response
	// Response is between 1 and 2
	// Response is not validate as per assignement speciication
	public static BookType getBookType(int response) {
		return 	response == 1 ? BOOK : DICTIONARY;
	}
}
