package assignment_3.jUnit5;

/**
 * MyMathTest.java
 * 30 jan. 2018
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * A first example of how to use Junit 5. 
 * 
 * @author jlnmsi
 *
 */
class MyMathTest {

	@Test
	public void testMultiply() {
		/* Test extreme cases */
		assertEquals(0, MyMath.mult(10, 0));  // check check 10*0 = 0	 
		assertEquals(10, MyMath.mult(10, 1));  // check check 10*1 = 10	   
		assertEquals(0, MyMath.mult(0, 10));  // check check 0*10 = 0	
	   
		/* Test a few standard cases */
	   assertEquals(50, MyMath.mult(10, 5),"10 x 5 must be 50");  // check 10*5 = 50
	   assertEquals(-35, MyMath.mult(-7, 5), "-7 x 5 must be -35");  // check -7*5 = -35
	   
	   /* Test a case with large numbers, check 23246*7958 = 184991668 */
	   assertEquals(184991668, MyMath.mult(23246, 7958), "23246 x 7958 must be 184991668"); 
	   
	   /* Check for IllegalArgumentException */
	   assertThrows(IllegalArgumentException.class, () -> MyMath.mult(10, -1));
	 } 
	
	@Test
	public void testSorting() {
		/* 
		 * Test extreme cases
		 */
		int[] arr1 = new int[0];       // Empty array
		MyMath.sort(arr1);
		assertEquals(0,arr1.length);
		
		int[] arr2 = {5};         // Singleton array
		MyMath.sort(arr2);
		assertEquals(1,arr2.length);
		assertEquals(5,arr2[0]);
		
		/* 
		 * A few standard cases 
		 */
		int[] arr3 = {5,5,5};     // All elements are equal
		MyMath.sort(arr3);
		assertEquals(3,arr3.length);
		for (int i : arr3)
			assertEquals(5,i);
		
		int[] arr4 = {4,3,2,1};     // Descending order
		MyMath.sort(arr4);
		assertEquals(4,arr4.length);
		assertEquals(1,arr4[0]);
		assertEquals(4,arr4[3]);
		
		int[] arr5 = random(100,100);   // Random array of size 100
		MyMath.sort(arr5);
		for (int i=0; i<arr5.length-1;i++)
			assertTrue(arr5[i]<=arr5[i+1]);
		
		
		/*
		 * Test a very large array
		 */
		int[] arr6 = random(100000,1000000);  // About 15sec to sort 1000000 elements
		MyMath.sort(arr6);
		for (int i=0; i<arr6.length-1;i++)
			assertTrue(arr6[i]<=arr6[i+1]);
	
	 } 
	
	
	/* ********************************************************
	 * 			Private help methods ==> Fixture
	 * ********************************************************/
	
	/*
	 * Generates random integer array of length size with elements
	 * in the range [0,max].
	 */
	private int[] random(int size,int max) {
		/* Setup random generator */
		Random rand = new Random();
		
		/* Add random numbers in range [1,max] */
		int[] arr = new int[size];
		for (int i=0;i<size;i++) {
			//int n = rand.nextInt() % max;
			int n = rand.nextInt(max);
			arr[i] = n;
		}
		return arr; 
	}	
}