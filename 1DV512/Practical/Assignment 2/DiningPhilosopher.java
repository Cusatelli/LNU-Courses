
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

/**
 * The skeleton is created by <i>Suejb Memeti</i> & modified by <i>Kostiantyn Kucher</i>.
 * <br>Though the Implementation is done by <i>Cusatelli</i>.
 * <br><br>
 * The DiningPhilosopher.java class Initializes the Philosophers and Chopsticks 
 * which will be used within Philosopher.java. It also exits the System once 
 * the Simulation time has ended.
 * @version 2.0
 * @author cusatelli
 */
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
	 * @throws InterruptedException
	 * @version 2.0
	 * @author Implementation -> cusatelli
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

			if (DEBUG) { System.out.println("\n>>> Asking all philosophers to stop\n"); }
			
			/*
			 *  Terminate all threads whenever SIMULATION_TIME has ended.
			 *  the .terminate() method sets the boolean field 'terminate' to false
			 *  which in turn lets the run() methods while-loop know that it should no
			 *  longer execute.
			 */
			for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) { philosophers.get(i).terminate(); }

		} finally {
			executorService.shutdown();
			executorService.awaitTermination(10, TimeUnit.MILLISECONDS);
		}
	}

	public void initialize(int simulationTime, int randomSeed) {
		SIMULATION_TIME = simulationTime;
		SEED = randomSeed;

		philosophers = new ArrayList<Philosopher>(NUMBER_OF_PHILOSOPHERS);
		chopsticks = new ArrayList<Chopstick>(NUMBER_OF_PHILOSOPHERS);

		//create the executor service
		executorService = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);

		/*
		 *  Add Chopsticks:
		 */
		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) { chopsticks.add(new Chopstick(i)); }
		
		/*
		 *  Add Philosopher to Philosophers:
		 */
		for (int i = 1; i <= NUMBER_OF_PHILOSOPHERS; i++) {
			Philosopher philosopher; // Philosopher...
			/*
			 *  Assign the corresponding Philosopher to Philosophers list:
			 */
			if(i == NUMBER_OF_PHILOSOPHERS) { philosopher = new Philosopher(i - 1, chopsticks.get(0), chopsticks.get(i - 1), randomSeed, DEBUG); }
			else { philosopher = new Philosopher(i - 1, chopsticks.get(i), chopsticks.get(i - 1), randomSeed, DEBUG); }
			
			philosophers.add(philosopher);
		}
	}

	public ArrayList<Philosopher> getPhilosophers() { return philosophers; }

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
