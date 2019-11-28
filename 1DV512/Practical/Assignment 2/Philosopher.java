
/*
 * File:	Philosopher.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti (modified by Kostiantyn Kucher)
 * Date: 	November 2019
 */

import java.util.Random;

/**
 * The skeleton is created by <i>Suejb Memeti</i> & modified by <i>Kostiantyn Kucher</i>.
 * <br>Though the Implementation is done by <i>Cusatelli</i>.
 * @version 2.0
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
	
	/* ADDITIONAL FIELDS */
	public volatile boolean terminate = false; // To decide when to end the while-loop in run().
	protected double startTime; // To save the start time of time to be spent eating.
	protected double endTime; // The end time to calculate the time spent eating.
	
	/**
	 * An <i>Enumeration</i> of the possible <b>States</b> a Philosopher can have during runtime.
	 * @version 1.0
	 * @author cusatelli
	 */
	private enum State { THINK, HUNGRY, EAT; }
	
	public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick, int seed, boolean debug) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.DEBUG = debug;
		randomGenerator.setSeed(id+seed);
	}
	
	public int getId() { return id; }

	/**
	 * Divide Thinking Time with Number Of Thinking Turns = Average Thinking Time.
	 * @return <b>double:</b> Average Thinking Time
	 * @version 1.0
	 * @author cusatelli
	 */
	public double getAverageThinkingTime() { return thinkingTime / numberOfThinkingTurns; }
	
	/**
	 * Divide Eating Time with Number Of Eating Turns = Average Eating Time.
	 * @return <b>double:</b> Average Eating Time
	 * @version 1.0
	 * @author cusatelli
	 */
	public double getAverageEatingTime() { return eatingTime / numberOfEatingTurns; }
	
	/**
	 * Divide Hungry Time with Number Of Hungry Turns = Average Hungry Time.
	 * @return <b>double:</b> Average Hungry Time
	 * @version 1.0
	 * @author cusatelli
	 */
	public double getAverageHungryTime() { return hungryTime / numberOfHungryTurns; }
	
	/* 
	 * GETTERS 
	 */
	public int getNumberOfThinkingTurns() 	{ return numberOfThinkingTurns; }
	public int getNumberOfEatingTurns() 	{ return numberOfEatingTurns; 	}
	public int getNumberOfHungryTurns() 	{ return numberOfHungryTurns; 	}
	public double getTotalThinkingTime() 	{ return thinkingTime; 			}
	public double getTotalEatingTime() 		{ return eatingTime; 			}
	public double getTotalHungryTime() 		{ return hungryTime; 			}

	/**
	 * The start() method is initiated before the run() method to set any
	 * variables that needs initializing.
	 * @version 2.0
	 * @author cusatelli
	 */
	private void start() {
		/*
		 *  Set the current system time to keep track of how long has 
		 *  passed since the start of the current state:
		 */
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * @version 2.0
	 * @author cusatelli
	 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReentrantLock.html#getQueueLength()">Resolve Deadlocks with getQueueLength()</a>
	 */
	@Override
	public void run() {
		/*
		 * While the application is running:
		 */
		while(!terminate) {
			start(); // Run start() first...
			try { 
				StateManager(State.THINK);  // Set Philosopher state to THINK!
				StateManager(State.HUNGRY); // Set Philosopher state to HUNGRY!
				
				/*
				 *  Reslove Deadlocks:
				 *  getQueueLength() returns an estimate of the number of threads waiting to acquire this lock. 
				 *  If this value is greater than 0 then we have a deadlock and the system should terminate itself.
				 *  Otherwise we can try to pick up chopsticks.
				 */
				if(leftChopstick.getQueueLength() > 0) { 
					if(DEBUG) { System.out.println("\n[ DEADLOCK DETECTED ]"); }
					System.exit(0); 
				} else {
					/*
					 * If left chopstick is free we pick it up.
					 */
					if(leftChopstick.pickup()) {
						if(DEBUG) { System.out.println("[ Philosopher: " + this.getId() + " ] picked up [ Left  Chopstick: " + leftChopstick.getId() + " ]"); }
						/*
						 * If right chopstick is free we pick it up.
						 */
						if(rightChopstick.pickup()) {
							if(DEBUG) { System.out.println("[ Philosopher: " + this.getId() + " ] picked up [ Right Chopstick: " + rightChopstick.getId() + " ]"); }
						/*
						 * Get current time to calculate the time philosopher was hungry
						 * compared with the start time:
						 */
						endTime = System.currentTimeMillis();
						hungryTime += endTime - startTime; // Calculate the time this Philosopher will spend EATING.
						StateManager(State.EAT); // Philosopher is EATING.
						/*
						 * When Philosopher is no longer eating put right chopstick down and make it free.
						 */
						rightChopstick.putdown();
						if(DEBUG) { System.out.println("[ Philosopher: " + this.getId() + " ] put down  [ Right Chopstick: " + rightChopstick.getId() + " ]"); }
					}
					/*
					 * When Philosopher is no longer eating put left chopstick down and make it free.
					 */
					leftChopstick.putdown();
					if(DEBUG) { System.out.println("[ Philosopher: " + this.getId() + " ] put down  [ Left  Chopstick: " + leftChopstick.getId() + " ]"); }
					}
				}
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
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
	 * @throws InterruptedException
	 * @version 2.0
	 * @author cusatelli
	 */
	private void StateManager(State state) throws InterruptedException {
		int randomTime;
		switch(state) {
		/*
		 * Thinking acts as a break period for the actor which it simply does nothing other than wait.
		 */
		case THINK:
			randomTime = getRandom(1000); // Calculate Random Time...
			thinkingTime += randomTime; // Add the new Random Time to Thinking Time.
			numberOfThinkingTurns++; // Increment Turns.
			if(DEBUG) { System.out.println("[ Philosopher: " + this.getId() + " ] is Thinking..."); }
			Thread.sleep(randomTime); // Sleep for Random Time (Which is the same as spending time Thinking).
			break;
			
		/*
		 * Hungry is the state where the actor is waiting for available ChopSticks
		 * From its previous actor.
		 */
		case HUNGRY:
			numberOfHungryTurns++; // Increment Turns.
			if(DEBUG) { System.out.println("[ Philosopher: " + this.getId() + " ] is Hungry!"); }
			break;
			
		/*
		 * Eating is the state where the actor busy with both ChopSticks &
		 * during this time it will simply hold these ChopSticks for a random
		 * amount of time. After which the actor will release the ChopSticks for the 
		 * next actor to use.
		 */
		case EAT:
			randomTime = getRandom(1000); // Calculate Random Time...
			eatingTime += randomTime; // Add the new Random Time to Eating Time.
			numberOfEatingTurns++; // Increment Turns.
			if(DEBUG) { System.out.println("[ Philosopher: " + this.getId() + " ] is Eating."); }
			Thread.sleep(randomTime); // Sleep for Random Time (Which is the same as spending time Eating).
			break;
			
		/*
		 *  This state should never be called, it is only here as a precaution.
		 *  However, if this state were to be triggered, something has gone wrong and the
		 *  system should terminate itself!
		 */
		default:
			System.err.println("\nOops! Something went wrong in StateManager(State state)!"
					+ "\nDefault Switch Case was called by accident."
					+ "\nPlease make sure you're only calling this method with States contained within the State Manager.");
			System.exit(0); // Terminate application...
		}
	}
	
	/**
	 * Generate a random Integer value using randomGenerator field as Random generator.
	 * @param value
	 * @return a random integer value between 0 - <b>value</b>
	 * @version 2.0
	 * @author cusatelli
	 */
	private int getRandom(int value) { return randomGenerator.nextInt(value); }
	
	/**
	 * If the Terminate method is called the terminate field will be 
	 * set to true and the while-loop in run will exit.
	 * @version 2.0
	 * @author cusatelli
	 */
	public void terminate() { 
		terminate = true;
		if(DEBUG) { System.out.println("[ Philosopher: " + this.getId() + " ] has been Terminated!"); }
	}
}
