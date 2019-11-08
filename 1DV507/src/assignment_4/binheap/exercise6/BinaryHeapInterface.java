package assignment_4.binheap.exercise6;

public interface BinaryHeapInterface {
	// BinaryIntHeap -> Constructs an empty heap
	public void insert(int n);		// Add n to heap
	public int pullHighest();		// Return and remove element with highest priority
	public int size();				// Current heap size
	public boolean isEmpty();		// True if heap is empty
}
