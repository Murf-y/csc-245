/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 12, 2022
 * LastModified: Feb 12, 2022
 * FileName: EquilateralTriangle.java
 *****************************************************
 */
package Assignement2.Shapes;

import Assignement2.ShapeType;
import Assignement2.utils.Color;
import Assignement2.utils.MathHelper;

public class EquilateralTriangle extends Triangle{
	
	public EquilateralTriangle(float x , float y , Color c, float side)
	{
		super(x,y,c,side,side,side); 
		type = ShapeType.EQUILATERAL_TRIANGLE;
	}
	
	
	public EquilateralTriangle(float x , float y , float side)
	{
		super(x,y,side,side,side);  
		type = ShapeType.EQUILATERAL_TRIANGLE;
	}
	
	
	public String toString()
	{	
		// We can directly use sides[0] because all sides are equal
		
		// Ouput in the form
		// 	Equilateral-Triangle:
		//			SideLength: 12
		// 			Coordinates: (1, 2)
		//			Color: (125, 255, 255)
		return String.format("Equilateral %s", super.toString());
	}
	public boolean equals(EquilateralTriangle t) {
		return super.equals(t) && MathHelper.floatAproxEquals(sides[0], t.getSideLengthAtIndex(0));
	}
	public double area()
	{
		return ((sides[0]*sides[0])*(Math.sqrt(3)))/4 ;
	}
	
	public double perimeter()
	{
		return sides[0]*3;
	}
	
}
