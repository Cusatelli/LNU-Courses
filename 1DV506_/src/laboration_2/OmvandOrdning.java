package laboration_2;

import java.util.*;

public class OmvandOrdning {
	private static Scanner sc;

	public static void main(String[] args) {
		
		System.out.println("Mata in positiva heltal. Avsluta med ett negativt.");
		sc = new Scanner(System.in);
		
		// Define variables:
		int inTal = 0;
		int count = 0;
		
		// Use ArrayList because:
		// "Man skall inte behöva ange hur många tal man ämnar mata in."
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (inTal >= 0) {
			System.out.print("Tal " + (count + 1) + ": ");
		    inTal = sc.nextInt();
		    list.add(inTal);
		    count++;
		}
		
		// Remove negative from list:
		list.remove(list.size() - 1);
		
		// Print List Size (Positives):
		System.out.println("\nAntal positiva: " + list.size());
		
		// Create new list and add items backwards:
		ArrayList<Integer> baklanges = new ArrayList<Integer>();
		for (int i = list.size() - 1; i >= 0; i--) {
			baklanges.add(list.get(i));
		}
		
		sc.close();
		
		//Print Results:
		System.out.println("Baklänges: " + baklanges);
	}
}