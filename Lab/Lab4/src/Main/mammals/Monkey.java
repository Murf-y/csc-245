package Main.mammals;

import Main.Mammal;

public class Monkey extends Mammal{
	public Monkey(String name, int age, boolean acquatic) {
		super(name, age, acquatic);
		type = "monkey";
	}

	public void makeNoise() {
		System.out.println("Chatter . . .");
	}
	public String toString() {
		return "Monkey\n"+super.toString();
	}
}
