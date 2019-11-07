package laboration_1;

import java.util.Scanner;

public class Tid {
	private static Scanner sc;

	public static void main(String[] args) {
		
		//Frågar efter antal sekunder. 
		System.out.print("Ange antal sekunder: ");
		//Läser av värdet.
		sc = new Scanner(System.in);
		//Sparar värdet (sekunder).
		int sekunder = sc.nextInt();
		
		//Formel för att beräkna HHMMSS:
		int totSek = sekunder;
		int tim = totSek / 3600;
		int min = (totSek % 3600) / 60;
		int sek = totSek % 60;
		
		//Bestämer värdet för (tid) då %02d är koden för "datum" eller tid.
		String tid = String.format("Detta motsvarar: %02d Timmar, %02d Minuter och %02d Sekunder ", tim, min, sek);
		
		//Skriver ut tråden (tid).
		System.out.println(tid);
				
	}
}
