package laboration_4;

/*
 * FileHandler is used to get the file heltal, heltalTva & heltalTre
 * You can change between these files freely between compilations.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;

public class HistogramMain extends Histogram {
	public static void main(String[] args) throws FileNotFoundException {
		Histogram NH = new Histogram();
		
		// File Handler to easily change file where Histogram will collect Integers from:
		FileHandler fileHandler = new FileHandler();
		// Choose a file between 1 - 3:
		// [ 1 ] Contains 100 Integers (where 83 of values are between 1 - 100).
		// [ 2 ] Contains 201 Integers (where 100 of values are between 1 - 100).
		// [ 3 ] Contains 300 Integers (where 92 of values are between 1 - 100).
		File file = fileHandler.files(1); // <------ 1-3
		
		// Print out:
		NH.printAll(file);
	}
}
