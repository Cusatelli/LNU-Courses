package assignment_3.jUnit5;
/**
 * MyMath.java
 * 30 jan. 2018
 *
 * @author jlnmsi
 *
 */
public class MyMath {
	
	/*
	 * A static method computing a*b using recursion.
	 * It requires that the 2nd parameter b is non-negative. 
	 */
	public static int mult(int a,int b) {
		if (b < 0)
			throw new IllegalArgumentException("2nd parameter must be non-negative!");
		else if (b == 0)
			return 0;
		else
			return a + mult(a,b-1);
	
	}
	
	/*
	 * A static method sorting an integer array. 
	 *  
	 */
	public static void sort(int[] in) {
		int sz = in.length;
		for (int i=0;i<sz-1;i++) {
			int first = i;           // position to update
			int min = first;         // initialize min
			for (int j=first+1;j<sz;j++) {  // remaining elements
				if (in[j] < in[min])
					min = j;
			}
			/* Swap first and min */
			int tmp = in[first];
			in[first] = in[min];
			in[min] = tmp;
		}	
	}
}