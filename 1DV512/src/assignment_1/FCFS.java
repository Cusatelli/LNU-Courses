package assignment_1;
/*
 * File:	Process.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti
 * Date: 	November, 2018
 */

/*
 * Implementation Author: Cusatelli
 * Student ID: ev222hh
 * Date: 11 November 2019
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class FCFS {
	boolean isDebugMode = false;

	// The list of processes to be scheduled
	public ArrayList<Process> processes;
	
	// The completed time of each process to be kept and reused.
	private int completedTime; // If set as field it doesn't need to be initialized beforehand.

	// Class constructor
	public FCFS(ArrayList<Process> processes) {
		this.processes = processes;
	}

	public void run() {
		if(isDebugMode) { debugMessage("Run", true); }
		// TODO Implement the FCFS algorithm here
		
		// Sort Processes according to Arrival Time:
		this.processes = sortProcesses(processes);
		
		// Set currents of the processes:
		for(Process process : processes) {
			// If the arrival time is less than the completed time
			// add this processes burstTime to completedTime:
			if(process.getArrivalTime() <= completedTime) {
				completedTime += process.getBurstTime(); 
				// ================ Debugging ================
				if(isDebugMode) { debugMessage("Burst Time(Completed Time): " + completedTime, true); }
				// ===========================================
			} else { 
				completedTime = process.getBurstTime() + process.getArrivalTime();
				// ================ Debugging ================
				if(isDebugMode) { debugMessage("Burst Time + Arrival Time (Completed Time): " + completedTime, true); }
				// ===========================================
			}
			process.setCompletedTime(completedTime);
			process.setTurnaroundTime(process.getCompletedTime() - process.getArrivalTime());
			// ================ Debugging ================
			if(isDebugMode) { debugMessage("Completed Time - Arrival Time (Turn Around Time): " + process.getTurnaroundTime(), true); }
			// ===========================================
			process.setWaitingTime(process.getTurnaroundTime() - process.getBurstTime());
			// ================ Debugging ================
			if(isDebugMode) { debugMessage("Turn Around Time - Burst Time (Waiting Time): " + process.getWaitingTime(), true); }
			// ===========================================
		}
	}

	public void printTable() {
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Print Table", true); }
		// ===========================================
		// TODO Print the list of processes in form of a table here
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> emptyList = new ArrayList<String>();
		ArrayList<String> underscoreList = new ArrayList<String>();
		strings.add("Process ID");
		strings.add("Arrival Time");
		strings.add("Burst Time");
		strings.add("Completed Time");
		strings.add("Turn Around Time");
		strings.add("Waiting Time");
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String: \n" + stringBuilder.toString(), true); }
		// ===========================================
		int columns = strings.size();
		int width = 18;

		// Initialize empty List (For blank spaces):
		for (int i = 0; i < columns; i++) { emptyList.add(""); }
		// Initialize underscore List:
		String str = "";
		for (int i = 0; i < columns; i++) { 
			for (int j = 0; j < width; j++) { str += "_"; }
			underscoreList.add(str);
			str = "";
		}

		// Append underscores:
		for (int i = 0; i <= columns * width + columns; i++) { stringBuilder.append("_"); }
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String: \n" + stringBuilder.toString(), true); }
		// ===========================================
		stringBuilder.append("\n");

		// Create Empty Row with '|':
		stringBuilder.append(buildTableOfStrings(emptyList, columns, width));
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String: \n" + stringBuilder.toString(), true); }
		// ===========================================
		// Columns, Width (in characters).
		stringBuilder.append("\n");
		stringBuilder.append(buildTableOfStrings(strings, columns, width));
		// ArrayList<String> contents, columns, width
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String: \n" + stringBuilder.toString(), true); }
		// ===========================================
		
		stringBuilder.append("\n");
		stringBuilder.append(buildTableOfStrings(underscoreList, columns, width));
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String: \n" + stringBuilder.toString(), true); }
		// ===========================================
		
		// Initialize rows of data:
		for (Process processes : processes) {
			ArrayList<String> data = new ArrayList<String>();

			stringBuilder.append("\n");
			stringBuilder.append(buildTableOfStrings(emptyList, columns, width));
			
			data.add("" + processes.getProcessId());
			data.add("" + processes.getArrivalTime());
			data.add("" + processes.getBurstTime());
			data.add("" + processes.getCompletedTime());
			data.add("" + processes.getTurnaroundTime());
			data.add("" + processes.getWaitingTime());
			// ================ Debugging ================
			if(isDebugMode) { debugMessage("Current Data: \n" + data.toString(), true); }
			// ===========================================

			stringBuilder.append("\n");
			stringBuilder.append(buildTableOfStrings(data, columns, width));
			
			stringBuilder.append("\n");
			stringBuilder.append(buildTableOfStrings(underscoreList, columns, width));
		}

		System.out.println(stringBuilder.toString());
	}
	
	public void printGanttChart() {
		if(isDebugMode) { debugMessage("Print Gantt Chart", true); }
		StringBuilder stringBuilder = new StringBuilder();
		int length = processes.size();
		int burstTime = 0;
		int count = 0;
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Length of Processes: " + length, true); }
		if(isDebugMode) { debugMessage("Start Burst Time: " + burstTime, true); }
		if(isDebugMode) { debugMessage("Start Count: " + count, true); }
		// ===========================================
		/*--------------------------------------------
		 * First Row
		 --------------------------------------------*/
		stringBuilder.append(buildGanttChartLine(length, "", "__", "___", "__", "_"));
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String:\n" + stringBuilder.toString(), true); }
		// ===========================================
		/*--------------------------------------------
		 * Second Row
		 --------------------------------------------*/
		stringBuilder.append(buildGanttChartLine(length, "|", "  ", "  ", "  ", "|"));
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String:\n" + stringBuilder.toString(), true); }
		// ===========================================
		/*--------------------------------------------
		 * Third Row
		 --------------------------------------------*/
		for (int i = 0; i < length; i++) {
			stringBuilder.append("|");
			burstTime = processes.get(i).getBurstTime();
			for (int j = 0; j < burstTime; j++) { stringBuilder.append("  "); }
			stringBuilder.append(" P" + (i + 1) + " ");
			for (int j = 0; j < burstTime; j++) { stringBuilder.append("  "); }
		}
		stringBuilder.append("|"); // Line End

		// Line Break
		stringBuilder.append("\n");
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String:\n" + stringBuilder.toString(), true); }
		// ===========================================
		/*--------------------------------------------
		 * Fourth Row
		 --------------------------------------------*/
		stringBuilder.append(buildGanttChartLine(length, "|", "__", "__", "__", "|"));
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String:\n" + stringBuilder.toString(), true); }
		// ===========================================
		/*--------------------------------------------
		 * Fifth Row
		 --------------------------------------------*/
		burstTime = 0;
		stringBuilder.append(burstTime);
		for (int i = 0; i < length; i++) {
			burstTime = processes.get(i).getBurstTime();
			count += burstTime;
			for (int j = 0; j < burstTime; j++) { stringBuilder.append("  "); }
			stringBuilder.append("    ");
			
			// Add 1 whitespace less if count is greater than 9:
			if(count < 10) {
				for (int j = 0; j < burstTime; j++) {
					stringBuilder.append("  ");
				}
			} else {
				for (int j = 1; j < burstTime; j++) {
					stringBuilder.append("  ");
				}
				stringBuilder.append(" ");
			}
			stringBuilder.append(count);
		}

		// Line Break
		stringBuilder.append("\n");
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Current String:\n" + stringBuilder.toString(), true); }
		// ===========================================
		System.out.print(stringBuilder.toString());
	}
	
	private StringBuilder buildGanttChartLine(int length, String first, String second, String third, String fourth, String fifth) {
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Building Gantt Chart Row...", true); }
		// ===========================================
		StringBuilder stringBuilder = new StringBuilder();
		int burstTime = 0;
		for (int i = 0; i < length; i++) {
			stringBuilder.append(first);
			burstTime = processes.get(i).getBurstTime();
			for (int j = 0; j <= burstTime; j++) { stringBuilder.append(second); }
			stringBuilder.append(third);
			for (int j = 0; j < burstTime; j++) { stringBuilder.append(fourth); }
		}
		stringBuilder.append(fifth);
		stringBuilder.append("\n"); // Line Break.
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Gantt Chart Row Built", true); }
		// ===========================================
		return stringBuilder;
	}
	
	private ArrayList<Process> sortProcesses(ArrayList<Process> processesArrayList) {
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Sorting Processes...", true); }
		// ===========================================
		Collections.sort(processesArrayList, new Comparator<Process>() {

			@Override
			public int compare(Process o1, Process o2) {
				// TODO Auto-generated method stub
				return o1.getArrivalTime() - o2.getArrivalTime();
			}
		});
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Processes Sorted", true); }
		// ===========================================
		
		return processesArrayList;
	}
	
	private StringBuilder buildTableOfStrings(ArrayList<String> strings, int columns, int width) {
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Building Table Of Strings...", true); }
		// ===========================================
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < columns; i++) {
			stringBuilder.append("|");
			
			int length = strings.get(i).length();
			if(length != width) {
				for (int j = 0; j < width - length; j++) {
					stringBuilder.append(" ");
					if((j == ((width - length) / 2) - 1)) {
						// ================ Debugging ================
						if(isDebugMode) { debugMessage("((width - length) / 2) - 1): " + j, true); }
						// ===========================================
						stringBuilder.append(strings.get(i));
					}
				}
				
			} else {
				// ================ Debugging ================
				if(isDebugMode) { debugMessage("Lenght of String equals Width of Columns", true); }
				// ===========================================
				stringBuilder.append(strings.get(i));
			}
		}
		// ================ Debugging ================
		if(isDebugMode) { debugMessage("Table Of Strings Built", true); }
		// ===========================================
		return stringBuilder.append("|");
	}
	
	private void debugMessage(String message, boolean showTime) {
		StringBuilder stringBuilder = new StringBuilder();
		if(showTime) { 
			stringBuilder.append("[" + getCurrentTime() + "]"); 
		}
		stringBuilder.append("[Debug Mode] " + message);
		System.out.println(stringBuilder.toString());
	}
	
	private String getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}
}
