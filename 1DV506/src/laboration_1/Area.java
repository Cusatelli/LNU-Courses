package laboration_1;

import java.util.Scanner;

public class Area {
	private static Scanner sc;

	public static void main(String[] args) {
		System.out.print("Ange en cirkelradie: ");
		sc = new Scanner(System.in);
		
		//nextDouble istället för nextInt för att läsa av decimaler.
		//(float) för att kunna läsa av float i nextDouble.
		float R = (float) sc.nextDouble();
		
		//Formel: A = πr^2
		double A = Math.PI*Math.pow(R, 2);
		
		//"%.1f" begränsar antalet decimaler till 1 ("%.2f" hade visat 2 decimaler).
		System.out.printf("Cirkelns area är " + "%.1f", A);
	}

}
