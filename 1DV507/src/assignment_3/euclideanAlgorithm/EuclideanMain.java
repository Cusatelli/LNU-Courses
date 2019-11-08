package assignment_3.euclideanAlgorithm;

import java.util.Scanner;

public class EuclideanMain {
	private static Scanner scan;
	public static int m;
	public static int n;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in); // Scan for user input.
		// Loop twice while all input is valid:
		for (int i = 1; i <= 2; i++) {
			System.out.print("Please enter number " + i + ": ");
			String input = scan.nextLine();
			// If valid input, proceed:
			if (isValid(input)) { 				
				if (i == 1 && isValid(input)) { m = Integer.parseInt(input); } // Set m to input. 
				if (i == 2 && isValid(input)) { n = Integer.parseInt(input); } // Set n to input. 			
				}
			// else if it's not a valid input repeat until valid.
			else { 
				while (!isValid(input)) {
				System.out.println("Please enter a valid digit!");
				input = scan.nextLine();
				if (i == 1 && isValid(input)) { m = Integer.parseInt(input); } // Set m to input. 
				if (i == 2 && isValid(input)) { n = Integer.parseInt(input); } // Set n to input. 		
				}
			} 
		}
		// Calculate the greatest common divisor:
		System.out.println("\nGCD(" + m + ", " + n + ") = " + greatestCommonDivisor(m, n) + "");
	}
	
	// Calculate the greatestCommonDivisor of two integers:
	public static int greatestCommonDivisor(int m, int n) {
		// If m is 0 then the GCD is = n:
		if(m == 0) { return n; }		
		// Catch if n is 0:
		if(n == 0) { return m; }		
		// Return the GCD of M, N:
		return greatestCommonDivisor(n, m % n);
	}
	
	// Check if valid input:
	@SuppressWarnings("unused")
	public static boolean isValid(String input) {
		// Repeat for input lenght:
		for (int i = 0; i < input.length(); i++) {
			// Check if character is a digit:
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
}