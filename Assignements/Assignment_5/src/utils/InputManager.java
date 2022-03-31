/* Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 27, 2022
 * LastModified: Mar 27, 2022
 * FileName: InputManager.java
 *****************************************************
 */
package utils;

import java.util.Scanner;

//This class handles input from the user
public class InputManager {
	private Scanner scanner;

	public InputManager() {
		scanner = new Scanner(System.in);
	}

	public void close() {
		scanner.close();
	}

	public int getValidIntWithAttempts(String prompt,int min, int max, int current_attempts) {
		// return a valid integer in range [min - max]
		// inclusive
		if(current_attempts <= 0) return Integer.MIN_VALUE;
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
				System.out.println(String.format("Attempts left: %d", current_attempts-1));
				return getValidIntWithAttempts(prompt, min, max, --current_attempts);
			}
		} catch (NumberFormatException e) {
			System.out.println("Entered value must be an integer only!");
			System.out.println(String.format("Attempts left: %d", current_attempts-1));
			return getValidIntWithAttempts(prompt, min, max, --current_attempts);
		}
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
	public int getValidPositiveInt(String prompt) {
		// return a valid integer in range [min - max]
		// inclusive
		int num;

		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		try {
			num = Integer.parseInt(input);

			if (num >= 0) {
				return num;
			} else {
				System.out.println("Entered value must be positive!");
				return getValidPositiveInt(prompt);
			}
		} catch (NumberFormatException e) {
			System.out.println("Entered value must be an integer only!");
			return getValidPositiveInt(prompt);
		}
	}
	public String getString(String prompt) {
		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		return input;
	}

}