package Q2;
//Need to implement the interface and the comapreTo method
public class Animal implements Sortable{
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
		return "Age: "+age+" Color: "+color+" Gender: "+gender+" Consumption: "+consumption+"\n";
	}
	
	//Need to cast the object to be able to access age which is specific for object of class Animal
	public int compareTo(Object o) {
		if(age==((Animal) o).getAge()){
			return 0;
		}else if(age>((Animal) o).getAge()){
			return 1;
		}else
			return -1;
	}
	
}
