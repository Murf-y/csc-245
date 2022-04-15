package Q2;

public class Cow extends Animal{

	public Cow(int a, String c, String g, int co) {
		super(a, c, g, co);
	}
	public void eat(){
		System.out.println("It consumes "+getConsumption()+" g");
	}
	public String toString(){
		return "Cow	"+super.toString();
	}
}
