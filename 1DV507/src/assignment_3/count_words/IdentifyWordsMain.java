package assignment_3.count_words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/*
 * Credit: Bozho & Michael
 * 
 * Code: "Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "utf-8")))".
 * Site: StackOverflow.
 * URL: https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
 * 
 * NOTE: Used this code instead of FileWriter (used originally) which uses default encoding. <---------
 */
public class IdentifyWordsMain {

	// Line ArrayList (To preserve file style):
	private static ArrayList<String> lineArray = new ArrayList<String>();
	// Words ArrayList (Separated by whitespace):
	public static ArrayList<String> words = new ArrayList<String>();
	
	public static void main(String[] args) throws FileNotFoundException {
		// Name of file to read/open.
		String fileName = "HistoryOfProgramming.txt";
		String newFile = "words.txt";
		
		// Read one line at a time:
		String line = null;

		// FileReader reads text files in the default encoding.
		FileReader fileReader = new FileReader(fileName);
		// Wrapping fileReader in BufferedReader which
		// prevents reading of data from file repeatedly:
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// Credit: Bozho & Michael:
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "utf-8"))) {
			// Print original file contents:
			System.out.println("Text\n" + 
					"====");
			
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				// Replace all non letter with blanks ("Remove"):
				line = line.replaceAll("[^a-zA-Z ]", "");
				lineArray.add(line); // Add to ArrayList<String>.
				try {
				// Write to new text file ("words.txt"):
				writer.write(line); // Take line after removal of non-letter.
				
				// Add new line after each line in words.txt file.
				writer.write("\n"); 
				
				// I/O Exception Message:
				} catch (IOException ex) {
					System.out.println("Error! There was an issue when writing \'" + newFile + "\'!");
				}
			}
			
			// Print altered file contents from ArrayList<String>,
			// added in previous while-loop:
			System.out.println("\nSequence of words\n" + 
					"=================");
			for(int i = 0; i < lineArray.size(); i++) {
				System.out.println(lineArray.get(i));
			}
			
			// Seperate by whitespace:
			/*
			 * USE: 
			 * myString.split("\\s+");
			 * "Hello[space][tab]World" = "Hello", "World"
			 * TO SPLIT LINE PROPERLY!
			 * URL: https://stackoverflow.com/questions/225337/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
			 */
			for (int i = 0; i < lineArray.size(); i++) {
				String input = "";
				String tmp = lineArray.get(i);
				for (int j = 0; j < tmp.length(); j++) {
					if (!(tmp == null)) {
						if (Character.isWhitespace(tmp.charAt(j))) {
							words.add(input);
							input = "";
							
						} else {
							input += tmp.charAt(j);
							input = input.replaceAll(" ", "");
							words.remove(" ");
						}
					}
				}
			}
			// Closing files.
			bufferedReader.close();
			
		// File Not Found Exception Message:
		} catch (FileNotFoundException ex) {
			System.out.println("The file \'" + fileName + "\' could not be found!");
		// I/O Exception Message:
		} catch (IOException ex) {
			System.out.println("Error! There was an issue when reading \'" + fileName + "\'!");
		}
	}
}