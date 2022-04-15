/* Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Apr 15, 2022
 * LastModified: Apr 15, 2022
 * FileName: InputManager.java
 *****************************************************
 */
package utils;

import java.util.Scanner;


public class InputManager {
	private Scanner scanner;

	public InputManager() {
		scanner = new Scanner(System.in);
	}

	public void close() {
		scanner.close();
	}
	public int getValidIntInRange(String prompt, int min, int max) {
		// return a valid integer in range [min - max]
		// inclusive
		int num;

		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		try {
			num = Integer.parseInt(input);

			if (num >= min && num <= max) {
				return num;
			} else {
				System.out.println(String.format("Entered value must be in range [%d - %d] only!", min, max));
				return getValidIntInRange(prompt, min, max);
			}
		} catch (NumberFormatException e) {
			System.out.println("Entered value must be an integer only!");
			return getValidIntInRange(prompt, min, max);
		}
	}
	public String getString(String prompt) {
		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		return input;
	}

}