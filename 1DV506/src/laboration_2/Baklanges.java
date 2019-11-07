package laboration_2;

import java.util.Scanner;

public class Baklanges {
	public static void main(String[] args) {
		
		// Enter "Textrad".
		System.out.print("Mata in en textrad: ");
		Scanner sc = new Scanner(System.in);
		String textrad = sc.nextLine();
		String baklanges = "";
		
		sc.close();
		
		// Build new string backwards with for-loop:
		for (int i = textrad.length() - 1; i >= 0; i--) {
			baklanges = baklanges + textrad.charAt(i);
		}
		
		// Print Results.
		System.out.println("Baklänges: " + baklanges);
	}
}
