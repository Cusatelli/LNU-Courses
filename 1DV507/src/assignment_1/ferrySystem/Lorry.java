package assignment_1.ferrySystem;

public class Lorry extends Vehicle {	
	private final int pricePassengers = 20; // Price is included in vehicle price.
	private final int priceVehicle = 300; // Vehicle price.
	private final int maxPassengers = 2; // Maximum allowed passengers in Vehicle.
	private final int vehicleSpace = 40; // Vehicle space required for boarding.
	
	// Lorry Constructor:
	public Lorry(int passengers) {
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
