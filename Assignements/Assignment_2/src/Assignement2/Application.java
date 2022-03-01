/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Feb 12, 2022
 * LastModified: Feb 16, 2022
 * FileName: Application.java
 *****************************************************
 */
package Assignement2;

import java.util.ArrayList;
import java.util.Vector;

import Assignement2.Shapes.*;
import Assignement2.utils.*;

public class Application {
	
	// This could have been Vector<Shape>
	// but for it is like this for assignement specification
	// Store the shapes in a collection
	private ArrayList<Shape> shapes;
	
	// Input manager handles all the input validation from the user
	private InputManager input_manager;
	
	// File manager handles all the file writing/reading
	private FileManager file_manager;
	
	public Application() {
		// Initialize the dependencies 
		shapes = new ArrayList<Shape>();
		input_manager = new InputManager();
		file_manager = new FileManager();
	}
	
	// -------------------------------------------------------------------
	public void printDashedLine() {
		System.out.println("\n---------------------\n");
	}
	public void operationDoneOutput() {
		printDashedLine();
		System.out.println("Operation Done successfully!");
		printDashedLine();
	}
	public void displayMainMenu()
	{
		String menu = 	"1.Add a shape\n"+
						"2.Delete a shape\n"+
						"3.Compute area and perimeter\n"+
						"4.Display all\n"+
						"5.Move an object\n"+
						"6.Read from file\n"+
						"7.Exit\n"+
						"---------------------";

		System.out.println(menu);
	}
	public void displayShapesMenu() {
		String menu = 
				"A.Add a Circle\n"+
				"B.Add a Square\n"+
				"C.Add a Triangle\n"+
				"D.Return to main menu\n"+
				"---------------------";

		System.out.println(menu);
	}
	public MainMenuChoice getMainMenuChoiceFromUser() {
		int response = input_manager.getValidIntInRange("Enter your choice: ", 1, 7);
		return MainMenuChoice.getMainMenuChoice(response);
	}
	public boolean shapeAlreadyExists(Shape shape) {
		
		// If no shapes exists return false
		if(shapes.size() == 0) {return false;}
		
		for(Shape s: shapes) {
			if(s.getShapeType() == shape.getShapeType()) {
				// if both shapes have the same type, check the coordinates
				// The equals method approximate the coordinates of the shapes
				// since the coordinates are floats
				if(s.equals(shape)) {
					return true;
				}
			}
		}
		return false;
	}
	public MovementDirection getMovementDirectionFromUser() {
		String menu = 
				"Choose a Movement Direction \n"+
				"1.Up\n"+
				"2.Down\n"+
				"3.Right\n"+
				"4.Left\n"+
				"---------------------";

		System.out.println(menu);
		
		int response = input_manager.getValidIntInRange("Enter your choice: ", 1, 4);
		return MovementDirection.getMovementDirection(response);
	}
	public ArrayList<Shape> findShapesWithCoords(float a, float b){
		
		// Find all shapes in that location and return them
		
		// A dummy Shape sub class object to compare with
		Shape s = new Circle(a,b, 1);
		
		ArrayList<Shape> found_shapes = new ArrayList<Shape>();
		for(Shape shape: shapes) {
			if(shape.equals(s)) {
				found_shapes.add(shape);
			}
		}
		return found_shapes;
	}
	// -------------------------------Add a Shape-------------------------
	public void handleAddCircle() {

		// Get the radius of the Circle
		// and the location, and check it already exits if not, add it
		float radius = input_manager.getValidPositiveFloat("Enter circle radius: ");
		float x_coordinate = input_manager.getValidFloatInRange("Enter X coordinate: ",-200,200);
		float y_coordinate = input_manager.getValidFloatInRange("Enter Y coordinate: ", -200 , 200);
		
		Shape shape = new Circle(x_coordinate,y_coordinate,radius);
		if(shapeAlreadyExists(shape)) {
			System.out.println("This Exact Shape already exists in the world!");
			printDashedLine();
		}
		else {
			shapes.add(shape);
			operationDoneOutput();
		}
		
	}
	public void handleAddSquare() {

		// Get the side of the Square
		// and the location, and check it already exits if not, add it
		float side_length = input_manager.getValidPositiveFloat("Enter square side length: ");
		float x_coordinate = input_manager.getValidFloatInRange("Enter X coordinate: ",-200,200);
		float y_coordinate = input_manager.getValidFloatInRange("Enter Y coordinate: ", -200 , 200);
		
		Shape shape = new Square(x_coordinate,y_coordinate,side_length);
		if(shapeAlreadyExists(shape)) {
			System.out.println("This Exact Shape already exists in the world!");
			printDashedLine();
		}
		else {
			shapes.add(shape);
			operationDoneOutput();
		}
	}
	public void handleAddTriangle() {
		// Get the sides of the triangle
		// and the location, and check it already exits if not, add it
		
		float side_length_1 = input_manager.getValidPositiveFloat("Enter Triangle first side length: ");
		float side_length_2 = input_manager.getValidPositiveFloat("Enter Triangle second side length: ");
		float side_length_3 = input_manager.getValidPositiveFloat("Enter Triangle third side length: ");

		float x_coordinate = input_manager.getValidFloatInRange("Enter X coordinate: ",-200,200);
		float y_coordinate = input_manager.getValidFloatInRange("Enter Y coordinate: ", -200 , 200);
		
		Shape shape;
		// If all sides are equal
		// create a Equilateral triangle instead
		// We use  floatAproxEquals() to approximate float equalities
		if(MathHelper.floatAproxEquals(side_length_1, side_length_2) && 
			MathHelper.floatAproxEquals(side_length_1, side_length_3)) {
			shape = new EquilateralTriangle(x_coordinate,y_coordinate,side_length_1);
		}
		else {
			
			shape = new Triangle(x_coordinate,y_coordinate,side_length_1,side_length_2,side_length_3);
		}
		if(shapeAlreadyExists(shape)) {
			System.out.println("This Exact Shape already exists in the world!");
			printDashedLine();
		}
		else {
			shapes.add(shape);
			operationDoneOutput();
		}
	}
	public void handleAddEvent() {
		
		// Displays the sahpes menu and get the choice of the user in form of a ShapeType
		displayShapesMenu();
		char response = input_manager.getValidCharInRange("Enter shape: ", 'A', 'D');
		if(response == 'D') { 
			printDashedLine();
			return ;
		}
		
		ShapeType shape_type = ShapeType.getShapeFromChar(response);
		
		// Maps each shape type to its corresponding add method
		// Equilateral_Triangle  is handeled inside the triangle-Event (as per assignement specification)
		switch(shape_type) {
			case CIRCLE:{
				handleAddCircle();
				break;
			}
			case SQUARE:{
				handleAddSquare();
				break;
			}
			case TRIANGLE:{
				handleAddTriangle();
				break;
			}
			default:
				break;
			}
	}
	
