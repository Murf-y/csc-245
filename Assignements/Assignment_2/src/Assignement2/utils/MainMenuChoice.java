package Assignement2.utils;

public enum MainMenuChoice {
	ADD, DELETE,COMPUTE,DISPLAY_ALL,MOVE,READ_FROM_FILE,EXIT;
	
	public static MainMenuChoice getMainMenuChoice(int choice) {
		// choice will always be in range [1 - 7]
		switch(choice) {
			case 1:{
				return ADD;
			}
			case 2:{
				return DELETE;
			}
			case 3:{
				return COMPUTE;
			}
			case 4:{
				return DISPLAY_ALL;
			}
			case 5:{
				return MOVE;
			}
			case 6:{
				return READ_FROM_FILE;
			}
			
			case 7:{
				return EXIT;
			}
			
			default:{
				// This will never be executed but just in case
				// Exit the program
				
				return EXIT;
			}
		}
	}
}
