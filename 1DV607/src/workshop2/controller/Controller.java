package workshop2.controller;

import workshop2.Program;
import workshop2.model.Registry;
import workshop2.view.Console;

public class Controller {
	private Registry registry;
	private Console console;
	
//	private USER_ACTIONS[] user_Actions;
	
	public Controller(Registry registry, Console console) {
		this.registry = registry;
		this.console = console;
	}
	
	public void start() {
		while(Program.PROGRAM_IS_RUNNING) { update(); } 
	}
	
	public void update() {
		console.start();
	}
	
}
