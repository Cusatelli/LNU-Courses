package assignment_3.jUnit5.list_test;
/*
*   IntList.java
*
*   Created 2005-nov-06, 22:54:39
*/

public interface IntList {
	/** Add integer n to list */
	public void add(int n);
	/** Remove integer at position index */
	public void remove(int index) throws IndexOutOfBoundsException;
	/** Get integer at position index */
	public int get(int index) throws IndexOutOfBoundsException;
	/** Number of integers currently stored */
	public int size();
	/** Find position of integer n, otherwice return -1 */
	public int indexOf(int n);
	/** Sort list in ascending order */
	public void sort();
	/** String of type "[ 7 56 -45 68 ... ]" */
	public String toString();
}


