package assignment_3.count_words.treeSet;

import assignment_3.count_words.Word;

public class TreeWordSetTest {
	public static void main(String[] args) {
		// TEST:
		String[] alphabet = {"Alpha", "Beta", "Charlie", "Delta", "Echo", "Foxtrot", "India", "Horus", "Gamma", "John", "Kennedy", "Lambda"};
		TreeWordSet tws = new TreeWordSet();
		Word word;
		tws = new TreeWordSet();
		Word one = new Word("Marie");
		Word two = new Word("Marie");
		Word three = new Word("Curie");
		for (int i = 0; i < alphabet.length; i++) {
			word = new Word(alphabet[i]);
			tws.add(word);
			System.out.println(tws.contains(word));
		}
		
		System.out.println(tws.contains(one));
		System.out.println(tws.contains(two));
		System.out.println(tws.contains(three));
		System.out.println("Size: " + tws.size());
		System.out.println("Tree:\n"
				+ "======");
		tws.toString(TreeWordSet.root);
	}
}
