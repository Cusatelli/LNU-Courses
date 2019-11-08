package assignment_4.exercise1;

import java.util.Iterator;

/**
 * Since I did not submit the correct files during the first hand-in (.class instead of .java files) 
 * I can not say that I have included any of the teacher notes into my assignment.
 */

public interface Queue<T> {
	public int size();						// current queue size
    public boolean isEmpty();				// true if queue is empty
    public void enqueue(Object element);	// add element at end of queue
    public Object dequeue();				// return and remove first element.
    public Object first();					// return (without removing) first element
    public Object last();					// return (without removing) last element
    public String toString();				// return a string representation of the queue content
    public Iterator<Object> iterator();		// element iterator
	
}
