package workshop2.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import workshop2.Program;

public class Debug {
	private static boolean DEBUG_MODE;
	private static Scanner scan;
	
	public static void message(String message, boolean showTime) {
		if(DEBUG_MODE) {
			StringBuilder stringBuilder = new StringBuilder();
			if(showTime) { 
				stringBuilder.append("[" + getCurrentTime() + "]"); 
			}
			stringBuilder.append("[Debug Mode] " + message);
			System.out.println(stringBuilder.toString());
		}
	}
	
	public static boolean getMode() {
		return DEBUG_MODE;
	}
	
	public static boolean setLaunchMode() {
		System.out.print("Do you wish to launch in [Debug Mode]?"
			+ "\n[1] Yes"
			+ "\n[2] No"
			+ "\n[0] Exit"
			+ "\nEnter: ");
		scan = new Scanner(System.in);
		// Check input for Debug Mode:
		if(scan.hasNextInt()) {
			int input = scan.nextInt();
			if(input == 1) { DEBUG_MODE = true; } 
			else if (input == 2) { DEBUG_MODE = false; }
			else if (input == 0) { Program.PROGRAM_IS_RUNNING = false; }
			else { setLaunchMode(); }	// If invalid input RETRY.
		} else { setLaunchMode(); }		// If invalid input RETRY.
		
		return DEBUG_MODE;
	}
	
	private static String getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}
}
