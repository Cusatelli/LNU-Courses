package ev222hh_lab2;

import java.util.Random;
import java.util.Scanner;

public class HighLow {
	private static Scanner sc;

	public static void main(String[] args) {
		
		// Collected from previous exercise: Slumpsumma.java in package ev222hh_lab1.
		Random slump = new Random();
		int s = slump.nextInt(100) +1;
		
		//INTRODUCTION:
		System.out.println("--------------------------------------------------\n\n"
				+ "      You must guess a value between 1-100\n"
				+ "  If you guess correctly you win, else you lose.\n\n"
				+ "	      LET THE GAME BEGIN!\n\n"
				+ "--------------------------------------------------\n");
		
		// So long as "antalGissningar" is lower than 10.
		for(int antalG = 1; antalG <= 10;) {
			sc = new Scanner(System.in);
			System.out.print("Gissning " + antalG + ": ");
			int gissning = sc.nextInt();
			
			// If "antalGissningar" exceeds 10 the "game" is ended.
			if (antalG == 10) {
				System.out.print("\nTyvärr så svarade du fel 10 gånger i rad." + "\nRätt svar = " + s);
				System.out.print("\nBättre lycka nästa gång!");
				//Break to terminate loop.
				break;
			}
			
			// If Lower, Higher or Correct answer.
			if (gissning == s) {
				
				if (antalG == 1) {
					System.err.println("--------------------------------------------------\n\n"
							+ "		     GRATTIS!\n\n"
							+ "        Rätt svar efter bara \"" + antalG + "\" gissning\n\n"
							+ "		   FANTASTISKT!\n\n"
							+ "--------------------------------------------------");
					break;
					
				} else if (antalG <= 5) {
					System.err.println("--------------------------------------------------\n\n"
							+ "		     GRATTIS!\n\n"
							+ "      Rätt svar efter bara \"" + antalG + "\" gissningar\n\n"
							+ "		    STRÅLANDE!\n\n"
							+ "--------------------------------------------------");
					break;
					
				} else {
					System.err.println("--------------------------------------------------\n\n"
							+ "		     GRATTIS!\n\n"
							+ "         Rätt svar efter \"" + antalG + "\" gissningar\n\n"
							+ "    Kan du klara det på under 5 gissningar?!\n\n"
							+ "--------------------------------------------------");
					break;
				}
				
				
			} else if (gissning < s) {
				System.out.println("Ledtråd: högre");
				antalG++;
				
			} else if (gissning > s) {
				System.out.println("Ledtråd: lägre");
				antalG++;
				
			} else {
				break;
			}
		}
	}
}

