package assignment_3.sortingAlgorithm;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.Random;
import org.junit.jupiter.api.Test;

class SortTest {
	
	private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Å", "Ä", "Ö"};
	
	/*
	 * Using a Test case method for JUnit5 testing since
	 * I encountered problems with the "duplicate" array
	 * created within the method itself.
	 * 
	 * The methods used are the same, except for the 
	 * array copy function.
	 */
	@Test
	void testInsertionSort() {
		/*
		 * Testing extreme use cases:
		 */
		int[] arr1 = new int[0]; 					// Empty array
		SortingAlgorithms.insertionSortTest(arr1);
		assertEquals(0, arr1.length); 				// Expected length.
		
		int[] arr2 = {11}; 							// Singleton array
		SortingAlgorithms.insertionSortTest(arr2);
		assertEquals(1, arr2.length); 				// Expected length.
		assertEquals(11, arr2[0]); 					// Expected value at 0.
		
		/*
		 * Testing a few standard use cases:
		 */
		int[] arr3 = {9, 9, 9, 9}; 					// Equal elements
		SortingAlgorithms.insertionSortTest(arr3);
		assertEquals(4, arr3.length); 				// Expected length.
		for (int i : arr3)
			assertEquals(9, i); 					// Expected result.
		
		int[] arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};	// Descending order
		SortingAlgorithms.insertionSortTest(arr4);
		assertEquals(9, arr4.length); 				// Expected length.
		assertEquals(1, arr4[0]); 					// Expected value at 0.
		assertEquals(4, arr4[3]);					// Expected value at 3.
		assertEquals(9, arr4[8]);					// Expected value at 8.
		
		int[] arr5 = random(100, 100);				// Random array of size 100.
		SortingAlgorithms.insertionSortTest(arr5);
		for (int i = 0; i < arr5.length - 1; i++) {
			assertTrue(arr5[i] <= arr5[i + 1]); 	// Expected result is that
		}											// every value is sorted.
		
		/*
		 * Testing an extremely large array:
		 */
		int[] arr6 = random(1000000, 1000000); 		// About 392-432 seconds to sort.
		SortingAlgorithms.insertionSortTest(arr6);	// 1000000 elements.
		for (int i = 0; i < arr6.length - 1; i++) {
			assertTrue(arr6[i] <= arr6[i + 1]);		// Expected result is that
		}											// every value is sorted.
	}	
	
	@Test
	void testMergeSort() {
		/*
		 * Testing extreme use cases:
		 */
		int[] arr1 = new int[0]; 					// Empty array
		SortingAlgorithms.mergeSortTest(arr1);
		assertEquals(0, arr1.length); 				// Expected length.
		
		int[] arr2 = {11}; 							// Singleton array	
		SortingAlgorithms.mergeSortTest(arr2);
		assertEquals(1, arr2.length); 				// Expected length.
		assertEquals(11, arr2[0]); 					// Expected value at 0.
		
		/*
		 * Testing a few standard use cases:
		 */
		int[] arr3 = {9, 9, 9, 9}; 					// Equal elements
		SortingAlgorithms.mergeSortTest(arr3);
		assertEquals(4, arr3.length); 				// Expected length.
		for (int i : arr3)
			assertEquals(9, i); 					// Expected result.
		
		int[] arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};	// Descending order
		SortingAlgorithms.mergeSortTest(arr4);
		assertEquals(9, arr4.length); 				// Expected length.
		assertEquals(1, arr4[0]); 					// Expected value at 0.
		assertEquals(4, arr4[3]);					// Expected value at 3.
		assertEquals(9, arr4[8]);					// Expected value at 8.
		
		int[] arr5 = random(100, 100);				// Random array of size 100.
		SortingAlgorithms.mergeSortTest(arr5);
		for (int i = 0; i < arr5.length - 1; i++) {
			assertTrue(arr5[i] <= arr5[i + 1]); 	// Expected result is that
		}											// every value is sorted.
		
		/*
		 * Testing an extremely large array:
		 */
		int[] arr6 = random(1000000, 1000000); 		// About 402-451 seconds to sort.
		SortingAlgorithms.insertionSortTest(arr6);	// 1000000 elements.
		for (int i = 0; i < arr6.length - 1; i++) {
			assertTrue(arr6[i] <= arr6[i + 1]);		// Expected result is that
		}	
	}
	
	@Test
	void testInsertionSortString() {
		/*
		 * Testing extreme use cases:
		 */
		String[] arr1 = new String[0]; 				// Empty array
		SortingAlgorithms.insertionSortStringTest(arr1, SortingAlgorithms.c);
		assertEquals(0, arr1.length); 				// Expected length.
		
		String[] arr2 = {"A"}; 						// Singleton array
		SortingAlgorithms.insertionSortStringTest(arr2, SortingAlgorithms.c);
		assertEquals(1, arr2.length); 				// Expected length.
		assertEquals("A", arr2[0]); 				// Expected value at 0.
		
		/*
		 * Testing a few standard use cases:
		 */
		String[] arr3 = {"Z", "Z", "Z", "Z"}; 		// Equal elements
		SortingAlgorithms.insertionSortStringTest(arr3, SortingAlgorithms.c);
		assertEquals(4, arr3.length); 				// Expected length.
		for (String i : arr3)
			assertEquals("Z", i); 					// Expected result.
		
		String[] arr4 = {"I", "H", "G", "F", "E", "D", "C", "B", "A"};// Descending order
		SortingAlgorithms.insertionSortStringTest(arr4, SortingAlgorithms.c);
		assertEquals(9, arr4.length); 				// Expected length.
		assertEquals("A", arr4[0]); 					// Expected value at 0.
		assertEquals("D", arr4[3]);					// Expected value at 3.
		assertEquals("I", arr4[8]);					// Expected value at 8.
		
		String[] arr5 = randomStr(100, 100);		// Random array of size 100.
		SortingAlgorithms.insertionSortStringTest(arr5, SortingAlgorithms.c);
		for (int i = 0; i < arr5.length - 1; i++) {
			assertTrue(c.compare(arr5[i], arr5[i + 1]) <= 0); 	// Expected result is that
		}											// every value is sorted.
		
		/*
		 * Testing an extremely large array:
		 */
		String[] arr6 = randomStr(1000000, 1000000); 				// About 1122-1166 seconds to sort.
		SortingAlgorithms.insertionSortStringTest(arr6, SortingAlgorithms.c);	// 1000000 elements.
		for (int i = 0; i < arr6.length - 1; i++) {
			assertTrue(c.compare(arr6[i], arr6[i + 1]) <= 0);		// Expected result is that
		}															// every value is sorted.
	}
	
	// Total time (start to finish): About 35 minutes (2050 seconds).
	
	/* ********************************************************
	 * 			Private help methods ==> Fixture
	 * ********************************************************/	
	/*
	 * Generates random integer array of length size with elements
	 * in the range [0, max].
	 */
	private int[] random(int size, int max) {
		/* Setup random generator */
		Random rand = new Random();
		
		/* Add random numbers in range [1,max] */
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			int n = rand.nextInt(max);
			arr[i] = n;
		}
		return arr; 
	}
	
	public String[] randomStr(int size, int max) {
		Random rand = new Random();
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {		
			arr[i] = alphabet[rand.nextInt(alphabet.length)];; // random value 1-100;
		}
		return arr;
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
}