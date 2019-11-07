package laboration_1;

import java.util.Scanner;

public class Fahrenheit {
	
	private static Scanner sc;

	public static void main(String[] args) {
		//Frågar användaren om ett värde.
		System.out.print("Ange en temperatur i Fahrenheit: ");
		//Läser av värdet från användaren.
		sc = new Scanner(System.in);
		//Sätter värdet till F.
		float F = sc.nextInt();
		//Formeln för Fahrenheit till Celsius.
		float C = (F - 32) * 5/9;
	    //Skriver ut Celsius värdet.
		System.out.println("Temperatur i Celsius: " + C);
	}
	
}
