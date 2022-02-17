package Assignment1;
import java.util.Scanner;
public class Bookstore {
	private Book[] collection;
	private int count;
	public Book[] getCollection() {
		return collection;
	}

	public void setCollection(Book[] c) {
		collection = c;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int c) {
		count = c;
	}

	public Bookstore() {
		collection = new Book[10];
		count = 0;
	}
	public void increaseSize(){
		Book[] temp=new Book[collection.length+10];
		for(int i=0; i<collection.length;i++){
			temp[i]=collection[i];
		}
		collection=temp;
	}
	public int findIndex(String t, String a,int e){
		int index=-1;
		if(e==2){
			for(int i=0;i<collection.length;i++){
				if(collection[i]==null)
					return index;
				if(collection[i].getTitle().equalsIgnoreCase(t)){
					if(collection[i] instanceof Encyclopedia){
						index = i;
						return index;
					}
				}
			}
		}else if(e==1){
			for(int i=0;i<collection.length;i++){
				if(collection[i]==null)
					return index;
				if(collection[i].getTitle().equalsIgnoreCase(t)&&collection[i].getAuthor().equalsIgnoreCase(a)){
					index = i;
					return index;
				}
			}
		}
		return index;
	}
	public void addBook(){
		if(count==collection.length){
			increaseSize();
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("1.Add a normal book");
		System.out.println("2.Add an encyclopedia");
		System.out.println("--------------------------");
		System.out.print("Enter your choice: ");
		int addChoice=scan.nextInt();
		if(addChoice!=1&&addChoice!=2){
			System.out.println();
			System.out.println("Wrong Choice.");
			return;
		}
		System.out.println("Enter the title: ");
		scan.nextLine();
		String title=scan.nextLine();
		if(addChoice==2){
			int index=findIndex(title,null,addChoice);
			if(index!=-1){
				collection[index].setNbCopies(collection[index].getNbCopies()+1);
				System.out.println("Encyclopedia already in collection. Adding to copies.");
				return;
			}
		}
		System.out.println("Enter the author: ");
		String author=scan.nextLine();
		if(addChoice==1){
			int index=findIndex(title,author,addChoice);
			if(index!=-1){
				collection[index].setNbCopies(collection[index].getNbCopies()+1);
				System.out.println("Book already in collection. Adding to copies.");
				return;
			}
		}
		
		System.out.println("Enter the number of pages: ");
		int nbPages=scan.nextInt();
		System.out.println("Enter the genre: ");
		scan.nextLine();
		String genre=scan.nextLine();
		System.out.println("Enter the number of copies: ");
		int nbCopies=scan.nextInt();
		System.out.println("Enter the price: ");
		float price=scan.nextInt();
		if(addChoice==2){
			System.out.println("Enter the number of volumes: ");
			int nbVolumes=scan.nextInt();
			Encyclopedia e=new Encyclopedia(title,author,nbPages,genre,nbCopies,price,nbVolumes);
			collection[count]=e;
			count++;
		}else if(addChoice==1){
			Book b=new Book(title,author,nbPages,genre,nbCopies,price);
			collection[count]=b;
			count++;
		}else{
			System.out.println("Wrong Choice. Please choose between 1 and 2.");
		}
	}
	public void deleteBook(){
		Scanner scan=new Scanner(System.in);
		System.out.println("1.Normal book");
		System.out.println("2.Encyclopedia");
		System.out.println("--------------------------");
		System.out.print("Enter your choice: ");
		int dChoice=scan.nextInt();
		System.out.println("Enter the title: ");
		scan.nextLine();
		String title=scan.nextLine();
		if(dChoice==2){
			int index=findIndex(title,null,dChoice);
			if(index!=-1){
				for(int i=index;i<collection.length;i++){
					if(i==collection.length-1){
						collection[i]=null;
						break;
					}
					collection[i]=collection[i+1];
				}
				count--;
			}else{
				System.out.println("Did not find the encyclopedia");
			}
		}
		if(dChoice==1){
			System.out.println("Enter the author: ");
			String author=scan.nextLine();
			int index=findIndex(title,author,dChoice);
			if(index!=-1){
				for(int i=index;i<collection.length;i++){
					if(i==collection.length-1){
						collection[i]=null;
						break;
					}
					collection[i]=collection[i+1];
				}
				count--;
			}else{
				System.out.println("Did not find the book");
			}
		}
	}
	
	public void sellBook(){
		Scanner scan=new Scanner(System.in);
		System.out.println("1.Normal book");
		System.out.println("2.Encyclopedia");
		System.out.println("--------------------------");
		System.out.print("Enter your choice: ");
		int dChoice=scan.nextInt();
		System.out.println("Enter the title: ");
		scan.nextLine();
		String title=scan.nextLine();
		if(dChoice==2){
			int index=findIndex(title,null,dChoice);
			if(index!=-1){
				if(collection[index].getNbCopies()-1==0){
					for(int i=index;i<collection.length;i++){
						if(i==collection.length-1){
							collection[i]=null;
							break;
						}
						collection[i]=collection[i+1];
					}
					count--;
				}else{
					collection[index].setNbCopies(collection[index].getNbCopies()-1);
				}
			}else{
				System.out.println("Did not find the encyclopedia");
			}
		}
		if(dChoice==1){
			System.out.println("Enter the author: ");
			String author=scan.nextLine();
			int index=findIndex(title,author,dChoice);
			if(index!=-1){
				if(collection[index].getNbCopies()-1==0){
					for(int i=index;i<collection.length;i++){
						if(i==collection.length-1){
							collection[i]=null;
							break;
						}
						collection[i]=collection[i+1];
					}
					count--;
				}else{
					collection[index].setNbCopies(collection[index].getNbCopies()-1);
				}
			}else{
				System.out.println("Did not find the book");
			}
		}
	}
	
	public void listAll(){
		for(int i=0;i<collection.length;i++){
			if(count==0){
				System.out.println("Empty collection");
			}
			if(collection[i]==null){
				return;
			}
			System.out.println(collection[i].toString());
		}
	}
	public void menu(){
		int choice = 0;
		Scanner scan=new Scanner(System.in);
		int wrong=0;
		do{
			System.out.println("1.Add book");
			System.out.println("2.Delete book");
			System.out.println("3.Sell book");
			System.out.println("4.List all");
			System.out.println("5.Exit");
			System.out.println("--------------------");
			System.out.print("Enter your choice: ");
			choice=scan.nextInt();
			System.out.println();
			switch(choice){
			case 1:
				wrong=0;
				addBook();
				break;
			case 2:
				wrong=0;
				deleteBook();
				break;
			case 3:
				wrong=0;
				sellBook();
				break;
			case 4:
				wrong=0;
				listAll();
				break;
			case 5:
				wrong=0;
				System.out.println("Goodbye");
				break;
			default:
				wrong++;
				if(wrong==5){
					System.out.println("You have entered the wrong input 5 consecutive times. Goodbye!");
					break;
				}
				System.out.println("Wrong choice. Please choose from 1 to 5.");
			}
			System.out.println();
		}while(choice!=5 && wrong!=5);
	}
	public static void main(String[] args){
		Bookstore b=new Bookstore();
		b.menu();

	}
	
}
