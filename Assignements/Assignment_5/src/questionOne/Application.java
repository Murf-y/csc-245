/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 27, 2022
 * LastModified: Mar 27, 2022
 * FileName: Application.java
 *****************************************************
 */
package questionOne;

import utils.InputManager;

public class Application {
	
	private InputManager input_manager;
	
 	public Application() {
		input_manager = new InputManager();
	}
	public void run() {
		String expression = input_manager.getString("Enter a fully parenthesized expression: ");
		
		try {
			int value = Parser.parseFullyParenthesized(expression);
			String result = String.format("The result of the expression: \n%s = %d", expression, value);
			System.out.println(result);
			System.out.println("\n----------------\n");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid Expression, Only enter a fully parenthesized expressions");
			run();
			return;
		}
		
	
		int rerun = input_manager.getValidIntInRange("Rerun?\n1. Yes\n2. No\n--------------\nEnter your choice: ", 1, 2);
		if(rerun == 1) run();
		else close();
	}
	public void close() {
		System.out.println("Exiting the porgram, Beep Boop . . .");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Application().run();
	}

}
