package Farm;

public class Animal {
	private int age;
	private String color;
	private String gender;
	private int consumption;
	public Animal(int a, String c, String g, int co) {
		age = a;
		color = c;
		gender = g;
		consumption = co;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int a) {
		age = a;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		color = c;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String g) {
		gender = g;
	}
	public int getConsumption() {
		return consumption;
	}
	public void setConsumption(int c) {
		consumption = c;
	}
	public boolean equals(Animal a){
		if(a.getAge()==age&&a.getColor().equalsIgnoreCase(color)&&a.getGender().equalsIgnoreCase(gender))
			return true;
		return false;
	}
	public String toString(){
		return "Age: "+age+" Color: "+color+" Gender: "+gender+" Consumption: "+consumption;
	}
	
}
