package assignment_1.ferrySystem;

public class Car extends Vehicle {	
	private final int pricePassengers = 20; // Price is included in vehicle price.
	private final int priceVehicle = 100; // Vehicle price.
	private final int maxPassengers = 4; // Maximum allowed passengers in Vehicle.
	private final int vehicleSpace = 5; // Vehicle space required for boarding.
	
	// Car Constructor:
	public Car(int passengers) {
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