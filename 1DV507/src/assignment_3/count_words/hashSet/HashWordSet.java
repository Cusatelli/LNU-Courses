package assignment_3.count_words.hashSet;

import java.util.Iterator;

import assignment_3.count_words.Word;
import assignment_3.count_words.WordSet;

public class HashWordSet implements WordSet {
	private Node[] buckets;
	private int size;
	private static class Node {
        Object key;
        Node next;
    }
	
	public HashWordSet(int capacity) {
        buckets = new Node[capacity];
        size = 0;
    }
	
	private int hashCode(int hash) {
		int index = hash;
		if (index < 0) { index = -index; }
		return index % buckets.length;
	}
	
	public void rehash() {
		Node[] tmp = buckets; // Copy of old bucket.
		buckets = new Node[2 * tmp.length]; // New empty buckets.
		size = 0;
		for ( Node node : tmp ) { // Insert old buckets into new buckets.
			if (node == null) { continue; } // Empty bucket.
			while (node != null) { 
				add((Word) node.key); // Add elements again.
				node = node.next;
			}
		}
	}
	
	@Override
	public void add(Word word) {
		int index = hashCode(word.hashCode());
		Node current = buckets[index];
		while (current != null) {
			// element is already in set
			if (current.key.equals(word)) { return; }
			// otherwise visit next entry in the bucket
			current = current.next;
		}
		// no element found so add new entry
		Node node = new Node();
		node.key = word;
		// current Entry is null if bucket is empty
		// if it is not null it becomes next Entry
		node.next  = buckets[index];
		buckets[index] = node;
		size++;
		if(size == buckets.length) rehash(); // If full;
	}

	@Override
	public boolean contains(Word word) {
		int index = hashCode(word.hashCode());
		Node current = buckets[index];

		while (current != null) {
			// check if node contains element
			if (current.key.equals(word)) { return true; }
			// otherwise visit next node in the bucket
			current = current.next;
		}
		// no element found
		return false;
	}
	
	@Override
	public Iterator<Word> iterator() {
		return null;
	}
	
//	@Override
//    public Iterator<Word> iterator() {
//        return new HashWordSetIterator();
//    }
//	
//	// Iterator helper class:
//	class HashWordSetIterator implements Iterator {
//		private int currentBucket;
//		private int previousBucket;
//		private Node currentEntry;
//		private Node previousEntry;
//
//		public HashWordSetIterator() {
//			currentEntry = null;
//			previousEntry = null;
//			currentBucket = -1;
//			previousBucket = -1;
//		}
//
//		@Override
//		public boolean hasNext() {
//			// currentEntry node has next
//			if (currentEntry != null && currentEntry.next != null) { return true; }
//
//			// there are still nodes
//			for (int index = currentBucket+1; index < buckets.length; index++) {
//				if (buckets[index] != null) { return true; }
//			}
//
//			// nothing left
//			return false;
//		}
//
//		@Override
//		public Object next() {
//			previousEntry = currentEntry;
//			previousBucket = currentBucket;
//
//			// if either the current or next node are null
//			if (currentEntry == null || currentEntry.next == null) {
//
//				// go to next bucket
//				currentBucket++;
//
//				// keep going until you find a bucket with a node
//				while (currentBucket < buckets.length &&
//						buckets[currentBucket] == null) {
//					// go to next bucket
//					currentBucket++;
//				}
//
//				// if bucket array index still in bounds
//				// make it the current node
//				if (currentBucket < buckets.length) {
//					currentEntry = buckets[currentBucket];
//				}
//				// otherwise there are no more elements
//				else {
//					throw new NoSuchElementException();
//				}
//			}
//			// go to the next element in bucket
//			else {
//				currentEntry = currentEntry.next;
//			}
//
//			// return the element in the current node
//			return currentEntry.key;
//
//		}
//
//	}
//	
	@Override
	public int size() {
		return size;
	}

	@Override
    public String toString() {
        Node currentNode = null;
        StringBuffer sb = new StringBuffer();

        // loop through the array
        for (int index=0; index < buckets.length; index++) {
            // we have an entry
            if (buckets[index] != null) {
            	currentNode = buckets[index];
                sb.append("[" + index + "]");
                sb.append(" " + currentNode.key.toString());
                while (currentNode.next != null) {
                	currentNode = currentNode.next;
                    sb.append(" -> " + currentNode.key.toString());
                }
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}