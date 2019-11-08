package assignment_4.binheap;

import assignment_4.binheap.exercise5.BinaryIntHeap;

public class BinaryHeapMain {
	public static void main(String[] args) {
		BinaryIntHeap BIH = new BinaryIntHeap();

		System.out.println("isEmpty?: " + BIH.isEmpty() + "\n");
		BIH.insert(11);
		BIH.insert(2);
		BIH.insert(3);
		BIH.insert(54);
		BIH.insert(99);
		BIH.insert(21);
		BIH.insert(32);
		BIH.insert(15);
		BIH.insert(9);
		BIH.insert(10);
		System.out.println("First-in: " + BIH.pullHighest());
		System.out.println("Size: " + BIH.size());
		System.out.println("isEmpty?: " + BIH.isEmpty());
		System.out.println("First-in: " + BIH.pullHighest());
	}
}
