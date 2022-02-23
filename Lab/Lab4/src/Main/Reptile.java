package Main;

public class Reptile extends Animal{
	public Reptile(String name, int age, boolean acquatic) {
		super(name, age, acquatic);

		type = "reptile";
		legless = false;
	}
	public Reptile(String name, int age, boolean acquatic, boolean legless) {
		super(name, age, acquatic);

		type = "reptile";
		this.legless = legless;
	}

	private boolean legless;

	public boolean isLegless() {
		return legless;
	}

	public void setLegless(boolean legless) {
		this.legless = legless;
	}
	
	public void makeNoise() {
		System.out.println("hisssss . . . ");
	}
	public String toString() {
		return "Reptile\n"+super.toString();
	}
}
