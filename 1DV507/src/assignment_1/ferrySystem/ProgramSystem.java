package assignment_1.ferrySystem;

import java.util.ArrayList;
import java.util.Iterator;

//"Very Big Corp. of America" is a Fictional Corporation from Monthy Python
//And is used as a company name for this Ferry Program:
public class ProgramSystem implements Ferry {
	
	private final int maxPassengerSpace = 200;
	private final int maxVehicleSpace = 200; // Is divided by 5 in toString Method.
	
	// ArrayLists for records of Vehicles and Passengers
	ArrayList<Vehicle> arrVehicles = new ArrayList<>();
	ArrayList<Passenger> arrPassengers = new ArrayList<>();
	
	// Counts passenger spaces occupied on ferry:
	@Override
	public int countPassengers() {
		int totalPassengers = 0; // Total amount of passengers:
		
		// Adds passengers to totalPassengers:
		for (int i = 0; i < arrPassengers.size(); i++) {
			totalPassengers += arrPassengers.get(i).getPassengers();
		}
		
		// Adds passengers from Vehicles to totalPassengers:
		for (int i = 0; i < arrVehicles.size(); i++) {
			totalPassengers += arrVehicles.get(i).getPassengers();
		}
		
		return totalPassengers;
	}
	
	// Counts vehicle spaces occupied on ferry:
	@Override
	public int countVehicleSpace() {
		int totalVehicles = 0;
		// Adds Vehicles to totalVehicles:
		for (int i = 0; i < arrVehicles.size(); i++) {
			totalVehicles += arrVehicles.get(i).getSpace();
		}
		
		return totalVehicles;
	}

	// Counts accumulated money:
	@Override
	public int countMoney() {
		int totalMoney = 0;
		
		// Counts all vehicles and prices
		// then adds it to totalMoney:
		for (int i = 0; i < arrVehicles.size(); i++) {
			totalMoney += arrVehicles.get(i).getPrice();
		}
		
		// Repeat for passengers:
		for (int i = 0; i < arrPassengers.size(); i++) {
			totalMoney += arrPassengers.get(i).getPrice();
		}
		
		return totalMoney;
	}
	
	@Override
	public Iterator<Vehicle> iterator() {
		return null;
	}

	// Embarks vehicle, unless there isn't enough room on Ferry:
	@Override
	public void embark(Vehicle v) {
		
		// Adds Vehicles to the Ferry:
		if (hasSpaceFor(v)) {
			arrVehicles.add(v);
			countMoney();
			
		} else {
			errorMessage(1);
		}
	}

	// Embarks passenger, unless there isn't enough room on Ferry:
	@Override
	public void embark(Passenger p) {
		
		// Adds Passengers to the Ferry:
		if (hasRoomFor(p)) {
			arrPassengers.add(p);
			countMoney();
		
		} else {
			errorMessage(1);
		}
	}

	// Disembarks all vehicles and passengers:
	@Override
	public void disembark() {
		
		// Empties Ferry (Vehicles and Passengers) when docked:
		// Note: Does not clear money earned!
		arrPassengers.clear();
		arrVehicles.clear();
	}

	// Checks if there is enough space for more vehicles on board:
	@Override
	public boolean hasSpaceFor(Vehicle v) {
		
		// Checks if Vehicles Required Space + current space is less than Vehicles Required Space:
		if (v.getSpace() + countVehicleSpace() < maxVehicleSpace) {
			return true;
			
		} else {
			return false;
		}
	}

	// Checks if there is enough room for more passengers on board:
	@Override
	public boolean hasRoomFor(Passenger p) {
		
		// Checks if there is enough room for all passengers:
		if (this.countPassengers() + countPassengers() < maxPassengerSpace) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public String errorMessage(int e) {
		String error = null;
		
		switch (e) {
		case 1:
			error = "* * * The ferry is full! There will be another scheduled departure at: 15:00! * * *";
			
		case 2:
			error = "ERROR #2";
			
		}
		return error;
	}
	
	// Creates a "Nice looking ferry status print out":
	@Override
	public String toString() {
		String ferryStatus = "-------------------------------------------------"
						+ "\n\t\t FERRY STATUS:"
						+ "\n_________________________________________________\n"
						+ "\n Current amount of passengers on board: " + countPassengers() + "\n"
						+ " Availible space: " + (maxPassengerSpace - countPassengers()) + "\n"
						+ "\n-------------------------------------------------\n"
						+ "\n Current amount of vehicle space occupied: " + (countVehicleSpace() / 5) + "\n"
						+ " Availible space: " + ((maxVehicleSpace - countVehicleSpace()) / 5) + "\n"
						+ "\n-------------------------------------------------\n"
						+ "\n Current profit: " + countMoney() + " Kr\n"
						+ "\n_________________________________________________\n";
		return ferryStatus;
	}
}