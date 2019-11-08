package assignment_4.exercise1;

import assignment_4.exercise1.LinkedQueue;

/**
 * Since I did not submit the correct files during the first hand-in (.class instead of .java files) 
 * I can not say that I have included any of the teacher notes into my assignment.
 */

/**
 * The {@code QueueMain} class demonstrates how to use the {@code LinkedQueue} class methods which implements the {@code Queue} interface.
 * 
 * @author ev222hh
 */

public class QueueMain<T> extends LinkedQueue<T> {
	/**
	 * Decides how many iterations you want the loop to go through until it reaches this size. 
	 */
	private static int toSize = 0;
	/**
	 * Counts how many items is added in queue (Total).
	 */
	private static int number = 0;
	
	/**
	 * Main method demonstrates how to use the {@code LinkedQueue} class methods.
	 * @param args arguments
	 */
	public static void main(String[] args) {
		LinkedQueue<Object> queue = new LinkedQueue<Object>();
		toSize = 5; // Specify how many elements in queue you want. 
		
		/**
		 *  Enqueue elements in queue:
		 */
		System.out.println("_______________________________________________________________________\n");
		while (queue.size() != toSize) { // Enqueues elements.
			number++;
			queue.enqueue(number);

			if (number % 3 == 0) {
				queue.dequeue(); // Dequeues all elements in multiples of 3.
			}
		}
		System.out.println("Enqueues " + number + " elements, and dequeues " + (number - toSize) + " elements:\n");
		System.out.println("Leaving a queue size of " + queue.size());
		System.out.println("Current elements in queue: " + queue.toString());
		System.out.println("_______________________________________________________________________\n");		

		toSize = 6; // Specify how many remaining elements in queue you want.
		number = 0; // Resets number count to 0.
		
		/**
		 *  Dequeue elements in queue:
		 */
		while (queue.size() != toSize) { // Dequeues remaining elements.
			if (queue.size() < toSize && number == 0)
				System.out.println("Desired size (" + toSize + ") is too high.\n"
						+ "Looping " + queue.size() + " times instead!");
				
			if (queue.isEmpty()) {
				System.out.println("\nQueue is Empty . . .\n"
						+ "_______________________________________________________________________\n");
				break;
			}
			number++;
			queue.dequeue(); 
		}
		System.out.println("Dequeues " + number + " elements, until there is " + queue.size() + " remaining:\n");
		System.out.println("Leaving a queue size of " + queue.size());
		System.out.println("Current elements in queue: " + queue.toString());
		System.out.println("_______________________________________________________________________");
	}
}