	// ----------------------------Delete a Shape-------------------------
	public void handleDeleteEvent() {		
		
		// Get the shape location from the user
		float x_coordinate = input_manager.getValidFloatInRange("Enter X coordinate: ",-200,200);
		float y_coordinate = input_manager.getValidFloatInRange("Enter Y coordinate: ", -200 , 200);
		
		// Get all shapes in that location
		ArrayList<Shape> found_shapes = findShapesWithCoords(x_coordinate,y_coordinate);
		
		// If no shapes are found in that location displays a message
		if(found_shapes.size() == 0) {
			System.out.println("Could not find any shapes with the specified coordinates!\nAre you missing something?");
			printDashedLine();
		}else {
			// Remove all shapes in that location
			shapes.removeAll(found_shapes);
			operationDoneOutput();
		}
		
	}
	
	// ---------------------------Compute charactersitics ----------------
	public void handleComputeEvent() {
		
		// Get the shape location from the user
		float x_coordinate = input_manager.getValidFloatInRange("Enter X coordinate: ",-200,200);
		float y_coordinate = input_manager.getValidFloatInRange("Enter Y coordinate: ", -200 , 200);
		
		// Get all shapes found in the same location
		ArrayList<Shape> found_shapes = findShapesWithCoords(x_coordinate,y_coordinate);
		
		// Check if there is no shapes in that location, displays a message if so.
		if(found_shapes.size() == 0) {
			System.out.println("Could not find any shapes with the specified coordinates!\nAre you missing something?");
			printDashedLine();
		}else {
			for(Shape s: found_shapes) {
				
				// Compute the area and perimeter for each shape at that location
				double area = s.area();
				double perimeter = s.perimeter();
				ShapeType type = s.getShapeType();
				
				System.out.println(
						String.format("%s\n\tArea:\t\t%.5f\n\tPerimeter:\t%.5f\n", type,area,perimeter));
			}
			operationDoneOutput();
		}
	}
	
