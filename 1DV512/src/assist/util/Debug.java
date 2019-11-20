package assist.util;

public class Debug {
	private static boolean isDebugMode = false;
	
	public static void True() { isDebugMode = true; }
	public static void False() { isDebugMode = false; }
	
	/**
	 * Prints a string. If the argument is null then the string "null" is printed. Otherwise, the string's characters are converted into bytes according to the platform's default character encoding, and these bytes are written in exactly the manner of the write(int) method. Additionally it will add other formatting to the String such as prefix, current time & suffix.
	 * <br>{@code [Debug][Time][HH:MM:SS]}
	 * <br>{@code . . . .[String]}
	 * @param input
	 * @version 1.0
	 * @author cusatelli
	 */
	public static void print(String input) {
		if(isDebugMode) { System.out.print(Format.debugContent(input));	}
	}
	
	/**
	 * Prints a String and then terminate the line. This method behaves as though it invokes print(String) and then println(). Additionally it will add other formatting to the String such as prefix, current time & suffix.
	 * <br>{@code [Debug][Time][HH:MM:SS]}
	 * <br>{@code . . . .[String]}
	 * @param input
	 * @version 1.0
	 * @author cusatelli
	 */
	public static void println(String input) {
		if(isDebugMode) { System.out.println(Format.debugContent(input)); }
	}
	
	/**
	 * Prints a String and then terminate the line. This method behaves as though it invokes print(String) and then println(). Additionally it will add other formatting to the String such as newline, prefix, current time, suffix & newline.
	 * <br>{@code }
	 * <br>{@code [Debug][Time][HH:MM:SS]}
	 * <br>{@code . . . .[String]}
	 * <br>{@code }
	 * @param input
	 * @version 1.0
	 * @author cusatelli
	 */
	public static void printd(String input) {
		if(isDebugMode) { System.out.println("\n" + Format.debugContent(input) + "\n");	}
	}
	
}
