import java.util.Scanner;

public class Zoo {
	Scanner input_scanner;
	Animal[] animals;
	
	
	public void printDashedLine() {
		System.out.println("\n-------------------------------\n");
		
	}
	public void displayMenu() {
		String menu = "1.Add animal\n"+
						"2.Remove animal\n"+
						"3.Find\n"+
						"4.Mate\n"+
						"5.Sounds\n"+
						"6.PrintAllLions\n"+
						"7.PrintAll\n"+
						"8.Exit\n"+
						"---------------------------\n"+
						"Enter your choice: ";
		System.out.print(menu);
	}
	
	public AnimalType getAnimalTypeFromUser() {
		String menu = 
						"\t 1.Lion\n"+
						"\t 2.Giraffe\n"+
						"\t 3.Seal\n"+
						"\t 4.Snale\n"+
						"--------------------\n"+
						"Enter the Animal Type: ";
		System.out.print(menu);
		int choice = Integer.parseInt(input_scanner.nextLine());
		
		return AnimalType.getChoice(choice);
	}
	
	
	
	
	public boolean animalAlreadyExists(Animal animal) {
		for(int i =0 ; i< animals.length; i++) {
			if(animals[i] != null) {
				if(animals[i].equals(animal)) {
					return true;
				}
			}
		}
		return false;
	}
	public void updateAnimalsState(Animal animal) {
		for(int i =0; i< animals.length; i++) {
			if(animals[i] != null) {
				if(animals[i].equals(animal)) {
					animals[i] = animal;
					return;
				}
			}
		}
	}
	public void addAnimalToAnimals(Animal animal) {
		for(int i=0;i < animals.length; i++) {
			if(animals[i] == null) {
				animals[i] = animal;
				return;
			}
		}
		
		int size = animals.length;
		Animal[] new_animals = new Animal[size + 10];
		for(int i =0, j =0; i<size; i++) {
			animals[j++] = animals[i]; 
		}
		new_animals[size+1] = animal;
		animals = new_animals;

		System.out.println("Added an animal from the zoo");
	}
	public void addEvent() {
		System.out.print("Enter the animal name: ");
		String name = input_scanner.nextLine();
		
		System.out.print("Enter the animal age: ");
		int age = Integer.parseInt(input_scanner.nextLine());
		
		AnimalType type = getAnimalTypeFromUser();
		
		Animal animal = new Animal("", 0 ,null);
		
		switch(type) {
			case LION:{
				animal = new Lion(name,age, null);
				break;
			}
			case GIRAFFE:{
				animal = new Giraffe(name,age, null);
				break;
			}
			case SNAKE:{
				animal = new Snake(name,age, null);
				break;
			}
			case SEAL:{
				animal = new Seal(name,age, null);
				break;
			}
		}
		if (animalAlreadyExists(animal)) {
			System.out.println("This animal already exists in the zoo");
		}
		else {
			addAnimalToAnimals(animal);
		}
	}
	
