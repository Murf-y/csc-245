/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 12, 2022
 * LastModified: Feb 12, 2022
 * FileName: Color.java
 *****************************************************
 */
package Assignement2.utils;

public class Color {
	private int red;
	private int green;
	private int blue;
	
	public Color(int r, int g, int b) {
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	public String toString() {
		return String.format("(%s, %s, %s)", red,green,blue);
	}
}
