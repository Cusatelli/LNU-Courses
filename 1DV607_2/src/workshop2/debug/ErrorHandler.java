package workshop2.debug;

import workshop2.Program;

public class ErrorHandler extends Program {
		
	public void MemberNotFound() {
		view_Handler.displayMessage("Member Not Found!\n");
		controller_Handler.exit();
	}
	
	public void BoatNotFound() {
		view_Handler.displayMessage("Boat Not Found!\n");
		controller_Handler.exit();
	}
	
}
