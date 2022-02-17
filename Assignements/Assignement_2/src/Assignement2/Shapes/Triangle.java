/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 12, 2022
 * LastModified: Feb 12, 2022
 * FileName: Triangle.java
 *****************************************************
 */
package Assignement2.Shapes;

import Assignement2.Shape;
import Assignement2.ShapeType;
import Assignement2.utils.Color;
import Assignement2.utils.MathHelper;

public class Triangle extends Shape{
	
	protected float[] sides ;

	public Triangle(float x, float y , Color c, float s1 , float s2 , float s3)
	{
		super(x,y,c); 
		type = ShapeType.TRIANGLE;
		
		
		sides = new float[] {s1,s2,s3};
	}

	public Triangle(float x, float y , float s1 , float s2 , float s3)
	{
		super(x,y); 
		type = ShapeType.TRIANGLE;
		
		
		sides = new float[] {s1,s2,s3};

	}
	public float getSideLengthAtIndex(int index)
	{
		if(index >=0 || index <= 2) {			
			return sides[index];
		}
		else {
			return 0;
		}
	}

	public void setSideLengthAtIndex(int index, float side_length)
	{
		if(index >=0 || index <= 2) {			
			sides[index] = side_length;
		}
	}

	public String toString()
	{
		// Ouput in the form
		// Triangle:
		//		Sides: (14, 10, 16)
		// 		Coordinates: (1, 2)
		//		Color: (125, 255, 255)
		return String.format("Triangle:\n\tSides: (%s, %s, %s)\n\t%s", sides[0], sides[1], sides[2], super.toString());
	}
	public boolean equals(Triangle t) {
		return super.equals(t) 
				&& MathHelper.floatAproxEquals(sides[0], t.getSideLengthAtIndex(0))
				&& MathHelper.floatAproxEquals(sides[1], t.getSideLengthAtIndex(1))
				&& MathHelper.floatAproxEquals(sides[2], t.getSideLengthAtIndex(2));
	}
	public String grandParentToString() {
		return super.toString();
	}

	public double area()
	{
		double s = 0.5 * (sides[0] + sides[1] + sides[2]);
		return Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]));
	}

	public double perimeter()
	{
		return sides[0] + sides[1] + sides[2];
	}
}
