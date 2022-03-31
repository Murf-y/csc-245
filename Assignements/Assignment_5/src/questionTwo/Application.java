/* Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 27, 2022
 * LastModified: Mar 27, 2022
 * FileName: Application.java
 *****************************************************
 */
package questionTwo;

import java.util.Vector;

import utils.FileManager;
import utils.InputManager;

public class Application {
	
	private InputManager input_manager;
	
 	public Application() {
		input_manager = new InputManager();
	}
 	
 	public String joinIntoOne(Vector<String> lines) {
 		String res = "";
 		for(String line: lines) {
 			res += line;
 		}
 		return res;
 	}
 	public boolean isValidHtml(Vector<String> lines) {
 		Stack<String> tages = new Stack<String>();
 		String html = joinIntoOne(lines);
 		String openings = "<h1> <html> <b> <i>";
 		String tags = "<h1> </h1> <html> </html> <b> </b> <i> </i>";
 		
 		for(int i = 0; i < html.length(); i++) {
			String c = String.valueOf(html.charAt(i));
			if(c.isBlank()) continue;
			
			// Extract tag and evaluate it
			if(c.equals("<")) {
				int count = 0;
				String tag = "";
				do {
					String chr = String.valueOf(html.charAt(i));
					tag += chr;
					i++;
					if (chr.equals("<"))
						count++;
					else if (chr.equals(">"))
						count--;
				} while (count != 0 && i < html.length());
				i--;
				
				if(!tags.contains(tag)) return false;
				
				if(openings.contains(tag)) {
					tages.push(tag);
				}else {
					
					// No tages but we have a closing tag!
					if(tages.isEmpty()) return false;
					
					// Compare the popped to the current tag
					String popped_tag = tages.pop();
					String tag_name = tag.substring(2, tag.length() - 1);
					String popped_tag_name = popped_tag.substring(1, popped_tag.length() - 1);
					if(!tag_name.equals(popped_tag_name)) {
						return false;
					}
				}
			}	
		}
 		return tages.isEmpty();
 	}
	public void run() {
		String file_name = input_manager.getString("Enter html file name (default: html.txt): ");
		Vector<String> lines = FileManager.readFromFile(file_name);
		System.out.println("Html file \"" + file_name + "\" is "+ (isValidHtml(lines) ? "":"NOT" ) +" a valid html file");
		
		close();
	}
	public void close() {
		System.out.println("Exiting the porgram, Beep Boop . . .");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Application().run();
	}

}
