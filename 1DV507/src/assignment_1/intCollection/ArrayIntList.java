package assignment_1.intCollection;

import java.util.ArrayList;
import java.util.List;

public class ArrayIntList extends AbstractIntCollection implements IntList {
	
	private List<Integer> list = new ArrayList<Integer>();
	
	// Debug to check if values are actually overwritten:
	public void overrideValues(int a, int b, int c, int d, int e, int f, int g, int h) {
		values[0] = a;
		values[1] = b;
		values[2] = c;
		values[3] = d;
		values[4] = e;
		values[5] = f;
		values[6] = g;
		values[7] = h;
		
		size = values.length;
	}
	
	// Add values to List:
	public void toList() {
		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
	}
	
	// Reverts List to int[] array values:
	public void revertToArray() {
		resize();
		size = list.size();
		for (int i = 0; i < size; i++) {
			int tmp = list.get(i);
			values[i] = tmp;
		}
	}
	
	@Override
	public void add(int n) {
		list.add(n);
		// Debug:
		System.out.println("Add(" + list.get(list.size() - 1) + ")");
		revertToArray();
	}

	@Override
	public void addAt(int index, int n) throws IndexOutOfBoundsException {
		list.add(index,  n);
		// Debug:
		System.out.println("Add(" + n + ") at index (" + index + ")");
		revertToArray();
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		// Debug:
		System.out.println("Remove(" + index + "): " + list.get(index));
		list.remove(index);
		revertToArray();
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		int getIndex = list.get(index);
		// Debug:
		System.out.println("Get(" + index + "): " + getIndex);
		return getIndex;
	}

	@Override
	public int indexOf(int n) {
		int indexOf = list.indexOf(n);
		// Debug:
		System.out.println("Index of " + n + ": " + indexOf);
		return indexOf;
	}
	
	public int size() {
		// Debug:
		System.out.println("Size: " + size);
		return size;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			// Debug:
			System.out.println("The List is Empty!");
			return true;
		}
		// Debug:
		System.out.println("The List contains elements!");
		return false;
	}
}