	// --------------------------Display All Shapes-----------------------
	public void handleDisplayAllEvent() {
		
		// If the vector was empty
		if(shapes.size() == 0) {
			printDashedLine();
			System.out.println("Looks Empty! Consider adding some Shapes :)");
			printDashedLine();
			return;
		}
		
		printDashedLine();
		for(Shape s : shapes) {
			System.out.println(s.toString()+"\n");
			
		}
		printDashedLine();
	}
	
	// --------------------------Move a Shape-----------------------------
	public void handleMoveEvent() {
		
		// Display the menu so the user can choose a shape
		// A circle cannot be moved!
		String menu = "What Shape do you want to move?\n"
					+ "B. Square\n"
					+ "C. Triangle\n"
					+ "D. Equilateral Triangle\n"
					+ "-------------\n";
		System.out.println(menu);
		
		// Get the input from the user in form of a ShapeType
		char response = input_manager.getValidCharInRange("Enter shape: ", 'B', 'D');
		ShapeType type = ShapeType.getShapeFromChar(response);
		
		// Get the shape location
		float x_coordinate = input_manager.getValidFloatInRange("Enter X coordinate: ",-200,200);
		float y_coordinate = input_manager.getValidFloatInRange("Enter Y coordinate: ", -200 , 200);
		
		// Check all shapes with the same location
		ArrayList<Shape> found_shapes = findShapesWithCoords(x_coordinate,y_coordinate);
		
		// This is used when the specific shape is found
		Shape shape = null;
		
		// If no shapes where found with the specific location
		if(found_shapes.size() == 0) {
			System.out.println("Could not find any shapes with the specified Coordinates!\nAre you missing something?");
			printDashedLine();
			return;
		}
		
		// get the exact same shape from the found shape in that location
		for(Shape s: found_shapes) {
			if(s.getShapeType() == type) {
				shape = s;
				break;
			}
		}
		
		// If no shape with the same type as specified by the user is found in that location
		if(shape == null) {
			System.out.println("Could not find any shapes with the specified Type!\nAre you missing something?");
			printDashedLine();
			return;
		}
		
		// Get the distance to move the shape
		// And the movement direction
		float movement_distance = input_manager.getValidFloat("Enter a distance to move the shape: ");
		MovementDirection mvt = getMovementDirectionFromUser();
		
		// Map each movement direction with its specific effect on the coordinates
		for(int i=0; i< shapes.size(); i++) {
			if((shapes.get(i)).equals(shape) && shapes.get(i).getShapeType() == shape.getShapeType()) {
				switch(mvt) {
					case UP:{
						shape.setYCoordinate(shape.getYCoordinate() + movement_distance);
						shapes.set(i, shape);
						break;
					}
					case DOWN:{
						shape.setYCoordinate(shape.getYCoordinate() - movement_distance);
						shapes.set(i,shape);
						break;
					}
					case RIGHT:{
						shape.setXCoordinate(shape.getXCoordinate() + movement_distance);
						shapes.set(i,shape);
						break;
					}
					case LEFT:{
						shape.setXCoordinate(shape.getXCoordinate() - movement_distance);
						shapes.set(i,shape);
						break;
					}
				}
			}
		}
		operationDoneOutput();
	}
	

