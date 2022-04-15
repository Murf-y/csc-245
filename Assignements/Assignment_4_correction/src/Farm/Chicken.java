package Farm;

public class Chicken extends Animal{

	public Chicken(int a, String c, String g, int co) {
		super(a, c, g, co);
	}
	public void eat(){
		System.out.println("It consumes "+getConsumption()+" g");
	}
	public String toString(){
		return "Chicken	"+super.toString();
	}
}
