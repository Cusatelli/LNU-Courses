/*
 * AbstractIntCollection.java
 * Date: 23 nov 2007
 * Author: Jonas Lundberg
 */
package assignment_1.intCollection;

import java.util.Iterator;

/*
 * An abstract class that provides basic support for 
 * array based linear data structures.
 */

public abstract class AbstractIntCollection {
	protected int size = 0;
	protected int[] values = new int[8];
	
	
	/* Public interface */
	public int size() {return size;}
	
	public boolean isEmpty() {return size==0;}
		
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		for (int i=0;i<size;i++) {
			buf.append(" "+values[i]);
		}

		buf.append(" ]");
		return buf.toString();
	}
	
	public Iterator<Integer> iterator() {
		return new IntIterator();
	}
	
	/* Protected help methods that can be used by extending classes */
	protected void  resize() {
		int[] tmp = new int[2*values.length];
		System.arraycopy(values,0,tmp,0,values.length); 
		values = tmp;
	}
	
	protected boolean checkIndex(int index, int upper){
		if (index < 0 || index >= upper) {
			String msg = "Index = "+index+", Upper boundary = "+upper;
			System.err.println(msg);
			return false;
		}
		return true;
	}
	
	/* Private inner class used by iterator() */
	class IntIterator implements Iterator<Integer> {
		private int count = 0;
		public Integer next() {return values[count++];}
		
		public boolean hasNext() {return count<size;}
		
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}
}
