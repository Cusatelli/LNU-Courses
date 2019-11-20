package assignment_2;
/*
 * File:	Philosopher.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti (modified by Kostiantyn Kucher)
 * Date: 	November 2019
 */

import java.util.Random;

import assist.util.Debug;
import assist.util.Error;
import assist.util.Time;
import jdk.tools.jlink.internal.plugins.ReleaseInfoPlugin;

/**
 * The skeleton is created by <i>Suejb Memeti</i> & modified by <i>Kostiantyn Kucher</i>.
 * <br>Though the Implementation is done by <i>Cusatelli</i>.
 * @version 1.0
 * @author cusatelli
 */
public class Philosopher implements Runnable {
	
	/*
	 * Controls whether logs should be shown on the console or not.
	 * Logs should print events such as: state of the philosopher, and state of the chopstick
	 * 		for example: philosopher # is eating;
	 * 		philosopher # picked up the left chopstick (chopstick #)
	 */
	public boolean DEBUG = false;
	
	private int id;
	
	private final Chopstick leftChopstick;
	private final Chopstick rightChopstick;
	
	private Random randomGenerator = new Random();
	
	private int numberOfEatingTurns = 0;
	private int numberOfThinkingTurns = 0;
	private int numberOfHungryTurns = 0;

	private double thinkingTime = 0;
	private double eatingTime = 0;
	private double hungryTime = 0;
	
	// Add New Fields here:
	// Variables to save in field for use in run().
	private Thread activeThread; // For example use thread_01 when determining the active thread.
	private long startTime;
	private long waitingTime;
	private States state;
	
	private int milliseconds_Max = 1000; // Set the max amount of milliseconds in the field for easy access.
	
	/**
	 * An <i>Enumeration</i> of the possible <b>States</b> a Philosopher can have during runtime.
	 * @version 1.0
	 * @author cusatelli
	 */
	public enum States {
		THINKING,
		HUNGRY,
		EATING;
	}
	
	/**
	 * The <b>State Manager</b> takes in a state parameter and with a switch case<br>
	 * it determines which actions to perform.<br><br>
	 * <b>Example:</b> <i>State THINKING: increments Turns, sleeps for random time,<br>
	 * sets new current State to HUNGRY & breaks switch case.</i><br><br>
	 * <b>Inspired by:</b><br>SharpAccents Unity & C# Tutorials on 
	 * <a href="https://sharpaccent.com/?c=course&id=14">SharpAccent.com</a>
	 * 
	 * @param state
	 * @version 2.0
	 * @author cusatelli
	 * @throws InterruptedException
	 */
	public void StateManager(States state) throws InterruptedException {
		switch(state) {
		/*
		 * Thinking acts as a break period for the actor which it simply does nothing other than wait.
		 */
		case THINKING:
			Debug.println("[Before] Number of Thinking Turns: " + numberOfThinkingTurns);
			numberOfThinkingTurns++; // Increment Number of Turns Spent Thinking.
			Debug.println("[After] Number of Thinking Turns: " + numberOfThinkingTurns);
			
			Debug.println("[Before] Sleeping...");
			Thread.sleep(1000); // Wait for random time.
			Debug.println("[After] Sleep Finished.");
			
			Debug.println("[Before] Thinking Time: " + thinkingTime);
			thinkingTime += 1000; // Increment Thinking Time by how long is spent in Thinking Time.
			Debug.println("[After] Thinking Time: " + thinkingTime);
			
			Debug.println("[Before] Current State: " + state);
			state = States.HUNGRY; // Switch State to HUNGRY.
			Debug.println("[After] Current State: " + state);
			
			break; // Break otherwise it continues to "case HUNGRY:"
			
		/*
		 * Hungry is the state where the actor is waiting for available ChopSticks
		 * From its previous actor.
		 * 
		 * TODO: Add more description of function
		 */
		case HUNGRY:
			Debug.println("[Before] Number of Hungry Turns: " + numberOfHungryTurns);
			numberOfHungryTurns++; // Increment Number of Turns Spent Hungry.
			Debug.println("[After] Number of Hungry Turns: " + numberOfHungryTurns);
			
			Debug.println("[Before] Checking Chopsticks...");
			checkChopSticks(leftChopstick, rightChopstick); // Check if any of the Chopsticks is available.
			Debug.println("[After] Check Chopsticks Finished.");
			
			Debug.println("[Before] Wating Time: " + waitingTime);
			waitingTime = System.currentTimeMillis() - startTime; // Register how long time has passed since start.
			Debug.println("[After] Wating Time: " + waitingTime);
			
			Debug.println("[Before] Hungry Time: " + hungryTime);
			hungryTime += waitingTime; // Add waiting time (since start) to hungry time.
			Debug.println("[After] Hungry Time: " + hungryTime);
			
			Debug.println("[Before] Current State: " + state);
			state = States.EATING; // Switch state to eating once all chopsticks are in hand.
			Debug.println("[After] Current State: " + state);
			
			break; // Break otherwise it continues to "case EATING:"
			
		/*
		 * Eating is the state where the actor busy with both ChopSticks &
		 * during this time it will simply hold these ChopSticks for a random
		 * amount of time. After which the actor will release the ChopSticks for the 
		 * next actor to use.
		 */
		case EATING:
			Debug.println("[Before] Number of Eating Turns: " + numberOfEatingTurns);
			numberOfEatingTurns++; // Increment Number of Turns Spent Eating.
			Debug.println("[After] Number of Eating Turns: " + numberOfEatingTurns);
			
			Debug.println("[Before] Eating...");
			Thread.sleep(1000);
			Debug.println("[After] Finished Eating.");
			
			Debug.println("[Before] Putting Down Chopsticks...");
			Debug.println("[Before] Putting Down Left Chopstick...");
			leftChopstick.putDown();
			Debug.println("[After] Put Down Left Chopstick.");
			Debug.println("[Before] Putting Down Right Chopstick...");
			rightChopstick.putDown();
			Debug.println("[After] Put Down Right Chopstick.");
			Debug.println("[After] Put Down Chopsticks.");
			
			Debug.println("[Before] Eating Time: " + eatingTime);
			eatingTime += waitingTime; // Add waiting time (since start) to eating time.
			Debug.println("[After] Eating Time: " + eatingTime);
			
			Debug.println("[Before] Current State: " + state);
			state = States.THINKING; // Switch state to thinking.
			Debug.println("[After] Current State: " + state);
			
			break; // Break otherwise it continues to "case default:"
			
		/*
		 * In case none of the States match with the States presented in the Enumeration
		 * print Error message and terminate the application...
		 */
		default:
			Error.println("Something went wrong! Current State did not match!");
			Error.terminate();
			break;
		}
	}
	
