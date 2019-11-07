package ev222hh_lab1;

import java.util.Scanner;

public class SummaAvTre {
	private static Scanner sc;

	public static void main(String[] args) {
		
		//Frågar efter värde från användaren.
		System.out.print("Ange ett tresiffrigt heltal: ");
		//Läser av värdet.
		sc = new Scanner(System.in);
		//Sätter värdet till (heltal).
		int heltal = sc.nextInt();
		
		//Hittar 100 talet av värdet (EX: "4".83 i 483).
		int hundra = heltal / 100;
		//Hittar 10 talet av värdet (EX: 4"8".3 i 483).
		int tio = (heltal / 10) % 10;
		//Hittar 1 talet av värdet (EX: 48"3".0 i 483)
		int ett = heltal % 10;
		//Hittar den totala summan av alla tre värden.
		int hTE = hundra + tio + ett;
		
		//Skriver ut summan av de värden.
		System.out.println("Summan av siffrorna i heltalet är: " + hTE);
	}
}
