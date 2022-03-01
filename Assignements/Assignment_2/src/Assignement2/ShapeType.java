/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 12, 2022
 * LastModified: Feb 12, 2022
 * FileName: ShapeType.java
 *****************************************************
 */
package Assignement2;

public enum ShapeType {
	CIRCLE, SQUARE,TRIANGLE, EQUILATERAL_TRIANGLE;
	
	public static ShapeType getShapeFromChar(char c) {
		switch(c) {
			case 'A':{
				return CIRCLE;
			}
			case 'B':{
				return SQUARE;
			}
			case 'C':{
				return TRIANGLE;
			}
			case 'D':{
				return EQUILATERAL_TRIANGLE;
			}
			default:{
				return CIRCLE;
			}
		}
	}
	public static ShapeType getShapeFromName(String c) {
		switch(c) {
			case "circle":{
				return CIRCLE;
			}
			case "square":{
				return SQUARE;
			}
			case "triangle":{
				return TRIANGLE;
			}
			case "equilateral triangle":{
				return EQUILATERAL_TRIANGLE;
			}
			default:{
				return CIRCLE;
			}
		}
	}
}
