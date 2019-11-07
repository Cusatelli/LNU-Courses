package ev222hh_lab4.stack;

import java.util.Iterator;

public class ImplementsStack implements Stack {
	
	int capacity = 2;
	int[] stack = new int[capacity];
	int top = 0;

	// Expands or Shrinks Stack array by 2
	public void resize() {
		int length  = size();
		
		// First check if empty:
		if (isEmpty()) {
			System.out.println("Stack is Empty");
		
		// If size of Stack is 1/4th of current capacity
		// Shrink it by half:
		} else if(length <= (capacity/2)/2) {
			capacity = capacity/2;
			
			int newStack[] = new int[capacity];
			
			for (int i = 0; i < length; i++) 
				newStack[i] = stack[i];
			
			stack = newStack;
		
		// If size of Stack has reached the current capacity
		// Expand capacity by 2 times:	
		} else if (length == capacity) {
			int newStack[] = new int[capacity*2];
			
			for (int i = 0; i < stack.length; i++) {
				newStack[i] = stack[i];
			}
			
			stack = newStack;
			capacity *= 2;
		}
	}
	
	// Returns size of Stack:
	@Override
	public int size() {
		return top;
	}
	
	// Returns false if size is greater than 0:
	@Override
	public boolean isEmpty() {
		return top<=0;
	}
	
	// Adds object(int) on top of Stack array:
	@Override
	public void push(Object element) {	
		if(size() == capacity)
			resize();
		
		stack[top] = (int) element;
		top++;
	}

	// Removes object(int) on top of Stack array:
	// Unless stack is empty!
	@Override
	public Object pop() {
		int data = 0;
		
		if(isEmpty()) {
			System.out.println("Stack is empty!");
		} else {
			top--;
			data = stack[top];
			stack[top] = 0;
			resize();
		}
		return data;
	}
	
	// Returns object(int) on top of stack array:
	// unless stack is empty!
	@Override
	public Object peek() {
		int data = 0;
		
		if (isEmpty()) {
			System.out.println("Stack is empty!");
		} else {
			data = stack[top - 1];
		}
		return data;
	}
	
	// Iterates over stack array:
	// Unless stack is empty!
	@Override
	public Iterator<Object> iterator() {
		int count = 0;
		
		if (!isEmpty()) {
			System.out.print("Iterate over Stack: ");
			// if stack capacity is greater than stack size it will only print values of the size:
			for (int i : stack) {
				count++;
				if (count <= size()) {
					System.out.print("[" + i + "]");	
				}
			}
		}
		System.out.println();
		return null;
	}
}