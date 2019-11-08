package assignment_1.ferrySystem;

public class Bicycle extends Vehicle {
	private final int pricePassengers = 0; // Price is included in vehicle price.
	private final int priceVehicle = 40; // Vehicle price.
	private final int maxPassengers = 1; // Maximum allowed passengers in Vehicle.
	private final int vehicleSpace = 1; // Vehicle space required for boarding. (1/5)

	// Bicycle Constructor:
	public Bicycle(int passengers) {
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