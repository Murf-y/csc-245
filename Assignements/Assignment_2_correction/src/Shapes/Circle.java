package Shapes;

public class Circle extends Shape{
	private int radius;
	public Circle(String c, int x, int y, int r) {
		super(c, x, y);
		radius=r;
	}
	public String toString(){
		return "circle, "+super.toString() + ", "+radius;
	}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int r) {
		radius = r;
	}
	public boolean equals(Circle c){
		return super.equals(c) && radius==c.getRadius();
	}
	public double perimeter(){
		return 2*Math.PI*radius;
	}
	public double area(){
		return Math.PI*Math.pow(radius, 2);
	}
	public int getBound(){
		return radius;
	}
}
