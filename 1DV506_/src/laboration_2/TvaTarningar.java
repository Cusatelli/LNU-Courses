package laboration_2;

import java.util.*;

public class TvaTarningar {

	public static void main(String[] args) {
		// Random number simulator:
		Random slump = new Random();
		
		// Define variables
		int diceOne = 0;
		int diceTwo = 0;
		int kast = 0;
		// count = 1 because actual lowest = 2.
		int count = 1;
		int c2 = 0, c3 = 0, c4 = 0, c5 = 0, 
			c6 = 0, c7 = 0, c8 = 0, c9 = 0, 
			c10 = 0, c11 = 0, c12 = 0;
		
		// Array to store variables 2 - 12:
		int[] kastList = {c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		
		// Array to contain all Dice-Throw outcomes:
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// Loops for 10 000 Dice-Throws.
		for (int i = 0; i <= 10000; i++) {
			
			// Takes both Dice-Throws (1-6) and adds them together.
			// Dice-Throw results are limited to 2-12.
			diceOne = slump.nextInt(6) + 1;
			diceTwo = slump.nextInt(6) + 1;
			kast = diceOne + diceTwo;
			
			// Stores every Dice-Throw result in list.
			list.add(kast);
			
			// Determines where to store every Dice-Throw in kastList:
			if (kast == 2) {
				c2++;
				kastList[0] = c2;
				
			} else if (kast == 3) {
				c3++;
				kastList[1] = c3;
				
			} else if (kast == 4) {
				c4++;
				kastList[2] = c4;
				
			} else if (kast == 5) {
				c5++;
				kastList[3] = c5;
				
			} else if (kast == 6) {
				c6++;
				kastList[4] = c6;
				
			} else if (kast == 7) {
				c7++;
				kastList[5] = c7;
				
			} else if (kast == 8) {
				c8++;
				kastList[6] = c8;
				
			} else if (kast == 9) {
				c9++;
				kastList[7] = c9;
				
			} else if (kast == 10) {
				c10++;
				kastList[8] = c10;
				
			} else if (kast == 11) {
				c11++;
				kastList[9] = c11;
				
			} else if (kast == 12) {
				c12++;
				kastList[10] = c12;
				
			} else {
				System.err.println("ERROR: Value!");
				break;
			}
		}
		
		// Prints Results:
		System.out.println("Frequency table for rolling two dices 10000 times.\n"
				+ "_______________________\n\n"
				+ " Sum	 	Count\n"
				+ "_______________________");
		
		for (int i = 0; i < kastList.length; i++) {
			count++;
			System.out.println(" " + count + "	 |	" + kastList[i]);
		}
	}
}
