/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 12, 2022
 * LastModified: Feb 12, 2022
 * FileName: Shape.java
 *****************************************************
 */
package Assignement2;

import Assignement2.utils.Color;
import Assignement2.utils.MathHelper;

public abstract class Shape {

	protected float x_coordinate;
	protected float y_coordinate;
	protected Color color ; 
	
	protected final int dimension = 2;
	protected ShapeType type;

	public Shape(float x, float y)
	{
		x_coordinate = x;
		y_coordinate = y;
		color = null;
	}
	
	public Shape(float x, float y , Color c )
	{
		x_coordinate = x;
		y_coordinate = y;
		color = c;

	}

	public float getXCoordinate()
	{
		return x_coordinate;
	}

	public float getYCoordinate()
	{
		return y_coordinate;
	}

	public String getColor()
	{
		if(color != null)
			return color.toString();
		else
			return "No color." ;
	}
	
	public ShapeType getShapeType() {
		return type;
	}
	
	public void setXCoordinate(float x)
	{
		if(x_coordinate < 100 && x_coordinate > -100) {			
			x_coordinate = x;
		}
		else {
			System.out.println("X coordinates cannot go out of range [-100 - 100]");	
		}
	}

	public void setYCoordinate(float y)
	{
		if(y_coordinate < 100 && y_coordinate > -100) {			
			y_coordinate = y;
		}
		else {
			System.out.println("X coordinates cannot go out of range [-100 - 100]");	
		}
	}

	public void setColor(int r , int g , int b)
	{
		Color C = new Color(r,g,b);
		color = C;
	}

	public String toString()
	{
		// Ouput in the form
		// 		Coordinates: (1, 2)
		//		Color: (125, 255, 255)
		String s = String.format("Coordinates: (%s, %s)\n\tColor: %s",x_coordinate, y_coordinate, getColor()); 
		return s;
	}
	
	public boolean equals(Shape s) {
		
		// Since float are never exactly equals
		// we should check aproximation with epsilon
		return MathHelper.floatAproxEquals(x_coordinate, s.getXCoordinate()) && 
				MathHelper.floatAproxEquals(y_coordinate, s.getYCoordinate());
	}
	public abstract double area();
	public abstract double perimeter(); 

}
