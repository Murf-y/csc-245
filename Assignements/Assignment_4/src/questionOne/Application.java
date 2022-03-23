/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 20, 2022
 * LastModified: Mar 20, 2022
 * FileName: Application.java
 *****************************************************
 */
package questionOne;

import utils.InputManager;

public class Application {
	
	private Farm farm;
	private InputManager input_manager;
	
	
	public Application() {
		farm = new Farm();
		input_manager = new InputManager();
	}
	
	public void displayMenu() {
		System.out.println(getMenuString());
	}
	public String getMenuString() {
		String menu = 
					"1. Add an animal\r\n"
				+ 	"2. Search for an animal\r\n"
				+ 	"3. Sort\r\n"
				+ 	"4. Remove by consumption\r\n"
				+ 	"5. Exit\r\n"
				+ 	"--------------------------\r\n"
				+ 	"Enter your choice: ";
		return menu;
	}
	
	
	public void addAnimal() {
		String animals_types = 	"Choose an Animal type to add\r\n"
								+"1. Cow\r\n"
								+"2. Horse\r\n"
								+"3. Lamb\r\n"
								+"4. Chicken\r\n"
								+"5. Return to Main Menu\r\n"
								+"--------------\r\n"
								+ "Enter your choice: ";
		
		int animal_type = input_manager.getValidIntInRange(animals_types, 1, 5);
		if(animal_type == 5) return;
		int age = input_manager.getValidPositiveInt("Enter the animal age: ");
		String gender = input_manager.getString("Enter the animal gender: ");
		String color = input_manager.getString("Enter the animal color: ");
		
		switch(animal_type) {
			case 1:{
				Animal cow = new Cow(age,gender, color);
				Animal alreadyInFarm = farm.animalWithSameCharacteristics(cow);
				if(alreadyInFarm != null && alreadyInFarm instanceof Cow ) {
					System.out.println("A Cow with the exact characteristics already exists!");
					return;
				}
				farm.addElement(cow);
				break;
			}
			case 2:{
				Animal horse = new Horse(age,gender, color);
				Animal alreadyInFarm = farm.animalWithSameCharacteristics(horse);
				if(alreadyInFarm != null && alreadyInFarm instanceof Horse ) {
					System.out.println("A Horse with the exact characteristics already exists!");
					return;
				}
				farm.addElement(horse);
				break;
			}
			case 3:{
				Animal lamb = new Lamb(age,gender, color);
				Animal alreadyInFarm = farm.animalWithSameCharacteristics(lamb);
				if(alreadyInFarm != null && alreadyInFarm instanceof Lamb ) {
					System.out.println("A Lamb with the exact characteristics already exists!");
					return;
				}
				farm.addElement(lamb);
				break;
			}
			case 4:{
				Animal chicken = new Chicken(age,gender, color);
				Animal alreadyInFarm = farm.animalWithSameCharacteristics(chicken);
				if(alreadyInFarm != null && alreadyInFarm instanceof Chicken ) {
					System.out.println("A Chicken with the exact characteristics already exists!");
					return;
				}
				farm.addElement(chicken);
				break;
			}
		}
		System.out.println("The animal was added successfully!");
	}
	
	public void displayAllWithType() {
		String animals_types = 	"Choose an Animal type to display\r\n"
				+"1. Cow\r\n"
				+"2. Horse\r\n"
				+"3. Lamb\r\n"
				+"4. Chicken\r\n"
				+"5. Return to Main Menu\r\n"
				+"--------------\r\n"
				+ "Enter your choice: ";

		int animal_type = input_manager.getValidIntInRange(animals_types, 1, 5);
		if(animal_type == 5) return;
		switch(animal_type) {
			case 1:{
				farm.displayAllAnimalsWithClass(Cow.class);
				break;
			}
			case 2:{
				farm.displayAllAnimalsWithClass(Horse.class);
				break;
			}
			case 3:{
				farm.displayAllAnimalsWithClass(Lamb.class);
				break;
			}
			case 4:{
				farm.displayAllAnimalsWithClass(Chicken.class);
				break;
			}
		}
	}
	
	public void sortAnimals() {
		farm.sortByConsumption();
		farm.displayFarm();
	}
	
	public void removeByConsumption() {
		int k = input_manager.getValidPositiveInt("Enter the maximum consumption amount: ");
		farm.removeConsumersGreaterThan(k);
	}
	
	public void handleChoice(int choice) {
		switch(choice) {
			case 1:{
				addAnimal();
				break;
			}
			case 2:{
				displayAllWithType();
				break;
			}
			case 3:{
				sortAnimals();
				break;
			}
			case 4:{
				removeByConsumption();
				break;
			}
		}
		System.out.println("\n----------------\n");
	}
	public void run() {
		int choice = 5;
		do {
			choice = input_manager.getValidIntWithAttempts(getMenuString(), 1, 5, 5);
			// Only if current_attempts where exceeded
			if(choice == Integer.MIN_VALUE) {
				break;
			}
			handleChoice(choice);
		}while(choice != 5);
		close();
	}
	public void close() {
		System.out.println("Exiting the applitcation, Beep Boop . . .");
		System.exit(0);
	}
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}

}
