/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Apr 15, 2022
 * LastModified: Apr 15, 2022
 * FileName: FileManager.java
 *****************************************************
 */
package utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileManager {
	private InputManager input_manager;
	
	public FileManager() {
		input_manager = new InputManager();
	}
	public Vector<String> readFromFileWithAttempts(int attempts_left) throws Exception{
		
		if(attempts_left <= 0) throw new Exception();
		
		String file_name = input_manager.getString("Enter file name (default: input.txt): ");
		
		Vector<String> lines = new Vector<String>();
		try(FileReader f_reader = new FileReader(file_name);
				BufferedReader b_reader = new BufferedReader(f_reader))
			{	
				String line = b_reader.readLine();
				while (line != null) {
					lines.add(line);
					line = b_reader.readLine();
				}
				

				return lines;
			}
			catch(FileNotFoundException e)
			{
				System.out.println(String.format("Cannot open file \"%s\" are you missing something? . . .", file_name));
				System.out.println("Attempts left : " + (attempts_left-1));
				return readFromFileWithAttempts(attempts_left - 1);
			}
		
	}
	public void writeToFile(String file_name, String content, boolean append) {
		try(FileWriter f_writer = new FileWriter(file_name, append);
				BufferedWriter b_writer = new BufferedWriter(f_writer))
			{
				b_writer.write(content + "\n");
			}
			catch(IOException e)
			{
				System.out.println(String.format("Cannot open file \"%s\" are you missing something? . . .", file_name));
			}
	}
}