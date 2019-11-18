package workshop2.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

abstract class ConsoleHandler {

    protected Scanner scan = new Scanner(System.in);
    
    private String format_FirstCharacter_Print = "▕▎";
    private String format_BeforeText_Print = "        ";
    private String format_AfterText_Print = ": ";
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
    
    void printLineError(String message) {
    	System.out.println(format_FirstCharacter_Print 
    			+ format_Error_Print 
    			+ message);
    }

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
    
    /*
     * Using <T> is a new way of doing methods for me so I
     * have included a link in case I need to look this up while coding...
     * Reference: https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
     */
    protected <Element> Element getInput(Element[] elements) {
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
            	
            } else { scan.next(); }
        }
        printFooter();

        return elements[input - 1];
    }
    
    private boolean isInputValid(int input, int number) {
        return input > 0 && input <= number;
    }
    
    /*
     * Using <T> is a new way of doing methods for me so I
     * have included a link in case I need to look this up while coding...
     * Reference: https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
     */
    protected <Element> void printMenu(Element[] elements, HashMap<Element, String> map) {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append(buildStringBuilder(0));
        
    	for (int i = 0 ; i < elements.length; i++) {
        	Element element = elements[i];
            if (map.containsKey(element)) {
            	
            	// If First Element:
            	if(i == 0) { stringBuilder.append(buildStringBuilder(1)); }
            	else { stringBuilder.append(buildStringBuilder(2)); }
            	
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
        stringBuilder.append(buildStringBuilder(3));
        
    	printLine(stringBuilder.toString());
    }
    
    private String buildStringBuilder(int stage) {
    	switch(stage) {
    	case 0:
    		return " ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁ "
        			+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print
        			+ "▕▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎"
        			+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print;
    	case 1:
    		return "▕▎\t\t\tMENU\t\t\t▕▎\n" 
					+ format_FirstCharacter_Print + format_BeforeText_Print 
					+ "▕▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎\n" 
					+ format_FirstCharacter_Print + format_BeforeText_Print
					+ "▕▛▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▜▎\n" 
					+ format_FirstCharacter_Print + format_BeforeText_Print;
    	case 2:
    		return "\n" + format_FirstCharacter_Print + format_BeforeText_Print;
    	case 3:
    		return "\n" + format_FirstCharacter_Print + format_BeforeText_Print 
            		+ "▕▙▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▟▎"
            		+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print
            		+ " ▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔"
            		+ "\n" + format_FirstCharacter_Print + format_BeforeText_Print;
    	default:
    		return null;
    	}
		
    }
    
    // Polar Questions or General Questions 
    // are Questions where Yes or No answers are expected
    // Source: https://en.wikipedia.org/wiki/Yes%E2%80%93no_question
    boolean printPolar(String message) {
        boolean isValidInput = false;

        while (!isValidInput) {
            printLine(format_FirstCharacter_Print + " " + message);
            printLine(format_FirstCharacter_Print + " [1] Yes");
            printLine(format_FirstCharacter_Print + " [2] No");
            printLine(format_FirstCharacter_Print);
            print(format_FirstCharacter_Print + " " + format_Enter_Print);
            int input = scan.nextInt();

            if (input == 1) { return true; }
            else if(input == 2) { return false; }
        }
        
        return false;
    }
    
}
