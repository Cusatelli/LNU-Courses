package workshop2.view;

public class Console extends ConsoleHandler {

	// Pattern to check input:
	String idPattern = "^([a-zA-Z]{1}\\d{3})$"; // One Character & 3 digits.
	String namePattern = "^\\D[ _a-zA-Z]{2,40}$"; // 2-40 characters.
	String ssnPattern = "^(\\d{12})$"; // 12 digits. (YYYYMMDDXXXX).
	String integerPattern = "^(\\d?[0-9]|[1-9]0|[1-9]00|[1-9]000)$"; // 1-4 digit input
	
	public void start() {
		System.out.print("\nWhat would you like to do?"
				+ "\n------------- MEMBER ---------------"
				+ "\n[1] Register"
				+ "\n[2] Lists"
				+ "\n[3] Delete"
				+ "\n[4] Edit"
				+ "\n[5] View"
				+ "\n-------------- BOAT ----------------"
				+ "\n[6] Register"
				+ "\n[7] Delete"
				+ "\n[8] Edit"
				+ "\n------------------------------------"
				+ "\n[0] Exit Application"
				+ "\n------------------------------------"
				+ "\nEnter: ");
	}
	
	public void m_setFullName() {
		System.out.print("Enter Full Name: ");
	}
	
	public void m_setSocialSecurityNumber() {
		System.out.print("Enter Social Security Number(YYYYMMDDXXXX): ");
	}
	
	public void m_setId() {
		System.out.print("Generating ID...");
	}
	
	public void m_display() {
		Member member = getMember();
		
	}

	public void m_delete() {
		System.out.println("Deleting Member");
	}
	
	public void m_edit() {
		System.out.println("Editing Member");
	}
	public void b_register() {
		System.out.println("Registering Boat");
	}

	public void b_delete() {
		System.out.println("Deleting Boat");
	}
	
	public void b_edit() {
		System.out.println("Editing Boat");
	}
	
	public void list() {
		System.out.println("List");
	}
	
	public void listType() {
		System.out.print("\nHow would you like to view the data?"
				+ "\n[1] Compact List"
				+ "\n[2] Verbose List"
				+ "\n[0] Back"
				+ "\nEnter: ");
	}
	
	public void view() {
		System.out.println("View");
	}
	
	public void exit() {
		System.out.println("Exit");
	}
	
	public void invalid() {
		System.out.println("\nInvalid input");
	}
	
}
