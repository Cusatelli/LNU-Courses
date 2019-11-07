package laboration_2;

import java.util.Scanner;

public class Palindrom {
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		System.out.print("Mata in en textrad: ");
		String textrad = sc.nextLine();
		
		// ".replaceAll("[^a-zA-Z]+", "")".
		// Removes all non-alphabetical characters in textrad:
		// Credit: Sean Patrick Floyd.
		// https://stackoverflow.com/questions/4283351/how-to-replace-special-characters-in-a-string
		String alpha = textrad.replaceAll("[^a-zA-Z-äÄ-öÖ-åÅ]+", "").toLowerCase();
		
		// Define variables:
		int length = alpha.length();
		int first = 0;
		int last = length - 1;
		boolean palindrom = false;
		
		// Go through textrad from front to end && end to front, until they meet.
		while (last > first) {
			
			// Check first and last characters (repeat):
			char firstChar = alpha.charAt(first++);
			char lastChar = alpha.charAt(last--);
			
			// Check letters only.
			Character.isLetter(firstChar);
			Character.isLetter(lastChar);
			
			// If first and last character are not the same, end loop.
			// It is not a palindrome.
			if (firstChar != lastChar) {
				palindrom = false;
				break;
			
			// If first and last characters are same all the way through.
			// It is a palindrome.
			} else {
				palindrom = true;
			}
		}
		if (palindrom == true) {
			System.out.println("\"" + textrad + "\"" + " är ett palindrom.");
		} else {
			System.out.println("\"" + textrad + "\"" + " är inte ett palindrom.");
		}
	}
}
