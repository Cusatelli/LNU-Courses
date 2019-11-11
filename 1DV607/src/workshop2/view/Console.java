package workshop2.view;

public class Console {
	
	public Console() {
		
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
		System.out.println("Registering Member");
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
