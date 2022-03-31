package Recursion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2 {
	private static int[] numbers=new int [10];
	private static int count=0;
	public static void increaseSize(){
		int[] temp=new int[numbers.length+10];
		for(int i=0;i<numbers.length;i++){
			temp[i]=numbers[i];
		}
		numbers=temp;
	}
	public static void even_odd(int n, int i){
		if(i==count){
			return;
		}
		else if(n==1 && numbers[i]%2==1){
			System.out.print(numbers[i]+" ");
		}else if(n==0&&numbers[i]%2==0){
			System.out.print(numbers[i]+" ");
		}
		even_odd(n,i+1);
	}
	public static void add(){
		String answer="";
		Scanner scan= new Scanner(System.in);
		do{
			if(count==numbers.length)
				increaseSize();
			int n=0;
			System.out.println("Enter a number:");
			boolean error=true;
			while(error){
				try{
					n=scan.nextInt();
					error=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong input type. Please enter again:");
					scan.nextLine();
				}
			}
			numbers[count]=n;
			count++;
			System.out.println("Do you want to continue adding? (yes/no)");
			answer=scan.next();
		}while(answer.equalsIgnoreCase("yes"));
	}
	public static void max(int m, int i){
		if(i==count)
			System.out.println("Max is "+m);
		else if(numbers[i]>m){
			max(numbers[i],i+1);
		}else{
			max(m,i+1);
		}
	}
	 public static boolean addsUp(int [] arr)
	    {
	        return addsUp(arr, 0, 0, 0, 0, 0);
	    }
	public static boolean addsUp(int[] arr, int i, int c1, int sum1, int c2, int sum2)
    {
        if (i == arr.length)
            return sum1 == sum2;
        return addsUp(arr, i+1, c1+1, sum1 + arr[i], c2, sum2) ||
        		addsUp(arr, i+1, c1, sum1, c2+1, sum2 + arr[i]);//the || will let you go through all possible combinations
    }
	public static void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	public static boolean sum(int[] arr, int sum, int prev, int curr, int csum){
		boolean reach=false;
		if(csum==sum){//if sum has been found
			return true;
		}
		if(curr==arr.length){//if pointer has reached the end of the array
			return false;
		}
		if(curr-1==prev){//if previous element has been included in the sum
			reach=sum(arr,sum,prev,curr+1,csum);
		}else if(csum+arr[curr]>sum){//if the addition of the element to the current sum exceeds the targeted sum
			reach=sum(arr,sum,prev,curr+1,csum);
		}else{//if the addition of the element to the current sum does not exceed the targeted sum			
			reach=sum(arr,sum,curr,curr+1,csum+arr[curr]);
		}
		if(reach==true)//if target has been reached, return
			return reach;
		else {//if not reached go back in elements
			reach=sum(arr,sum,prev,curr+1,csum);
		}
		return reach;
	}
	public static void display(){
		add();
		int choice=0;
		do{
			System.out.println("1. Even or odd");
			System.out.println("2. Find max");
			System.out.println("3. Adds up");
			System.out.println("4. Sum");
			System.out.println("5. Exit");
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
				System.out.println("Print Options:");
				System.out.println("0. Even");
				System.out.println("1. Odd");
				while(error1){
					try{
						n=scan.nextInt();
						error1=false;
					}catch(InputMismatchException e){
						System.out.println("Wrong input type. Please enter again:");
						scan.nextLine();
					}
				}
				even_odd(n, 0);
				break;
			case 2:
				max(0,0);
				break;
			case 3:
				System.out.println(addsUp(numbers));
				break;
			case 4:
				System.out.println("Please enter the sum target:");
				while(error1){
					try{
						n=scan.nextInt();
						error1=false;
					}catch(InputMismatchException e){
						System.out.println("Wrong input type. Please enter again:");
						scan.nextLine();
					}
				}
				System.out.println(sum(numbers, n,-2,0,0));
				break;
			case 5:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Wrong Input");
			}
			System.out.println();
		}while(choice!=5);
	}
	public static void main(String[] args){
		display();
	}
}
