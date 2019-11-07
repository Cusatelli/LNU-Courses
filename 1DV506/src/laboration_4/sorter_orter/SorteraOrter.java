package laboration_4.sorter_orter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SorteraOrter{
	
	private static ArrayList<String> orter = new ArrayList<>();
	private static FileReader fileReader;
	private static BufferedReader bufferedFileReader;
	private static File file = new File("Resources/orter.txt");
	static int numberOfCities = 0;
	
	public static void main(String[] args) throws IOException {		
		List<Ort> cities = new ArrayList<Ort>();
		Ort ort;
		
		// Read orter.txt file from project folder:
		try { // Get file.
			fileReader = new FileReader(file); // Enables read file.
			bufferedFileReader = new BufferedReader(fileReader); // Parse through the document.
			String currentLine = bufferedFileReader.readLine(); // Get first line in dictionary.
			
			while(currentLine != null) {
				orter.add(currentLine); // Add line to orter arrayList<String>.
				currentLine = bufferedFileReader.readLine(); // Read next Line.
				//System.out.println(orter); // Debug
			}
			// Close streams:
			bufferedFileReader.close();
			fileReader.close();
		
		// If file is missing print custom error message:
		} catch(IOException e) {
			System.out.println("Error: FILE NOT FOUND!");
		}
		
		// Add ArrayList<String> orter to List<Ort> cities:
		// split at semi-colon ";" :
		for (int i = 0; i < orter.size(); i++) {
			String[] value = orter.get(i).split(";");
			String code = value[value.length - 2];
			String city = value[value.length - 1];
			// Convert postcode to integer for ort readability:
			int postcode = Integer.parseInt(code);
			
			// Counts number of cities:
			numberOfCities++;
			
			// Add postcode and city to Ort 
			// and ort to cities:
			ort = new Ort(postcode, city); // <------------------------ Ort ort = new Ort()
			cities.add(ort);
		}
		
		// Creates a print out:
		System.out.println("____________________________________\n\n"
				+ " Läser orter från filen: " + file +
				"\n____________________________________\n"
				+ "\n Antal funna orter: " + numberOfCities + "\n");

		// Sort cities by post code:
		Collections.sort(cities);
		
		// iterate over cities and print cities in sorted order:
		for(Ort o : cities) {
			System.out.println(o);
		}
		
		System.out.println("____________________________");
	}
}