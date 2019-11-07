package laboration_3;

public class Pnr {

/*--------------------------------------------------------
	   					 Main 2
--------------------------------------------------------*/
	public static void main(String[] args) {
		// Person Nummer format (ÅÅMMDDNNNN):
		String pnr1 = "9807265431";
		String pnr2 = "9710235486";

/*------------------------------------------------------*/
		// pnr1 == pnr2?
		if (areEqual(pnr1, pnr2) == true) {
			System.out.println("Båda Person Nummer är dem samma!");
			
		} else {
			System.out.println("Person Nummeren är inte dem samma!");
		}	
		
/*------------------------------------------------------*/
		// Person Nummer 1 = Female?
		if (isFemaleNumber(pnr1) == true) {
			System.out.println("\nFemale: " + getFirstPart(pnr1) 
			+ "-" + getSecondPart(pnr1));
			
		} else {
			System.out.println("\nMale: " + getFirstPart(pnr1) 
			+ "-" + getSecondPart(pnr1));
		}
	
/*------------------------------------------------------*/
		if (isFemaleNumber(pnr2) == true) {
			System.out.println("Female: " + getFirstPart(pnr2) 
			+ "-" + getSecondPart(pnr2));
			
		} else {
			System.out.println("Male: " + getFirstPart(pnr2) 
			+ "-" + getSecondPart(pnr2));
		}
	}
	
/*--------------------------------------------------------
						Task 2.1
--------------------------------------------------------*/
	// Returns Social Security Number (ÅÅMMDD) Method
	public static String getFirstPart(String pnr) {
		// Returns 1st to 6th part of pnr.
		return pnr.substring(0,6);
	}
	
/*--------------------------------------------------------
						Task 2.1
--------------------------------------------------------*/
	// Returns Social Security Number (NNNN) Method
	public static String getSecondPart(String pnr) {
		// Returns 7th to 10th part of pnr.
		return pnr.substring(6,10);
	}

/*--------------------------------------------------------
						Task 2.2
--------------------------------------------------------*/
	// Returns True if it is a Female Social Security Number Method:
	public static boolean isFemaleNumber(String pnr) {
		int femaleNr = Integer.parseInt(getSecondPart(pnr));
		
		// if mod 2 = 0 then it is a female S.S.N. 
		if (femaleNr%2 != 0) {
			return false;
			
		} else {
			return true;
		}
	}

/*--------------------------------------------------------
						Task 2.3
--------------------------------------------------------*/
	// Returns compares two Social Security Number and detects if they are the same Method:
	public static boolean areEqual(String pnr1, String pnr2) {
		
		if (pnr1 == pnr2) {
			return true;
			
		} else {
			return false;
		}
	}
}
