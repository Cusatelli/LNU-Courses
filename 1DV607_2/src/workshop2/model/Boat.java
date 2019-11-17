package workshop2.model;

public class Boat {
	public enum ENUMERATION_BOAT_TYPES {
		Sailboat,
		Motorsailer,
		Kayak,
		Canoe,
		Other
	}

	private ENUMERATION_BOAT_TYPES type;
	private double length;

	public Boat(ENUMERATION_BOAT_TYPES type, double length) {
		this.type = type;
		this.length = length;
	}

	public ENUMERATION_BOAT_TYPES getType() { return type; }
	public void setType(ENUMERATION_BOAT_TYPES type) { this.type = type; }
	
	public double getLength() { return length; }
	public void setLength(double length) { this.length = length; }
	
}
