package assignment_1.intCollection;

/*
 * Override Values method is present because of easy debugging 
 * and to further ease testing of program for assessment:
 * 
 * Removal of overrideValues in both ArrayIntList and ArrayIntStack
 * does not impact the stability of the program.
 */

public abstract class CollectionMain extends AbstractIntCollection implements IntList {

	public static void main(String[] args) {
		ArrayIntList list = new ArrayIntList();
		ArrayIntStack stack = new ArrayIntStack();
		
		System.out.println("\n--------------- LIST ---------------");
		
		// Before we override values the list is empty:
		list.isEmpty();
		// Overrides all OLD values from AbstractIntCollection:
		// Enter 8 desired integers (Or comment out line):
		list.overrideValues(1, 6, 3, 0, 5, 19, 7, 12);
		
		// Convert int[] values to List<Integer> for easier manipulation:
		// This line is important for program functionality!
		list.toList();
		
		// Manipulates ArrayList:
		System.out.println("Current List: " + list);
		// Check if array is empty:
		list.isEmpty();
		list.size();
		list.remove(0);
		System.out.println("Current List: " + list);
		// AddAt(index, element) <---
		// And also pushes previous occupant to the right:
		list.addAt(0, 2);
		// Adds new element last in ArrayList:
		list.add(5);
		list.remove(4);
		list.add(6);
		System.out.println("List: " + list);
		// Get finds element at index 
		// (Ex: get(0) finds element at index 0):
		list.get(0);
		list.size();
		
		/*-------------------------------------*/
		System.out.println("\n-------------- STACK ---------------");
		// Before we override values the stack is empty:
		stack.isEmpty();
		
		// Overrides all OLD values from AbstractIntCollection:
		// Enter 8 desired integers (Or comment out line):
		stack.overrideValues(1, 6, 3, 0, 5, 19, 7, 12);
		
		// Convert int[] values to Stack<Integer> for easier manipulation:
		// This line is important for program functionality!
		stack.toStack();
		
		// Prints stack:
		System.out.println("Current Stack: " + stack);
		// Check if array is empty:
		stack.isEmpty();
		// Adds a value on top of stack:
		stack.push(1);
		// removes value on top of stack:
		stack.pop();
		stack.push(19);
		System.out.println("Current Stack: " + stack);
		// looks at value on top of stack:
		stack.peek();
		stack.push(11);
		// Returns the size of the current stack:
		stack.size();
	}
}
