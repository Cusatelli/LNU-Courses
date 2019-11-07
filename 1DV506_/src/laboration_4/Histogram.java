package laboration_4;

/*
 * NOTE: Histogram is runned through HistogramMain 
 * (Reason being I thought it looked more organized).
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Histogram extends FileHandler {
	
	private ArrayList<Integer> arrHeltal = new ArrayList<Integer>();
	private int[] countStars = new int[11];
	private Scanner scan;
	private int total = 0;
	
/*--------------------------------------------------------
		Convert file from text to ArrayList:
--------------------------------------------------------*/	
	public ArrayList<Integer> toArrayList(File file) throws FileNotFoundException {
		scan = new Scanner(file);
		
		while(scan.hasNextInt()) {	
			int item = scan.nextInt();
			arrHeltal.add(item);
		}
		scan.close();
		
		return arrHeltal;
	}
/*--------------------------------------------------------
	  		  Sorts ArrayList [1, 100]:
--------------------------------------------------------*/	
	public void sortHeltal() {
		for(int i = 0; i < arrHeltal.size(); i++) {
			
			if (arrHeltal.get(i) <= 0 || arrHeltal.get(i) > 100) {
				countStars[10]++;
			
			} else {
				
				for (int j = 0; j < countStars.length; j++) {

					if(arrHeltal.get(i) > (j * 10) && arrHeltal.get(i) <= ((j + 1) * 10)) {
						countStars[j]++;
						total++;
					}
				}
			}
		}
	}
/*--------------------------------------------------------
			  Converts integers to stars:
--------------------------------------------------------*/
	public int toStars(int stars) {
		while(stars != 0) {
			System.out.print("*");
			stars--;
		}
		return stars;
	}
/*--------------------------------------------------------
	  			Call and Print all values:
--------------------------------------------------------*/	
	public void printAll(File file) throws FileNotFoundException {
		toArrayList(file);
		sortHeltal();
		
		System.out.print("Läser heltal från filen: " + file + "\n"
				+ "Antal i Intervallet [1, 100]: " + total + "\n"
				+ "Övriga: " + countStars[10] + "\n"
				+ "Histogram:");
		int count = 0;
		for (int i = 0; i < countStars.length - 1; i++) {
			count++;
			System.out.print("\n" + ((count*10) - 9) + "\t- " + (count*10) + "\t|");
			toStars(countStars[i]);
		}
	}
	
}