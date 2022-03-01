package Shapes;

public class Triangle extends Shape{
	private int[] sides;
	public Triangle(String c, int x,int y, int[] s){
		super(c,x,y);
		sides=s;
	}
	public Triangle(String c, int x,int y){
		super(c,x,y);
	}
	public int[] getSides() {
		return sides;
	}
	public void setSides(int[] s) {
		sides = s;
	}
	public String toString(){
		return "triangle, "+super.toString() + ", "+sides[0]+", "+sides[1]+", "+sides[2];
	}
	public boolean equals(Triangle t){
		boolean arr=true;
		for(int i=0;i<sides.length;i++){
			if(sides[i]!=t.getSides()[i]){
				arr=false;
			}
		}
		return super.equals(t) && arr;
	}
	public double perimeter(){
		return sides[0]+sides[1]+sides[2];
	}
	public double area(){
		double s=perimeter()/2;
		return Math.sqrt((s)*(s-sides[0])*(s-sides[1])*(s-sides[2]));
	}
	public int getBound(){
		int max=0;
		for(int i=0;i<sides.length;i++){
			if(sides[i]>max){
				max=sides[i];
			}
		}
		return max;
	}
}
