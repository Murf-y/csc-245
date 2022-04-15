package Farm;

public class Dog extends Animal{

	public Dog(int a, String c, String g, int co) {
		super(a, c, g, co);
	}
	public void eat(){
		System.out.println("It consumes "+getConsumption()+" g");
	}
	public String toString(){
		return "Dog	"+super.toString();
	}
}
