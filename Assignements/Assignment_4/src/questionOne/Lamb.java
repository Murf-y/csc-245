/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 20, 2022
 * LastModified: Mar 20, 2022
 * FileName: Lamb.java
 *****************************************************
 */
package questionOne;

public class Lamb extends Animal{
	public Lamb(int age, String gender, String color) {
		super(age, gender, color);
		consumption_amount = 200;
	}

	public void eat() {
		System.out.println(String.format("I Consume %d g per day", consumption_amount));
	}
	public String toString() {
		return "Lamb	" + super.toString();
	}
}
