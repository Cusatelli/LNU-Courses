package workshop2.model;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String name;
	private int socialSecurityNumber;
	
	public Member(int ID, String name, int socialSecurityNumber) {
		this.ID = ID;
		this.name = name;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public int getID() { return ID; }
	public void setID(int ID) { this.ID = ID; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getSocialSecurityNumber() { return socialSecurityNumber; }
	public void setSocialSecurityNumber(int socialSecurityNumber) {	
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
}
