package assignment_1.exercise_6.histogram;

/*
 * NOTE: Histogram is runned through HistogramMain 
 * (Reason being I thought it looked more organized).
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

public class Histogram extends FileHandler {
	static int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
    static int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	
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
	  				Changed to XChart!
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
/*--------------------------------------------------------
						XChart!
--------------------------------------------------------*/		
	public void xchart(File file) throws FileNotFoundException {
		toArrayList(file);
		sortHeltal();
		
		/*** PIE ***/
		String[] num = {"1-10", "11-20", "21-30", "31-40", "41-50", "51-60", "61-70", "71-80", "81-90", "91-100"};
		PieChart pc = new PieChartBuilder().width(WIDTH/2).height(HEIGHT/2).title("Histogram from 1DV506").build();
		for (int i = 0; i < num.length; i++) {
			pc.addSeries(num[i], countStars[i]);
		}		
		new SwingWrapper<PieChart>(pc).displayChart().setLocation(0, HEIGHT/4); // <- Places window in center of screen after displaying.
		
		/*** BAR ***/
		// Bar Chart will display 0-10 in only 0 bar. etc.
		CategoryChart bc = new CategoryChartBuilder().width(WIDTH/2).height(HEIGHT/2).title("Histogram from 1DV506").build();
		int[] array = new int[10];
		int[] bcCount = new int[10];
		for (int i = 0; i < countStars.length - 1; i++) {
			bcCount[i] = countStars[i]/3;
			array[i] = i * 10;
		}
		bc.addSeries("Numbers", array, bcCount);
		new SwingWrapper<CategoryChart>(bc).displayChart().setLocation(WIDTH/2, HEIGHT/4); // <- Places window in center of screen after displaying.
	}
}