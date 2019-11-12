package workshop2;

import workshop2.controller.Controller;
import workshop2.model.Registry;
import workshop2.view.Console;

public class Program {
	public static boolean PROGRAM_IS_RUNNING = true;
	
	public static void main(String[] args) {
		Registry registry = new Registry();
		Console console = new Console();
		Controller controller = new Controller(registry, console);
		controller.start(); // Run program. 
	}
	
	public static void quit() {
		PROGRAM_IS_RUNNING = false;
	}
}