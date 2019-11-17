package workshop2.view;

import java.util.HashMap;
import java.util.regex.Pattern;

import workshop2.controller.INPUT_ENUMERATION;
import workshop2.model.Boat.ENUMERATION_BOAT_TYPES;

public class View extends ViewHandler {
	
	private HashMap<INPUT_ENUMERATION, String> hashMap_Input = new HashMap<>();
	private HashMap<ENUMERATION_BOAT_TYPES, String> hashMap_BOAT_TYPE = new HashMap<>();
	private String tableFormat = "| %5s | %30s | %20s | %20s |\n";
	private Pattern ssnPattern = Pattern.compile("[0-9]{6}-[0-9]{4}");

	public View () {
		initializeHashMap();
	}
	
	public void printMenu(INPUT_ENUMERATION[] input_Enumeration) {
        displayMenu(input_Enumeration, hashMap_Input);
	}
	
    public INPUT_ENUMERATION getInput(INPUT_ENUMERATION[] input_Enumeration) {
        return userInput(input_Enumeration);
    }

    public void displayMemberListHeader() {
        showRow(tableFormat, "ID", "Name", "Personal number", "Number of boats");
    }

    public void displayMemberListRow(int id, String name, String socialSecurityNumber, int numberOfBoats) {
        showRow(tableFormat, id, name, socialSecurityNumber, numberOfBoats);
    }

    public void displayAddedMember () {
        displayMessage("New member added");
    }

    public void displayMember(int id, String name, String socialSecurityNumber) {
    	displayMessage("––––––––––––––––––––––––––");
    	displayMessage("Name: " + name);
    	displayMessage("Personal number: " + socialSecurityNumber);
    	displayMessage("ID: " + id);
    	displayMessage("--------------------------");
    }

    public String displayUpdateName (String currentName) {
        if (displayYesAndNoQuestion("Change name (" + currentName + ")?")) {
            return getUserInput("Change to");
        }
        return currentName;
    }

    public String displayUpdatePno(String currentPno) {
        if (displayYesAndNoQuestion("Change personal number (" + currentPno + ")?")) {
            return getUserInput("Change to");
        }
        return currentPno;
    }

    public void displayMemberDeleted () {
        displayMessage("Deleted member");
    }

    public void displayAddedBoat () {
        displayMessage("New boat added");
    }

    public void displayBoat(ENUMERATION_BOAT_TYPES type, double length) {
    	displayMessage("Type: " + hashMap_BOAT_TYPE.get(type));
        displayMessage("Length: " + length);
        displayMessage("--------------------------");
    }

    public ENUMERATION_BOAT_TYPES displayUpdateType (ENUMERATION_BOAT_TYPES currentType) {
        if (displayYesAndNoQuestion("Change type (" + hashMap_BOAT_TYPE.get(currentType) + ")?")) {
            return getInputBoatType();
        }
        return currentType;
    }

    public double displayUpdateLength(double currentLength) {
        if (displayYesAndNoQuestion("Change length (" + currentLength + ")?")) {
            return getUserFloatInput("Change to:");
        }
        return currentLength;
    }

    public void displayBoatDeleted () {
        displayMessage("Deleted boat");
    }

    public void displayMemberNotFound () {
        displayMessage("User not found");
    }

    public void displayBoatNotFound() {
        displayMessage("Boat not found");
    }

    public INPUT_ENUMERATION getUserRequest (INPUT_ENUMERATION[] input_Enumerations) {
        return userInput(input_Enumerations);
    }

    public int getInputMemberId () {
        return getUserIntInput("Members ID");
    }

    public String getInputMemberName () {
        return getUserInput("New members name");
    }

    public String m_getInputSSN () {
        return getUserPatternInput("New members Personal Number [XXXXXX-XXXX]", ssnPattern);
    }

    public int getInputBoatIndex () {
        return getUserIntInput("Boats index");
    }

    public ENUMERATION_BOAT_TYPES getInputBoatType () {
    	ENUMERATION_BOAT_TYPES[] boatType_Enumeration = ENUMERATION_BOAT_TYPES.values();

        displayMenu(boatType_Enumeration, hashMap_BOAT_TYPE);

        return userInput(boatType_Enumeration);
    }

    public float getInputBoatLength () {
        return getUserFloatInput("New boats length");
    }
    
    private void initializeHashMap() {
		hashMap_Input.put(INPUT_ENUMERATION.LIST_COMPACT, 			"Compact List");
		hashMap_Input.put(INPUT_ENUMERATION.LIST_VERBOSE, 			"Verbose List");
		hashMap_Input.put(INPUT_ENUMERATION.MEMBER_REGISTER, 		"Register Member");
		hashMap_Input.put(INPUT_ENUMERATION.MEMBER_VIEW, 			"View Member");
		hashMap_Input.put(INPUT_ENUMERATION.MEMBER_EDIT, 			"Edit Member");
		hashMap_Input.put(INPUT_ENUMERATION.MEMBER_REMOVE, 			"Delete Member");
		hashMap_Input.put(INPUT_ENUMERATION.BOAT_REGISTER, 			"Register Boat");
		hashMap_Input.put(INPUT_ENUMERATION.BOAT_EDIT, 				"Edit Boat");
		hashMap_Input.put(INPUT_ENUMERATION.BOAT_REMOVE, 			"Delete Boat");
		hashMap_Input.put(INPUT_ENUMERATION.EXIT_APPLICATION, 		"Exit Application");
		hashMap_BOAT_TYPE.put(ENUMERATION_BOAT_TYPES.Sailboat, 		"Sailboat");
		hashMap_BOAT_TYPE.put(ENUMERATION_BOAT_TYPES.Motorsailer, 	"Motorsailer");
		hashMap_BOAT_TYPE.put(ENUMERATION_BOAT_TYPES.Kayak, 		"Kayak");
		hashMap_BOAT_TYPE.put(ENUMERATION_BOAT_TYPES.Canoe, 		"Canoe");
		hashMap_BOAT_TYPE.put(ENUMERATION_BOAT_TYPES.Other, 		"Other");
	}
	
}
