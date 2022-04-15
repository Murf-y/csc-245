/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Apr 15, 2022
 * LastModified: Apr 15, 2022
 * FileName: Application.java
 *****************************************************
 */
package qOne;

import java.util.Vector;

import utils.FileManager;
import utils.InputManager;

public class Application {
	
	private InputManager input_manager;
	private FileManager file_manager;
	private Dictionary dictionary;
	
	private final String output_file_name = "output.txt";
	
	public Application() {
		input_manager = new InputManager();
		file_manager = new FileManager();
		dictionary = new Dictionary();
	}
	
	public void displayMenu() {
		String menu = 
				  "1.	Create the dictionary\r\n"
				+ "2.	Add a definition\r\n"
				+ "3.	Remove a definition\r\n"
				+ "4.	Search for a definition\r\n"
				+ "5.	Print Dictionary\r\n"
				+ "6.	Exit\r\n"
				+ "-----------------------------------\r\n";
		System.out.println(menu);
	}
	
	public void addLinesToDictionary(Vector<String> lines) {
		for(String line: lines) {
			if(line.isBlank()) continue;
			String[] parts = line.split(":", 2);
			if(dictionary.containsWord(parts[0])) {
				System.out.println("Line " + line + " will be ignored, since the word \""+ parts[0]+ "\" already exists!");
				continue;
			}
			if(dictionary.containsDefinition(parts[1])) {
				System.out.println("Line " + line + " will be ignored, since the definition already exists!");
				continue;
			}
			dictionary.addWord(parts[0], parts[1]);
		}
	}
	public void saveDictionaryToFile() {
		Vector<String> words = new Vector<String>();
		
		// Add the elements to the vector (since a vector is mutable)
		dictionary.InOrderAdd(words);
		
		// Ovveride the file
		file_manager.writeToFile(output_file_name, "", false);
		
		for(String line: words) {
			file_manager.writeToFile(output_file_name, line, true);
		}
		
		System.out.println("Succesfully added the dictionary in file "+ output_file_name);
	}
	public void handleChoice(int choice) {
		switch(choice) {
			case 1:{
				try {
					Vector<String> lines = file_manager.readFromFileWithAttempts(3);
					addLinesToDictionary(lines);
				}
				catch(Exception e) {
					System.out.println("No more attempts left . . .");
				}
				break;
			}
			case 2:{
				System.out.println("Adding to the dictionary . . .");
				String word = input_manager.getString("Enter a word: ");
				if(dictionary.containsWord((word))) {
					System.out.println("This word already exists in the dictionary, try something else . . .");
					return;
				}else {
					String definition = input_manager.getString("Enter the definition for the word \"" + word + "\" : ");
					if(dictionary.containsDefinition(definition)) {
						System.out.println("This definition already exists in the dictionary, try something else . . .");
						return;
					}
					dictionary.addWord(word, definition);
				}
				break;
			}
			case 3:{
				System.out.println("Removing from the dictionary . . .");
				String word = input_manager.getString("Enter a word: ");
				if(!dictionary.containsWord(word)) {
					System.out.println("This word does not exists in the dictionary, try something that exists . . .");
					return;
				}
				dictionary.remove(word);
				break;
			}
			case 4:{
				System.out.println("Searching in the dictionary . . .");
				String word = input_manager.getString("Enter a word: ");
				try {
					String definition = dictionary.findDefinition(word);
					System.out.println("The word \""+word+"\" definition is : " + definition);
				}catch(IllegalArgumentException e) {
					System.out.println("The word \""+word+"\" is not in the dictionary!");
				}
				break;
			}
			case 5:{
				System.out.println("----------- Dictionary ---------");
				dictionary.displayInOrder();
				System.out.println("--------------------------------");
				break;
			}
		}
		System.out.println("-----------------------------------\r\n");
	}
	public void run() {
		displayMenu();
		int choice = input_manager.getValidIntInRange("Enter your choice: ", 1, 6);
		
		while(choice != 6) {
			handleChoice(choice);
			displayMenu();
			choice = input_manager.getValidIntInRange("Enter your choice: ", 1, 6);
		}
		close();
	}
	public void close() {
		saveDictionaryToFile();
		System.out.println("Exiting the program, Beep Boop . . .");
		System.exit(0);
	}
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
}
