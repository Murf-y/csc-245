package Recursion;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex1 {
	public static String rev(int n){
		if(n==0)
			return "";
		return ""+n%10+rev(n/10);
	}
	public static int countD(int n){
		if(n/10==0)
			return 1;
		return 1+countD(n/10);
	}
	public static String repeat(String s, int n){
		if(n==0){
			return "";
		}
		return s+repeat(s,n-1);
	}
	public static void display(){
		int choice=0;
		do{
		System.out.println("1. Reverse number");
		System.out.println("2. Count Digits");
		System.out.println("3. Repeat");
		System.out.println("4. Exit");
		System.out.println("-----------------------");
		System.out.println("Enter a choice:");
		Scanner scan= new Scanner(System.in);
		boolean error=true;
		while(error){
			try{
				choice=scan.nextInt();
				error=false;
			}catch(InputMismatchException e){
				System.out.println("Wrong input type. Please enter again:");
				scan.nextLine();
			}
		}
		int n=0;
		boolean error1=true;
		switch(choice){
		case 1:
			System.out.println("Enter a number:");
			while(error1){
				try{
					n=scan.nextInt();
					error1=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong input type. Please enter again:");
					scan.nextLine();
				}
			}
			System.out.println(rev(n));
			break;
		case 2:
			System.out.println("Enter a number:");
			while(error1){
				try{
					n=scan.nextInt();
					error1=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong input type. Please enter again:");
					scan.nextLine();
				}
			}
			System.out.println(countD(n));
			break;
		case 3:
			System.out.println("Enter a string:");
			scan.nextLine();
			String str=scan.nextLine();
			error1=true;
			System.out.println("Enter a number:");
			while(error1){
				try{
					n=scan.nextInt();
					error1=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong input type. Please enter again:");
					scan.nextLine();
				}
			}
			System.out.println(repeat(str,n));
			break;
		case 4:
			System.out.println("Goodbye");
			break;
		default:
			System.out.println("Wrong Input");
		}
		System.out.println();
		}while(choice!=4);
		
	}
	public static void main(String[] args){
		display();
		
	}
}
