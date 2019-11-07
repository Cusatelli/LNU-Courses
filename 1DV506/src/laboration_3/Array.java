package laboration_3;

import java.util.Arrays;
/*--------------------------------------------------------
						 Main 1
--------------------------------------------------------*/
public class Array {
	public static void main(String[] args) {
		int[] n = {3,4,5,6,7};
		
		// Call & Print sum method:
		System.out.println("sum: " + sum(n));
		
		// Call & Print toString method:
		System.out.println("n: " + toString(n));
		
		// Call & Print addN method (+ Convert toString):
		System.out.println("addN: " + toString(addN(n, 7)));
		
		// Call & Print reverse method (+ Convert toString):
		System.out.println("reverse: " + toString(reverse(n)));
		
		// Call & Print hasN method:
		System.out.println("hasN: " + hasN(n, 3));
		
		// Call & Print replaceAll method (Array, old, new):
		replaceAll(n, 4, 9);
		System.out.println("replaceAll: " + toString(n));
		
		// Call & Print sort method (+ Convert toString):
		System.out.println("sort: " + toString(sort(n)));
	}
/*--------------------------------------------------------
						Task 1.1
--------------------------------------------------------*/
	public static int sum(int[] arr) {
		int sum = 0;
		
		// The total sum:
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}
/*--------------------------------------------------------
						Task 1.2
--------------------------------------------------------*/
	public static String toString(int[] arr) {
		// Convert to String:
		String str = Arrays.toString(arr);
		return str;
	}
/*--------------------------------------------------------
						Task 1.3
--------------------------------------------------------*/
	public static int[] addN(int[] arr, int n) {
		int[] addN;
		addN = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			addN[i] = arr[i];
			addN[i] = addN[i] * n;
		}
		return addN;	
	}
/*--------------------------------------------------------
						Task 1.4
--------------------------------------------------------*/
	public static int[] reverse(int[] arr) {
		int[] reverse;
		reverse = new int[arr.length];
		int backwards = arr.length - 1;
		
		for (int i = 0; i < arr.length; i++) {
			reverse[backwards] = arr[i];
			backwards--;
		}
		return reverse;
	}
/*--------------------------------------------------------
						Task 1.5
--------------------------------------------------------*/
	public static boolean hasN(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				return true;
			}
		}
		return false;
	}
/*--------------------------------------------------------
						Task 1.6
--------------------------------------------------------*/
	public static void replaceAll(int[] arr, int old, int nw) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == old) {
				arr[i] = nw;
			}
		}
	}
/*--------------------------------------------------------
						Task 1.7
--------------------------------------------------------*/
	public static int[] sort(int[] arr) {
		
		int[] sort;
		sort = new int[arr.length];

		// Copy arr to sort:
		for (int i = 0; i < arr.length; i++) {
			sort[i] = arr[i];
		}
		
		// BubbleSort:
		boolean unsorted = true;
		int backwards = 0;
		int temporary;
		
		while (unsorted) {
			unsorted = false;
			backwards++;
			for (int i = 0; i < arr.length - backwards; i++) {
				if (sort[i] > sort[i + 1]) {
					temporary = sort[i];
					sort[i] = sort[i + 1];
					sort[i + 1] = temporary;
					unsorted = true;
				}
			}
		}
		return sort;
	}
/*--------------------------------------------------------
						Task 1.8
--------------------------------------------------------*/
	public static boolean hasSubsequence(int[] arr, int[] sub) {
		return false;
	}
/*--------------------------------------------------------
						Task 1.9
--------------------------------------------------------*/
	public static boolean isLarger(int[] a1, int[] a2) {
		return false;
	}
}
