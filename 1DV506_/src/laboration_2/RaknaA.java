package laboration_2;

import java.util.Scanner;

public class RaknaA {
	private static Scanner sc;

	public static void main(String[] args) {
		
		// Read input:
		sc = new Scanner(System.in);
		System.out.print("Mata in en textrad: ");
		
		// NextLine otherwise it doesn't read whole string.
		String textrad = sc.nextLine();
		
		// Define variables.
		int upperCount = 0;
		int lowerCount = 0;
		int length = textrad.length();
		
		char upper = 'A';
		char lower = 'a';
		
		// Repeat until length is 0.
		for (int i = 0; i < length; i++) {
			char letter = textrad.charAt(i);
			
			// Find upper case A.
			if (letter == upper) {
				upperCount++;
				
			// Find lower case A.	
			} else if (letter == lower) {
				lowerCount++;
				
			} else {
				continue;
			}
		}
		// Print results:
		System.out.println("Antal a: " + lowerCount + "\nAntal A: " + upperCount);
	}
}
