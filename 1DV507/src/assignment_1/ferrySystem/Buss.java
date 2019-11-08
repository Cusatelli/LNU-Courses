package assignment_1.ferrySystem;

public class Buss extends Vehicle {
	private final int pricePassengers = 15; // Price per passenger on board in Vehicle.
	private final int priceVehicle = 200; // Vehicle price.
	private final int maxPassengers = 20; // Maximum allowed passengers in Vehicle.
	private final int vehicleSpace = 20; // Vehicle space required for boarding.
	
	// Buss Constructor:
	public Buss(int passengers) {
		// Control if amount of passengers doesn't exceed Max allowed Passengers 
		// & that there isn't a negative number of passengers boarding:
		if (passengers > maxPassengers || passengers < 0) {
			System.err.println("* * * Please choose between " + 0 + " and " + maxPassengers + " Passengers! * * *");
		
		// Sets amount of passengers, price and space occupied by vehicle:
		} else {
			setPassengers(passengers);
			setPrice((passengers * pricePassengers) + priceVehicle);
			setSpace(vehicleSpace);
		}
	}
}
