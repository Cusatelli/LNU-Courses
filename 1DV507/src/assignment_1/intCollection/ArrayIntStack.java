package assignment_1.intCollection;

import java.util.Stack;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
	private Stack<Integer> stack = new Stack<Integer>();
	
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

	// Add values to Stack:	
	public void toStack() {
		for (int i = 0; i < values.length; i++) {
			stack.add(values[i]);
		}
	}
	
	// Reverts Stack to int[] array values:
	public void revertToArray() {
		resize();
		size = stack.size();
		for (int i = 0; i < size; i++) {
			int tmp = stack.get(i);
			values[i] = tmp;
		}
	}
	
	@Override
	public void push(int n) {
		stack.push(n);
		System.out.println("Push(" + n + ")");
		revertToArray();
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		System.out.println("Pop(" + stack.get(stack.size()-1) + "): " );
		stack.pop();
		revertToArray();
		return 0;
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		int peeked = stack.peek();
		System.out.println("Peek(" + peeked + ")");
		return peeked;
	}

	public int size() {
		size = stack.size();
		System.out.println("Size: " + size);
		return size;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			// Debug:
			System.out.println("The Stack is Empty!");
			return true;
		}
		// Debug:
		System.out.println("The Stack contains elements!");
		return false;
	}
}