	/**
	 * <b>StateManager</b> determines which action to take whenever 
	 * a Philosopher is in a particular state.
	 * @param
	 * @return <b>String</b> of Philosophers current <b>state</b>
	 * @version 1.0
	 * @author cusatelli
	 */
	public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick, int seed, boolean debug) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		
		this.DEBUG = debug;
		
		/*
		 * set the seed for this philosopher. To differentiate the seed from the other philosophers, we add the philosopher id to the seed.
		 * the seed makes sure that the random numbers are the same every time the application is executed
		 * the random number is not the same between multiple calls within the same program execution 
		 
		 * NOTE
		 * In order to get the same average values use the seed 100, and set the id of the philosopher starting from 0 to 4 (0,1,2,3,4). 
		 * Each philosopher sets the seed to the random number generator as seed+id. 
		 * The seed for each philosopher is as follows:
		 * 	 	P0.seed = 100 + P0.id = 100 + 0 = 100
		 * 		P1.seed = 100 + P1.id = 100 + 1 = 101
		 * 		P2.seed = 100 + P2.id = 100 + 2 = 102
		 * 		P3.seed = 100 + P3.id = 100 + 3 = 103
		 * 		P4.seed = 100 + P4.id = 100 + 4 = 104
		 * Therefore, if the ids of the philosophers are not 0,1,2,3,4 then different random numbers will be generated.
		 */
		
		randomGenerator.setSeed(id+seed);
	}
	public int getId() {
		return id;
	}
	
	/**
	 * Divide Thinking Time with Number Of Thinking Turns = Average Thinking Time.
	 * @return <b>double:</b> Average Thinking Time
	 * @version 1.0
	 * @author cusatelli
	 */
	public double getAverageThinkingTime() {
		/* TODO
		 * Return the average thinking time
		 * Add comprehensive comments to explain your implementation
		 */
		return thinkingTime / numberOfThinkingTurns;
	}
	
	/**
	 * Divide Eating Time with Number Of Eating Turns = Average Eating Time.
	 * @return <b>double:</b> Average Eating Time
	 * @version 1.0
	 * @author cusatelli
	 */
	public double getAverageEatingTime() {
		/* TODO
		 * Return the average eating time
		 * Add comprehensive comments to explain your implementation
		 */
		return eatingTime / numberOfEatingTurns;
	}
	
	/**
	 * Divide Hungry Time with Number Of Hungry Turns = Average Hungry Time.
	 * @return <b>double:</b> Average Hungry Time
	 * @version 1.0
	 * @author cusatelli
	 */
	public double getAverageHungryTime() {
		/* TODO
		 * Return the average hungry time
		 * Add comprehensive comments to explain your implementation
		 */
		return hungryTime / numberOfHungryTurns;
	}
	
	public int getNumberOfThinkingTurns() {
		return numberOfThinkingTurns;
	}
	
	public int getNumberOfEatingTurns() {
		return numberOfEatingTurns;
	}
	
	public int getNumberOfHungryTurns() {
		return numberOfHungryTurns;
	}

	public double getTotalThinkingTime() {
		return thinkingTime;
	}

	public double getTotalEatingTime() {
		return eatingTime;
	}

	public double getTotalHungryTime() {
		return hungryTime;
	}

	@Override
	public void run() {
		/* TODO
		 * (Initialize some additional variables, if necessary) 
		 * 
		 * Think,
		 * Get hungry,
		 * Pick up the left and then the right chopstick,
		 * Eat,
		 * Release the chopsticks.
		 * ^^^ Repeat until the thread is interrupted 
		 * 		 
		 * Increment the thinking/hungry/eating turns counter *when each turn starts*.
		 * 
		 * Update the duration of each turn *after the turn is completely finished*.
		 * Keep track of total hungry turn durations by getting the current timestamp with System.currentTimeMillis()
		 * when the turn starts, then another System.currentTimeMillis() after the turn has finished, and subtracting these. 
		 * For thinking and eating turns, use the duration generated with randomGenerator.nextInt(1000).
		 * 
		 * If DEBUG is true, print the log messages for each event.
		 * Additionally, you might want to print a message such as "philosopher X has finished" when the thread terminates
		 * (for debugging purposes).
		 * 
		 * 
		 * Add comprehensive comments to explain your implementation, including deadlock prevention/detection.
		 * You should start with a straightforward implementation, but you will eventually have to make it more sophisticated
		 * w.r.t the order (and conditions) of the actions and the threads synchronization in order to pass the tests with the expected results!
		 */
		
		start(); // Initialize Variables.
		Debug.println("[After] Start Finished.");

		Debug.println("[Before] While Active Thread.");
		while(!isInterrupted(activeThread)) {
			Debug.println("[Before] Randomly Generated Waiting Time: " + waitingTime);
			// Get random integer which will be used to determine waiting time in milliseconds
			waitingTime = randomGenerator.nextInt(milliseconds_Max) + 1;
			Debug.println("[After] Randomly Generated Waiting Time: " + waitingTime);
			Debug.println("[Before] Systems current Time in milliseconds: " + startTime);
			startTime = System.currentTimeMillis(); // Set the Start Time as the systems current Time. (in Milliseconds)
			Debug.println("[After] Systems current Time in milliseconds: " + startTime);
			
			// Handle States through the State Manager:
			try {
				Debug.println("[Before] Manage State: " + state);
				StateManager(state); 
				Debug.println("[After] Manage State: " + state);
			}
			catch (InterruptedException e) { 
				Error.println("Could not check States!");
				Error.terminate();
			}
		}
		Debug.println("[After] While Active Thread.");
	}
	
	/**
	 * Initialize all Variables before run() in start().<br>
	 * This is to keep run() as clean as possible.
	 * 
	 * @author cusatelli
	 */
	void start() {
		// Initialize Variables:
		if(DEBUG) { 
			Debug.True();
			Time.Show();
		} else { Debug.False(); } // Set debug mode to true or false.
		Debug.println("Debugging Mode Started...");
		
		Debug.println("[Before] Setting Variables - State:" + state + " - startTime: " + startTime + " - Thread: " + activeThread);
		state = States.THINKING; // Set Starting State to THINKING.
		startTime = 0; // Set Starting Time to 0.
		activeThread = Thread.currentThread(); // Set thread_01 to the current Thread.
		Debug.println("[After] Setting Variables - State:" + state + " - startTime: " + startTime + " - Thread: " + activeThread);
	}
	
	/**
	 * Check if Thread was ever interrupted & if so return this value.<br>
	 * This method serves only as a purpose to confirm the<br>
	 * Interruption of a Thread during DEBUG mode.
	 * 
	 * @param thread
	 * @return true if Thread was interrupted, otherwise false
	 * @author cusatelli
	 */
	boolean isInterrupted(Thread thread) {
		if(thread.interrupted()) {
			Debug.println("Thread: " + thread + "\n    was interrupted");
			return true;
		
		} else {
			Debug.println("Thread: " + thread + "\n    wasn't interrupted");
			return false;
		}
	}
	
	void checkChopSticks(Chopstick left, Chopstick right) {
		Debug.println("Initiated Chopsticks...");
		try {
			while(!left.isActiveThread(activeThread) && !right.isActiveThread(activeThread)) {
				Debug.println("Checking while Chopsticks isn't active Thread...");
				while(!left.pickUp()) {
					Debug.println("Left Chopstick isn't picked up! Sleeping...");
					Thread.sleep(5);
					Debug.println("Sleeping Finished.");
				}
				Debug.println("Left Chopstick is picked up!");
				while(right.pickUp()) { 
					Debug.println("Right Chopstick isn't picked up! Sleeping...");
					Thread.sleep(5);
					Debug.println("Sleeping Finished."); 
				}
				Debug.println("Right Chopstick is picked up!");
			}
		} catch (InterruptedException error) { 
			Error.println("Could not check Chopsticks!");
			Error.terminate();
		}
		Debug.println("Chopsticks Finished.");
	}
	
}
