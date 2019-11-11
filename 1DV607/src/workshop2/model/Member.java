package workshop2.model;

public class Member {
	private int ID;
	private String name;
	private int socialSecurityNumber;
	
	public Member() {
		//TODO: Add boats to member...
	}

	public int getID() { return ID; }
	public void setID(int iD) { ID = iD; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getSocialSecurityNumber() { return socialSecurityNumber; }
	public void setSocialSecurityNumber(int socialSecurityNumber) {	
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
}
