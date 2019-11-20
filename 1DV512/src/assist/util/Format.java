package assist.util;

class Format {
	private final static String debugPrefix = "[Debug]";
	private final static String errorPrefix = "[Error]";
	private final static String suffix = "]";
	private final static String whitespace = "       ";
	private final static int maxLength = 100;
	
	private static String toString(String input) {
		StringBuilder output = new StringBuilder();
		String spaces = whitespace + " ";
		String[] arr = input.split("\n");
		
		int length = 0;
		for (int i = 0; i < arr.length; i++) { length += arr[i].length(); }
		
		int count = 1;
		if(length > maxLength) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length(); j++) {
					if(j == maxLength*count) {
						output.append("\n" + spaces);
						if(arr[i].charAt(j) == ' ') { j++; }
						output.append(arr[i].charAt(j));
						count++;
					} else { output.append(arr[i].charAt(j)); }
				}
			}
		} else {
			output.append(input);
		}
		return output.toString();
	}
	
	public static String debugContent(String input) {
		return debugPrefix + Time.Display() 
				+ whitespace + "[" + toString(input) + suffix;
	}
	
	public static String errorContent(String input) {
		return errorPrefix + Time.Display() 
				+ whitespace + "[" + toString(input) + suffix;
	}
}
