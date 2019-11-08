package assignment_3.count_words.treeSet;

import java.util.ArrayList;
import java.util.Iterator;

import assignment_3.count_words.Word;
import assignment_3.count_words.WordSet;

public class TreeWordSet implements WordSet {
	public ArrayList<String> temp = new ArrayList<String>();
	Word word;
	TreeWordSet tws;
	public int size = 0;
	public int index;
	
	public static Node root; // Root Node.
	public TreeWordSet() {
		TreeWordSet.root = null;
	}
	
	public int toHash() {
		index = word.hashCode();
		if (index < 0) { index = -index; }
		return index;
	}
	
	@Override
	public void add(Word word) {
		Node node = new Node(word); // New Node with our desired word to input.
		if(!contains(word)) {
			/* 
			 * If we have found the correct location for insertion,
			 * insert the Node.
			 */
			if(root == null) {
				root = node;
				return;
			}

			/*
			 * Similar procedure as in find() method.
			 */
			Node current = root;
			Node parent = null;
			while(true) {
				parent = current;
				/* current.data > word */
				if(current.data.hashCode() > index) { // Swap pos of id and curr.data.
					current = current.left;

					if(current == null) {
						parent.left = node;
						return;
					}

				} else {
					current = current.right;

					if(current == null) {
						parent.right = node;
						return;
					}
				}
			}
		}
	}

	@Override
	public boolean contains(Word word) {
		Node current = root; // Set current Node to the root node. (For localizing position in tree).

		while(current != null) { // While we have not found the specified word.
			if (current.data.equals(word)) {
				return true; // We have found the word.
				/* 
				 * If current Node data is greater than word, 
				 * go to Left Branch in tree.
				 * Or Right Branch if less than word.
				 * And set current(root) Node to Left / Right Node.
				 */
				// Left Node:
			} else if (current.data.hashCode() > index) {
				current = current.left; // Set current(Root) Node to Left branch as new current.
				// Right Node:
			} else {
				current = current.right; // Set current(Root) Node to Right branch as new current.
			}
		}
		return false; // If we could not find word in any branch it is not present; Return false.
	}
	
	/* ******	TO STRING	****** */
	// Display root Node:
	public void toString(Node root) {
		if(root != null) {
			System.out.println(" " + ((Word) root.data).getWord() + "");
			toString(root.left);
			toString(root.right);
		}
	}

	public void toArray(Node root) {
		if(root != null) {
			temp.add(((Word) root.data).getWord());
			toArray(root.left);
			toArray(root.right);
		}
	}
	
	@Override 
	public int size() {
		return(size(root)); 
	}

	private int size(Node node) { 
		if (node == null) return(0); 
		else { 
			return(size(node.left) + 1 + size(node.right)); 
		}
	}
	
	@Override
	public Iterator<Word> iterator() {
		return null;
	}
	
	public class Node {
		public Object data;
		public Node left;
		public Node right;
		/*
		 * Left and Right Node points to NULL 
		 * This way we know when we have reached the end of the Tree.
		 */
		public Node(Word word) {
			this.data = word;
			left = null;
			right = null;
		}
	}
}
