package workshop2.controller;

import java.util.Scanner;

import workshop2.Program;
import workshop2.model.Registry;
import workshop2.view.Console;

public class Controller {
	// Classes:
	private Registry registry;
	private Console console;
	private InputHandler inputHandler;
	
	// Resources:
	private Scanner scan;
	
	
	public Controller(Registry registry, Console console) {
		this.registry = registry;
		this.console = console;
	}
	
	public void start() {
		// Initialize news:
		scan = new Scanner(System.in);
		inputHandler = new InputHandler();
		
		while(Program.PROGRAM_IS_RUNNING) { update(); } 
	}
	
	public void update() {
		console.start();
		if(scan.hasNextInt()) { inputHandler.start(scan.nextInt()); }
	}
	
}
