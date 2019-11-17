package workshop2.model;

import java.util.Random;

public class Id {
	private int uniqueID;
	
	public Id() {
		this.uniqueID = generateUniqueID();
	}
	
	/**
	 * Creates a new random number generator & sets the seed 
	 * of the random number generator to a value very likely to 
	 * be distinct from any other invocation.
	 * 
	 * @return a Character between A-Z & an Integer between 100-999.
	 * 
	 * @author cusatelli
	 */
	public int generateUniqueID() {
		//TODO: Generate unique ID
		// 001-999 (Example: 186)
		Random random = new Random();
		int output = random.nextInt(900) + 99; // 100 - 999 integers.
		return output;
		
		// TODO: Check with MemberRegistry.txt if ID already taken.
	}
	
//	private char generateRandomCharacter() {
//		// A-Z (Example: R)
//		Random random = new Random();
//		char output = (char)(random.nextInt('Z' - 'A') + 'A'); // A - Z characters.
//		return output;
//	}
	
	public int getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}
}
