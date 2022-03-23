/* ****************************************************
 *
 * Author: Anonymous
 * Id: xxx
 * 
 * Date: Mar 22, 2022
 * LastModified: Mar 22, 2022
 * FileName: Application.java
 *****************************************************
 */
package questionTwo;

import java.util.Vector;

import utils.FileManager;

public class TestProgram
{
	/************** -  DONT MODIFY - ************************/
	final static int SIZE=5;

	public static void sort(Sortable[] items)
	{
		/*sorts  an array of items in an increasing order as specified in the compareTo() method*/

		for (int i = 1; i < items.length; i++ )
		{
			Sortable key  = items[i];
			int position = i;
			while (position > 0 && items[position-1].compareTo(key) > 0)
				{
					items[position]=items[position-1];
					position--;
				}
			items[position]=key;
		}
	}
	
	public static void show(Sortable[] items)
	{
		for (int i = 0; i < items.length; i++ )
		{
			 if (items[i]!= null)
			 	System.out.println(items[i]);
			}
	}
	/************** -  DONT MODIFY - ************************/
	
	/************** -  Utils - *********************/
	public static int size(Object[] objs) {
		int total = 0;
		for (int i = 0; i < objs.length; i++) {
			if(objs[i] != null) total++;
		}
		return total;
	}
	public static void printDashedLine() {
		System.out.println("\n-----------------");
	}
	/**********************************************/
	
	/************** -  Handle Getting animals from a file - ************************/
	public static void addAnimalToAnimals(Animal[] animals, Animal animal) {
		// Add if you are able to add
		for(int i = 0; i< animals.length; i++) {
			if(animals[i] == null) {
				animals[i] = animal;
				return;
			}
		}
		
		// If not expend the array and add
		Animal[] new_animals = new Animal[animals.length + 10];
		for(int i = 0; i < animals.length; i++) {
			new_animals[i] = animals[i];
		}
		new_animals[animals.length] = animal;
		animals = new_animals;
	}
	public static Animal getAnimalFromParts(String type, int age, String gender, String color) {
		switch(type) {
			case "cow":{
				Animal cow = new Cow(age,gender,color);
				return cow;
			}
			case "horse":{
				Animal horse = new Horse(age,gender,color);
				return horse;
			}
			case "lamb":{
				Animal lamb = new Lamb(age,gender,color);
				return lamb;
			}
			case "chicken":{
				Animal chicken = new Chicken(age,gender,color);
				return chicken;
			}
			
			default:{
				throw new IllegalArgumentException("Parsing an invalid line, this was not supposed to happen!");
			}
		}
	}	
	public static void parseLinesIntoAnimal(Vector<String> lines, Animal[] animals) {
		lines.forEach(line -> {
			if(!line.isEmpty()) {
				String[] parts = line.toLowerCase().trim().split(" ");
				
				if(parts.length == 4) {
					String types ="cow horse lamb chicken";
					
					String type = parts[0].toLowerCase();
					String age_str = parts[1];
					String gender = parts[2];
					String color = parts[3];
					if(types.contains(type)) {
						try {
							int age = Integer.parseInt(age_str);
							Animal animal = getAnimalFromParts(type,age,gender,color);
							addAnimalToAnimals(animals, animal);
						}catch(NumberFormatException e) {
							System.out.println(String.format("Invalid line while parsing, Age must be an integer: %s", line));
							printDashedLine();
						}
					}else {
						System.out.println(String.format("Invalid line while parsing, Wrong type: %s", line));
						printDashedLine();
					}
				}else {
					System.out.println(String.format("Invalid line while parsing, Wrong format: %s", line));
					printDashedLine();
				}	
			}
		});
	}
	public static Animal[] getActualAnimalsOnly(Animal[] animals) {
		Animal[] new_animals = new Animal[size(animals)];
		for(int i = 0; i < new_animals.length; i++) {
			new_animals[i] = animals[i];
		}
		return new_animals;
	}
	/***********************************************************************/
	
	
	/************** -  Handle Writing to the File - ************************/
	public static void writeAnimalsToFile(Animal[] animals, String file_name) {
		for(int i =0; i< animals.length; i++) {
			FileManager.writeToFile(file_name,animals[i].toString(),  true);
		}
		printDashedLine();
		System.out.println("Finished Writing Animals to File . . .");
		printDashedLine();
	}
	/***********************************************************************/
	
	
	public static void close() {
		System.out.println("Exting the program, Beep Boop . . . ");
		System.exit(0);
	}
	public static void main (String[] args)
	{
		Animal[] animals= new Animal[SIZE];
		
		// Get animals from "input.txt"
		Vector<String> lines = FileManager.readFromFile("input.txt");
		parseLinesIntoAnimal(lines,animals);
		animals = getActualAnimalsOnly(animals);
		
		sort(animals);
		show(animals);
		
		
		// Write animals array into "output.txt"
		writeAnimalsToFile(animals, "output.txt");
		
		
		close();
	}
}