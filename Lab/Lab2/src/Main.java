import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static Scanner scanner = new Scanner(System.in);
	public static void displayMenu() {
		String menu=  "1. add a person\n"+
					 "2. delete a person\n"+
					 "3. modify a person\n"+
					 "4. list all persons\n"+
					 "5. count population\n"+
					 "6. exit\n"+
					 "____________________";
		System.out.println(menu);
	}
	
	public static int getUserChoice() {
		displayMenu();
		System.out.print("Enter your choice: ");
		int choiceInt = scanner.nextInt();
		return choiceInt;
	}
	
	public static void exitProgram() {
		System.out.println("Exiting the program . . .");
		System.exit(0);
	}
	public static void application(Planet planet) {
		int choice = getUserChoice();
		
		while(choice != 6) {
			switch(choice) {
			
			// Add person
				case 1:{
					System.out.println("Enter a name: ");
					String name = scanner.next();

					System.out.println("Enter a age: ");
					int age = scanner.nextInt();

					System.out.println("Enter a gender: ");
					String gender = scanner.next();
					
					Person currentPerson = new Person(name,age,gender);
					
					if(planet.isPersonAlreadyExists(currentPerson)) {
						System.out.println("Person already exists!");
						System.out.println("\n\n");
					}
					else {
						planet.addPerson(currentPerson);
					}
					
					break;
				}
				
			// Delete person
				case 2:{
					System.out.println("Enter the name: ");
					String name = scanner.next();

					System.out.println("Enter the age: ");
					int age = scanner.nextInt();

					System.out.println("Enter the gender: ");
					String gender = scanner.next();
					
					Person currentPerson = new Person(name,age,gender);
					
					if(planet.isPersonAlreadyExists(currentPerson)) {

						ArrayList<Person> people = planet.getPeople();
						for(int i=0; i< people.size(); i++) {
							if(people.get(i).equals(currentPerson)) {
								people.remove(i);
							}
						}
						planet.setPeople(people);
					}
					else {
						System.out.println("This person does not exists!");
						System.out.println("\n\n");
					}
					
					break;
				}
			// Modify a person
				case 3:{
					System.out.println("Enter the name: ");
					String name = scanner.next();

					System.out.println("Enter the age: ");
					int age = scanner.nextInt();

					System.out.println("Enter the gender: ");
					String gender = scanner.next();
					
					Person currentPerson = new Person(name,age,gender);
					
					if(planet.isPersonAlreadyExists(currentPerson)) {
						
						System.out.println("Enter the new name: ");
						String newName = scanner.next();

						System.out.println("Enter the new age: ");
						int newAge = scanner.nextInt();

						System.out.println("Enter the new gender: ");
						String newGender = scanner.next();
						Person newPerson = new Person(newName,newAge,newGender);
						
						ArrayList<Person> people = planet.getPeople();
						for(int i=0; i< people.size(); i++) {
							if(people.get(i).equals(currentPerson)) {
								people.set(i, newPerson);
							}
						}
						planet.setPeople(people);
						
					}
					else {
						System.out.println("This person does not exists!");
						System.out.println("\n\n");
					}
					
					break;
				}
			// List all person
				case 4:{
					System.out.println("\n\n");
					for(Person person: planet.getPeople()) {
						System.out.println(person.toString());
					}
					System.out.println("\n\n");
					break;
				}
			// Count population
				case 5:{
					System.out.println("\n\n");
					int total = planet.getPeople().size();
					int maleCount = 0;
					int femaleCount = 0;
					
					for(Person person: planet.getPeople()) {
						if(person.getGender().equalsIgnoreCase("male")){
							maleCount ++;
						}
						else {
							femaleCount++;
						}
					}
					System.out.println("Current total population is: "+planet.getPeople().size());
					System.out.println("Current Male population is: "+maleCount);
					System.out.println("Current Female population is: "+femaleCount);
					
					System.out.println("\n\n");
					break;
				}
				
			}
			
			choice = getUserChoice();
		}
		
		exitProgram();
	}
	public static void main(String[] args) {
		Planet p = new Planet();
		
		application(p);
	}

}
