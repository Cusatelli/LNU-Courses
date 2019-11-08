package assignment_3.sortingAlgorithm;

public class MergeSort {
	private int[] output; // Will be new (sorted) duplicate array.
	private int[] tmp; // Stores temporary values in separate array.
	private int length; // length of array.
	
	/*
	 * Initializes the actual sorting algorithm:
	 */
	public void sort(int[] in) {
		output = in; // Duplicate array.
		length = in.length; // Set length of array.		
		tmp = new int[length]; // New empty array (with original length).
		
		mergeSort(0, length - 1); // Merge Sort method.
	}
	
	/* 
	 * Deconstructs the duplicate array into several smaller arrays:
	 * And does the mergeSort calculations and initiates the merge method:
	 */
	public void mergeSort(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) { // If the first value is less than the last:
			int middleIndex = lowerIndex + (higherIndex - lowerIndex) / 2;  // Set middle of array.lenght
			
			mergeSort(lowerIndex, middleIndex); // Repeat for first up to middle. (1 - 5 (if length is 10)).
			mergeSort(middleIndex + 1, higherIndex); // Last for first down to middle. (10 - 5 (if length is 10)).
			
			merge(lowerIndex, middleIndex, higherIndex); // Merge the arrays first - middle & middle - last.
		}
	}
	/*
	 * Merges the arrays into one copy:
	 * 
	 * Checks if the lowest value is lower or greater than the previous value
	 * and inserts it in the proper position.
	 */
	public void merge(int lowerIndex, int middleIndex, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) { // Iterates over whole array:
			tmp[i] = output[i]; //duplicate output array to tmp array.
		}
		
		/* 
		 * Essential variables for calculating positions 
		 * and assigning correct values.
		 */
		int i = lowerIndex; // i begins at first.
		int j = middleIndex + 1; // j begins at middle.
		int k = lowerIndex; // k begins at first.		
		/*
		 * While "first" is less or equal to middle.
		 * & While "middle" is less or equal to last.
		 */
		while (i <= middleIndex && j <= higherIndex) {
			if(tmp[i] <= tmp[j]) { // if value at i is less || equal to j:
				output[k] = tmp[i]; // Set the value first in array since it's the lesser.
				i++;
			
			} else {
				output[k] = tmp[j]; // Else set the value last (middle) since it is greater.
				j++;
			}
			k++;
		}
		
		while (i <= middleIndex) { // While first is less than middle pos:
			output[k] = tmp[i]; // Set the value first in array since it's the lesser.
			k++;
			i++;
		}
	}
}