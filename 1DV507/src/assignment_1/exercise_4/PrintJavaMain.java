package assignment_1.exercise_4;

import java.io.File;

public class PrintJavaMain {
	public static void main(String[] args) {
		PrintJavaMain test = new PrintJavaMain();
		File directory = new File("src/ev222hh_assign1/");
		System.out.println("┐");
		test. printAllJavaFiles(directory);
		System.out.println("┘");
	}
	
	private int rootL = 0;
	private int count = 0;
	private int it = 0;
	private void printAllJavaFiles(File directory) {
		File subDir[] = directory.listFiles(); // Create a list of all the directories.		
		if(rootL == 0) { rootL = subDir.length; }
//		System.out.println(rootL);
		if (!directory.isDirectory()) { // If the file isn't a directory.
			throw new IllegalArgumentException("Target must be a Directory."); // Throw IllegalArgumentException
		}
//		System.out.println(directory.getName());

		if (subDir[it] != null) { // If list isn't empty.
			int length = subDir.length;
			if (count < length) {
				if (subDir[it].isDirectory()) {
					System.out.println("├──┬─ " + subDir[it].getName()); // Directory Name
					 printAllJavaFiles(subDir[it]); // Go to next directory.
				} else {
					System.out.println("│  │");
					System.out.println("│  ├─┬─ " + subDir[count].getName()); // File Name
					System.out.println("│  │ └─── " + subDir[count].length() + " bytes"); // Size
					count++; // Go to next file in current directory.
					 printAllJavaFiles(directory); // Run again.
				}
			} else {
				System.out.println("├──┘");
				System.out.println("│");
				count = 0;
				it++;
				if(rootL > it + 1) {
//					System.out.println(directory.getName());
					printAllJavaFiles(directory.getParentFile()); // Go back to root directory.
				}
			}
		}
	}
}