	public void deleteAnimalFromAnimals(Animal animal) {
		Animal[] copy = new Animal[animals.length - 1];

		for (int i = 0, j = 0; i < animals.length; i++) {
			if(animals[i]!= null) {
				if (!animals[i].equals(animal)) {
					copy[j++] = animals[i];
				}
			}
				
		}
		animals = copy;
		System.out.println("Removed an animal from the zoo");
	}
	public void removeEvent() {
		System.out.print("Enter the animal name: ");
		String name = input_scanner.nextLine();
		
		System.out.print("Enter the animal age: ");
		int age = Integer.parseInt(input_scanner.nextLine());
		
		AnimalType type = getAnimalTypeFromUser();
		
		Animal animal = new Animal("", 0 ,null);
		
		switch(type) {
			case LION:{
				animal = new Lion(name,age, null);
				break;
			}
			case GIRAFFE:{
				animal = new Giraffe(name,age, null);
				break;
			}
			case SNAKE:{
				animal = new Snake(name,age, null);
				break;
			}
			case SEAL:{
				animal = new Seal(name,age, null);
				break;
			}
		}
		if (animalAlreadyExists(animal)) {
			deleteAnimalFromAnimals(animal);
		}
		else {
			System.out.println("This animal does not exists in the zoo!");
		}
	}
	public void findEvent() {
		System.out.print("Enter the animal name: ");
		String name = input_scanner.nextLine();
		
		System.out.print("Enter the animal age: ");
		int age = Integer.parseInt(input_scanner.nextLine());
		
		AnimalType type = getAnimalTypeFromUser();
		
		Animal animal = new Animal("", 0 ,null);
		
		switch(type) {
			case LION:{
				animal = new Lion(name,age, null);
				break;
			}
			case GIRAFFE:{
				animal = new Giraffe(name,age, null);
				break;
			}
			case SNAKE:{
				animal = new Snake(name,age, null);
				break;
			}
			case SEAL:{
				animal = new Seal(name,age, null);
				break;
			}
		}
		if (animalAlreadyExists(animal)) {
			System.out.println("This animal exists in the Zoo!");
		}
		else {
			System.out.println("This animal does not exists in the zoo!");
		}
	}
	public void mateAnimal(Animal animal_to_mate) {
		System.out.print("Enter the animal you want to mate: ");
		String name = input_scanner.nextLine();
		
		System.out.print("Enter the animal age you want to mate: ");
		int age = Integer.parseInt(input_scanner.nextLine());
		
		AnimalType type = getAnimalTypeFromUser();
		
		Animal animal = new Animal("", 0 ,null);
		
		switch(type) {
			case LION:{
				animal = new Lion(name,age, null);
				break;
			}
			case GIRAFFE:{
				animal = new Giraffe(name,age, null);
				break;
			}
			case SNAKE:{
				animal = new Snake(name,age, null);
				break;
			}
			case SEAL:{
				animal = new Seal(name,age, null);
				break;
			}
		}
		if (animalAlreadyExists(animal)) {
			animal_to_mate.Mate(animal);
			animal.setSpouse(animal_to_mate);
			updateAnimalsState(animal_to_mate);
		}
		else {
			System.out.println("This animal does not exists in the zoo!");
			return;
		}
	}
	public void mateEvent() {
		System.out.print("Enter the animal name: ");
		String name = input_scanner.nextLine();
		
		System.out.print("Enter the animal age: ");
		int age = Integer.parseInt(input_scanner.nextLine());
		
		AnimalType type = getAnimalTypeFromUser();
		
		Animal animal = new Animal("", 0 ,null);
		
		switch(type) {
			case LION:{
				animal = new Lion(name,age, null);
				break;
			}
			case GIRAFFE:{
				animal = new Giraffe(name,age, null);
				break;
			}
			case SNAKE:{
				animal = new Snake(name,age, null);
				break;
			}
			case SEAL:{
				animal = new Seal(name,age, null);
				break;
			}
		}
		if (animalAlreadyExists(animal)) {
			mateAnimal(animal);
		}
		else {
			System.out.println("This animal does not exists in the zoo!");
		}
	}
	public void soundsEvent() {
		for(int i =0; i< animals.length; i++) {
			if(animals[i] != null) {
				animals[i].Sound();
			}
		}
	}
	public void printLionsEvent() {
		for(int i =0; i< animals.length; i++) {
			if(animals[i] != null && animals[i] instanceof Lion) {
				
				System.out.println(animals[i].toString()+ "\n");
			}
		}
		printDashedLine();
	}
	public void printAllEvent() {
		for(int i =0; i< animals.length; i++) {
			if(animals[i] != null) {
				
				System.out.println(animals[i].toString()+ "\n");
			}
		}
		printDashedLine();
	}
	
	
	public void handleChoiceEvent(MenuChoice choice) {
		switch(choice) {
			case ADD:{
				addEvent();
				break;
			}
			case REMOVE:{
				removeEvent();
				break;
			}
			case FIND:{
				findEvent();
				break;
			}
			case MATE:{
				mateEvent();
				break;
			}
			case SOUNDS:{
				soundsEvent();
				break;
			}
			case PRINT_LIONS:{
				printLionsEvent();
				break;
			}
			case PRINT_ALL:{
				printAllEvent();
				break;
			}
		}
	}
	public void handleChoice() {
		displayMenu();
		int choiceInt = Integer.parseInt(input_scanner.nextLine());
		MenuChoice choice = MenuChoice.getChoice(choiceInt); 

		while(choice != MenuChoice.EXIT) {
			
			handleChoiceEvent(choice);
			printDashedLine();
			displayMenu();
			choiceInt = Integer.parseInt(input_scanner.nextLine());
			choice = MenuChoice.getChoice(choiceInt); 	
		}
		
		close();
	}
	public void open() {
		input_scanner = new Scanner(System.in);
		animals = new Animal[10];
		
		
		handleChoice();
	}
	public void close() {
		System.out.println("Exiting the program, Beep Boop . . .");
		System.exit(0);
	}
}
