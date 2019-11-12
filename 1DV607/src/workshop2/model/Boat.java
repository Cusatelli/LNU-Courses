package workshop2.model;

import java.io.Serializable;

public class Boat implements Serializable {
	private int ID;
	private double length;
	public enum TYPE { Sailboat, Motorsailer, Canoe, Kayak, Other }
	private TYPE type;
	
	public int getID() { return ID; }
	public void setID(int iD) { ID = iD; }
	
	public double getLength() { return length; }
	public void setLength(double length) { this.length = length; }
	
	public TYPE getType() { return type; }
	public void setType(TYPE type) { this.type = type; }
}
