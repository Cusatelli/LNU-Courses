package laboration_2;

/*
 * Fungerar ej om Noll placeras först i heltalet. 
 * (Ex: 0067895 get fel resultat för Nollor).
 * 
 * Däremot misstänker jag att det är okej eftersom de inte ingår i heltalet.
 */

import java.util.Scanner;

public class RaknaSiffror {
	private static Scanner sc;

	public static void main(String[] args) {
		
		// Read input:
		sc = new Scanner(System.in);
		System.out.print("Mata in ett heltal: ");
		int N = sc.nextInt();
		int noll = 0, jamn = 0, udda = 0;
		
		// Repeat until it has gone through whole number.
		while (N > 0) {
			
			// If number is 0:
			if ((N % 10) == 0) {
				noll++;
				
			// If number is even:	
			} else if (N % 2 == 0) {
				jamn++;
			
			// If number is odd:
			} else {
				udda++;
			}
			
			// Next number.
			N /= 10;
		}
		
		// Print results:
		System.out.println("Nollor: " + noll + "\nUdda: " + udda + "\nJämna: " + jamn);
	}
}