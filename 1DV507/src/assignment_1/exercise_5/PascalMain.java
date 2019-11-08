package assignment_1.exercise_5;

public class PascalMain {
	
	public static void main(String[] args) {
		PascalMain p = new PascalMain();
		
		int INPUT = 15; // Number of desired rows.
		
		System.out.print("\nThe " + INPUT + ":th row of Pascal/'s Triangle: ");
		System.out.print(p.printArray(p.pascalRow(INPUT)));
	}
	
	private int[] pascalRow(int n) {
		int[] previous;
		int[] current = { 1 };
		previous = current;
		
		for (int i = 2; i <= n; i++) {
			current = new int[i];
			current[0] = 1;
			current[i - 1] = 1;
			for (int j = 0; j <= i - 3; j++) {
				current[j + 1] = previous[j] + previous[j + 1];
			}
			previous = current;
		}
		return current;
	}
	
	private String printArray(int[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(" " + array[i] + " ");
		}
		return sb.toString();
	}
}
