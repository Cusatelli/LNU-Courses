package workshop2;

import workshop2.controller.Controller;

public class Program {
	public static boolean PROGRAM_IS_RUNNING = true;
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.start(); // Run program. 
	}
	
	public static void quit() {
		PROGRAM_IS_RUNNING = false;
	}
}