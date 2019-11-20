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
	
	// New Fields:
	private Thread activeThread;
	
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

	/*
	 * Start of Implementation:
	 */
	
	/**
	 * Check if the Thread checked is the current Active Thread.
	 * @param activeThread
	 * @return true if the Thread checked is the current Active Thread.
	 * @version 2.0
	 * @author cusatelli
	 */
	public boolean isActiveThread(Thread activeThread) {
		if(this.activeThread == activeThread) { return true; }
		else { return false; }
	}
	
	private synchronized boolean isLocked() {
		if(!Thread.holdsLock(activeThread)) {
			activeThread = Thread.currentThread();
			Thread.holdsLock(activeThread);
			return true;
		} else if(Thread.holdsLock(activeThread)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * If Active Thread is set not locked, set it to the current Active Thread, set Active thread to locked & return true.
	 * else if the active thread is already locked return true also.
	 * If none of the above return false.<br>
	 * The active thread represents in this case if the Chopsticks have been picked up or not.
	 * @return True if Active Thread is activeThread.
	 * @version 2.0
	 * @author cusatelli
	 */
	public synchronized boolean pickUp() {
		if(!Thread.holdsLock(activeThread)) {
			activeThread = Thread.currentThread();
			((Lock) activeThread).lock();
			return true;
		} else if(Thread.holdsLock(activeThread)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Once this method is called unlock the activeThread & set it to null so
	 * it no longer represents holding the chopsticks.
	 * @version 2.0
	 * @author cusatelli
	 */
	public synchronized void putDown() {
		if(Thread.holdsLock(activeThread)) {
			((Lock) activeThread).unlock();
			activeThread = null;
		}
	}
	/*
	 * End of Implementation.
	 */
}

