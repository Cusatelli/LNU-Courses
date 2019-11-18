package workshop2.model;

import java.io.Serializable;

public class Boat implements Serializable {
	// Generated serialVersionUID:
	private static final long serialVersionUID = 725737191972536903L;

	public enum TYPE {
		Sailboat,
        Motorsailer,
        Kayak,
        Canoe,
        Other;
	}

	private TYPE type;
	private double length;

	public Boat(TYPE type, double length) {
		this.type = type;
		this.length = length;
	}

	public TYPE getType() { return type; }
	public void setType(TYPE type) { this.type = type; }
	
	public double getLength() { return length; }
	public void setLength(double length) { this.length = length; }
}
