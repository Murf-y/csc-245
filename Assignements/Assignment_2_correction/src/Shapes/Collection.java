package Shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Collection {
	private Shape[] shapes;
	private int count;
	public Collection(){//Constructor
		shapes=new Shape[10];
		count=0;
	}
	public void increaseSize(){//Increasing the size of the array
		Shape[] temp=new Shape[shapes.length*2];
		for(int i=0;i<shapes.length;i++){
			temp[i]=shapes[i];
		}
		shapes=temp;
		
	}
	public void read(){//Reading from a file to create the shapes
			boolean error=true;
			while(error==true){
				try{
					FileReader fr=new FileReader("shapes.txt");
					BufferedReader br=new BufferedReader(fr);
					String line=null;
					while((line=br.readLine())!=null){
						String[] splitting=line.split(", ");
						if(count==shapes.length){//checking if the array is full and if yes increase the size
							increaseSize();
						}
						switch(splitting[0]){//adding based on the line components while checking if the type is correct
						case "circle":
							try{
								String color=splitting[1];
								int x =Integer.parseInt(splitting[2]);
								int y =Integer.parseInt(splitting[3]);
								int radius=Integer.parseInt(splitting[4]);
								if((x+radius)>100||(x+radius)<-100||(y+radius)>100||(y+radius)<-100)
									continue;
								shapes[count]=new Circle(color,x,y,radius);
								count++;}
							catch(NumberFormatException e){
								System.out.println("Wrong Input Type");
							}catch(IndexOutOfBoundsException e){
								System.out.println("Wrong number of arguments");
							}
							break;
						case "square":
							try{
								String color=splitting[1];
								int x =Integer.parseInt(splitting[2]);
								int y =Integer.parseInt(splitting[3]);
								int sl=Integer.parseInt(splitting[4]);
								if((x+(sl/2))>100||(x+(sl/2))<-100||(y+(sl/2))>100||(y+(sl/2))<-100)
									continue;
								shapes[count]=new Square(color,x,y,sl);
								count++;}
							catch(NumberFormatException e){
								System.out.println("Wrong Input Type");
							}
							catch(IndexOutOfBoundsException e){
								System.out.println("Wrong number of arguments");
							}
							break;
						case "triangle":
							try{
								String color=splitting[1];
								int x =Integer.parseInt(splitting[2]);
								int y =Integer.parseInt(splitting[3]);
								int s1 =Integer.parseInt(splitting[4]);
								int s2 =Integer.parseInt(splitting[5]);
								int s3 =Integer.parseInt(splitting[6]);
								int[] sides={s1,s2,s3};
								int max=0;
								for(int i=0;i<sides.length;i++)
									if(sides[i]>max){
										max=sides[i];
									}
								if((x+max)>100||(x+max)<-100||(y+max)>100||(y+max)<-100)
									continue;
								if(sides[0]+sides[1]>sides[2]&&sides[1]+sides[2]>sides[0]&&sides[0]+sides[2]>sides[1]){
									shapes[count]=new Triangle(color,x,y,sides);
									count++;
								}else{
									System.out.println("Sides do not work");
								}
							}
							catch(NumberFormatException e){
								System.out.println("Wrong Input Type");
							}
							catch(IndexOutOfBoundsException e){
								System.out.println("Wrong number of arguments");
							}
							break;
						case "equilateral triangle":
							try{
								String color=splitting[1];
								int x =Integer.parseInt(splitting[2]);
								int y =Integer.parseInt(splitting[3]);
								int s1 =Integer.parseInt(splitting[4]);
								int s2 =Integer.parseInt(splitting[5]);
								int s3 =Integer.parseInt(splitting[6]);
								int[] sides={s1,s2,s3};
								if((x+sides[0])>100||(x+sides[0])<-100||(y+sides[0])>100||(y+sides[0])<-100)
									continue;
								if(sides[0]==sides[1]&&sides[1]==sides[2]){
									shapes[count]=new EquilateralTriangle(color,x,y,sides);
									count++;
								}else{
									System.out.println("Not an equilateral triangle");
								}
							}
							catch(NumberFormatException e){
								System.out.println("Wrong Input Type");
							}
							catch(IndexOutOfBoundsException e){
								System.out.println("Wrong number of arguments");
							}
							break;
						default:
							System.out.println("Not a shape");
						}
					}
					br.close();
					fr.close();
					error=false;
				}catch(IOException e){
					System.out.println("Wrong file name.");
				}
			}
	}
	public void write(){//writing to a new file that is generated using a File object
		try{
			File file=new File("output.txt");
			FileWriter fw=new FileWriter(file);
			PrintWriter pw=new PrintWriter(fw);
			for(int i=0;i<count;i++){
				pw.println(shapes[i].toString());
			}
			pw.close();
			fw.close();
		}catch(IOException e){
			System.out.println("Wrong File.");
		}
	}
	public void add(){//adding based on the type and while reading every variable needed, with try catch
		if(count==shapes.length){
			increaseSize();
		}
		Scanner scan =new Scanner(System.in);
		System.out.println();
		System.out.println("A. Add a Circle");
		System.out.println("B. Add a Sqaure");
		System.out.println("C. Add a Triangle");
		System.out.println("D. Return to main menu");
		System.out.println("-----------------");
		System.out.print("Enter shape:");
		String choice=scan.next();
		String color=null;
		boolean error=true;
		int x=0;
		int y=0;
		switch(choice){
		case "A":
			System.out.println("Enter the color");
			color=scan.next();
			System.out.println("Enter the radius");
			int radius=0;
			while(error==true){
				try{
					radius=scan.nextInt();
					error=false;
				}
				catch(InputMismatchException e){
					System.out.println("Wrong Format. Enter again.");
					scan.nextLine();
				}
			}
			do{
				System.out.println("Enter the x coordinate");
				error=true;
				while(error==true){
					try{
						x=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(Math.abs(x)+radius>100)
					System.out.println("X should be between -100 and 100");
			}while(Math.abs(x)+radius>100);
			do{
				System.out.println("Enter the y coordinate");
				error=true;
				while(error==true){
					try{
						y=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(Math.abs(y)+radius>100)
					System.out.println("Y should be between -100 and 100");
			}while(Math.abs(y)+radius>100);
			Circle c= new Circle(color,x,y,radius);
			shapes[count]=c;
			count++;
			break;
		case "B":
			System.out.println("Enter the color");
			color=scan.next();
			System.out.println("Enter the side length");
			int sl=0;
			while(error==true){
				try{
					sl=scan.nextInt();
					error=false;
				}
				catch(InputMismatchException e){
					System.out.println("Wrong Format. Enter again.");
					scan.nextLine();
				}
			}
			
			do{
				System.out.println("Enter the x coordinate");
				error=true;
				while(error==true){
					try{
						x=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(Math.abs(x)+sl/2>100)
					System.out.println("X should be between -100 and 100");
			}while(Math.abs(x)+sl/2>100);
			do{
				System.out.println("Enter the y coordinate");
				error=true;
				while(error==true){
					try{
						y=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(Math.abs(y)+sl/2>100)
					System.out.println("X should be between -100 and 100");
			}while(Math.abs(y)+sl/2>100);
			Square s=new Square(color,x,y,sl);
			shapes[count]=s;
			count++;
			break;
		case "C":
			System.out.println("Enter the color");
			color=scan.next();
			System.out.println("Enter the sides' length");
			int[] sides=new int[3];
			while(error==true){
				try{
					for(int i=0;i<sides.length;i++){
						System.out.println("Enter side"+(i+1));
						sides[i]=scan.nextInt();
					}
					error=false;
				}
				catch(InputMismatchException e){
					System.out.println("Wrong Format. Enter again.");
					scan.nextLine();
				}
			}
			int max=0;
			for(int i=0;i<sides.length;i++){
				if(sides[i]>max){
					max=sides[i];
				}
			}
			do{
				System.out.println("Enter the x coordinate");
				error=true;
				while(error==true){
					try{
						x=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(Math.abs(x)+max>100)
					System.out.println("X should be between -100 and 100");
			}while(Math.abs(x)+max>100);
			do{
				System.out.println("Enter the y coordinate");
				error=true;
				while(error==true){
					try{
						y=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(Math.abs(y)+max>100)
					System.out.println("X should be between -100 and 100");
			}while(Math.abs(y)+max>100);
			if(sides[0]==sides[1]&&sides[1]==sides[2]){
				shapes[count]=new EquilateralTriangle(color,x,y,sides);
				count++;
			}
			else if(sides[0]+sides[1]>sides[2]&&sides[1]+sides[2]>sides[0]&&sides[0]+sides[2]>sides[1]){
				shapes[count]=new Triangle(color,x,y,sides);
				count++;
			}else{
				System.out.println("Sides given do not make a triangle");
			}
			break;
		case "D":
			System.out.println();
			break;
		default:
			System.out.println("Wrong Input");
		}
		
	}
	
	public void delete(){//checking for the elements and deleting them based on x and y while shifting since deleting mutliple elements
		boolean error=true;
		System.out.println("Enter the x coordinate");
		int x=0;
		Scanner scan=new Scanner(System.in);
		while(error==true){
			try{
				x=scan.nextInt();
				error=false;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Format. Enter again.");
				scan.nextLine();
			}
		}
		System.out.println("Enter the y coordinate");
		error=true;
		int y=0;
		while(error==true){
			try{
				y=scan.nextInt();
				error=false;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Format. Enter again.");
				scan.nextLine();
			}
		}
		for(int i=0;i<shapes.length;i++){
			if(shapes[i]==null){
				return;
			}
			if(shapes[i].getX()==x&&shapes[i].getY()==y){
				for(int j=i;j<count;j++){
					System.out.println(i);
					if(j==count-1&&count==shapes.length)
						shapes[count-1]=null;
					else{
						shapes[j]=shapes[j+1];
					}
					
				}
				count--;
			}
		}
	}
	public void compute(){//same flow as delete method but instead of deleting, output the area and perimeter methods
		boolean error=true;
		System.out.println("Enter the x coordinate");
		int x=0;
		Scanner scan=new Scanner(System.in);
		while(error==true){
			try{
				x=scan.nextInt();
				error=false;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Format. Enter again.");
				scan.nextLine();
			}
		}
		System.out.println("Enter the y coordinate");
		error=true;
		int y=0;
		while(error==true){
			try{
				y=scan.nextInt();
				error=false;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Format. Enter again.");
				scan.nextLine();
			}
		}
		for(int i=0;i<count;i++){
			if(shapes[i]==null){
				return;
			}
			if(shapes[i].getX()==x&&shapes[i].getY()==y){
				System.out.println(shapes[i].toString());
				System.out.println("Perimeter= "+shapes[i].perimeter());
				System.out.println("Area= "+shapes[i].area());
				System.out.println();
			}
		}
	}
	public void move(){//check for elements at X and Y and make sure that X and Y, depending on which is going to be changed do not exceed, with the shape, the 100 or -100 units since we have a 200 units wide and 200 units tall square as a boundary.
		boolean error=true;
		System.out.println("Enter the x coordinate");
		int x=0;
		Scanner scan=new Scanner(System.in);
		while(error==true){
			try{
				x=scan.nextInt();
				error=false;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Format. Enter again.");
				scan.nextLine();
			}
		}
		System.out.println("Enter the y coordinate");
		error=true;
		int y=0;
		while(error==true){
			try{
				y=scan.nextInt();
				error=false;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Format. Enter again.");
				scan.nextLine();
			}
		}
		System.out.println();
		System.out.println("1. Up");
		System.out.println("2. Down");
		System.out.println("3. Right");
		System.out.println("4. Left");
		System.out.print("Choose the direction by which you want to move the objects: ");
		error=true;
		int dir=0;
		while(error==true){
			try{
				dir=scan.nextInt();
				error=false;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Format. Enter again.");
				scan.nextLine();
			}
		}
		int length=0;
		switch(dir){
		case 1:
			System.out.println("Please enter the distance");
			do{
				error=true;
				while(error==true){
					try{
						length=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(length<0){
					System.out.println("Enter a value between 0 and 100");
				}
			}while(length<0);
			for(int i=0;i<count;i++){
				if(shapes[i].getX()==x&&shapes[i].getY()==y){
					if((x+length+shapes[i].getBound())<100)
						shapes[i].setX(x+length);
					else
						System.out.println("Could not modify");
				}
			}
			break;
		case 2:
			System.out.println("Please enter the distance");
			do{
				error=true;
				while(error==true){
					try{
						length=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(length>0){
					System.out.println("Enter a value between 0 and 100");
				}
				
			}while(length>0);
			for(int i=0;i<count;i++){
				if(shapes[i].getX()==x&&shapes[i].getY()==y){
					if((x+length+shapes[i].getBound())>-100)
						shapes[i].setX(x+length);
					else
						System.out.println("Could not modify");
				}
			}
			break;
		case 3:
			System.out.println("Please enter the distance");
			do{
				error=true;
				while(error==true){
					try{
						length=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(length<0){
					System.out.println("Enter a value between 0 and 100");
				}
				if((y+length)>100){
					System.out.println("Enter a value less than "+length+" since it makes x bigger than 100.");
				}
			}while((y+length)>100||length<0);
			for(int i=0;i<count;i++){
				if(shapes[i].getX()==x&&shapes[i].getY()==y){
					if((y+length+shapes[i].getBound())<100)
						shapes[i].setY(y+length);
					else
						System.out.println("Could not modify");
				}
			}
			break;
		case 4:
			System.out.println("Please enter the distance");
			do{
				error=true;
				while(error==true){
					try{
						length=scan.nextInt();
						error=false;
					}
					catch(InputMismatchException e){
						System.out.println("Wrong Format. Enter again.");
						scan.nextLine();
					}
				}
				if(length>0){
					System.out.println("Enter a value between 0 and 100");
				}
				if((y+length)<-100){
					System.out.println("Enter a value less than "+length+" since it makes x smaller than -100.");
				}
			}while((y+length)<-100||length>0);
			for(int i=0;i<count;i++){
				if(shapes[i].getX()==x&&shapes[i].getY()==y){
					if((y+length+shapes[i].getBound())>-100)
						shapes[i].setY(y+length);
					else
						System.out.println("Could not modify");
				}
			}
			break;
		default:
			System.out.println("Wrong input");
		}
	}
	public void displayAll(){//print all shapes
		for(int i=0; i<shapes.length;i++){
			if(shapes[i]==null){
				return;
			}
			System.out.println(shapes[i].toString());
		}
		System.out.println();
	}
	public void menu(){
		Scanner scan =new Scanner(System.in);
		int choice=0;
		do{
		System.out.println("1. Add a shape");
		System.out.println("2. Delete a shape");
		System.out.println("3. Compute Area and Perimeter");
		System.out.println("4. Display All");
		System.out.println("5. Move an object");
		System.out.println("6. Read from file");
		System.out.println("7. Exit");
		System.out.println("---------");
		System.out.print("Enter your choice:");
		boolean error=true;
		while(error==true){
			try{
				choice=scan.nextInt();
				error=false;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Format. Enter again.");
				scan.nextLine();
			}
		}
		switch(choice){
		case 1:
			add();
			break;
		case 2:
			delete();
			break;
		case 3:
			compute();
			break;
		case 4:
			displayAll();
			break;
		case 5:
			move();
			break;
		case 6:
			read();
			break;
		case 7:
			write();
			System.out.println("Exiting");
			break;
		default:
			System.out.println("Wrong Choice. Please pick between 1 and 7.");	
		}
		}while(choice!=7);
	}
	public static void main(String[] args){
		Collection c = new Collection();
		c.menu();
	}
	}
