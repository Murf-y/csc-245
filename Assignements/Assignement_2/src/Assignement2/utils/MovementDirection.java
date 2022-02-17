package Assignement2.utils;

public enum MovementDirection {
	UP,DOWN,RIGHT,LEFT;
	
	public static MovementDirection getMovementDirection(int response) {
		switch(response) {
			case 1:{
				return UP;
			}
			case 2:{
				return DOWN;
			}
			case 3:{
				return RIGHT;
			}
			case 4:{
				return LEFT;
			}
			// default will never be called because the input is validate
			// response can only be in range [1-4]
			default:{
				return UP;
			}
		}
	}
}
