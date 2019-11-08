package assignment_2.exercise_1;

/*******************************************************************************
 * 
 *  Compilation:  javac LinkedQueue.java
 *  Execution:    java QueueMain.java > LinkedQueue.java > Queue.java
 *
 *  A LinkedQueue implementing Queue Interface provided from course assignment.
 *
 *******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code LinkedQueue} and {@code QueueMain} classes represents a First in, First out (FIFO)
 * queue of Objects / elements.
 * With the interface {@code Queue} implemented in {@code LinkedQueue} it supports the regular
 * operations such as <em>enqueue</em> and <em>dequeue</em>, along with the generic methods:
 * <em>size</em> which returns the queue size, <em>isEmpty</em> which returns true if the queue is empty, 
 * <em>first</em> returns the first element in the queue without removing it and 
 * <em>last</em> returns the last element without removing it.
 * <p>
 * These classes implements a singly linked list with non-static methods (Exception: {@code QueueMain})
 * and non-static nested helper class for linked list nodes.
 * <p>
 * Worst case scenario all methods take O(1) time to complete an operation.
 * 
 * @author ev222hh
 * 
 */

public class LinkedQueue implements Queue {
	
	private int size; // Current queue Size.
	private Node head; // First Node / Element.
	private Node tail; // Last Node / Element.
	//private Object element = new Object();
	
	// Helper class.
	private class Node {
		private Object element;
		private Node next;
	}
	
	/**
	 * Initialize empty queue.
	 */
	public LinkedQueue() throws NoSuchElementException {
		try {
			head = null; // Initialize head.
			tail = null; // Initialize tail.
			size = 0; // Initialize size.
			//assert debug();
			
		} catch (NoSuchElementException e) {
			System.out.println("ERROR: The Queue contains no elements!");
		}
		
	}
	
	/**
	 * @return integer value of current queue size.
	 */
	@Override
	public int size() {
		return size; // Returns current queue size.
	}
	
	/**
	 * Check if queue is empty.
	 * @return true if queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return head == null; // Returns true if the queue is empty.
	}

	// Adds element at end of queue.
	// The Element of the element to add to end queue.
	@Override
	public void enqueue(Object element) {
		Node last = tail;
		tail = new Node();
		tail.element = element;
		tail.next = null;
		
		if (isEmpty()) {
			head = tail;
		} else {
			last.next = tail;
		}
		size++;
//		assert debug();
	}
	
	// Return and remove first element add to queue (Currently in Queue).
	@Override
	public Object dequeue() {
		if (isEmpty()) throw new NoSuchElementException("The Queue contains no elements!"); // Throws exception if the queue is empty.	
		Object element = head.element;
		head = head.next; // Sets head to next element.
		size--; // reduces size of queue by 1.

		if (isEmpty()) {
			tail = null; // if the queue is empty set the tail to null.
		}

//		assert debug();
		return element; // Returns the element of the queue that was added first (Currently in queue).
	}
	
	/** 
	 * @return the <b>first</b> added element (currently in queue);
	 * else if queue is empty throw <em>NoSuchElementException</em>.
	 */
	@Override
	public Object first() {
		if (isEmpty()) throw new NoSuchElementException("The Queue contains no elements!"); // Throws exception if the queue is empty.
		return head.element; // Returns the first element added (currently in queue) to the queue. 
	}

	/** 
	 * @return the <b>last</b> added element (currently in queue);
	 * else if queue is empty throw <em>NoSuchElementException</em>.
	 */
	@Override
	public Object last() {
		if (isEmpty()) throw new NoSuchElementException("The Queue contains no elements!"); // Throws exception if the queue is empty.
		return tail.element; // Returns the last element added (currently in queue) to the queue. 
	}

	/**
	 * Element iterator.
	 * @return the iterator which iterates over the queue, in <b>FIFO</b> (First in, First out) order.
	 */
	@Override
	public Iterator<Object> iterator() {
		return new QueueIterator();
	}
	
	/**
	 * <b>Iterator</b>
	 */
	private class QueueIterator implements Iterator<Object> {
		private Node current = head;

		/**
		 *  Returns true if current isn't empty.
		 *  @return true if current element is not equal to null.
		 */
		@Override
		public boolean hasNext() {
			return current != null; // Returns true if current isn't empty.
		}

		/**
		 * Iterates over next element in queue.
		 * @return next element.
		 */
		@Override
		public Object next() {
			if(!hasNext()) throw new NoSuchElementException("The Queue has no next element!"); // Throws exception if the queue doesn't have next element.
			
			Object element = current.element;
			current = current.next;
			return element;
		}
	}
	
	/**
	 * @return a String representation of the queue content.
	 */
	@Override
	public String toString() {
		String printOut = "";
		Node current = head;
		
		int count = size; // Count until current size has been reached:
		while(count != 0) {
			printOut += "[ " + current.element + " ]"; // String output.
			current = current.next; // Next element.
			count--; // Decrement by 1.
		}
		
		return printOut;
	}

	/**
	 * Debug internal variables.
	 * @return true if no values contradicts themselves.
	 */
	@SuppressWarnings("unused")
	private boolean debug() {
		if (size < 0) { // If size is less than 0.
			return false;

		} else if(size == 0) { // If size equals 0.
			if (head != null) 
				return false; // Returns false is head is empty.

			if (tail != null)
				return false; // Returns false is tail is empty.

		} else if(size == 1) { // If size equals 1.
			if (head != null || tail != null)
				return false; // Returns false if head or tail is empty.

			if (head != tail)
				return false; // Returns true if head equals tail (It's the only element in queue). Else false.

			if (head.next != null)
				return false; // Returns false if head doesn't have a next element.

		} else {
			if (head == null || tail == null)
				return false; // Returns false if head or tail is empty.

			if (head == tail)
				return false; // Returns false if head equals tail.

			if (head.next != null)
				return false; // Returns false if head doesn't have next element.

			if (tail.next != null)
				return false; // Returns false if tail doesn't have next element.
		}

		/**
		 * debug for number of nodes and it's consistency.
		 */
		int nodeSize = 0;
		// for (Node = first element; Node != null && Node Size <= 0; Node = Node.next) {
		for (Node n = head; n != null && nodeSize <= 0; n = n.next) {
			nodeSize++;
		}

		if (nodeSize != size) {
			return false; // Return false if nodeSize doesn't match current size. (Should not happen).
		}

		/**
		 *  debug for consistency with tail variable.
		 */
		Node tailNode = tail;
		while (tailNode.next != null) { // While tail has next.
			tailNode = tailNode.next; // Set tailNode to next element in queue.
		}

		if (tailNode != tail) { 
			return false; // Return false if tailNode doesn't match tail. (Should not happen).
		}

		return true; // If all other variables doesn't return false, return true.
	}
}