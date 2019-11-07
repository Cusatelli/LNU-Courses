package ev222hh_lab1;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Avstand {
	private static Scanner sc;

	public static void main(String[] args) {
		System.out.println("fyll i värdena för (x1, y1) samt (x2, y2).");
		
		//Frågar efter (x1, #)
		System.out.print("x1: ");
		sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		
		//Frågar efter (#, y1)
		System.out.print("y1: ");
		sc = new Scanner(System.in);
		int y1 = sc.nextInt();
		
		//Berättar för användaren vad första punkten ser ut som i (x, y) format.
		System.out.println("Punkt (1): (" + x1 + ", " + y1 + ").");
		
		//Frågar efter (x2, #)
		System.out.print("x2: ");
		sc = new Scanner(System.in);
		int x2 = sc.nextInt();
		
		//Frågar efter (#, y2)
		System.out.print("y2: ");
		sc = new Scanner(System.in);
		int y2 = sc.nextInt();
		
		//Berättar för användaren vad andra punkten ser ut som i (x, y) format.
		System.out.println("Punkt (2): (" + x2 + ", " + y2 + ").");
		
		//Beräknar avståndet enligt formeln:
		//Sqrt((x1-x2)^2 + (y1-y2)^2)
		double avstand = Math.sqrt(
				Math.pow((x1-x2), 2) + 
				Math.pow((y1-y2), 2));
		
		//Sätter nogrannheten till 3 decimaler
		DecimalFormat noggranhet = new DecimalFormat("#.000");
		
		//Skriver ut värdet på avståndet till anv.
		System.out.println("avståndet mellan punkterna är: " + noggranhet.format(avstand));
	}
}
