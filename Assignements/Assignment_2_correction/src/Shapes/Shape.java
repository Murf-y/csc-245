package Shapes;

public abstract class Shape {
	private String color;
	private int X;
	private int Y;
	final private int dimensions =2;
	public Shape(String c,int x,int y){
		color=c;
		X=x;
		Y=y;
	}
	public abstract int getBound();
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		color = c;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public String toString() {
		return color+", "+X+", "+Y;
	}
	public boolean equals(Shape s){
		return color.equals(s.getColor())&&X==s.getX()&&Y==s.getY();
	}
	public abstract double area();
	public abstract double perimeter();
}
