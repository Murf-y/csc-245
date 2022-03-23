/* ****************************************************
 *
 * Author: Anonymous
 * Id: xxx
 * 
 * Date: Mar 22, 2022
 * LastModified: Mar 22, 2022
 * FileName: Application.java
 *****************************************************
 */
package questionTwo;

public interface Sortable {
	public int compareTo(Object o);
	/*	a.compareTo(b) returns 0 if a is equal to b, 
	 *  a number greater than 0 if a is greater than b and 
	 *  a number less than 0 if a is less than b. 
	 *  Animals are compared by age.*/
}
