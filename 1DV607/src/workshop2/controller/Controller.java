package workshop2.controller;

import java.util.Scanner;

import workshop2.Program;
import workshop2.view.Console;
import workshop2.view.Debug;

public class Controller {
	Console console = new Console();
	Debug debug;
	InputHandler inputHandler;
	RegistryHandler registryHandler;
	
	private Scanner scan;
	
	public void start() {
		// Debug Tool:
		debug = new Debug();
		debug.setLaunchMode();
		debug.message("Controller.start()", "Setting Debug...", "in Field variable.", true);
		debug.message("Controller.start()", "Debug in Field Initialized!", true);

		// Scanner:
		debug.message("Controller.start()", "Setting Scanner...", "in Field variable.", true);
		scan = new Scanner(System.in);
		debug.message("Controller.start()", "Scanner in Field Initialized!", true);
		
		// Input Handler:
		debug.message("Controller.start()", "Setting InputHandler...", "in Field variable.", true);
		inputHandler = new InputHandler();
		debug.message("Controller.start()", "InputHandler in Field Initialized!", true);
		
		// Registry Handler:
		debug.message("Controller.start()", "Setting RegistryHandler...", "in Field variable.", true);
		registryHandler = new RegistryHandler();
		debug.message("Controller.start()", "RegistryHandler in Field Initialized!", true);
		
		debug.message("Controller.start()", "start() Initiated!", true);
		// Infinite Loop:
		debug.message("Controller.start()", "Initiating update()...", true);
		while(Program.PROGRAM_IS_RUNNING) { update(); } 
	}
	
	public void update() {
		console.start();
		if(scan.hasNextInt()) {
			inputHandler.start(scan.nextInt());
		}
	}
	
}
