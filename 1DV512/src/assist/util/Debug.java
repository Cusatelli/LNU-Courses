package assist.util;

public class Debug {
	private static boolean isDebugMode = false;
	private final static String prefix = "[Debug] ";
	
	public static void True() { isDebugMode = true; }
	public static void False() { isDebugMode = false; }
	
	public static void print(String output) {
		if(isDebugMode) {
			if(Time.showTime) { System.out.print(Time.getTime() + prefix + output); }
			else { System.out.print(prefix + output); }	
		}
	}
	
	public static void println(String output) {
		if(isDebugMode) {
			if(Time.showTime) { System.out.println(Time.getTime() + prefix + output); }
			else { System.out.println(prefix + output); }
		}
	}
	
	public static void printd(String output) {
		if(isDebugMode) {
			if(Time.showTime) { System.out.println("\n" + Time.getTime() + prefix + output + "\n"); }
			else { System.out.println("\n" + prefix + output + "\n"); }
		}
	}
	
}
