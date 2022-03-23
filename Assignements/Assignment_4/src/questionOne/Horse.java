package questionOne;

public class Horse extends Animal{
	public Horse(int age, String gender, String color) {
		super(age, gender, color);
		consumption_amount = 7000;
	}

	public void eat() {
		System.out.println(String.format("I Consume %d g per day", consumption_amount));
	}
	public String toString() {
		return "Horse	" + super.toString();
	}
}
