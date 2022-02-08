
public enum AnimalType {
	LION,GIRAFFE,SNAKE,SEAL;
	public static AnimalType getChoice(int response) {
		switch(response) {
			case 1:{
				return LION;
			}
			case 2:{
				return GIRAFFE;
			}
			case 3:{
				return SEAL;
			}
			case 4:{
				return SNAKE;
			}
			default:{
				return LION;
			}
			
		}
	}
}