package Farm;

public class Horse extends Animal{

	public Horse(int a, String c, String g, int co) {
		super(a, c, g, co);
	}
	public void eat(){
		System.out.println("It consumes "+getConsumption()+" g");
	}
	public String toString(){
		return "Horse	"+super.toString();
	}
}
