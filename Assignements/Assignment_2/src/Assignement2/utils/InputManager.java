/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 12, 2022
 * LastModified: Feb 12, 2022
 * FileName: Application.java
 *****************************************************
 */
package Assignement2.utils;

import java.util.Scanner;

// This class handles input from the user
public class InputManager {
	private Scanner scanner;
	
	public InputManager() {
		scanner = new Scanner(System.in);
	}
	
	public void close() {
		scanner.close();
	}
	public int getValidIntInRange(String prompt,int min, int max) {
		// return a valid integer in range [min - max] 
		// inclusive
		int num;
		
		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		try {
			num = Integer.parseInt(input);
			
			if(num >= min && num <= max) {
				return num;
			}
			else {
				System.out.println(String.format("Entered value must be in range [%d - %d] only!", min,max));
				return getValidIntInRange(prompt,min,max);
			}
		}catch(NumberFormatException e) {
			System.out.println("Entered value must be an integer only!");
			return getValidIntInRange(prompt,min,max);
		}
	}
	public float getValidFloatInRange(String prompt,float min, float max) {
		// return a valid integer in range [min - max] 
		// inclusive
		float num;
		
		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		try {
			num = Float.parseFloat(input);
			
			if(num >= min && num <= max) {
				return num;
			}
			else {
				System.out.println(String.format("Entered value must be in range [%.1f - %.1f] only!", min,max));
				return getValidFloatInRange(prompt,min,max);
			}
		}catch(NumberFormatException e) {
			System.out.println("Entered value must be a number only!");
			return getValidFloatInRange(prompt,min,max);
		}
	}
	public float getValidPositiveFloat(String prompt) {
		// return a valid integer in range [min - max] 
		// inclusive
		float num;
		
		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		try {
			num = Float.parseFloat(input);
			
			if(num > 0) {
				return num;
			}
			else {
				System.out.println("Entered value must be positive only!");
				return getValidPositiveFloat(prompt);
			}
		}catch(NumberFormatException e) {
			System.out.println("Entered value must be a number only!");
			return getValidPositiveFloat(prompt);
		}
	}
	
	public float getValidFloat(String prompt) {
		// return a valid integer in range [min - max] 
		// inclusive
		float num;
		
		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		try {
			num = Float.parseFloat(input);
			
			return num;
		}catch(NumberFormatException e) {
			System.out.println("Entered value must be an integer only!");
			return getValidFloat(prompt);
		}
	}


	public char getValidCharInRange(String prompt,char min, char max) {
		
		// Return a valid character in range [min - max] 
		// inclusive
		// This is caseSensitive
		
		System.out.print(prompt);
		String input = scanner.nextLine();
		input = input.trim();
		
		if(input.length() != 1) {
			System.out.println("Entered value must be 1 character long!");
			return getValidCharInRange(prompt,min,max);
		}
		
		char c = input.charAt(0);
		c = Character.toUpperCase(c);
		
		if(c >= min && c <= max) {
			return c;
		}
		else {
			System.out.println(String.format("Entered value must be in range [%s - %s] only!", min,max));
			return getValidCharInRange(prompt,min,max);
		}
		
	}

}