	// --------------------------Read from file---------------------------
	public Vector<String> split_with_trim(String line) {
		String[] parts = line.split(",");
		Vector<String> res= new Vector<String>();
		
		// Since the format is 
		// A , B , C
		// parts should be exactly 3 elements big
		// otherwise return an empty Vector
		if(parts.length != 3) {
			return res;
		}
		res.add(parts[0].toLowerCase().trim());
		res.add(parts[1].toLowerCase().trim());
		res.add(parts[2].toLowerCase().trim());
		return res;
		
	}
	public boolean isValidShapeIdentifier(String line) {
		// A line is valid if it contains the following format
		// TYPE, X_float, Y_float
		// any other format will returns false
		// TYPE is case insensitive :
		//							CIRCLE
		// 							SQUARE
		// 							TRIANGLE
		//							EQUILATERAL_TRIANGLE
		
		Vector<String> parts = split_with_trim(line);
		
		// Check if the line was not splitted into 3 parts
		if(parts.size() == 0) {
			return false;
		}
		// check if the 2 last parts are actualy numbers
		try {
			Float.parseFloat(parts.get(1));
			Float.parseFloat(parts.get(2));
			
		}catch(NumberFormatException e) {
			return false;
		}
		
		// check that the first part is an actual type
		String[] types = {"circle", "square", "triangle", "equilateral triangle"};
		for(String type:types) {
			if(type.equalsIgnoreCase(parts.get(0))) {
				return true;
			}
		}
		return false;
	}
	public void handleReadFromFileEvent() {
		// Get the lines from the file
		Vector<String> lines = file_manager.readFromFile("shapes.txt");
		
		// On each line, check if it is valid
		// Split it into 3 parts and create a Shape with the corresponding parts
		for(String line: lines) {
			if(isValidShapeIdentifier(line)) {
				Vector<String> parts = split_with_trim(line);
				ShapeType type = ShapeType.getShapeFromName(parts.get(0)); 
				
				// No need to check for NumberFormatException 
				// Since we already checked when validating the input
				float x = Float.parseFloat(parts.get(1));
				float y = Float.parseFloat(parts.get(2));
				
				if((x < -200 || x > 200 ) || (y < -200 || y > 200)) {
					System.out.println(String.format("Skipped %s , because X and Y coordinates must be in range [-200 - 200]", line));
					continue;
				}
				Shape shape = null;
				switch(type) {
					case CIRCLE:{
						shape = new Circle(x,y,1);
						break;
					}
					case SQUARE:{
						shape = new Square(x,y,1);
						break;
					}
					case TRIANGLE:{
						shape = new Triangle(x,y,3,4,5);
						break;
					}
					case EQUILATERAL_TRIANGLE:{
						shape = new EquilateralTriangle(x,y,1);
						break;
					}
					default:{
						break;
					}
				}
				// Check if the shape already exists
				if(!shapeAlreadyExists(shape)) {
					shapes.add(shape);
				}
				// If so display a message
				else {
					System.out.println(String.format("Skipped %s , because a Shape with the exact specification already exists", line));
				}
			}
		}
		printDashedLine();
		System.out.println("Information read successfully!");
		printDashedLine();
	}
	
	
	// -------------------------Main Functions----------------------------

	public void handleChoice(MainMenuChoice choice) {
		// Maps each user choice to its corresponding event 
		switch(choice) {
			case ADD:{
				handleAddEvent();
				break;
			}
			case DELETE:{
				handleDeleteEvent();
				break;
			}
			case COMPUTE:{
				handleComputeEvent();
				break;
			}
			case DISPLAY_ALL:{
				handleDisplayAllEvent();
				break;
			}
			case MOVE:{
				handleMoveEvent();
				break;
			}
			case READ_FROM_FILE:{
				handleReadFromFileEvent();
				break;
			}
			// Default case is unreachable
			// since input is validated
			default:
				break;
		}
	}
	public void saveShapes() {
		// Saves the shapes Vector in a file 
		// appending to the end of the file
		// if we want to overide the file we can simply 
		// put a writeToFile with an empty string and append = false
		for(Shape s: shapes) {
			String content = String.format("%s,%s,%s\n",s.getShapeType().toString() , s.getXCoordinate(), s.getYCoordinate());
			
			file_manager.writeToFile("output.txt", content, true);
		}
		System.out.println("Shapes has been saved to output.txt");
	}
	public void run() {
		
		// Start the application, with displaying the menu and asking for input
		
		displayMainMenu();
		MainMenuChoice choice = getMainMenuChoiceFromUser();
		
		while(choice != MainMenuChoice.EXIT) {
			
			handleChoice(choice);
			
			// When handle choice is finished reAsk for input.
			displayMainMenu();
			choice = getMainMenuChoiceFromUser();
		}
		
		exitProgram();
	}
	public void exitProgram() {
		
		// Saves the shapes that are inside the Vector shape into a file called "output.txt"
		saveShapes();
		// Ensure no soucre leakage and close the input manager
		input_manager.close();
		
		// Display an exit message and exit with status of success
		System.out.println("Exiting the program, Beep Boop . . .");
		System.exit(0);
	}
	public static void main(String[] args) {
		
		// Roll a new app instance
		Application app = new Application();
		
		
		// Launch the app
		app.run();
	}

}
