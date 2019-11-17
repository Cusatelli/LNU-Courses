package workshop2.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class ViewHandler {
	private String printFormat = "| ";
	private Scanner scan = new Scanner(System.in);
	
	<ELEMENT> void displayMenu(ELEMENT[] array, HashMap<ELEMENT, String> map) {
		displayMessage("\n");
		for (int i = 0 ; i < array.length; i++) {
			ELEMENT element = array[i];

			if (map.containsKey(element)) {
				String option = "[" + indexToInput(i) + "] " + map.get(element) + "\n";
				displayMessage(option);
			}
		}
		displayMessage("\n");
	}
	
	<ELEMENT> ELEMENT userInput(ELEMENT[] element_1) {
		int input = 0;
		
		while (!isValidInput(input, element_1.length)) {
			displayMessage("Enter: ");
			if (scan.hasNextInt()) { input = scan.nextInt(); }
			else { scan.next(); }
		}

		return element_1[inputToIndex(input)];
	}
	
	public void displayMessage(String message) {
		System.out.print(printFormat + message);
	}
	
	public void displayExitMessage() {
		displayMessage("\n");
		displayMessage("Application Terminated!\n");
		displayMessage("   __________   ____      ____  _____  _______________  _____\n");
		displayMessage("  //  _____ \\\\  \\\\ \\\\    // //  || ||  ||____  _____||  || ||\n");
		displayMessage("  || //   \\\\||   \\\\ \\\\  // //   || ||       || ||       || ||\n");
		displayMessage("  || ||_______    \\\\ \\\\// //    || ||       || ||       || ||\n");
		displayMessage("  || _______||    // //\\\\ \\\\    || ||       || ||       ||_||\n");
		displayMessage("  || ||_______   // //  \\\\ \\\\   || ||       || ||       _____\n");
		displayMessage("  ||________||  //_//    \\\\_\\\\  ||_||       ||_||       |___|\n");
		displayMessage("\n");
	}
	
	void showRow(String format, Object ...args) {
		System.out.format(format, args);
	}
	
	int getUserIntInput (String title) {
		displayMessage(title);
		while (!scan.hasNextInt()) {
			scan.next();
			displayMessage("[Error] Please try again");
		}

		return scan.nextInt();
	}

	float getUserFloatInput (String title) {
		displayMessage(title);
		while (!scan.hasNextFloat()) {
			scan.next();
			displayMessage("[Error] Please try again");
		}

		return scan.nextFloat();
	}

	String getUserPatternInput (String title, Pattern pattern) {
		displayMessage(title);
		while (!scan.hasNext(pattern)) {
			scan.next();
			displayMessage("[Error] Please try again");
		}

		return scan.next();
	}

	String getUserInput (String title) {
		displayMessage(title);
		return scan.next();
	}

	boolean displayYesAndNoQuestion (String question) {
		boolean acceptedInputValue = false;
		boolean result = false;

		while (!acceptedInputValue) {
			System.out.print(question + " [Y/N]");
			String answer = scan.next().toUpperCase();

			if (answer.equals("Y") || answer.equals("N")) {
				result = answer.equals("Y");
				acceptedInputValue = true;
			}
		}

		return result;
	}
	
	private int indexToInput(int index) {
		return index + 1;
	}
	
	private boolean isValidInput(int input, int number) {
		return input > 0 && input <= number;
	}
	
	private int inputToIndex(int input) {
		return input - 1;
	}
}
