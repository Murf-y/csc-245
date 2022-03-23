/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 20, 2022
 * LastModified: Mar 20, 2022
 * FileName: Animal.java
 *****************************************************
 */
package questionOne;

public abstract class Animal {
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
}
