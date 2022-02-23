package Main;

import java.util.ArrayList;
import java.util.Vector;

import Main.mammals.Hippo;
import Main.mammals.Monkey;
import utils.FileManager;
import utils.InputManager;

public class Zoo {
	private ArrayList<Animal> animals;
	
	private FileManager file_manager;
	private InputManager input_manager;
	
	public void printDashedLine() {
		System.out.println("\n--------------------------------\n");
	}
	public void displayMenu() {
		String menu = 	"1.Add\n"+
						"2.Find\n"+
						"3.Delete\n"+
						"4.Read All Mammals\n"+
						"5.Read All Reptiles\n"+
						"6.Exit\n"+
						"-------------------\n";
		System.out.println(menu);
	}
	public int getAnimalTypeFromUser() {
		String menu = 	"Choose an Animal type to proceeed\n"
				+ "1.Monkey\n"+
				"2.Hippo\n"+
				"3.Reptiles\n"+
				"-------------------\n";
		System.out.println(menu);
		int choice = input_manager.getValidIntInRange("Enter your choice: ", 1, 3);
		return choice;
	}
	public boolean animalAlreadyExists(Animal animal) {
		for(Animal a: animals) {
			if(a.getType().equalsIgnoreCase(animal.getType())) {
				if(a.equals(animal)) {
					return true;
				}
			}
		}
		return false;
	}
	public void addAnimalEvent() {
		int animal_type = getAnimalTypeFromUser();
		String name = input_manager.getString("Enter the animal name: ");
		int age = input_manager.getValidIntInRange("Enter the animal age: ", 0, 1000000);
		boolean is_acquatic = input_manager.getBoolean("Is this animal Acquatic: ");
		
		switch(animal_type) {
		// Monkey
			case 1:{
				Animal animal = new Monkey(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					System.out.println("Monkey with the same characteristics already exists!");
					return;
				}
				else {
					animals.add(animal);
					System.out.println("A Monkey was added !");
				}
				break;
			}
		// Hippo
			case 2:{
				Animal animal = new Hippo(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					System.out.println("Hippo with the same characteristics already exists!");
					return;
				}
				else {
					animals.add(animal);
					System.out.println("A Hippo was added !");
				}
				break;
			}
		// Reptile
			case 3:{
				Animal animal = new Reptile(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					System.out.println("Reptile with the same characteristics already exists!");
					return;
				}
				else {
					animals.add(animal);
					System.out.println("A reptile was added !");
				}
				break;
			}
		}
		printDashedLine();
	}
	public void findAnimalEvent() {
		int animal_type = getAnimalTypeFromUser();
		String name = input_manager.getString("Enter the animal name: ");
		int age = input_manager.getValidIntInRange("Enter the animal age: ", 0, 1000000);
		boolean is_acquatic = input_manager.getBoolean("Is this animal Acquatic: ");
		
		switch(animal_type) {
		// Monkey
			case 1:{
				Animal animal = new Monkey(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					System.out.println("Monkey with the same characteristics found !");
					System.out.println(animal.toString());
					return;
				}
				else {
					System.out.println("A Monkey with these characteristics was not found !");
				}
				break;
			}
		// Hippo
			case 2:{
				Animal animal = new Hippo(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					System.out.println("Hippo with the same characteristics found !");
					System.out.println(animal.toString());
					return;
				}
				else {
					System.out.println("A Hippo with these characteristics was not found !");
				}
				break;
			}
		// Reptile
			case 3:{
				Animal animal = new Reptile(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					System.out.println("Reptile with the same characteristics found !");
					System.out.println(animal.toString());
					return;
				}
				else {
					System.out.println("A Reptile with these characteristics was not found !");
				}
				break;
			}
		}
		printDashedLine();
		
	}
	public void deleteAnimalEvent() {
		int animal_type = getAnimalTypeFromUser();
		String name = input_manager.getString("Enter the animal name: ");
		int age = input_manager.getValidIntInRange("Enter the animal age: ", 0, 1000000);
		boolean is_acquatic = input_manager.getBoolean("Is this animal Acquatic: ");
		
		switch(animal_type) {
		// Monkey
			case 1:{
				Animal animal = new Monkey(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					for(int i =0; i< animals.size(); i++) {
						if(animals.get(i).getType().equalsIgnoreCase(animal.getType())) {
							if(animals.get(i).equals(animal)) {
								animals.remove(i);
								System.out.println("A monkey was deleted!");
								return;
							}
						}
					}
					return;
				}
				else {
					System.out.println("A Monkey with these characteristics was not found !");
				}
				break;
			}
		// Hippo
			case 2:{
				Animal animal = new Hippo(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					for(int i =0; i< animals.size(); i++) {
						if(animals.get(i).getType().equalsIgnoreCase(animal.getType())) {
							if(animals.get(i).equals(animal)) {
								animals.remove(i);
								System.out.println("A hippo was deleted!");
								return;
							}
						}
					}
					return;
				}
				else {
					System.out.println("A Hippo with these characteristics was not found !");
				}
				break;
			}
		// Reptile
			case 3:{
				Animal animal = new Reptile(name,age,is_acquatic);
				
				if(animalAlreadyExists(animal)) {
					for(int i =0; i< animals.size(); i++) {
						if(animals.get(i).getType().equalsIgnoreCase(animal.getType())) {
							if(animals.get(i).equals(animal)) {
								animals.remove(i);
								System.out.println("A reptile was deleted!");
								return;
							}
						}
					}
					return;
				}
				else {
					System.out.println("A Reptile with these characteristics was not found !");
				}
				break;
			}
		}
		printDashedLine();
	}
	public void readAllMammalsEvent() {
		if(animals.size() == 0) {
			System.out.println("No animals in the zoo, consider adding some!");
		}
		for(Animal animal: animals) {
			if(animal instanceof Mammal) {
				System.out.println(animal.toString());
			}
		}
		printDashedLine();
	}
	public void readAllReptilesEvent() {
		if(animals.size() == 0) {
			System.out.println("No animals in the zoo, consider adding some!");
		}
		for(Animal animal: animals) {
			if(animal instanceof Reptile) {
				System.out.println(animal.toString());
			}
		}
		printDashedLine();
	}
	
