
/*
 * File:	Chopstick.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti (modified by Kostiantyn Kucher)
 * Date: 	November 2019
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The skeleton is created by <i>Suejb Memeti</i> & modified by <i>Kostiantyn Kucher</i>.
 * <br>Though the Implementation is done by <i>Cusatelli</i>.
 * <br><br>
 * The Chopstick.java class handles the locking and unlocking of chopsticks which Philosophers 
 * need to eat in DiningPhilosopher.java class. Here we set if a chopstick is being used or not.
 * @version 2.0
 * @author cusatelli
 */
public class Chopstick extends ReentrantLock {

	private static final long serialVersionUID = 1L;
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
	
	/**
	 * The thread waits for a certain time period as defined by arguments of the 
	 * method to acquire the lock on the resource before exiting.
	 *   
	 * @return If the Chopstick is not held by any thread, 
	 * then call to <b>tryLock()</b> returns <b>true</b> and the hold count is incremented by one. 
	 * If the Chopstick is not free then the method returns <b>false</b> 
	 * and the thread is not blocked but it exits.
	 * @throws InterruptedException
	 * @version 2.0
	 * @author cusatelli
	 */
	public boolean pickup() throws InterruptedException { return myLock.tryLock(); } // DEBUG in Philosopher.java
	
	/**
	 * Call to the <b>unlock()</b> method decrements the hold count by 1. 
	 * When this count reaches zero, the Chopstick is released or "put down".
	 * @version 2.0
	 * @author cusatelli
	 */
	public void putdown() { myLock.unlock(); } // DEBUG in Philosopher.java
}
