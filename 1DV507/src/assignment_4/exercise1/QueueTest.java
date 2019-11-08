package assignment_4.exercise1;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import assignment_4.exercise1.LinkedQueue;

/**
 * Since I did not submit the correct files during the first hand-in (.class instead of .java files) 
 * I can not say that I have included any of the teacher notes into my assignments solution.
 */

class QueueTest {
	LinkedQueue<String> qString = new LinkedQueue<String>();
	LinkedQueue<Integer> qInteger = new LinkedQueue<Integer>();

	@BeforeEach
	void setupThis() {
		qString = new LinkedQueue<String>();
		qInteger = new LinkedQueue<Integer>();
	}

	@DisplayName("Check Size of Queue Integer")
	@Test public void testSizeInteger() {
		assertEquals(0, qInteger.size());
		qInteger.enqueue(0);
		assertEquals(1, qInteger.size());
	}
	
	@DisplayName("Check Size of Queue String")
	@Test public void testSizeString() {
		assertEquals(0, qString.size());
		qString.enqueue("test");
		assertEquals(1, qString.size());
	}

	@DisplayName("Check if Queue is empty Integer")
	@Test public void testIfEmptyInteger() {
		assertEquals(true, qInteger.isEmpty());
		qInteger.enqueue(1);
		assertEquals(false, qInteger.isEmpty());
	}
	
	@DisplayName("Check if Queue is empty String")
	@Test public void testIfEmptyString() {
		assertEquals(true, qString.isEmpty());

		qString.enqueue("test");
		assertEquals(false, qString.isEmpty());
	}
	
	@DisplayName("Testing Enqueue Integer")
	@Test public void testEnqueueInteger() {
		qInteger.enqueue(1);
		assertEquals(1, qInteger.first());
		qInteger.enqueue(2);
		qInteger.enqueue(3);
		assertEquals(1,qInteger.first());
	}
	
	@DisplayName("Testing Enqueue String")
	@Test public void testEnqueueString() {
		qString.enqueue("1");
		assertEquals("1", qString.first());
		qString.enqueue("2");
		qString.enqueue("3");
		assertEquals("1",qString.first());
	}
	
	@DisplayName("Testing Dequeue Integer")
	@Test public void testDequeueInteger() {
		assertEquals(true, qInteger.isEmpty());
		qInteger.enqueue(1);
		assertEquals(1, qInteger.size());
		qInteger.dequeue();
		assertEquals(0, qInteger.size());
		assertEquals(true, qInteger.isEmpty());
	}
	
	@DisplayName("Testing Dequeue String")
	@Test public void testDequeueString() {
		assertEquals(true, qString.isEmpty());
		qString.enqueue("1");
		assertEquals(1, qString.size());
		qString.dequeue();
		assertEquals(0, qString.size());
		assertEquals(true, qString.isEmpty());
	}
	
	@DisplayName("Test First Integer")
	@Test public void testFirstInteger() {
		qInteger.enqueue(1);
		qInteger.enqueue(2);
		qInteger.enqueue(3);
		qInteger.enqueue(4);
		assertEquals(1, qInteger.first());
	}
	
	@DisplayName("Test First String")
	@Test public void testFirstString() {
		qString.enqueue("1");
		qString.enqueue("2");
		qString.enqueue("3");
		qString.enqueue("4");
		assertEquals("1", qString.first());
	}
	
	@DisplayName("Test Last Integer")
	@Test public void testLastInteger() {
		qInteger.enqueue(1);
		qInteger.enqueue(2);
		qInteger.enqueue(3);
		assertEquals(3, qInteger.last());
	}
	
	@DisplayName("Test Last String")
	@Test public void testLastString() {
		qString.enqueue("1");
		qString.enqueue("2");
		qString.enqueue("3");
		assertEquals("3", qString.last());
	}
	
	@DisplayName("Test toString Integer")
	@Test public void testToStringInteger() {
		qInteger.enqueue(1);
		qInteger.enqueue(2);
		qInteger.enqueue(3);
		String str = "[ 1 ][ 2 ][ 3 ]";
		assertEquals(str, qInteger.toString());
	}
	
	@DisplayName("Test toString String")
	@Test public void testToStringString() {
		qString.enqueue("1");
		qString.enqueue("2");
		qString.enqueue("3");
		String str = "[ 1 ][ 2 ][ 3 ]";
		assertEquals(str, qString.toString());
	}
}