/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 22, 2022
 * LastModified: Mar 22, 2022
 * FileName: Animal.java
 *****************************************************
 */
package questionTwo;

// Modified Animal class after question two
public abstract class Animal implements Sortable{
	
	private int age;
	private String gender;
	private String color;
	
	protected int consumption_amount;
	
	public Animal(int age,String gender, String color) {
		this.age = age;
		this.gender = gender;
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getConsumptionAmount() {
		return consumption_amount;
	}
	public abstract void eat();
	
	public boolean equals(Animal a) {
		return a.getAge() == age &&
				a.getGender().equalsIgnoreCase(gender) &&
				a.getColor().equalsIgnoreCase(color);
	}
	public String toString() {
		return String.format("Age:	%d,	Gender:	%s,	Color:	%s,	Daily Consumption:	%d", age,gender,color,consumption_amount);
	}

	public int compareTo(Object o) {
		Animal other = (Animal)o;
		// A number greater than 0 if a is greater than b
		if(age > other.age) return 1;
		// A number less than 0 if a is less than b. 
		if(age < other.age) return -1;
		// Returns 0 if a is equal to b, 
		return 0;
	}
}
