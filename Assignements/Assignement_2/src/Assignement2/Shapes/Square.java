/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 12, 2022
 * LastModified: Feb 12, 2022
 * FileName: Square.java
 *****************************************************
 */
package Assignement2.Shapes;

import Assignement2.Shape;
import Assignement2.ShapeType;
import Assignement2.utils.Color;
import Assignement2.utils.MathHelper;

public class Square extends Shape{

	private float side;
	
	public Square(float x, float y, Color c, float s)
	{
		super(x,y, c); 
		type = ShapeType.SQUARE;
		
		side = s;
	}

	public Square(float x, float y, float s)
	{
		super(x,y); 
		type = ShapeType.SQUARE;
		
		side = s;
	}
	


	public float getSide()
	{
		return side;
	}

	public void setSide(float s)
	{
		side = s;
	}

	public String toString()
	{
		// Ouput in the form
		// Square:
		//		SideLength: 2
		// 		Coordinates: (1, 2)
		//		Color: (125, 255, 255)
		return String.format("Square:\n\tSideLength: %s \n\t%s", side, super.toString());
	}

	public boolean equals(Square s) {
		return super.equals(s) 
				&& MathHelper.floatAproxEquals(side, s.getSide());
	}
	public double area()
	{
		return side*side ;
	}

	public double perimeter()
	{
		return 4*side;
	}
}
