package assignment_1.ferrySystem;

public class Vehicle {
	protected int price = 0; 								// Price
	protected int space = 0; 								// Available space for vehicles
	protected int passengers = 0; 							// Number of Passengers
	
	// Help Methods
	protected void setPrice(int p) { price = p; } 			// Sets price
	protected void setPassengers(int p) { passengers = p; } // Sets amount of passengers
	protected void setSpace(int s) { space = s; } 			// sets space required
	
	protected int getPrice() { return price; } 				// gets price
	protected int getPassengers() { return passengers; } 	// gets passengers
	protected int getSpace() { return space; } 				// gets space required
}