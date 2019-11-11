package assignment_1;
/*
 * Author: Cusatelli
 * Student ID: ev222hh
 * Date: 11 November 2019
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		ArrayList<Process> processes = new ArrayList<Process>();

		//list of processes to be scheduled
		//the first method parameter is the process id
		//the second method parameter is the arrival time
		//the third method parameter is the burst time
		processes.add(new Process(1, 0, 4));
		processes.add(new Process(2, 1, 3));
		processes.add(new Process(3, 2, 1));
		processes.add(new Process(4, 3, 2));
		processes.add(new Process(5, 4, 5));
		
		FCFS fcfs = new FCFS(processes);
		
		System.out.println("Debug Mode: Y/N?");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if(input.length() == 1) {
			char mode = input.charAt(0);
			
			if(mode == 'y') { fcfs.isDebugMode = true; } 
			else if(mode == 'n') { fcfs.isDebugMode = false; }
		} else {
			System.out.println("Invalid input!");
			System.out.println("Proceeding in Normal Mode!");
		}
		System.out.println("\nRunning...");
		fcfs.run();
		fcfs.printTable();
		System.out.println("\n");
		fcfs.printGanttChart();
		System.out.println("\nCompleted");
	}
	
}