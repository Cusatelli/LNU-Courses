package ev222hh_lab1;

import java.util.Scanner;

public class Ranta {

	private static Scanner sc;
	
	public static void main(String[] args) {
		
		//Frågar efter dina besparingar.
		System.out.print("Ange dina besparingar: ");
		// Läser in värdet.
		sc = new Scanner(System.in);
		//Sparar värdet som S.
		float S = sc.nextInt();
		
		//Frågar efter din årliga ränta.
		System.out.print("Ange din årliga ränta (i heltal): ");
		//Läser in värdet.
		sc = new Scanner(System.in);
		//Sparar värdet som rP (Ränta i Procent).
		float rP = sc.nextInt();
		
		//Antal år
		int år = 5;
		//Ränta från Procent till Decimaler.
		float P = rP/100;
		//Årliga räntan.
		double årP = S * P;
		//dem totala besparningar.
		double totalS = S + årP;
		
		//Skriver ut dina angivna värden för S och P (Procent).
		System.out.println("\n" + "Besparingar år noll: " + S + " SEK");
		System.out.println("Årsränta (i procent): " + P*100 + " %");
		
		//En FOR-LOOP som börjar på År 2 och går till År 5.
		for (int i = 2; i <= år; i++) {
			
			//Formeln för besparningar efter 5 år.
			årP = totalS * P;
			totalS += årP;
					
		}
		
		//Skriver ut värdet på dina totala besparningar EFTER 5 År.
		System.out.println("Värdet på besparingarna efter fem år är: " + Math.ceil(totalS) + " SEK");
	}
}
