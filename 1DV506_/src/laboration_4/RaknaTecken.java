package laboration_4;

import java.io.*;

/*
 * I could only find 714 white spaces in example 
 * Text: HistoryOfProgramming compared to your 728.
 * 
 * Though when I ran the word count in Google Docs it returned with 700 white spaces, 
 * and in the online word count app https://charcounter.com/en/ it agrees with my program and 
 * ((4667 Characters) - (3953 Without White Space)) = 714 white spaces.
 * 
 * Besides, it shows the correct amount of white spaces in other texts I have tried.
 */

public class RaknaTecken {
/*--------------------------------------------------------
	 					Field	
--------------------------------------------------------*/
	private static int large = 0;
	private static int small = 0;
	private static int white = 0;
	private static int other = 0;
/*--------------------------------------------------------
						 Main	
--------------------------------------------------------*/
	public static void main(String[] args) throws IOException {
		File file = new File("Resources/HistoryOfProgramming.txt");
		
		readFile(file);
		System.out.println(printAll());
	}
/*--------------------------------------------------------
				Read File & Check Numbers:	
--------------------------------------------------------*/
	public static void readFile(File file) throws IOException {
		FileInputStream fileInput = new FileInputStream(file);
		int reader;
		//----------------------------------- v (- 1 to avoid IOException)
		while ((reader = fileInput.read()) != - 1) {
			
			char c = (char) reader;
			whitespace(c);
			uppercase(c);
			lowercase(c);
			otherChar(c);
		}
		fileInput.close();
	}
/*--------------------------------------------------------
						Uppercase	
--------------------------------------------------------*/	
	public static void uppercase(char c) {
		if (Character.isUpperCase(c)) {
			large += 1;
		}
	}
/*--------------------------------------------------------
						Lowercase	
--------------------------------------------------------*/	
	public static void lowercase(char c) {
		if (Character.isLowerCase(c)) {
			small += 1;
		}
	}
/*--------------------------------------------------------
						White Space	
--------------------------------------------------------*/	
	public static void whitespace(char c) {
		if (Character.isWhitespace(c)) {
			white += 1;
		} else {
			
		}
	}
/*--------------------------------------------------------
					Other Characters	
--------------------------------------------------------*/	
	public static void otherChar(char c) {
		if ((Character.isLetter(c) != true) && (Character.isWhitespace(c) != true)) {
			other++;
		}
	}
/*--------------------------------------------------------
						Print All	
--------------------------------------------------------*/	
	public static String printAll() {
		return "Antal stora bokstäver: " + large 
				+ "\nAntal små bokstäver: " + small 
				+ "\nAntal \"whitespaces\": " + white
				+ "\nAntal övriga: " + other;
	}
}