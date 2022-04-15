package Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestProgram
{
	final static int SIZE=5;

	public static void sort(Sortable[] items)
	{
/*sorts  an array of items in an increasing order as specified in the compareTo() method*/

		for (int i = 1; i < items.length; i++ )
		{
			Sortable key  = items[i];
			int position = i;
			while (position > 0 && items[position-1].compareTo(key) > 0)
				{
					items[position]=items[position-1];
					position--;
				}
			items[position]=key;
		}
	}
	
	public static void show(Sortable[] items)
	{
		for (int i = 0; i < items.length; i++ )
		{
			 if (items[i]!= null)
			 	System.out.print(items[i]);
			}
	}
	public static void main(String[] args){
		Animal[] animals= new Animal[SIZE];
		int count=0;
		File file;
		Scanner scan = null;
		try {
			file=new File("input.txt");
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		while(scan.hasNextLine()){
			String line=scan.nextLine();
			if(count==animals.length){
				Animal[] temp=new Animal[count+1];
				for(int i =0;i<count;i++){
					temp[i]=animals[i];
				}
				animals=temp;
			}
			String[] s= line.split(" ");
			if(s.length==5){
				String color=s[1];
				String gender=s[2];
				int age=Integer.parseInt(s[3]);
				int consumption=Integer.parseInt(s[4]);
				switch(s[0]){
				case "Cow":
					if(consumption<=5000){
						animals[count]=new Cow(age,color,gender,consumption);
						count++;
					}
					break;
				case "Dog":
					if(consumption<=200){
						animals[count]=new Dog(age,color,gender,consumption);
						count++;
					}
					break;
				case "Horse":
					if(consumption<=7000){
						animals[count]=new Horse(age,color,gender,consumption);
						count++;
					}
					break;
				case "Chicken":
					if(consumption<=50){
						animals[count]=new Chicken(age,color,gender,consumption);
						count++;
					}
					break;
				}
			}
		}
		if(count<animals.length){
			Animal[] temp=new Animal[count];
			for(int i =0;i<count;i++){
				temp[i]=animals[i];
			}
			animals=temp;
		}
		sort(animals);
		show(animals);

	}


}
