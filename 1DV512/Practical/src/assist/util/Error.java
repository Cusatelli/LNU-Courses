package assist.util;

public class Error {
	
	public static void print(String input) {
		System.out.print(Format.errorContent(input));
	}
	
	public static void println(String input) {
		System.out.println(Format.errorContent(input));
}
	
	public static void terminate() {
		println("Fatal!");
		System.exit(0);
	}
}
