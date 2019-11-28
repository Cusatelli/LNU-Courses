
/*
 * File:	FCFSTest.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti
 * Date: 	November, 2018
 */

import static org.junit.Assert.*;

import java.util.ArrayList;


public class FCFSTest {

	@org.junit.Test
	public void test1() {
		ArrayList<Process> listOfProcesses = new ArrayList<Process>();

		//expected results
		int[] processIds = new int[]{1, 2, 3};
		int[] processCT  = new int[]{2, 4, 11};
		int[] processTAT = new int[]{2, 1, 6};
		int[] processWT  = new int[]{0, 0, 0};

		//list of processes to be scheduled
		//the first method parameter is the process id
		//the second method parameter is the arrival time
		//the third method parameter is the burst time
		listOfProcesses.add(new Process(1, 0, 2));
		listOfProcesses.add(new Process(2, 3, 1));
		listOfProcesses.add(new Process(3, 5, 6));

		FCFS myFcfs = new FCFS(listOfProcesses);
		myFcfs.run();

		for (int i = 0; i < listOfProcesses.size(); i++) {
			assertEquals(processIds[i], listOfProcesses.get(i).getProcessId());
			assertEquals(processCT[i], listOfProcesses.get(i).getCompletedTime());
			assertEquals(processTAT[i], listOfProcesses.get(i).getTurnaroundTime());
			assertEquals(processWT[i], listOfProcesses.get(i).getWaitingTime());
		}
	}

	@org.junit.Test
	public void test2() {
		ArrayList<Process> listOfProcesses = new ArrayList<Process>();

		listOfProcesses.add(new Process(1, 0, 4));
		listOfProcesses.add(new Process(2, 1, 3));
		listOfProcesses.add(new Process(3, 2, 1));
		listOfProcesses.add(new Process(4, 3, 2));
		listOfProcesses.add(new Process(5, 4, 5));

		int[] processIds = new int[]{1, 2, 3, 4, 5};
		int[] processCT  = new int[]{4, 7, 8, 10, 15};
		int[] processTAT = new int[]{4, 6, 6, 7, 11};
		int[] processWT  = new int[]{0, 3, 5, 5, 6};


		FCFS myFcfs = new FCFS(listOfProcesses);
		myFcfs.run();

		for (int i = 0; i < listOfProcesses.size(); i++) {
			assertEquals(processIds[i], listOfProcesses.get(i).getProcessId());
			assertEquals(processCT[i], listOfProcesses.get(i).getCompletedTime());
			assertEquals(processTAT[i], listOfProcesses.get(i).getTurnaroundTime());
			assertEquals(processWT[i], listOfProcesses.get(i).getWaitingTime());
		}
	}

	@org.junit.Test
	public void test3() {
		ArrayList<Process> listOfProcesses = new ArrayList<Process>();

		listOfProcesses.add(new Process(1, 0, 4));
		listOfProcesses.add(new Process(2, 2, 3));
		listOfProcesses.add(new Process(3, 1, 1));
		listOfProcesses.add(new Process(4, 3, 2));
		listOfProcesses.add(new Process(5, 4, 5));

		int[] processIds = new int[]{1, 3, 2, 4, 5};
		int[] processCT  = new int[]{4, 5, 8, 10, 15};
		int[] processTAT = new int[]{4, 4, 6, 7, 11};
		int[] processWT  = new int[]{0, 3, 3, 5, 6};


		FCFS myFcfs = new FCFS(listOfProcesses);
		myFcfs.run();

		for (int i = 0; i < listOfProcesses.size(); i++) {
			assertEquals(processIds[i], listOfProcesses.get(i).getProcessId());
			assertEquals(processCT[i], listOfProcesses.get(i).getCompletedTime());
			assertEquals(processTAT[i], listOfProcesses.get(i).getTurnaroundTime());
			assertEquals(processWT[i], listOfProcesses.get(i).getWaitingTime());
		}
	}

	@org.junit.Test
	public void test4() {
		ArrayList<Process> listOfProcesses = new ArrayList<Process>();

		listOfProcesses.add(new Process(1, 0, 18));
		listOfProcesses.add(new Process(2, 0, 5));
		listOfProcesses.add(new Process(3, 0, 7));


		int[] processIds = new int[]{1, 2, 3};
		int[] processCT  = new int[]{18, 23, 30};
		int[] processTAT = new int[]{18, 23, 30};
		int[] processWT  = new int[]{0, 18, 23};


		FCFS myFcfs = new FCFS(listOfProcesses);
		myFcfs.run();

		for (int i = 0; i < listOfProcesses.size(); i++) {
			assertEquals(processIds[i], listOfProcesses.get(i).getProcessId());
			assertEquals(processCT[i], listOfProcesses.get(i).getCompletedTime());
			assertEquals(processTAT[i], listOfProcesses.get(i).getTurnaroundTime());
			assertEquals(processWT[i], listOfProcesses.get(i).getWaitingTime());
		}
	}

	@org.junit.Test
	public void test5() {
		ArrayList<Process> listOfProcesses = new ArrayList<Process>();

		listOfProcesses.add(new Process(1, 0, 18));
		listOfProcesses.add(new Process(2, 3, 2));
		listOfProcesses.add(new Process(3, 25, 5));
		listOfProcesses.add(new Process(4, 29, 2));
		listOfProcesses.add(new Process(5, 33, 7));


		int[] processIds = new int[]{1, 2, 3, 4, 5};
		int[] processCT  = new int[]{18, 20, 30, 32, 40};
		int[] processTAT = new int[]{18, 17, 5, 3, 7};
		int[] processWT  = new int[]{0, 15, 0, 1, 0};


		FCFS myFcfs = new FCFS(listOfProcesses);
		myFcfs.run();

		for (int i = 0; i < listOfProcesses.size(); i++) {
			assertEquals(processIds[i], listOfProcesses.get(i).getProcessId());
			assertEquals(processCT[i], listOfProcesses.get(i).getCompletedTime());
			assertEquals(processTAT[i], listOfProcesses.get(i).getTurnaroundTime());
			assertEquals(processWT[i], listOfProcesses.get(i).getWaitingTime());
		}
	}

	@org.junit.Test
	public void test6() {
		ArrayList<Process> listOfProcesses = new ArrayList<Process>();

		//The example from the project description
		listOfProcesses.add(new Process(1, 0, 18));
		listOfProcesses.add(new Process(2, 2, 5));
		listOfProcesses.add(new Process(3, 4, 7));


		int[] processIds = new int[]{1, 2, 3};
		int[] processCT  = new int[]{18, 23, 30};
		int[] processTAT = new int[]{18, 21, 26};
		int[] processWT  = new int[]{0, 16, 19};


		FCFS myFcfs = new FCFS(listOfProcesses);
		myFcfs.run();

		for (int i = 0; i < listOfProcesses.size(); i++) {
			assertEquals(processIds[i], listOfProcesses.get(i).getProcessId());
			assertEquals(processCT[i], listOfProcesses.get(i).getCompletedTime());
			assertEquals(processTAT[i], listOfProcesses.get(i).getTurnaroundTime());
			assertEquals(processWT[i], listOfProcesses.get(i).getWaitingTime());
		}
	}

}
