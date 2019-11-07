package ev222hh_lab2;

public class Delbarhet {
	public static void main(String[] args) {
		System.out.println("Skriv ut alla tal mellan 100 - 200 som är delbara med 4 eller 5:\n");
		
		// Define numbers.
		int oneHundred = 100;
		int twoHundred = 200;
		int lengthLine = 0;
		
		
		// Print Line if /4 OR /5, else next iteration.
		for (int i = oneHundred; i < twoHundred + 1; i++) {
			int divFour = i % 4;
			int divFive = i % 5;
			
			// Break Line when at 10
			if (lengthLine == 10) {
				System.out.println();
				lengthLine = 0;
			
			// If length of line is not yet 10, continue:	
			} else if (lengthLine != 10) {
				
				// If it is divisible by 5:
				if (divFour <= 0 && !(divFive <= 0)) {
					System.out.print(i + " ");
					lengthLine++;
				
				// If it is divisible by 4:	
				} else if (divFive <= 0 && !(divFour <= 0)) {
					System.out.print(i + " ");
					lengthLine++;
					
				} else {
					continue;
				}
			}
		}
	}
}
