package ev222hh_lab1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Wind Chill Index Formula:
 * Twc = 13.12 + 0.6215*T - 11.37*V^{0.16} + 0.3965*T*V^{0.16}
 *
 * USE "," when adding value.
 * 
 */

public class VindAvkylning {
	public static void main(String[] args) {
		
		// Get Inputs
		System.out.print("Ange temperatur (C): ");
		Scanner sc = new Scanner(System.in);
		double T = sc.nextDouble();
		
		System.out.print("Ange vindhastigheten (m/s): ");
		double Vh = sc.nextDouble();
		
		sc.close();
		
		// Set Variables
		double V = (Vh) * 3.6;
		
		// Define Values
		double Vp = Math.pow(V, 0.16);
		double WindChillIndex = (13.12 + 0.6215*(T) - 11.37*Vp + 0.3965*(T)*Vp);
		
		// Limit decimals
		DecimalFormat decimals = new DecimalFormat("#.#");
		
		// Print Final Results
		System.out.println("Upplevd temperatur (C): " + decimals.format(WindChillIndex));
	}

}
