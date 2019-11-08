package assignment_3.jUnit5.list_test;

/**
 * IntListTest.java
 * 30 jan. 2018
 */


import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jlnmsi
 *
 */
public class IntListTest {

		
    private static int test_count = 0;

	/* Is executed before every test method (not test case).*/
	@BeforeEach
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count);
	}
	
	/* Is executed after every test method (not test case).*/
	@AfterEach
	public void tearDown() {}
	
	
	/* *********************************************************** 
	 * 
	 *             My list tests
	 * 
	 * ************************************************************/
	
	@Test
	public void testInitSize() {
		IntList list = new IntListImpl();
		assertEquals(0,list.size());
	}
	
	@Test
	public void testAddGet() {		
		/* Test add(int n) using build() */
		IntList list1 = build(5);
		assertEquals(5,list1.size());
		
		IntList list2 = build(10);
		assertEquals(10,list2.size());
		
		/* Test get(int n) */
		for (int i=0;i<list2.size();i++)
			assertEquals(i,list2.get(i));
		
		/* Test if get(int index) throws exception */
		assertThrows(IndexOutOfBoundsException.class, () -> list2.get(-8));
		assertThrows(IndexOutOfBoundsException.class, () -> list2.get(123));
	}
	
	@Test
	public void testIndexOf() {
		/* Test indexOf() using build() */		
		IntList list = build(100);
		for (int i=0;i<list.size();i++)
			assertEquals(i,list.indexOf(i));

	}

	@Test
	public void testRemove() {
		/* Test extreme cases */
		IntList list = build(10);
		list.remove(9);  //[0,1,2,3,4,5,6,7,8]
		list.remove(0);  //[1,2,3,4,5,6,7,8]
		assertEquals(8,list.size());
		
		/* Test interior */
		list.remove(3);  //[1,2,3,5,6,7,8]
		list.remove(3);  //[1,2,3,6,7,8]
		assertEquals(6,list.size());
		
		/* Check each remaining element */
		assertEquals(1,list.get(0));
		assertEquals(2,list.get(1));
		assertEquals(3,list.get(2));
		assertEquals(6,list.get(3));
		assertEquals(7,list.get(4));
		assertEquals(8,list.get(5));
				
		/* Test if remove(int index) throws exception */
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-8));
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(123));
		
	}
	
	@Test
	public void testSortToString() {
		/* Test extreme cases */
		IntList empty = new IntListImpl();
		empty.sort();
		assertEquals(0,empty.size());

		IntList one = new IntListImpl();
		one.add(234);
		one.sort();
		assertEquals(1,one.size());
		assertEquals(234,one.get(0));
		
		/* Test sort() using random() */		
		IntList list = random(20,100);
		System.out.println("\t  unsorted: "+list);
		list.sort();
		System.out.println("\t  sorted: "+list);
		
		/* Verify ascending */
		for (int i=1;i<list.size();i++)
			assertTrue(list.get(i-1)<=list.get(i));
		
	}
	
	/* ********************************************************
	 * 			Private help methods ==> Fixture
	 * ********************************************************/
	private IntList build(int size) {
		IntList list = new IntListImpl();
		for (int i=0;i<size;i++)
			list.add(i);
		return list; 
	}
	private IntList random(int size,int max) {
		/* Setup random generator */
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		/* Add random numbers modulus max*/
		IntList list = new IntListImpl();
		for (int i=0;i<size;i++) {
			int n = rand.nextInt() % max;
			list.add(n);
		}
		return list; 
	}	

}
