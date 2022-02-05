
public class Person {
	
	private String name;
	private int age;
	private String gender;
	
	public Person(String name,int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender=  gender;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Person otherPerson) {
		return (this.name.equalsIgnoreCase(otherPerson.name)) && 
				(this.gender.equalsIgnoreCase(otherPerson.gender)) && 
				(this.age == otherPerson.age);
	}
	public String toString() {
		return String.format("Name: %s, Age: %d, Gender: %s",name,age,gender);
	}
	
}