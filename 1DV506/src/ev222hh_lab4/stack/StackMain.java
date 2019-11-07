package ev222hh_lab4.stack;

import java.util.Random;

public class StackMain {
	public static void main(String[] args) {
		ImplementsStack stack = new ImplementsStack();
		Random random = new Random();
		
		/*
		 * Demonstrates how the stack interface works with some loops that adds elements
		 * and removes them:
		 */
		
		System.out.println("Stack is empty?\n* * " + stack.isEmpty() + " * *");
		
		// Adds elements to stack:
		for (int i = 0; i < 4; i++) {
			int rand = random.nextInt(101); // 0 - 100
			stack.push(rand/3);
			if (i%2 == 0) {
				System.out.println("Peek: " + stack.peek() + " <--");
			}
			stack.push(rand*2);
			stack.push((rand*6)/7);
			stack.iterator();
		}
		
		System.out.println("\nCurrent Stack Size: " + stack.size());
		System.out.println();
		
		// Removes elements from stack:
		for (int i = 0; i < 4; i++) {
			stack.pop();
			if (i%3 == 0) {
				
			}
			stack.pop();
			stack.iterator();
		}
		
		// Adds and removes elements from stack:
		System.out.println();
		
		stack.pop();
		System.out.println("Peek: " + stack.peek() + " <--");
		stack.pop();
		System.out.println("\nCurrent Stack Size: " + stack.size());
		stack.iterator();
	}
}