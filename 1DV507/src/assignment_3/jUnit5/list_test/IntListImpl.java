package assignment_3.jUnit5.list_test;

/*
*   IntListImpl.java
*
*   Created 2005-nov-07, 13:19:01
*/

public class IntListImpl implements IntList {
	private int size = 0;
	private int[] values;
	
	public IntListImpl() {values = new int[8];}
	
	public void add(int n) {
		values[size++] = n;
		if (size == values.length) { // increase size
			int[] tmp = new int[2*values.length];
			System.arraycopy(values,0,tmp,0,values.length); 
			values = tmp;
		}
	}
	
	public void remove(int index)  throws IndexOutOfBoundsException {
		checkIndex(index);
		for (int i=index;i<size;i++)
			values[i] = values[i+1];
		size--;
	}
	
	public int get(int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		return values[index];
	}
	
	public int size() {return size;}
	
	public int indexOf(int n) {
		for (int i=0;i<size;i++) {
			if (values[i]==n)
				return i;
		}
		return -1;
	}
	
	/* Using the sort(int[]) provided by java.util.Arrays */
	public void sort() {
		int[] tmp = new int[size];
		System.arraycopy(values,0,tmp,0,size);
		java.util.Arrays.sort(tmp);
		System.arraycopy(tmp,0,values,0,size);
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		for (int i=0;i<size;i++) {
			buf.append(" "+values[i]);
		}

		buf.append(" ]");
		return buf.toString();
	}
	
	private void checkIndex(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			String msg = "Index = "+index+", Length = "+values.length;
			throw new IndexOutOfBoundsException(msg);
		}
	}
}