/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 20, 2022
 * LastModified: Mar 20, 2022
 * FileName: Cow.java
 *****************************************************
 */
package questionTwo;

public class Cow extends Animal{
	
	
	public Cow(int age, String gender, String color) {
		super(age, gender, color);
		consumption_amount = 5000;
	}

	public void eat() {
		System.out.println(String.format("I Consume %d g per day", consumption_amount));
	}
	public String toString() {
		return "Cow	" + super.toString();
	}
}
