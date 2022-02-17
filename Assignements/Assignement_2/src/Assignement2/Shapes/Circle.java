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

public class Circle extends Shape{
	
	private float radius;
	public Circle (float x, float y, Color c, float r)
	{
		super(x,y,c);
		type = ShapeType.CIRCLE;
		
		
		radius = r;
	}

	public Circle (float x, float y, float r)
	{
		super(x,y); 
		type = ShapeType.CIRCLE;
		
		
		radius = r;
	}
	
	public float getRadius()
	{
		return radius;
	}

	public void setRadius(float r)
	{
		radius = r;
	}

	public String toString()
	{
		// Ouput in the form
		// Circle:
		//		Radius: 1.5
		// 		Coordinates: (1, 2)
		//		Color: (125, 255, 255)
		return String.format("Circle:\n\tRadius: %s\n\t%s", radius, super.toString());
	}
	
	public boolean equals(Circle c) {
		return super.equals(c) && MathHelper.floatAproxEquals(radius, c.getRadius());
	}
	public double area()
	{
		return Math.PI*radius*radius;
	}

	public double perimeter()
	{
		return Math.PI*2*radius;
	}

}
