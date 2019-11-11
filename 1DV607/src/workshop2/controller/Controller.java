package workshop2.controller;

import java.util.Scanner;

import workshop2.Program;
import workshop2.view.Console;
import workshop2.view.Debug;

public class Controller {
	Console console = new Console();
	Debug debug;
	InputHandler inputHandler;
	
	private Scanner scan;
	
	public void start(Debug debug) {
		debug.message("Controller.start()", "start() Initiated!", true);
		
		// Debug Tool:
		debug.message("Controller.start()", "Setting Debug...", "in Field variable.", true);
		this.debug = debug;
		debug.message("Controller.start()", "Debug in Field Initialized!", true);
		
		// Scanner:
		debug.message("Controller.start()", "Setting Scanner...", "in Field variable.", true);
		scan = new Scanner(System.in);
		debug.message("Controller.start()", "Scanner in Field Initialized!", true);
		
		// Input Handler:
		debug.message("Controller.start()", "Setting InputHandler...", "in Field variable.", true);
		InputHandler inputHandler = new InputHandler();
		debug.message("Controller.start()", "InputHandler in Field Initialized!", true);

		// Infinite Loop:
		debug.message("Controller.start()", "Initiating update()...", true);
		while(Program.PROGRAM_IS_RUNNING) { update(); } 
	}
	
	public void update() {
		debug.message("Controller.update()", "update() Initiated!", true);
		console.start();
		if(scan.hasNextInt()) {
			int input = scan.nextInt();
			if(input > 0 && input < 9) { inputHandler.start(input); }
		}
	}
	
}
