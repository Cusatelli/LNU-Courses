package assignment_2.exercise_3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import assignment_2.exercise_1.LinkedQueue;

class LinkedQueueTest {
	LinkedQueue linkedQueue = new LinkedQueue();

	@BeforeEach
	void setupThis() {
		linkedQueue = new LinkedQueue();
	}

	@DisplayName("Check Size of Queue")
	@Test public void testSize() {
		assertEquals(0, linkedQueue.size());
		linkedQueue.enqueue(new Object());
		assertEquals(1, linkedQueue.size());
	}

	@DisplayName("Check if Queue is empty")
	@Test public void testIfEmpty() {
		assertEquals(true, linkedQueue.isEmpty());

		linkedQueue.enqueue(new Object());
		assertEquals(false, linkedQueue.isEmpty());
	}

	@DisplayName("Testing Enqueue")
	@Test public void testEnqueue() {
		linkedQueue.enqueue("1");
		assertEquals("1", linkedQueue.first());
		linkedQueue.enqueue("2");
		linkedQueue.enqueue("3");
		assertEquals("1",linkedQueue.first());
	}

	@DisplayName("Testing Dequeue")
	@Test public void testDequeue() {
		assertEquals(true, linkedQueue.isEmpty());
		linkedQueue.enqueue("1");
		assertEquals(1, linkedQueue.size());
		linkedQueue.dequeue();
		assertEquals(0, linkedQueue.size());
		assertEquals(true, linkedQueue.isEmpty());
	}

	@DisplayName("Test First")
	@Test public void testFirst() {
		linkedQueue.enqueue("1");
		linkedQueue.enqueue("2");
		linkedQueue.enqueue("3");
		linkedQueue.enqueue("4");
		assertEquals("1", linkedQueue.first());
	}

	@DisplayName("Test Last")
	@Test public void testLast() {
		linkedQueue.enqueue("1");
		linkedQueue.enqueue("2");
		linkedQueue.enqueue("3");
		assertEquals("3", linkedQueue.last());
	}

	@DisplayName("Test toString")
	@Test public void testToString() {
		linkedQueue.enqueue("1");
		linkedQueue.enqueue("2");
		linkedQueue.enqueue("3");
		String str = "[ 1 ][ 2 ][ 3 ]";
		assertEquals(str,linkedQueue.toString());
	}
}