	public void handleChoice(int choice) {
		switch(choice) {
			case 1:{
				addAnimalEvent();
				break;
			}
			case 2:{
				findAnimalEvent();
				break;
			}
			case 3:{
				deleteAnimalEvent();
				break;
			}
			case 4:{
				readAllMammalsEvent();
				break;
			}
			case 5:{
				readAllReptilesEvent();
				break;
			}
		}
	}
	public boolean isValidInt(String a) {
		try {
			Integer.parseInt(a.trim());
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	public boolean isValidBoolean(String a) {
		if(a.trim().equalsIgnoreCase("0") || a.trim().equalsIgnoreCase("1")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isValidLine(String line) {
		String[] parts = line.split(" ");
		System.out.println(parts.length);
		// Format
		
		// Type name age boolean  4 parts
		
		// Reptile name age boolean boolean  5 parts
		
		// Check parts length
		if(parts.length != 4 && parts.length != 5) {
			System.out.println("bad length");
			return false;
		}
		
		// check type
		if(!parts[0].equalsIgnoreCase("hippo") && !parts[0].equalsIgnoreCase("monkey") && !parts[0].equalsIgnoreCase("reptile")) {

			System.out.println("bad types");
			return false;
		}
		// check age
		if(!isValidInt(parts[2])) {

			System.out.println("bad age");
			return false;
		}
		// check boolean 1
		if(!isValidBoolean(parts[3])) {

			System.out.println("bad boolean");
			return false;
		}
		if(parts.length == 5 && !isValidBoolean(parts[4])) {

			System.out.println("bad reptile without boolean");
			return false;
		}
		
		if(parts[0].equalsIgnoreCase("hippo") || parts[0].equalsIgnoreCase("monkey")) {
			if(parts.length != 4) {

				System.out.println("bad type length combination");
				return false;
			}
		}
		else {
			if(parts.length != 5) {

				System.out.println("bad type length combination of a reptile");
				return false;
			}
		}
		return true;
	}
	public void readFromAFile() {
		String file_name = input_manager.getString("Enter a file name to read from it (default: animals.txt): ");
		if(file_name.isBlank()) {
			file_name = "animals.txt";
		}
		Vector<String> lines = file_manager.readFromFile(file_name);
		for(String line: lines) {
			if(isValidLine(line)) {
				String[] parts = line.split(" ");
				String type = parts[0].trim().toLowerCase();
				String name = parts[1].trim();
				int age = Integer.parseInt(parts[2].trim());
				int is_acquatic = Integer.parseInt(parts[3].trim());
				
				switch(type) {
					case "monkey":{
						Animal a = new Monkey(name,age,is_acquatic == 0? false: true);
						if(animalAlreadyExists(a)) {
							System.out.println("A monkey with the same characteristics exists");
						}else {
							animals.add(a);
						}
						break;
					}
					case "hippo":{
						Animal a = new Hippo(name,age,is_acquatic == 0? false: true);
						if(animalAlreadyExists(a)) {
							System.out.println("A hippo with the same characteristics exists");
						}else {
							animals.add(a);
						}
						break;
					}
					case "reptile":{
						int is_legless =Integer.parseInt(parts[3].trim());
						Animal a = new Reptile(name,age,is_acquatic == 0? false: true, is_legless == 0? false: true);
						if(animalAlreadyExists(a)) {
							System.out.println("A reptile with the same characteristics exists");
						}else {
							animals.add(a);
						}
						break;
					}
				}
			}
			else {
				System.out.println(String.format("Skipped %s ",line));
			}
		}
	}
	public void open() {
		animals = new ArrayList<Animal>();
		file_manager = new FileManager();
		input_manager = new InputManager();
		
		readFromAFile();
		displayMenu();
		int choice = input_manager.getValidIntInRange("Enter your choice: ", 1, 6);
		while(choice!= 6) {
			handleChoice(choice);
			
			displayMenu();
			choice = input_manager.getValidIntInRange("Enter your choice: ", 1, 6);
		}
		
		close();
	}
	public void close() {
		System.out.println("Exiting the program, Beep Boop . . .");
		System.exit(0);
	}
}
