package workshop2;

import workshop2.controller.Controller;
import workshop2.view.Debug;

public class Program {
	public static boolean PROGRAM_IS_RUNNING = true;
	
	public static void main(String[] args) {
		Debug.setLaunchMode();
		Controller controller = new Controller();
		controller.start(); // Run program. 
	}
}