package assignment_1.exercise_9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class WarAndPeace {
	private static String originalFile = "WarAndPeace";
	
	public static void main(String[] args) throws IOException {
		String updated = readFile(originalFile);
		String[] original = updated.split(" ");
		
		System.out.println("Original word count: " + original.length);
		Stream<String> stream = Arrays.stream(original);
		
		// Stream wanted me to use float, why is that better than long in this scenario???
		float unique = stream.map(e -> e.toLowerCase()).map(e -> e.replaceAll("[^a-zA-Z]", "")).distinct().count();
		System.out.println("Unique words:        " + Math.round(unique));
	}

	public static String readFile(String file) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(file))) {
	        stream.forEach(str -> sb.append(str).append(" "));
	    }
		return sb.toString();
	}
}
