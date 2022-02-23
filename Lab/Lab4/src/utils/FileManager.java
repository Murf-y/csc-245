package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileManager {
	public Vector<String> readFromFile(String file_name){
		Vector<String> lines = new Vector<String>();
		try(FileReader f_reader = new FileReader(file_name);
				BufferedReader b_reader = new BufferedReader(f_reader))
			{	
				String line = b_reader.readLine();
				while (line != null) {
					lines.add(line);
					line = b_reader.readLine();
				}
			}
			catch(FileNotFoundException e)
			{
				System.out.println(String.format("Cannot open file \"%s\" are you missing something? . . .", file_name));
			}
			catch(IOException e) {
				System.out.println("An error occured while processing the file . . .");
			}
		
		return lines;
	}
	public void writeToFile(String file_name, String content, boolean append) {
		try(FileWriter f_writer = new FileWriter(file_name, append);
				BufferedWriter b_writer = new BufferedWriter(f_writer))
			{
				b_writer.write(content);
			}
			catch(IOException e)
			{
				System.out.println(String.format("Cannot open file \"%s\" are you missing something? . . .", file_name));
			}
	}
}