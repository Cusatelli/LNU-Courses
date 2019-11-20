package assignment_2;
/*
 * File:	DiningPhilosopher.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti (modified by Kostiantyn Kucher)
 * Date: 	November 2019
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import assist.util.Debug;


public class DiningPhilosopher {

	/*
	 * Controls whether logs should be shown on the console or not.
	 * Logs should print events such as: state of the philosopher, and state of the chopstick
	 * 		for example: philosopher # is eating;
	 * 		philosopher # picked up the left chopstick (chopstick #)
	 */
	public boolean DEBUG = false;
	
	private final int NUMBER_OF_PHILOSOPHERS = 5;
	private int SIMULATION_TIME = 10000;
	private int SEED = 0;

	ExecutorService executorService = null;
	ArrayList<Philosopher> philosophers = null;
	ArrayList<Chopstick> chopsticks = null;

	/**
	 * As described in the TODO:<br>
	 * Stopping all philosophers.
	 * After for-loop it terminates immediately.
	 * @version 1.0
	 * @author cusatelli
	 */
	public void start() throws InterruptedException {
		try {
			/*
			 * First we start two non-adjacent threads, which are T1 and T3
			 */
			for (int i = 1; i < NUMBER_OF_PHILOSOPHERS; i+=2) {
				executorService.execute(philosophers.get(i));
				Thread.sleep(50); //makes sure that this thread kicks in before the next one
			}

			/*
			 * Now we start the rest of the threads, which are T0, T2, and T4
			 */
			for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i+=2) {
				executorService.execute(philosophers.get(i));
				Thread.sleep(50); //makes sure that this thread kicks in before the next one
			}

			// Main thread sleeps till time of simulation
			Thread.sleep(SIMULATION_TIME);

			Debug.println(">>> Asking all philosophers to stop\n");
			
			/*
			 * Start of Implementation:
			 */
			long currentTime = System.currentTimeMillis();
			for(long threadSleep = currentTime; (currentTime - threadSleep) < SIMULATION_TIME;) {
				currentTime = System.currentTimeMillis();
				Thread.sleep(5);
			}
			Debug.println("Shutting Down Executor Service Now...");
			executorService.shutdownNow();
			/*
			 * End of Implementation!
			 */
		} finally {
			executorService.shutdown();
			executorService.awaitTermination(10, TimeUnit.MILLISECONDS);
		}
	}
	
	/**
	 * As described in the TODO:<br>
	 * Add new Chopsticks depending on the current number of Philosophers.
	 * Then proceed to add chopsticks as left and right chopsticks. Finally
	 * adding all to philosopher arrayList.
	 * @param simulationTime
	 * @param randomSeed
	 * @version 2.0
	 * @author cusatelli
	 */
	public void initialize(int simulationTime, int randomSeed) {
		SIMULATION_TIME = simulationTime;
		SEED = randomSeed;

		philosophers = new ArrayList<Philosopher>(NUMBER_OF_PHILOSOPHERS);
		chopsticks = new ArrayList<Chopstick>(NUMBER_OF_PHILOSOPHERS);

		//create the executor service
		executorService = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);

		/*
		 * Start of Implementation:
		 */
		// Add new Chopsticks depending on the number of Philosophers:
		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
			chopsticks.add(new Chopstick(i)); // New Chopsticks to arraylist
		}
		
		// Create Left & Right chopsticks... Since you need 2 chopsticks to eat.
		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
			// get chopsticks arraylist index i which was just created in the previous for-loop:
			Chopstick leftChopstick = chopsticks.get(i);
			int index = 0;
			// if not the last iteration set index = i + 1... If it's the last iteration it will case an 
			// out of range Exception without this if statement.
			if(i < NUMBER_OF_PHILOSOPHERS - 1) { index = i + 1; }
			// get chopsticks arraylist index index which was just created in the previous for-loop:
			Chopstick rightChopstick = chopsticks.get(index);
			// Add Philosophers to philosophers arraylist, with new chopsticks:
			philosophers.add(new Philosopher(i, leftChopstick, rightChopstick, SEED, DEBUG));
		}
		/*
		 * End of Implementation.
		 */
	}

	public ArrayList<Philosopher> getPhilosophers() {
		return philosophers;
	}

	/*
	 * The following code prints a table where each row corresponds to one of the Philosophers,
	 * Columns correspond to the Philosopher ID (PID), average thinking time (ATT), average eating time (AET), average hungry time (AHT), number of thinking turns(#TT), number of eating turns(#ET), and number of hungry turns(#HT).
	 * This table should be printed regardless of the DEBUG value
	 */
	public void printTable() {
		DecimalFormat df2 = new DecimalFormat(".##");
		System.out.println("\n---------------------------------------------------");
		System.out.println("PID \tATT \tAET \tAHT \t#TT \t#ET \t#HT");

		for (Philosopher p : philosophers) {
			System.out.println(p.getId() + "\t"
					+ df2.format(p.getAverageThinkingTime()) + "\t"
					+ df2.format(p.getAverageEatingTime()) + "\t"
					+ df2.format(p.getAverageHungryTime()) + "\t"
					+ p.getNumberOfThinkingTurns() + "\t"
					+ p.getNumberOfEatingTurns() + "\t"
					+ p.getNumberOfHungryTurns() + "\t");
		}

		System.out.println("---------------------------------------------------\n");
	}

}
