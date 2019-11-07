package ev222hh_lab1;

import java.util.Scanner;

public class VaxelPengar {
	private static Scanner sc;

	public static void main(String[] args) {
		// Get inputs
		sc = new Scanner(System.in);
		System.out.print("Ange kostnaden: ");
		double pris = sc.nextDouble();
		
		System.out.print("Ange erhållet belopp: ");
		double betald = sc.nextDouble();
		
		sc.close();
		
		// Set variables
		int tillbaka = (int) (betald - pris);
		int tusen, femhundra, tvahundra, hundra, femtio, tjugo, tio, fem, tva, ett;

		System.out.println("tillbaka: " + tillbaka);
		
		// Define values
		tusen = (int) (tillbaka / 1000.0);
		tillbaka -= tusen * 1000.0;

		femhundra = (int) (tillbaka / 500.0);
		tillbaka -= femhundra * 500.0;

		tvahundra = (int) (tillbaka / 200.0);
		tillbaka -= tvahundra * 200.0;

		hundra = (int) (tillbaka / 100);
		tillbaka -= hundra * 100;

		femtio = (int) (tillbaka / 50);
		tillbaka -= femtio * 50;

		tjugo = (int) (tillbaka / 20);
		tillbaka -= tjugo * 20;

		tio = (int) (tillbaka) / 10;
		tillbaka -= tio * 10;

		fem = (int) (tillbaka) / 5;
		tillbaka -= fem * 5;

		tva = (int) (tillbaka) / 2;
		tillbaka -= tva * 2;

		ett = (int) (tillbaka);
		tillbaka -= ett;
		
		// Print final results
		System.out.println("1000: " + tusen);
		System.out.println("500: " + femhundra);
		System.out.println("200: " + tvahundra);
		System.out.println("100: " + hundra);
		System.out.println("50: " + femtio);
		System.out.println("20: " + tjugo);
		System.out.println("10: " + tio);
		System.out.println("5: " + fem);
		System.out.println("2: " + tva);
		System.out.println("1: " + ett);
	}
}
