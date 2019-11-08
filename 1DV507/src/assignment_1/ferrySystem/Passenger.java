package assignment_1.ferrySystem;

public class Passenger {
	public int passengers = 0;
	public int price = 0;
	
	// How many passengers are allowed on board:
	public Passenger(int p) {
		setPassengers(p);
		setPrice(p);
	}
	
	// Setters & Getters:
	public void setPassengers(int p) { passengers = p; }
	public void setPrice(int p) { price = 20 * p; }
	
	public int getPassengers() { return passengers; }
	public int getPrice() { return price; }
}