package assignment_3.count_words;

public class Word implements Comparable<Word> {

	private String word;
	private int hash;

	public Word(String str) {
		this.word = str.toLowerCase();
		this.hash = str.hashCode();
	}

	@Override
	public String toString() {
		return "(" + hash + ")\t" + word;
	}

	@Override
	public int hashCode() {
		setHash(word.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object other) {
		/* ... true if two words are equal */
		if (other instanceof Word) {
			Word otherWord = (Word) other;
			return word.equals(otherWord.word); // Compare ID of Strings.
		}
		return false;
	}

	public int compareTo(Word w) {
		int compare = getWord().compareTo(w.getWord());
		if(compare < 0) {
			return -1;
		} else if(compare > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public void setHash(int hash) {
		this.hash = hash;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
//	private String word;
//	private int size;
//	private Node[] buckets = new Node[8];
//	
//	public Word(String str) {
//		word = str.toLowerCase();
//		add(word);
//	}
//	
//	public void add(String str) {
////		word = str/*.toLowerCase()*/;
//		int pos = getBucketNumber(str); // Get the position of the input String.
//		Node node = buckets[pos]; // First node in list.
//		while(node != null) { // Search list.
//			if(node.value.equals(str)) 
//				return; // Element found; return
//
//			else 
//				node = node.next; // Next node in list.
//		}
//		node = new Node(str); // If not found add node to list.
//		node.next = buckets[pos]; 
//		buckets[pos] = node;
//		size++;
//
//		if (size == buckets.length) rehash(); // Rehash (increase size) if needed.
//	}
//	
//	// Gets index of chosen word in hashbucket:
//	private int getBucketNumber(String str) {
//		int hash = str.hashCode(); // Use hashCode() from String class.
////		System.out.println(hash);
//		if (hash < 0) { hash = -hash; } // Check if it's a negative number.
////		System.out.println(hash % buckets.length);
//		return hash % buckets.length; // Hash function.
//	}
//	
//	@Override
//	public int hashCode() {
//		/* ... compute a hash value for word */
//		/* 
//		 * This is my preferred way of hashCoding at the moment.
//		 * If feels better to work with high value numbers:
//		 * Also it feels more accurate.
//		 */
//		int hash = 0; // Based on Integer String.
//		for (int i = 0; i < word.length(); i++) {
//			hash += word.hashCode();
//		}
//		return hash;
//	}
//
//	// Increases bucket size:
//	private void rehash() { 
//		Node[] temp = buckets; // Copy of old bucket.
//		buckets = new Node[2 * temp.length]; // New empty buckets.
//		size = 0;
//		for ( Node n : temp ) { // Insert old buckets into new buckets.
//			if (n == null) continue; // Empty bucket.
//			while (n != null) { 
//				add(n.value); // Add elements again.
//				n = n.next;
//			}
//		}
//	}
//	
//	public boolean contains(String str) {
//		int pos = getBucketNumber(str);
//		Node node = buckets[pos];
//		word = str.toLowerCase();
//		while(node != null) { // Search list for element.
//			if (node.value.equals(word))
//				return true; // Found element.
//
//			else
//				node = node.next;
//		}
//		return false; // Did not find element.
//	}
//	
//	@Override
//	public boolean equals(Object other) {
//		/* ... true if two words are equal */
//		if (other instanceof Word) {
//			Word otherWord = (Word) other;
//			return word.equals(otherWord.word); // Compare ID of Strings.
//		}
//		return false;
//	}
//
//	public int compareTo(Word w) {
//		/* ... compares two words lexicographically */
//		if (word.equalsIgnoreCase(w.word)) { return 1; }
//		else { return 0; }
//	}
//	
//	//Private inner classes
//	private class Node { 
//		String value;
//		Node next = null;
//		
//		public Node(String str) {
//			value = str;
//		}
//		
//		public String toString() {
//			return value;
//		}
//	}
}