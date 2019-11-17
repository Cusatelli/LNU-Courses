package workshop2.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

abstract class ConsoleHandler {

    private Scanner scan = new Scanner(System.in);
    
    private String format_FirstCharacter_Print = "▕▎";
    private String format_BeforeText_Print = "        ";
    private String format_AfterText_Print = ": ";
//	private String format_Debug_Print = "[Debug] ";
    private String format_Error_Print = "[Error] ";
    private String format_Enter_Print = "Enter";
    
    void print(String message) {
        System.out.print(format_FirstCharacter_Print 
        		+ format_BeforeText_Print 
        		+ message 
        		+ format_AfterText_Print);
    }
    
    void printLine(String message) {
        System.out.println(format_FirstCharacter_Print 
        		+ format_BeforeText_Print 
        		+ message);
    }
    
    void printLineEmpty() {
        System.out.println(format_FirstCharacter_Print 
        		+ format_BeforeText_Print);
    }
    
    public void printLineError(String message) {
    	System.out.println(format_FirstCharacter_Print 
    			+ format_Error_Print 
    			+ message);
    }
    
//    void printLineDebug(String message) {
//    	System.out.println(format_FirstCharacter_Print 
//    			+ format_Debug_Print 
//    			+ message);
//    }

    void printFormat(String format, Object ...args) {
        System.out.format(format_FirstCharacter_Print 
        		+ format_BeforeText_Print 
        		+ format, args);
    }

    int printTryAgainInteger(String message) {
        print(format_FirstCharacter_Print + " " + message);
        	
        while (!scan.hasNextInt()) {
            scan.next();
            printInvalidInputTryAgain();
        }

        return scan.nextInt();
    }

    double printTryAgainDouble(String message) {
        print(format_FirstCharacter_Print + " " + message);
        
        print(message);
        while (!scan.hasNextDouble()) {
            scan.next();
            printInvalidInputTryAgain();
        }

        return scan.nextDouble();
    }
    
    public void printHeader() {
    	printLine(" ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁ ▁▁▁▁▁▁ ▁▁ ▁ ▁");
    	printLine("▕▛▔▔▔▔▔▔▔▔▔ ▔▔▔▔▔▔▔▔ ▔▔ ▔");
    }
    
    public void printFooter() {
    	printLine("▕▙▁▁▁▁ ▁▁▁▁▁▁ ▁▁ ▁");
    	printLine(" ▔▔▔▔▔▔▔ ▔ ▔");
    }

    String getUserPatternInput(String message, Pattern pattern) {
        print(message);
        while (!scan.hasNext(pattern)) {
            scan.next();
            printInvalidInputTryAgain();
        }
        return scan.next();
    }
    
    private void printInvalidInputTryAgain() {
    	printLine(format_FirstCharacter_Print);
        printLineError(format_FirstCharacter_Print + " Wrong format!");
        print(format_FirstCharacter_Print + " Please try again");
    }

    String scanNext() {
        return scan.next();
    }
    
    <Element> Element getInput(Element[] elements) {
        int input = 0;
        // Ask for users choice until they respond with an index that exists in available options
        while (!isInputValid(input, elements.length)) {
        	printHeader();
        	print("▕▎ " + format_Enter_Print);
        	
            if (scan.hasNextInt()) {
            	input = scan.nextInt();
            	// If user inputs 0 the user wishes to exit the application
            	// Therefore set input to elements length because EXIT_APPLICATION
            	// Should ALWAYS be located last in the ACTIONS enumerations!
            	if(input == 0) { input = elements.length; }
            	// If user inputs the last value ACTUALLY containing the EXIT_APPLICATION
            	// The input will be set out of bounds to force a new input:
            	else if(input == elements.length) { input = elements.length + 1; } // Set input to out of bounds
            	
            } else {
                scan.next();
            }
        }
        
        printFooter();

        return elements[input - 1];
    }
    
    private boolean isInputValid(int input, int number) {
        return input > 0 && input <= number;
    }

    <Element> void printMenu(Element[] elements, HashMap<Element, String> map) {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append(" ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁ "
    			+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print
    			+ "▕▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎"
    			+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print);
        
    	for (int i = 0 ; i < elements.length; i++) {
        	Element element = elements[i];
            if (map.containsKey(element)) {
            	
            	// If First Element:
            	if(i == 0) {
            		stringBuilder.append("▕▎\t\t\tMENU\t\t\t▕▎\n" 
            				+ format_FirstCharacter_Print + format_BeforeText_Print 
            				+ "▕▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎\n" 
            				+ format_FirstCharacter_Print + format_BeforeText_Print
            				+ "▕▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎\n" 
            				+ format_FirstCharacter_Print + format_BeforeText_Print);
            	
            	} else {
            		stringBuilder.append("\n" + format_FirstCharacter_Print + format_BeforeText_Print);
            	}
            	// Get Last Element & Re-map it:
            	if(elements.length == i + 1) {
            		// Print Exit Application to '0'
            		if(elements[i].toString().length() <= 5) {
                		stringBuilder.append("▕▎ [" + 0 + "] " + map.get(element) + "\t\t\t\t\t▕▎");
            		} else {
            			stringBuilder.append("▕▎\t\t\t\t\t\t▕▎"
            					+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print
            					+ "▕▎ [" + 0 + "] " + map.get(element) + "\t\t\t▕▎");
            		}
            	
            	} else {
            		if(elements[i].toString().length() <= 5) {
                		stringBuilder.append("▕▎ [" + (i + 1) + "] " + map.get(element) + "\t\t\t\t\t▕▎");
            		} else {
                		stringBuilder.append("▕▎ [" + (i + 1) + "] " + map.get(element) + "\t\t\t\t▕▎");
            		}
            	}
            }
        }
        stringBuilder.append("\n" + format_FirstCharacter_Print + format_BeforeText_Print 
        		+ "▕▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎"
        		+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print
        		+ " ▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔"
        		+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print);
        
    	printLine(stringBuilder.toString());
    }
    
    // Polar Questions or General Questions 
    // are Questions where Yes or No answers are expected
    // Source: https://en.wikipedia.org/wiki/Yes%E2%80%93no_question
    boolean printPolar(String message) {
        boolean isValidInput = false;
        boolean result = false;

        while (!isValidInput) {
            printLine(format_FirstCharacter_Print + " " + message);
            printLine(format_FirstCharacter_Print + " [Y] Yes");
            printLine(format_FirstCharacter_Print + " [N] No");
            printLine(format_FirstCharacter_Print);
            print(format_FirstCharacter_Print + " " + format_Enter_Print);
            String input = scan.next().toUpperCase();

            if (input.equals("Y") || input.equals("N")) {
                result = input.equals("Y");
                isValidInput = true;
            }
        }
        return result;
    }
    
}
