package workshop2.view;

import java.util.Scanner;

public class ConsoleHandler {
	Scanner scan = new Scanner(System.in);
	
	public String getUserInput(String pattern) {
		String input = scan.nextLine();
		if(input.matches(pattern)) { return input; }
		else { 
			getUserInput(pattern);
			return null; // Will never return null.
		}
	}
	
}
