package utils;

public class Application {
	private InputManager input_manager;
	
	public int countABC(String s) {
		if(s.contains("aba")) {
			return 1 + countABC(s.replaceFirst("aba", ""));
		}
		if(s.contains("abc")) {
			return 1 + countABC(s.replaceFirst("abc", ""));
		}
		else {
			return 0;
		}
	}
	public String removeStr(String s) {
		// ssstttrrr
		// sstttrrr
		// 
		if(s.length() <= 1) return s;
		if(s.charAt(0) == s.charAt(1)) {
			return  removeStr(String.format("%c", s.charAt(0)) + s.substring(2));
		}else {
			return String.format("%c", s.charAt(0)) + removeStr(String.format("%c", s.charAt(1)) + s.substring(2));
		}
		
	}
	public int fib(int n) {
		return n == 0 ? 0 : ( n == 1 ? 1 : fib(n-1) + fib(n-2) );
	}
	
	
	public boolean strCopies(String s, String sub, int n) {
		
		if(n == 0) return true;
		if(s.length() < sub.length()) return false;
		if(s.substring(0, sub.length()).equals(sub)) {
			return strCopies(s.substring(1) , sub , n-1);
		}else {
			return n == 1 + (strCopies(s.substring(1), sub , n) ? 1 : 0);
		}
	}
	public void permute(String str,String result) {
		if(str.length() <= 0) System.out.println(result);
		for(int i = 0; i < str.length(); i ++) {
			
			char c = str.charAt(i);
			
			String rest = str.substring(0,i) + str.substring(i+1);
			
			permute(rest, result + c);
		}
	}
	public void handleChoice(int choice) {
		switch(choice) {
			case 1:{
				String s = input_manager.getString("Enter a String: ");
				int a = countABC(s);
				System.out.println("Count ABC Result is " + a);
				break;
			}
			case 2:{
				String s = input_manager.getString("Enter a String: ");
				s = removeStr(s);
				System.out.println("RemoveStr Result is " +s);
				break;
			}
			case 3:{
				int n = input_manager.getValidIntInRange("Enter a number: ", 1, Integer.MAX_VALUE);
				n = fib(n);
				System.out.println("Fibonacci Result is " + n );
				break;
			}
			case 4:{
				String s = input_manager.getString("Enter a String: ");
				String sub = input_manager.getString("Enter sub: ");
				int n = input_manager.getValidIntInRange("Enter number of occurances: ", 0, Integer.MAX_VALUE);
				boolean res = strCopies(s, sub, n);
				System.out.println("strCopies Result is " + res);
				break;
			}
			case 5:{
				String s = input_manager.getString("Enter a String: ");
				permute(s,"");
				break;
			}
		}
	}
	
	public void displayMenu() {
		String menu =	"1.	CountABC\r\n"
				+ 		"2.	ReverseStr\r\n"
				+ 		"3.	Fibonacci\r\n"
				+		"4.	StrCopies\r\n"
				+		"5.	Permutation\r\n"
				+		"6. Exit\r\n"
				+ 		"---------------------";
		System.out.println(menu);
	}
	public void run() {
		input_manager = new InputManager();
		displayMenu();
		int choice = input_manager.getValidIntInRange("Enter your choice: ", 1, 5);	
		
		while(choice != 6) {
			handleChoice(choice);
			printDashedLine();
			displayMenu();
			choice = input_manager.getValidIntInRange("Enter your choice: ", 1, 5);	
		}
		closeApp();
	}
	public void printDashedLine() {
		System.out.println("\n---------------------\n");
	}
	public void closeApp() {
		System.out.println("Exiting the program, Beep Boop . . .");
		System.exit(0);
	}
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
}
