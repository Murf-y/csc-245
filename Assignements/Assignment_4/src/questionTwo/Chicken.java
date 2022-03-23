/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 20, 2022
 * LastModified: Mar 20, 2022
 * FileName: Chicken.java
 *****************************************************
 */
package questionTwo;


public class Chicken extends Animal{
	public Chicken(int age, String gender, String color) {
		super(age, gender, color);
		consumption_amount = 50;
	}

	public void eat() {
		System.out.println(String.format("I Consume %d g per day", consumption_amount));
	}
	
	public String toString() {
		return "Chicken	" + super.toString();
	}
}
