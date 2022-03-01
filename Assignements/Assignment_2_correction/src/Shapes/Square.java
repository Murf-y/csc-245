package Shapes;

public class Square extends Shape{
	private int sideLength;
	public Square(String c, int x, int y, int s) {
		super(c, x, y);
		sideLength=s;
	}
	public int getSideLength() {
		return sideLength;
	}
	public void setSideLength(int s) {
		sideLength = s;
	}
	public String toString(){
		return "square, "+super.toString() + ", "+sideLength;
	}
	public boolean equals(Square s){
		return super.equals(s) && sideLength==s.getSideLength();
	}
	public double perimeter(){
		return 4*sideLength;
	}
	public double area(){
		return Math.pow(sideLength, 2);
	}
	public int getBound(){
		return (sideLength/2);
	}
}
