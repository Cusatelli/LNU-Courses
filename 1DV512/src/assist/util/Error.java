package assist.util;

public class Error {
	private final static String prefix = "[Error] ";
	
	public static void print(String output) {
		if(Time.showTime) { System.out.print(Time.getTime() + prefix + output); }
		else { System.out.print(prefix + output); }	
	}
	
	public static void println(String output) {
		if(Time.showTime) { System.out.println(Time.getTime() + prefix + output); }
		else { System.out.println(prefix + output); }
	}
	
	public static void terminate() {
		println("Fatal!");
		System.exit(0);
	}
}
