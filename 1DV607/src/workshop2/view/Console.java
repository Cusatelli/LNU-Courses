package workshop2.view;

import workshop2.controller.ACTIONS;
import workshop2.debug.InvalidInputParameter;
import workshop2.model.Boat.TYPE;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Console extends ConsoleHandler {

    private HashMap<ACTIONS, String> menu_Map = new HashMap<>();
    private HashMap<TYPE, String> boat_Map = new HashMap<>();
    
    // %Xs refers to 'X' number of whitespaces:
    private String listFormat = "▕▎  %4s ▕▎  %20s ▕▎  %22s ▕▎  %15s ▕▎ \n";
    private Pattern ssnPattern = Pattern.compile("[0-9]{8}[0-9]{4}");
    private String beforeMessage = "▕▎ ";

    public Console() {
    	initialize();
    }

    public void getMenu(ACTIONS[] actions) {
        printMenu(actions, menu_Map);
    }

    public void getListHeader() {
    	printLine(" ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁ ");
    	printLine("▕▛▔▔▔▔▔▔▔▜▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎");
        printFormat(listFormat, "ID", "First Name", "Social Security Number", "Number of boats");
        printLine("▕▙▁▁▁▁▁▁▁▟▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎");
    	printLine("▕▛▔▔▔▔▔▔▔▜▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎");
	}

    public void getList(int id, String name, String socialSecurityNumber, int numberOfBoats) {
    	// Split the SSN by birthdate & 4 last digits:
        printFormat(listFormat, id, name, addDashAtSplit(socialSecurityNumber, 0, 8, 12), numberOfBoats);
    }
    
    public void printListFooter() {
    	printLine("▕▙▁▁▁▁▁▁▁▟▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎");
		printLine(" ▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔ ");
    }

    public void m_printRegistered() {
    	printHeader();
        printLine(beforeMessage + "Member Registered!");
        printFooter();
    }

    public void m_getData(String name, String socialSecurityNumber, int id) {
    	printLine(" ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁ ");
    	printLine("▕▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎");
    	
    	if(name.length() >= 7) { printLine("▕▎ First Name: " + name + "\t\t\t▕▎"); }
    	else { printLine("▕▎ First Name: " + name + "\t\t\t\t▕▎"); }
    	
        printLine("▕▎ Social Security Number: " + addDashAtSplit(socialSecurityNumber, 0, 8, 12) + "\t▕▎");
        printLine("▕▎ ID: " + id + "\t\t\t\t\t▕▎");
		printLine("▕▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎");
    }

    public String m_editName(String name) {
        if (printPolar("Edit name: " + name + "?")) {
        	print(beforeMessage + "Update to");
        	return scanNext();
        }
        return name;
    }

    public String m_printEditSSN(String socialSecurityNumber) {
        if (printPolar("Edit Social Security Number: " + socialSecurityNumber+ "?")) {
            print(beforeMessage + "Update to");
            return scanNext();
        }
        return socialSecurityNumber;
    }

    public void m_printRemove() {
    	printHeader();
        printLine(beforeMessage + "Member Removed!");
        printFooter();
    }

    public void b_printRegister() {
    	printHeader();
        printLine(beforeMessage + "Boat Registered!");
        printFooter();
    }
    
    public void b_print(TYPE type, double length) {
    	printLine("\t\t▜▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎");
    	if(boat_Map.get(type).length() > 5) { printLine("\t\t▕▎ Type: " + boat_Map.get(type) + "\t\t▕▎"); } 
    	else { printLine("\t\t▕▎ Type: " + boat_Map.get(type) + "\t\t\t▕▎"); }
        
        // Add 's' to 'meter' if length is greater than 1.0:
        if(length <= 1.0) { printLine("\t\t▕▎ Length: " + length + " meter\t\t▕▎"); }
        else { printLine("\t\t▕▎ Length: " + length + " meters\t\t▕▎"); }
		printLine("\t\t▟▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎");
    }
    
    public void m_printFooter() {
		printLine(" ▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔ ");
    }
    
    public void b_printFooter(int typeOfFooter) throws InvalidInputParameter {
    	switch(typeOfFooter) {
    	case 1:
    		printLine("\t\t▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔ ");
    		break;
    	case 2:
    		m_printFooter();
    		break;
    	default:
    		throw new InvalidInputParameter("Invalid Input Parameter!");
    	}
    }

    public TYPE b_printEditType(TYPE currentType) {
    	printHeader();
        if (printPolar("Edit type: [" + boat_Map.get(currentType) + "]?")) {
            return b_getInputType();
        }
        printFooter();
        return currentType;
    }

    public double b_printEditLength(double currentLength) {
    	printHeader();
        if (printPolar("Edit length [" + currentLength + "]?")) {
            return printTryAgainDouble("Update to");
        }
        printFooter();
        return currentLength;
    }

    public void b_printRemoved() {
    	printHeader();
        printLine(beforeMessage + "Boat Removed!");
        printFooter();
    }
    
    public void printExceptionStackTrace(String message, Exception error) {
    	printHeader();
        printLineError(beforeMessage + message);
        printLine(beforeMessage + error);
        printFooter();
    }

    public ACTIONS getUserRequest(ACTIONS[] actions) {
        return getInput(actions);
    }

    public int m_getInputID() {
        return printTryAgainInteger("Members ID");
    }

    public String m_getInputFirstName() {
        print(beforeMessage + "First Name");
        return scanNext();
    }

    public String m_getInputSocialSecurityNumber() {
        return getUserPatternInput(beforeMessage + "Social Security Number [YYYYMMDDXXXX]", ssnPattern);
    }

    public int b_getInputIndex() {
        return printTryAgainInteger("Boat Index");
    }

    public TYPE b_getInputType() {
        TYPE[] types = TYPE.values();

        printMenu(types, boat_Map);

        return getInput(types);
    }

    public double b_getInputLength() {
        return printTryAgainDouble(beforeMessage + "Length");
    }
    
    public boolean getConfirmation() {
    	return printPolar("Are you sure you wish to EXIT the Application?");
    }
    
    private String addDashAtSplit(String input, int first, int middle, int last) {
    	String output = input.substring(first, middle);
    	output += "-" + input.substring(middle, last);
    	return output;
    }
    
    private void initialize() {
    	// Add String to Appropriate Action Enumeration
    	// To later display it in various print-outs:
        menu_Map.put(ACTIONS.LIST_COMPACT, 		"Compact List");
        menu_Map.put(ACTIONS.LIST_VERBOSE, 		"Verbose List");
        
        menu_Map.put(ACTIONS.MEMBER_VIEW, 		"View Member");
        menu_Map.put(ACTIONS.MEMBER_REGISTER, 	"Reg. Member");
        menu_Map.put(ACTIONS.MEMBER_EDIT, 		"Edit Member");
        menu_Map.put(ACTIONS.MEMBER_DELETE, 	"Remove Member");

        menu_Map.put(ACTIONS.BOAT_REGISTER, 	"Reg. Boat");
        menu_Map.put(ACTIONS.BOAT_EDIT, 		"Edit Boat");
        menu_Map.put(ACTIONS.BOAT_REMOVE, 		"Remove Boat");

        menu_Map.put(ACTIONS.EXIT_APPLICATION, 	"Exit Application");

        // Add boat type options
        boat_Map.put(TYPE.Sailboat, 			"Sailboat");
        boat_Map.put(TYPE.Motorsailer, 			"Motorsailer");
        boat_Map.put(TYPE.Kayak, 				"Kayak");
        boat_Map.put(TYPE.Canoe, 				"Canoe");
        boat_Map.put(TYPE.Other, 				"Other");
    }
    
    /**
     * Prints "APPLICATION LAUNCHED!" in the console or Terminal using Block Elements.
     * Block Elements is a Unicode block containing square block symbols of various fill and shading.
     * These are included in the box-drawing characters.
     * @author cusatelli
     * @version 2.0
     */
    public void printApplicationLaunched() {
    	printLine(" ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁ ");
    	printLine("▕▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎");
		printLine("▕▎    ░████   ░██████   ░██████   ░██       ░██   ░██████   ░████   ░████████ ░██   ░████   ░██   ░██  ▕▎");
		printLine("▕▎  ░██    ██ ░██   ░██ ░██   ░██ ░██       ░██ ░██       ░██   ░██    ░██    ░██ ░██    ██ ░████ ░██  ▕▎");
		printLine("▕▎  ░████████ ░██████   ░██████   ░██       ░██ ░██       ░████████    ░██    ░██ ░██    ██ ░██ ░████  ▕▎");
		printLine("▕▎  ░██   ░██ ░██       ░██       ░██       ░██ ░██       ░██   ░██    ░██    ░██ ░██    ██ ░██   ░██  ▕▎");
		printLine("▕▎  ░██   ░██ ░██       ░██       ░████████ ░██   ░██████ ░██   ░██    ░██    ░██   ░████   ░██   ░██  ▕▎");
		printLine("▕▎                                                                                                     ▕▎");
		printLine("▕▎        ░██         ░████   ░██   ░██ ░██   ░██   ░██████ ░██   ░██ ░████████ ░██████   ░██          ▕▎");
		printLine("▕▎        ░██       ░██   ░██ ░██   ░██ ░████ ░██ ░██       ░██   ░██ ░██       ░██   ░██ ░██          ▕▎");
		printLine("▕▎        ░██       ░████████ ░██   ░██ ░██ ░████ ░██       ░████████ ░██████   ░██   ░██ ░██          ▕▎");
		printLine("▕▎        ░██       ░██   ░██ ░██   ░██ ░██   ░██ ░██       ░██   ░██ ░██       ░██   ░██              ▕▎");
		printLine("▕▎        ░████████ ░██   ░██   ░████   ░██   ░██   ░██████ ░██   ░██ ░████████ ░██████   ░██          ▕▎");
		printLine("▕▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎");
		printLine(" ▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔ ");
    	
    }
    
    /**
     * Prints "APPLICATION TERMINATED!" in the console or Terminal using Block Elements.
     * Block Elements is a Unicode block containing square block symbols of various fill and shading.
     * These are included in the box-drawing characters.
     * @author cusatelli
     * @version 2.0
     */
    public void printApplicationTerminated() {
    	printLine(" ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁ ");
    	printLine("▕▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎");
		printLine("▕▎    ░████   ░██████   ░██████   ░██       ░██   ░██████   ░████   ░████████ ░██   ░████   ░██   ░██  ▕▎");
		printLine("▕▎  ░██   ░██ ░██   ░██ ░██   ░██ ░██       ░██ ░██       ░██   ░██    ░██    ░██ ░██    ██ ░████ ░██  ▕▎");
		printLine("▕▎  ░████████ ░██████   ░██████   ░██       ░██ ░██       ░████████    ░██    ░██ ░██    ██ ░██ ░████  ▕▎");
		printLine("▕▎  ░██   ░██ ░██       ░██       ░██       ░██ ░██       ░██   ░██    ░██    ░██ ░██    ██ ░██   ░██  ▕▎");
		printLine("▕▎  ░██   ░██ ░██       ░██       ░████████ ░██   ░██████ ░██   ░██    ░██    ░██   ░████   ░██   ░██  ▕▎");
		printLine("▕▎                                                                                                     ▕▎");
		printLine("▕▎ ░████████ ░████████ ░██████   ░██     ░██ ░██ ░██   ░██   ░████   ░████████ ░████████ ░██████   ░██ ▕▎");
		printLine("▕▎    ░██    ░██       ░██   ░██ ░████ ░████ ░██ ░████ ░██ ░██   ░██    ░██    ░██       ░██   ░██ ░██ ▕▎");
		printLine("▕▎    ░██    ░██████   ░██████   ░██ ░██ ░██ ░██ ░██ ░████ ░████████    ░██    ░██████   ░██   ░██ ░██ ▕▎");
		printLine("▕▎    ░██    ░██       ░██  ░██  ░██     ░██ ░██ ░██   ░██ ░██   ░██    ░██    ░██       ░██   ░██     ▕▎");
		printLine("▕▎    ░██    ░████████ ░██   ░██ ░██     ░██ ░██ ░██   ░██ ░██   ░██    ░██    ░████████ ░██████   ░██ ▕▎");
		printLine("▕▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎");
		printLine(" ▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔ ");
    }
    
}
