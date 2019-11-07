package laboration_2;

import java.util.*;

public class Lonerevision {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Mata in löner (och avsluta med 'X'): ");
		
		// Array List for storing all salaries:
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// Define variables
		int salary, averageSalary, distribution, pos1, pos2,
			count = 0, totalSalary = 0, median = 0;
		
		// Check if input is an Integer:
		while (sc.hasNextInt()) {
		    salary = sc.nextInt();
		    list.add(count, salary);
		    count++;
		}	
		
		// Calculate Total Salary:
		for (int i = 0; i < list.size(); i++) {
			salary = list.get(i);
			totalSalary = totalSalary + salary;
		}
		
		// Calculate Average Salary:
		averageSalary = (totalSalary / list.size());
		
		// ArrayList Sort:
		Collections.sort(list);
		
		// Find Median in ArrayList:
		if (list.size() % 2 == 0) {
			pos1 = list.get((list.size() / 2) - 1);
			pos2 = list.get((list.size() / 2));
			median = ((pos1 + pos2) / 2);
			
		} else {
			median = list.get((list.size() / 2));
		}
		
		// Compares lowest to highest Salary:
		distribution = list.get(list.size() - 1) - list.get(0);
		
		// Print Results:
		System.out.println("Medianlön: " + median
				+ "\nMedellön: " + averageSalary
				+ "\nLönespridning: " + distribution);
	}
}
