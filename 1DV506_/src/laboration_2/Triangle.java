package laboration_2;

import java.util.Scanner;

public class Triangle {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Mata in ett udda heltal: ");
		int N = sc.nextInt();
		
		// If value is not an odd number print error message.
		if (N % 2 == 0) {
			System.err.println("FEL: Var vänlig och mata in ett UDDA heltal.");
			
		} else {
			
//------------------------------------------------------------------------------//
//							   RÄTVINKLIG TRIANGEL								//
//------------------------------------------------------------------------------//
			
			System.out.println("\nRätvinklig triangel:");
			// For every N print * rows (vertical).
			for (int v = 1; v <= N; v++) {
				
				// For every N print * columns (horizontal).
				for (int h = 1; h <= N; h++) {
					
					// Remove left * on rows where j < i. ->
					if (h < v) {
						
						// Replace with Empty Space.
						System.out.print(" ");
						
					} else {
						// Print * on right side of rows <-
						System.out.print("*");
					}
				}
				// After every for-loop proceed to next row (Line).
				System.out.println();
			}
				
//------------------------------------------------------------------------------//
//							    LIKBENT TRIANGEL								//
//------------------------------------------------------------------------------//
				
				System.out.println("\nLikbent triangel:");
				// For every N print * rows (vertical).
				// To eliminate Empty Space above triangle (v = (N/2)+1). 
				for (int v = (N/2)+1; v <= N; v++) {
					
					// For every space required to push * to right <-
					for (int h = v; h < N; h++) {
						// Add Empty Space.
						System.out.print(" ");
					}
					// For every * - 1 on every row.
					for (int a = N; a < (v*2); a++) {
						// Print * on left side of rows ->
						System.out.print("*");
					}
					// After every for-loop proceed to next row (Line).
					System.out.println();
				}
		}
	}
}