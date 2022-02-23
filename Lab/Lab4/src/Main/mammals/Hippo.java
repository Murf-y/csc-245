package Main.mammals;

import Main.Mammal;

public class Hippo extends Mammal{
	public Hippo(String name, int age, boolean acquatic) {
		super(name, age, acquatic);

		type = "hippo";
	}

	public void makeNoise() {
		System.out.println("Honk . . .");
	}
	public String toString() {
		return "Hippo\n"+super.toString();
	}
}
