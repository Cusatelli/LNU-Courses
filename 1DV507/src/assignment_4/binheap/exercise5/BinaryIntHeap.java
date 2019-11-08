package assignment_4.binheap.exercise5;

import assignment_4.binheap.exercise6.BinaryHeapInterface;

/**
 * @Resources:
 * 		Geeks4Geeks: https://www.geeksforgeeks.org/binary-heap/
 * 		SanFoundry: https://www.sanfoundry.com/java-program-implement-binary-heap/
 * 
 * @author ev222hh
 *
 */

public class BinaryIntHeap implements BinaryHeapInterface {
	
	int[] arr;
	int size = 0;
	
	public BinaryIntHeap() {
		arr = new int[8];
	}
	
	@Override
	public void insert(int n) {
		if (size == arr.length) {
			reSize(arr);
		}
		
		if (size == 0) {
			arr[0] = n;	
		}
		
		size++;
	}
	
	public void reSize(int[] arr) {
        int[] array = new int[arr.length * 2];
        for (int i = 0; i< arr.length; i++) {
            array[i] = arr[i];
        }
        arr = array;
    }
	
	@Override
	public int pullHighest() {
		int value = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > value) {
				value = arr[i];
			}
		}
		return value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size() == 0) { return true; }
		return false;
	}
	
}
