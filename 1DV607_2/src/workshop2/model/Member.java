package workshop2.model;

import java.util.ArrayList;

import workshop2.debug.ErrorHandler;
import workshop2.model.Boat.ENUMERATION_BOAT_TYPES;

public class Member {
	private ErrorHandler error_Handler = new ErrorHandler();
	
	private String name;
	private String socialSecurityNumber;
	private int id;
	private ArrayList<Boat> boatArray = new ArrayList<>();
	
	public Member(int id, String name, String socialSecurityNumber) {
		this.name = name;
		this.socialSecurityNumber = socialSecurityNumber;
		this.id = id;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getSocialSecurityNumber() { return socialSecurityNumber; }
	public void setSocialSecurityNumber(String socialSecurityNumber) { this.socialSecurityNumber = socialSecurityNumber; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	

	public int getNumberOfBoats () {
		return boatArray.size();
	}

	public Boat b_get(int index) {
		if(b_Exists(index)) { return boatArray.get(index); } 
		else { 
			error_Handler.BoatNotFound(); 
			return null; // Will never return null!
		}
	}

	public Boat[] b_get() {
		Boat[] b_all = new Boat[boatArray.size()];
		return boatArray.toArray(b_all);
	}

	public void b_register(ENUMERATION_BOAT_TYPES type, float length) {
		Boat boat = new Boat(type, length);
		boatArray.add(boat);
	}

	public void b_remove(int index) {
		if(b_Exists(index)) { boatArray.remove(index); }
		else { error_Handler.BoatNotFound(); }
	}

	private boolean b_Exists(int index) {
		if (boatArray.size() <= index) { return true; }
		else { return false; }
	}
}
