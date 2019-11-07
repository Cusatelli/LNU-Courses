package ev222hh_lab2;

/*
 * Jag hoppas jag har gjort fel här!
 * Vad var den bästa lösningen?
 */

import java.util.Scanner;

public class NastStorsta {
	private static Scanner sc;

	public static void main(String[] args) {

		// Get user-input for each value
		System.out.print("Mata in 10 heltal: ");
		sc = new Scanner(System.in);
		
		// Set values for heltal 1 - 10:
		int h1 = sc.nextInt();
		int h2 = sc.nextInt();
		int h3 = sc.nextInt();
		int h4 = sc.nextInt();
		int h5 = sc.nextInt();
		int h6 = sc.nextInt();
		int h7 = sc.nextInt();
		int h8 = sc.nextInt();
		int h9 = sc.nextInt();
		int h10 = sc.nextInt();
		
		int largest = 0;

		sc.close();
		
		//System.out.println("\nMata in 10 heltal: " + h1 + " " + h2 + " " + h3 + " " + h4 + " " + h5 + " " 
		//+ h6 + " " + h7 + " " + h8 + " " + h9 + " " + h10);

//------------------------------------------------------------------------------//
//								  FIND LARGEST									//
//------------------------------------------------------------------------------//	
//------------------------------------------------------------------------------//
//		   					 		   H1										//
//------------------------------------------------------------------------------//
		
		if (h1 > h2 && h1 > h3 && h1 > h4 && h1 > h5 && h1 > h6 
				&& h1 > h7 && h1 > h8 && h1 > h9 && h1 > h10) {
			largest = h1;

//------------------------------------------------------------------------------//
//	 								   H2										//
//------------------------------------------------------------------------------//
			
		} else if (h2 > h1 && h2 > h3 && h2 > h4 && h2 > h5 && h2 > h6 
				&& h2 > h7 && h2 > h8 && h2 > h9 && h2 > h10) {
			largest = h2;
			
//------------------------------------------------------------------------------//
//									   H3										//
//------------------------------------------------------------------------------//
			
		} else if (h3 > h1 && h3 > h2 && h3 > h4 && h3 > h5 && h3 > h6 
				&& h3 > h7 && h3 > h8 && h3 > h9 && h3 > h10) {
			largest = h3;
			
//------------------------------------------------------------------------------//
//		 	 						   H4										//
//------------------------------------------------------------------------------//
			
		} else if (h4 > h1 && h4 > h2 && h4 > h3 && h4 > h5 && h4 > h6 
				&& h4 > h7 && h4 > h8 && h4 > h9 && h4 > h10) {
			largest = h4;
			
//------------------------------------------------------------------------------//
//									   H5										//
//------------------------------------------------------------------------------//

		} else if (h5 > h1 && h5 > h2 && h5 > h3 && h5 > h4 && h5 > h6 
				&& h5 > h7 && h5 > h8 && h5 > h9 && h5 > h10) {
			largest = h5;

//------------------------------------------------------------------------------//
//									   H6										//
//------------------------------------------------------------------------------//

		} else if (h6 > h1 && h6 > h2 && h6 > h3 && h6 > h4 && h6 > h5 
				&& h6 > h7 && h6 > h8 && h6 > h9 && h6 > h10) {
			largest = h6;

//------------------------------------------------------------------------------//
//			   						   H7										//
//------------------------------------------------------------------------------//

		} else if (h7 > h1 && h7 > h2 && h7 > h3 && h7 > h4 && h7 > h5 
				&& h7 > h6 && h7 > h8 && h7 > h9 && h7 > h10) {
			largest = h7;
			
//------------------------------------------------------------------------------//
//			   						   H8										//
//------------------------------------------------------------------------------//		
			
		} else if (h8 > h1 && h8 > h2 && h8 > h3 && h8 > h4 && h8 > h5 
				&& h8 > h6 && h8 > h7 && h8 > h9 && h8 > h10) {
			largest = h8;
			
//------------------------------------------------------------------------------//
//									   H9										//
//------------------------------------------------------------------------------//			
			
		} else if (h9 > h1 && h9 > h2 && h9 > h3 && h9 > h4 && h9 > h5 
				&& h9 > h6 && h9 > h7 && h9 > h8 && h9 > h10) {
			largest = h9;
			
//------------------------------------------------------------------------------//
//									  H10										//
//------------------------------------------------------------------------------//			
			
		} else if (h10 > h1 && h10 > h2 && h10 > h3 && h10 > h4 
				&& h10 > h5 && h10 > h6 && h10 > h7 && h10 > h9) {
			largest = h10;
			
//------------------------------------------------------------------------------//
//									 ERROR										//
//------------------------------------------------------------------------------//	
			
		} else {
			System.err.println("ERROR: Something went wrong!");
			System.err.println("ERROR: Try entering 10 different \"Heltal\"");
		}
		
//------------------------------------------------------------------------------//
//							  FIND SECOND LARGEST								//
//		  					    BY USING LARGEST								//
//------------------------------------------------------------------------------//		
//------------------------------------------------------------------------------//
//		 					   IF IT IS A POSITVE								//
//------------------------------------------------------------------------------//
		
		if (largest > 0) {
			for (int secondL = (largest - 1); secondL >= 0; secondL--) {
				
				if (secondL == h1) {
					System.out.println("Det näst största talet är: " + h1);
					break;
					
				} else if (secondL == h2) {
					System.out.println("Det näst största talet är: " + h2);
					break;
					
				} else if (secondL == h3) {
					System.out.println("Det näst största talet är: " + h3);
					break;
					
				} else if (secondL == h4) {
					System.out.println("Det näst största talet är: " + h4);
					break;
					
				} else if (secondL == h5) {
					System.out.println("Det näst största talet är: " + h5);
					break;
					
				} else if (secondL == h6) {
					System.out.println("Det näst största talet är: " + h6);
					break;
					
				} else if (secondL == h7) {
					System.out.println("Det näst största talet är: " + h7);
					break;
					
				} else if (secondL == h8) {
					System.out.println("Det näst största talet är: " + h8);
					break;
					
				} else if (secondL == h9) {
					System.out.println("Det näst största talet är: " + h9);
					break;
					
				} else if (secondL == h10) {
					System.out.println("Det näst största talet är: " + h10);
					break;
					
				} else {
					continue;
				}
			}
			
//------------------------------------------------------------------------------//
//		 					   IF IT IS A NEGATIVE								//
//------------------------------------------------------------------------------//	
			
		} else if (largest < 0) {
			for (int secondL = (largest + 1); secondL <= 0; secondL++) {
				
				if (secondL >= h1) {
					System.out.println("Det näst största talet är: " + h1);
					break;
					
				} else if (secondL >= h2) {
					System.out.println("Det näst största talet är: " + h2);
					break;
					
				} else if (secondL >= h3) {
					System.out.println("Det näst största talet är: " + h3);
					break;
					
				} else if (secondL >= h4) {
					System.out.println("Det näst största talet är: " + h4);
					break;
					
				} else if (secondL >= h5) {
					System.out.println("Det näst största talet är: " + h5);
					break;
					
				} else if (secondL >= h6) {
					System.out.println("Det näst största talet är: " + h6);
					break;
					
				} else if (secondL >= h7) {
					System.out.println("Det näst största talet är: " + h7);
					break;
					
				} else if (secondL >= h8) {
					System.out.println("Det näst största talet är: " + h8);
					break;
					
				} else if (secondL >= h9) {
					System.out.println("Det näst största talet är: " + h9);
					break;
					
				} else if (secondL >= h10) {
					System.out.println("Det näst största talet är: " + h10);
					break;
					
				} else {
					System.out.println("?");
					continue;
				}
			}
			
//------------------------------------------------------------------------------//
//									 ERROR										//
//------------------------------------------------------------------------------//	
			
		} else  {
			System.err.println("ERROR: Something went wrong!");
			System.err.println("ERROR: This code does not work if the largest value is 0.");
			System.err.println("ERROR: Please make sure the highest value entered is above or below 0.");
		}
	}
}