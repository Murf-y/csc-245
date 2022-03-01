package Shapes;

public class EquilateralTriangle extends Triangle{
	public EquilateralTriangle(String c, int x,int y, int[] s){
			super(c,x,y,s);
	}
	public String toString(){
		return "equilateral "+super.toString();
	}
}
