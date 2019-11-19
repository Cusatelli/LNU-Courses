package assignment_2;
/*
 * File:	Chopstick.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti (modified by Kostiantyn Kucher)
 * Date: 	November 2019
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private final int id;
	private Lock myLock = new ReentrantLock();
	
	public Chopstick(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public Lock getLock() {
		return myLock;
	}
	
	/* TODO
	 * Implement the pickup and put down chopstick logic in the Philosopher.run() method.
	 * Please note that the same chopstick can not be picked up by more than one philosopher at a time.
	 * Use the myLock to lock this chopstick. Print the logs only when the lock has been acquired. 
	 * The myLock.tryLock() method provides a boolean value indicating whether the lock was acquired or not.
	 * Further documentation: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReentrantLock.html#tryLock()
	 */
}

