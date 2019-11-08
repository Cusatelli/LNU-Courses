package assignment_3.sortingAlgorithm;

/*
 * Insertion Sort:
 * Credit:
 * Title: "Program: Implement insertion sort in java" 
 * Website: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
 * 
 * Merge Sort:
 * Credit: Arun Prakash && rolfl
 * Title: Merge Sort an integer array
 * Website: https://codereview.stackexchange.com/questions/64711/merge-sort-an-integer-array
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortingAlgorithms {
	
	public static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Å", "Ä", "Ö"};	
	public static int size = 10;
	public static String[] strArray = new String[size];
	public static int[] intArray = new int[size];
	
	public static void main(String[] args) {
		generateRandomInt();
		// Integer Insertion Sort:
//		System.out.println(Arrays.toString(insertionSort(intArray)));
//		System.out.println(Arrays.toString(intArray)); // Check if original is still intact.
//		System.out.println();
		
		// Integer Merge Sort:
		System.out.println("Sorted: " + Arrays.toString(mergeSort(intArray)));
		System.out.println("UnSorted: " + Arrays.toString(intArray));
		System.out.println();
		
		generateRandomString();
		// String Insertion Sort:
		System.out.println("Sorted: " + Arrays.toString(insertionSort(strArray, c)));
		System.out.println("UnSorted: " + Arrays.toString(strArray)); // Check if original is still intact.

	}
	
	// Insertion sort:
	public static int[] insertionSort(int[] in) {
		/*
		 * Could have had the copy in a separate method
		 * but since the assignment specified FOUR static methods
		 * I felt it was wrong to implement a fifth one.
		 * 
		 * Create a duplicate of original array.	
		 */		
		int[] output = new int[in.length]; // New array with the same size as the original.
		for (int i = 0; i < in.length; i++) { // Iterate over the original array size.
			output[i] = in[i]; // Duplicate values from original to copy.
		}
			
		for (int i = 0; i < in.length; i++) {
			int tmp = output[i]; // tmp to store values from array temporarily before moved.
			
			int index = i - 1; // indexer has to be less than i.			
			// While index is greater than -1 and current value in array is greater than tmp (which is previous(in first loop)).
			while ((index > - 1) && (output[index] > tmp)) {
				output[index + 1] = output[index]; // Move the position of value (index + 1) down one step.
				index--;
				//System.out.println(Arrays.toString(output));
			}
			// Set the position of value (index + 1) equal to tmp.
			// Otherwise the value will be lost next iteration and we will receive duplicates in array:
			output[index + 1] = tmp;
		}
		return output;
	}

	// VG Exercise
	// Merge sort:
	public static int[] mergeSort(int[] in) {
		MergeSort mergeSort = new MergeSort();
		int[] output = new int[in.length]; // New array with the same size as the original.
		for (int i = 0; i < in.length; i++) { // Iterate over the original array size.
			output[i] = in[i]; // Duplicate values from original to copy.
		}
		mergeSort.sort(output); // MergeSort the duplicate array.
		return output; // Return the new sorted duplicate array.
	}
	
	public static String[] insertionSort(String[] in, Comparator<String> c) { // <------ USE THE COMPARATOR<STRING> C
		int higherIndex; // Top to bottom.
		int lowerIndex; // Bottom to top.
		String tmp; // Temporary string to hold values.
		String[] output = new String[in.length]; // New array with same length as original array.
		for (int i = 0; i < in.length; i++) {
			output[i] = in[i];
		}
		
		for (lowerIndex = 1; lowerIndex < output.length; lowerIndex++) { //the condition has changed
			tmp = output[lowerIndex]; // Temporary equals the lowest unsorted index.
			higherIndex = lowerIndex - 1; // higher index is one less than lower index...
			
			while (higherIndex >= 0) { // While higher index is greater or equal to 0.
/* Comparator---> */if (c.compare(output[higherIndex], tmp) <= 0) { // Takes the tmp value and compares it to the higher index value in duplicate array.
					break; // If it is 0 or less, break.
				}
				output[higherIndex + 1] = output[higherIndex]; // Move the value one up in the array.
				higherIndex--; // Move one value down the chain.
			}
			
			output[higherIndex + 1] = tmp; // Set the duplicate array value in higher index + 1 to the temporary value.
		}
		return output; // Return the sorted duplicate array.
	}
	
	/* ***********************************************************************
	 * 							 HELPER METHODS 
	 * ***********************************************************************/
	// Generate a random String array from alphabet array (Swedish alphabeth):
	public static void generateRandomString() {
		Random rand = new Random();
		for (int i = 0; i < size; i++) {		
			strArray[i] = alphabet[rand.nextInt(alphabet.length)];; // random value 1-100;
		}
	}

	// Generate a random Integer array:
	public static void generateRandomInt() {
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			intArray[i] = rand.nextInt(100) + 1; // random value 1-100;
		}
	}
	
	// Comparator:
	public static Comparator<String> c = new Comparator<String>() {
		/* 
		 * o1 the first object to be compared.
		 * o2 the second object to be compared.
		 */
		@Override
		public int compare(String o1, String o2) {
			if (o1 == o2) { // If values 1 and 2 are the same then don't change pos.
				return 0;
			}
			if (o1 == null) {
				return -1; // If input 1 is equal to null return -1.
			}
			if (o2 == null) {
				return 1; // If input 2 is equal to null return 1.
			}
			return o1.compareTo(o2);
		}
	};
	/* ***********************************************************************
	 * 						 TEST CASES : SAME METHODS 
	 * ***********************************************************************/
	// Insertion Sort Test Case:
	public static int[] insertionSortTest(int[] in) {
		/* *****************************************************
		 * 		REMOVED FUNCTION TO CREATE DUPLICATE ARRAY.
		 * *****************************************************/
		for (int i = 0; i < in.length; i++) {
			int tmp = in[i]; // tmp to store values from array temporarily before moved.
			
			int index = i - 1; // indexer has to be less than i.			
			// While index is greater than -1 and current value in array is greater than tmp (which is previous(in first loop)).
			while ((index > - 1) && (in[index] > tmp)) {
				in[index + 1] = in[index]; // Move the position of value (index + 1) down one step.
				index--;
			}
			// Set the position of value (index + 1) equal to tmp.
			// Otherwise the value will be lost next iteration and we will receive duplicates in array:
			in[index + 1] = tmp; 
		}
		return in;
	}
	// Merge Sort Test Case:
	public static int[] mergeSortTest(int[] in) {
		MergeSort mergeSort = new MergeSort();
		/* *****************************************************
		 * 		REMOVED FUNCTION TO CREATE DUPLICATE ARRAY.
		 * *****************************************************/
		for (int i = 0; i < in.length; i++) { // Iterate over the original array size.
			in[i] = in[i]; // Duplicate values from original to copy.
		}
		mergeSort.sort(in); // MergeSort the duplicate array.
		return in; // Return the new sorted duplicate array.
	}
	
	public static String[] insertionSortStringTest(String[] in, Comparator<String> c) { // <------ USE THE COMPARATOR<STRING> C
		int higherIndex; // Top to bottom.
		int lowerIndex; // Bottom to top.
		String tmp; // Temporary string to hold values.
		/* *****************************************************
		 * 		REMOVED FUNCTION TO CREATE DUPLICATE ARRAY.
		 * *****************************************************/		
		for (lowerIndex = 1; lowerIndex < in.length; lowerIndex++) { //the condition has changed
			tmp = in[lowerIndex]; // Temporary equals the lowest unsorted index.
			higherIndex = lowerIndex - 1; // higher index is one less than lower index...
			
			while (higherIndex >= 0) { // While higher index is greater or equal to 0.
/* Comparator---> */if (c.compare(in[higherIndex], tmp) <= 0) { // Takes the tmp value and compares it to the higher index value in duplicate array.
					break; // If it is 0 or less, break.
				}
				in[higherIndex + 1] = in[higherIndex]; // Move the value one up in the array.
				higherIndex--; // Move one value down the chain.
			}
			
			in[higherIndex + 1] = tmp; // Set the duplicate array value in higher index + 1 to the temporary value.
		}
		return in; // Return the sorted duplicate array.
	}
}