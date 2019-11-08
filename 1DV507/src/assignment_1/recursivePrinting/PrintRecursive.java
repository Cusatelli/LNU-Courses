package assignment_1.recursivePrinting;

public class PrintRecursive {
	public static void main(String[] args) {
		/* Exercise 3 */
		PrintRecursive pr = new PrintRecursive();
		String str = "Alpha Omega Ump Foxtrot";
		System.out.println(str.length());
		pr.print(str, 0);
		System.out.println(); // Line break
		pr.printReverse(str, 0);
		
		/* Exercise 4 */
		
	}
	/* ------------------------------------ *
	 * 				Exercise 3 				*
	 * ------------------------------------ */
	private void print(String str, int pos) {
		System.out.print(str.charAt(pos));			// print from first to last.
		pos = pos + 1;								// Next character position in string
		if(!(pos >= str.length())) {				// Only if pos isn't equal or greater than str length.
			print(str, pos);						// Repeat.
		}
	}
	private void printReverse(String str, int pos) {
		int length = str.length() - 1;
		System.out.print(str.charAt(length - pos));	// print from last to first.
		pos = pos + 1;								// Next character position in string
		if(!(pos >= length + 1)) {					// Only if pos isn't equal or greater than str length.
			printReverse(str, pos);					// Repeat.
		}			
	}
	/* ------------------------------------ *
	 * 				Exercise 4 				*
	 * ------------------------------------ */
	
	
}