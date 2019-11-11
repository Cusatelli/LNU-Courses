package workshop2.controller;

import workshop2.Program;
import workshop2.view.Debug;

public class Controller {

	public void start() {		
		Debug.message("Controller.start() Initiated.", true);
		Debug.message("Initiating Controller.update()...", true);
		// Infinite Loop:
		while(Program.PROGRAM_IS_RUNNING) { update(); } 
	}
	
	public void update() {
		Debug.message("Controller.update() Initiated.", true);
		System.out.println("Update");
	}
	
}
