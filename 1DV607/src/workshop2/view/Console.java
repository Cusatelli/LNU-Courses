package workshop2.view;

import java.util.Scanner;

public class Console {
	Scanner scan;

	// Pattern to check input:
	String idPattern = "^([a-zA-Z]{1}\\d{3})$"; // One Character & 3 digits.
	String namePattern = "^\\D[ _a-zA-Z]{2,40}$"; // 2-40 characters.
	String ssnPattern = "^(\\d{12})$"; // 12 digits. (YYYYMMDDXXXX).
	String integerPattern = "^(\\d?[0-9]|[1-9]0|[1-9]00|[1-9]000)$"; // 1-4 digit input
	
	public Console() {
		scan = new Scanner(System.in);
	}
	
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
	
	public void m_register() {
		m_getName();
		String name;
		if(scan.hasNext(namePattern)) { name = scan.nextLine(); }
		
		m_getSSN();
		int ssn;
		if(scan.hasNext(ssnPattern)) { ssn = scan.nextInt(); }
		
		m_getID();
		int ID;
		if(scan.hasNext(idPattern)) { ID = scan.nextInt(); }
	}
	
	private void m_getName() {
		System.out.print("Enter Full Name: ");
	}
	
	private void m_getSSN() {
		System.out.print("Enter Social Security Number(YYYYMMDDXXXX): ");
	}
	
	private void m_getID() {
		System.out.print("Enter ID: ");
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
	
	public void view() {
		System.out.println("View");
	}
	
	public void exit() {
		System.out.println("Exit");
	}
	
	public void invalid() {
		System.out.println("Invalid input");
	}
	
}
