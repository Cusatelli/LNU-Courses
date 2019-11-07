package laboration_1;

import java.util.Scanner;

public class Citat {
	
	private static Scanner sc;

	public static void main(String[] args) {
		//Ber användaren skriva in en rad text i konsollen.
		System.out.print("Skriv in en rad text: ");
		//Läser av raden med text från konsollen.
		sc = new Scanner(System.in);
		//Sätter texten som den läste av i föregående linje kod till värdet c.
		String c = sc.nextLine();
		// Skriver ut värdet c (som sparats till text raden användaren skrev tidigare) med citattecken runt om.
	    System.out.println("Citat: " + "”" + c + "”");
	}
}
