package assignment_1.ferrySystem;

import java.util.Scanner;

public class FerryMain {
	public static void main(String[] args) {
		// Get input from user:
		Scanner scan = new Scanner(System.in);
		ProgramSystem proSys = new ProgramSystem();

		int input = 0;
		int newInput = 0;

		boolean next = true;
		while(next == true) {
			System.out.println("-----------------------------------\nPlease select one of the following: \n-----------------------------------\n"
					+ "[ 1 ] Vehicles\n"
					+ "[ 2 ] Passengers\n"
					+ "[ 3 ] Disembark & Save Profit\n"
					+ "[ 4 ] Ferry Status\n"
					+ "[ 5 ] Exit Application");
			System.out.print("Your selection: ");
			input = scan.nextInt();

			// Choose a vehicle:
			switch (input) {
			case 1:
				System.out.println("\n-----------------------------------\nChoose Vehicle:\n-----------------------------------\n"
						+ "[ 1 ] Bicycle\n"
						+ "[ 2 ] Car\n"
						+ "[ 3 ] Buss\n"
						+ "[ 4 ] Lorry\n"
						+ "[ 5 ] Previous Page!");
				System.out.print("Your selection: ");
				input = scan.nextInt();

				switch (input) {

				// Bicycle:
				case 1:
					Bicycle bicycle = new Bicycle(input);

					proSys.embark(bicycle); // proSys = Ferry corporation
					break;

				// Car:
				case 2:					
					System.out.println("\nHow many passengers in vehicle (Car)?\n"
							+ "Please enter a value between " + 0 + " & " + 4 + ".");
					System.out.print("Your selection: ");
					newInput = scan.nextInt();

					Car car = new Car(newInput);
					proSys.embark(car);
					break;

				// Buss:
				case 3:
					System.out.println("\nHow many passengers in buss?\n"
							+ "Please enter a value between " + 0 + " & " + 20 + ".");
					System.out.print("Your selection: ");
					newInput = scan.nextInt();

					Buss buss = new Buss(newInput);
					proSys.embark(buss);
					break;

				// Lorry:
				case 4:
					System.out.println("\nHow many passengers in lorry?\n"
							+ "Please enter a value between " + 0 + " & " + 2 + ".");
					System.out.print("Your selection: ");
					newInput = scan.nextInt();

					Lorry lorry = new Lorry(newInput);
					proSys.embark(lorry);
					break;

				// No Vehicle:
				case 5:
					System.out.println("\n     * * * * RETURNED! * * * *");
					break;

				// Invalid selection, send error message:
				default:
					System.err.println("\nInvalid selection!\n");
					break;
				}

				break;

			// After Vehicles, select Passengers:
			case 2:
				System.out.println("-----------------------------------\nHow many passengers would you like to board?");
				System.out.print("Your selection: ");
				newInput = scan.nextInt();

				Passenger passenger = new Passenger(newInput);
				proSys.embark(passenger);
				break;

			// Disembark & Print Ferry Status:
			case 3:
				proSys.disembark();
				//break;

			// Print Ferry Status:	
			case 4:
				System.out.println(proSys.toString());
				break;

			// Abort:
			case 5:
				next = false;
				System.err.println("\n* * * Application Terminated * * *\n");
			}
		}
		scan.close();
	}
}