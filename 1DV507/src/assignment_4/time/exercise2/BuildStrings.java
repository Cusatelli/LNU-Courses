package assignment_4.time.exercise2;

public class BuildStrings {

	public static void main(String[] args) {
		BuildStrings bs = new BuildStrings();
		System.out.println("____________________________________________________________"
				+ "\n\nThese are the results of running each method for one second."
				+ "\n____________________________________________________________\n");
		bs.buildString();
		bs.buildSB();
		System.out.println("____________________________________________________________");
	}

	private void buildString() {
		String string = ".";
		long time = System.currentTimeMillis();
		long desiredTime = time + 1000; // 1000 milliseconds = 1 second.
		while(System.currentTimeMillis() < desiredTime) {
			string += string;				
		}
		System.out.println("Time lapsed: " + (System.currentTimeMillis() - time) + " ms. ≈> " + (System.currentTimeMillis() - time)/1000 + " sec.");
		System.out.println("String Addition: " + string.length() + " characters.");
		}
	
	private void buildSB() {
		StringBuilder sb = new StringBuilder();
		String string = ".";
		long time = System.currentTimeMillis();
		long desiredTime = time + 1000; // 1000 milliseconds = 1 second.
		while(System.currentTimeMillis() < desiredTime) {
			sb.append(string);
		}
		System.out.println("\nTime lapsed: " + (System.currentTimeMillis() - time) + " ms. ≈> " + (System.currentTimeMillis() - time)/1000 + " sec.");
		System.out.println("StringBuilder appends: " + sb.toString().length() + " characters.");
	}
}
