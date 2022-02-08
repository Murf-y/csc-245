
public enum MenuChoice {
	ADD,
	REMOVE,FIND,MATE,SOUNDS,PRINT_LIONS,PRINT_ALL,EXIT;
	
	public static MenuChoice getChoice(int response) {
		switch(response) {
			case 1:{
				return ADD;
			}
			case 2:{
				return REMOVE;
			}
			case 3:{
				return FIND;
			}
			case 4:{
				return MATE;
			}
			case 5:{
				return SOUNDS;
			}
			case 6:{
				return PRINT_LIONS;
			}
			case 7:{
				return PRINT_ALL;
			}
			case 8:{
				return EXIT;
			}
			default:{
				return EXIT;
			}
			
		}
	}
}
