package Q1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dictionary {
	private BST b;
	public void menu(){
		Scanner scan =new Scanner(System.in);
		int choice=0;
		do{
		System.out.println("1. Create the dictionary");
		System.out.println("2. Add a definiton");
		System.out.println("3. Remove a definition");
		System.out.println("4. Search for a definition");
		System.out.println("5. Print Dictionary");
		System.out.println("6. Exit");
		System.out.println("---------------------------");
		System.out.println("Enter your choice:");
		boolean error=true;
		while(error){
			try{
				choice=scan.nextInt();
				error=false;
			}catch(InputMismatchException e){
				System.out.println("Wrong Input Type. Please enter again...");
				scan.nextLine();
			}
		}
		switch(choice){
		case 1:
			create();
			break;
		case 2:
			add();
			break;
		case 3:
			remove();
			break;
		case 4:
			search();
			break;
		case 5:
			if(b==null){
				System.out.println("Dictionary not created yet.");
				break;
			}
			b.print(b.getRoot());
			break;
		case 6:
			save();
			break;
		default:
			System.out.println("Enter a number between 1 and 6");
		}
		System.out.println();
		}while(choice!=6);
	}
	
	public void create(){
		b=new BST();
		Scanner scan = new Scanner(System.in);
		int wrong=0;
		boolean error=true;
		BufferedReader br = null;
		do{
			try{
				System.out.println("Please enter the name of the file");
				String f=scan.next();
				FileReader reader=new FileReader(f);
				br =new BufferedReader(reader);
				error=false;
			}catch(IOException e){
				System.out.println("File not found...");
				scan.nextLine();
				wrong++;
			}
		}while(wrong<3&&error==true);
		if(wrong==3)
			return;
		CD(br);
	}
	
	public void CD(BufferedReader br){
		String st="";
		try {
			if((st = br.readLine()) != null){
				String[] s=st.split(":");
				if(s.length==2){
					b.add(b.getRoot(), new Node(s[0],s[1]));
				}
				CD(br);
			}
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	public void save(){
		FileWriter fw;
		try {
			File f=new File("output.txt");
			fw = new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			CS(b.getRoot(),bw);
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
		
		
	}
	public void CS(Node r,BufferedWriter bw){
		if(r==null)
			return;
		CS(r.getLeft(),bw);
		System.out.println(r.toString());
		try {
			bw.write(r.toString()+"\n");
		} catch (IOException e) {
			System.out.println("Error");
		}
		CS(r.getRight(),bw);
	}
	
	public void remove(){
		if(b==null){
			System.out.println("Dictionary not created yet.");
			return;
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the word you wish to remove");
		String w=scan.nextLine();
		Node n=b.find(b.getRoot(), w);
		if(n==null){
			System.out.println("Word not found in dictionary");
		}else{
			b.remove(w);
		}
	}
	
	public void search(){
		if(b==null){
			System.out.println("Dictionary not created yet.");
			return;
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the word you wish to enter");
		String w=scan.nextLine();
		Node n=b.find(b.getRoot(), w);
		if(n==null){
			System.out.println("Word not in dictionary");
		}else{
			System.out.println(n.toString());
		}
	}
	
	public void add(){
		if(b==null){
			System.out.println("Dictionary not created yet.");
			return;
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the word you wish to enter");
		String w=scan.nextLine();
		Node n=b.find(b.getRoot(), w);
		if(n!=null){
			System.out.println("Word already in dictionary");
		}else{
			System.out.println("Enter its definition");
			String d=scan.nextLine();
			b.add(b.getRoot(), new Node(w,d));
		}
	}
	public static void main(String[] args){
		Dictionary d=new Dictionary();
		d.menu();
	}
}
