package Q2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
//Added writing to file after sorting
public class Farm {
	private LL farm;
	public Farm(){
		farm=new LL();
	}
	public void menu(){
		int choice=0;
		int wrong=0;
		do{
			System.out.println("1. Add an animal");
			System.out.println("2. Search for an animal");
			System.out.println("3. Sort");
			System.out.println("4. Remove by consumption");
			System.out.println("5. Exit");
			System.out.println("---------------------------");
			System.out.print("Enter your choice: ");
			Scanner scan = new Scanner(System.in);
			boolean error=true;
			while(error){
				try{
					choice=scan.nextInt();
					error=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong Input Format");
					scan.nextLine();
				}
			}
			switch(choice){
			case 1:
				wrong=0;
				add();
				break;
			case 2:
				wrong=0;
				search();
				break;
			case 3:
				wrong=0;
				farm.sort();
				System.out.println("Sorted List:");
				farm.printAll(farm.getHead());
				write();
				break;
			case 4:
				wrong=0;
				System.out.println("Enter the consumption value");
				error=true;
				int c=0;
				while(error){
					try{
						c=scan.nextInt();
						error=false;
					}catch(InputMismatchException e){
						System.out.println("Wrong Input Format");
						scan.nextLine();
					}
				}
				farm.deleteAll(c);
				farm.printAll(farm.getHead());
				break;
			case 5:
				wrong=0;
				System.out.println("Goodbye");
				break;
			default:
				wrong++;
				System.out.println("Wrong Input. Choose between 1 and 5.");
			}
			System.out.println();
		}while(choice!=5&&wrong!=5);
	}
	public void write(){
		try {
			  File file=new File("output.txt");
		      FileWriter myWriter = new FileWriter(file);
		      Node current =farm.getHead();
		      while(current!=null){
		    	  myWriter.write(current.toString());
		    	  current=current.getNext();
		      }
		      myWriter.close();
		      System.out.println("Writing Successful");
		    } catch (IOException e) {
		      System.out.println("An error occurred while writing to file");
		    }
	}
	public void search(){
		Scanner scan=new Scanner(System.in);
		boolean error=true;
		System.out.println("1. Cow");
		System.out.println("2. Dog");
		System.out.println("3. Horse");
		System.out.println("4. Chicken");
		System.out.print("Enter the type of the animal: ");
		int type=0;
		error=true;
		while(error){
			try{
				type=scan.nextInt();
				error=false;
			}catch(InputMismatchException e){
				System.out.println("Wrong Input Format");
				scan.nextLine();
			}
		}
		int i=0;
		switch(type){
		case 1:
			i=farm.findAll(farm.getHead(),"Cow",0);
			break;
		case 2:
			i=farm.findAll(farm.getHead(),"Dog",0);
			break;
		case 3:
			i=farm.findAll(farm.getHead(),"Horse",0);
			break;
		case 4:
			i=farm.findAll(farm.getHead(),"Chicken",0);			
			break;
		default:
			System.out.println("No such animal exists");
		}
		if(i==0){
			System.out.println("No such animal found");
		}
	}
	public void add(){
		Scanner scan = new Scanner(System.in);
		boolean error=true;
		System.out.println("Please enter the age of the animal");
		int age=0;
		while(error){
			try{
				age=scan.nextInt();
				error=false;
			}catch(InputMismatchException e){
				System.out.println("Wrong Input Format");
				scan.nextLine();
			}
		}
		System.out.println("Please enter the color of the animal");
		String color=scan.next();
		System.out.println("Please enter the gender of the animal");
		String gender=scan.next();
		error=true;
		System.out.println("1. Cow");
		System.out.println("2. Dog");
		System.out.println("3. Horse");
		System.out.println("4. Chicken");
		System.out.print("Enter the type of the animal: ");
		int type=0;
		error=true;
		while(error){
			try{
				type=scan.nextInt();
				error=false;
			}catch(InputMismatchException e){
				System.out.println("Wrong Input Format");
				scan.nextLine();
			}
		}
		
		int consumption=0;
		error=true;
		switch(type){
		case 1:
			System.out.println("Please enter the consumption of the animal");
			while(error||consumption>5000){
				if(error==false)
					System.out.println("Enter a consumption less or equal to 5000");
				try{
					consumption=scan.nextInt();
					error=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong Input Format");
					scan.nextLine();
					error=true;
				}
			}
			farm.add(farm.getHead(),new Cow(age,color,gender,consumption));
			break;
		case 2:
			System.out.println("Please enter the consumption of the animal");
			while(error||consumption>200){
				if(error==false)
					System.out.println("Enter a consumption less or equal to 200");
				try{
					consumption=scan.nextInt();
					error=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong Input Format");
					scan.nextLine();
					error=true;
				}
			}
			farm.add(farm.getHead(),new Dog(age,color,gender,consumption));
			break;
		case 3:
			System.out.println("Please enter the consumption of the animal");
			while(error||consumption>7000){
				if(error==false)
					System.out.println("Enter a consumption less or equal to 7000");
				try{
					consumption=scan.nextInt();
					error=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong Input Format");
					scan.nextLine();
					error=true;
				}
			}
			farm.add(farm.getHead(),new Horse(age,color,gender,consumption));
			break;
		case 4:
			System.out.println("Please enter the consumption of the animal");
			while(error||consumption>50){
				if(error==false)
					System.out.println("Enter a consumption less or equal to 50");
				try{
					consumption=scan.nextInt();
					error=false;
				}catch(InputMismatchException e){
					System.out.println("Wrong Input Format");
					scan.nextLine();
					error=true;
				}
			}
			farm.add(farm.getHead(),new Chicken(age,color,gender,consumption));
			break;
		default:
			System.out.println("No such animal exist");
		}
	}
	public static void main(String[] args){
		Farm f=new Farm();
		f.getFarm().add(f.getFarm().getHead(), new Cow(20,"red","male",200));
		f.getFarm().add(f.getFarm().getHead(), new Chicken(2,"white","female",1));
		f.getFarm().add(f.getFarm().getHead(), new Horse(5,"brown","male",5000));
		f.getFarm().add(f.getFarm().getHead(), new Cow(1,"black","male",300));
		f.getFarm().add(f.getFarm().getHead(), new Dog(5,"black","male",50));
		f.getFarm().add(f.getFarm().getHead(), new Cow(8,"white","female",1));
		f.menu();
	}
	public LL getFarm() {
		return farm;
	}
	public void setFarm(LL f) {
		farm = f;
	}
}
