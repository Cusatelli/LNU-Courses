package ev222hh_lab1;

import java.util.Scanner;

public class KortNamn {
	private static Scanner sc;

	public static void main(String[] args)  {
		System.out.print("Förnamn: ");
		sc = new Scanner(System.in);
		String F = sc.next();
		
		System.out.print("Efternamn: ");
		sc = new Scanner(System.in);
		String E = sc.next();
		
		//First letter in name
		int maxF = 1;
		//First three letters in surname
		int maxE = 4;
		
		//substring() for getting a substring of a String
		//length() for finding the length of a string
		//Math.min() returns the smallest of two INT values.
		System.out.printf("Kort Namn: " + F.substring(0, Math.min(F.length(), maxF)) + ". " + E.substring(0, Math.min(E.length(), maxE)));
	}
}

