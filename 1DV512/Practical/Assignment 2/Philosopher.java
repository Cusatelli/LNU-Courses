
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
	private double startTime; // To save the start time of time to be spent eating.
	private int randomTime; // Only a field because I'm using a state manager & would like to avoid using it as an in parameter in the method.
	private boolean chopsticksAvailable; // To keep track of chopsticks to prevent DEADLOCKS
	private final int randomGeneratorValue = 1000; // Random Generator value should be the same in all thus a field for this is appropriate!
	
	/**
	 * An <i>Enumeration</i> of the possible <b>States</b> a Philosopher can have during runtime.
	 * @version 1.0
	 * @author cusatelli
	 */
	private enum State { THINK, HUNGRY, EAT, DEADLOCK; }
	
	public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick, int seed, boolean debug) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		DEBUG = debug;
		randomGenerator.setSeed(id + seed);
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
	public double getTotalThinkingTime() 	{ return thinkingTime; 		}
	public double getTotalEatingTime() 	{ return eatingTime; 		}
	public double getTotalHungryTime() 	{ return hungryTime; 		}
	
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
		while(!Thread.currentThread().isInterrupted()) {
			try {
				while (!Thread.currentThread().isInterrupted()) {
					StateManager(State.THINK); // Set Philosopher state to THINK!
					StateManager(State.HUNGRY); // Set Philosopher state to HUNGRY!
					StateManager(State.DEADLOCK); // Set Philosopher state to DEADLOCK 
												  // & check if there is any deadlocks before proceeding to EATING.
					/*
					 * Get current time to calculate the time philosopher was hungry
					 * compared with the start time:
					 */
					hungryTime += System.currentTimeMillis() - startTime;
				}
			} catch (InterruptedException e) { Thread.currentThread().interrupt(); }
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
		switch(state) {
		/*
		 * Thinking acts as a break period for the actor which it simply does nothing other than wait.
		 */
		case THINK:
            		numberOfThinkingTurns++; // Increment Turns.
            		randomTime = getRandom(); // Calculate Random Time...
            		Thread.sleep(randomTime); // Sleep for Random Time (Which is the same as spending time Thinking).
           	 	thinkingTime += randomTime; // Add the new Random Time to Thinking Time.
			if(DEBUG) { System.out.println("[ Philosopher: " + getId() + " ] is Thinking..."); }
			break;
			
		/*
		 * Hungry is the state where the actor is waiting for available ChopSticks
		 * From its previous actor.
		 */
		case HUNGRY:
			numberOfHungryTurns++; // Increment Turns.
            		startTime = System.currentTimeMillis(); // Save start Time of Hunger for later calculations.
			if(DEBUG) { System.out.println("[ Philosopher: " + getId() + " ] is Hungry!"); }
			break;
			
		/*
		 * Eating is the state where the actor busy with both ChopSticks &
		 * during this time it will simply hold these ChopSticks for a random
		 * amount of time. After which the actor will release the ChopSticks for the 
		 * next actor to use.
		 */
		case EAT:
			numberOfEatingTurns++; // Increment Turns.
			randomTime = getRandom(); // Calculate Random Time...
			
			if(DEBUG) { System.out.println("[ Philosopher: " + getId() + " ] is Eating."); }
			Thread.sleep(randomTime); // Sleep for Random Time (Which is the same as spending time Eating).
			eatingTime += randomTime;
			
			/*
			 * When Philosopher is no longer eating put left chopstick down and make it free.
			 */
			leftChopstick.putdown();
			if(DEBUG) { System.out.println("[ Philosopher: " + getId() + " ] put down  [ Left  Chopstick: " + leftChopstick.getId() + " ]"); }

			/*
			 * When Philosopher is no longer eating put right chopstick down and make it free.
			 */
			rightChopstick.putdown();
			if(DEBUG) { System.out.println("[ Philosopher: " + getId() + " ] put down  [ Right Chopstick: " + rightChopstick.getId() + " ]"); }
			return; // Return to DEADLOCK state where it will break back to run().
		
		/*
		 *  Reslove Deadlocks:
		 *  Pick up Chopsticks (Beginning with left) & proceed to eat. However if there is a deadlock
		 *  then put down said left chopstick again & proceed to the next stage (Which is the next philosopher) 
		 *  & repeat all steps previously, until one philosopher can eat.
		 */
		case DEADLOCK:
			chopsticksAvailable = true;
            while (!Thread.currentThread().isInterrupted() && chopsticksAvailable) {

		/*
		 * If left chopstick is free we pick it up.
		 */
            	if (leftChopstick.pickup()) {
            		if(DEBUG) { System.out.println("[ Philosopher: " + getId() + " ] picked up [ Left  Chopstick: " + leftChopstick.getId() + " ]"); }
            		
            		/*
            		 * If right chopstick is free we pick it up.
            		 */
                    	if (rightChopstick.pickup()) {
				if(DEBUG) { System.out.println("[ Philosopher: " + getId() + " ] picked up [ Right Chopstick: " + rightChopstick.getId() + " ]"); }                        chopsticksAvailable = false;
                        
			/*
			 * Set Philosopher State to EAT & then return here so it can be properly 
			 * contained within these if statements. This state could've been within
			 * the while-loop of run() also, however that would leave the DEADLOCK state
			 * useless & all the if-statements would be contained within run() as well.
			 */
                        StateManager(State.EAT); // Set Philosopher state to EAT!
                        
                    } else {
                    	leftChopstick.putdown();
                    	if(DEBUG) { System.out.println("[ DEADLOCK ][ Philosopher: " + getId() + " ] put down  [ Left  Chopstick: " + leftChopstick.getId() + " ]"); }
                    }        
                }
            }
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
//			Thread.currentThread().interrupt();
			System.exit(0); // Terminate application...
		}
	}
	
	/**
	 * Generate a random Integer value using randomGenerator field as Random generator.
	 * @return a random integer value between 0 - <b>value</b>
	 * @version 2.0
	 * @author cusatelli
	 */
	private int getRandom() { return randomGenerator.nextInt(randomGeneratorValue); }
	
	/**
	 * If the Terminate method is called the terminate field will be 
	 * set to true and the while-loop in run will exit.
	 * @version 2.0
	 * @author cusatelli
	 */
	public void terminate() { 
		terminate = true;
		if(DEBUG) { System.out.println("[ Philosopher: " + getId() + " ] has been Terminated!"); }
	}
}
