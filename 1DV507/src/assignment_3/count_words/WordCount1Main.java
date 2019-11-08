package assignment_3.count_words;

import java.io.FileNotFoundException;
import java.util.TreeSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//import ev222hh_assign3.count_Words_NEW.binarySearchTree_NEW.BinarySearchTree;

public class WordCount1Main extends Word {
	public static Set<Word> hashSet = new HashSet<>();
	public static Set<Word> treeSet = new TreeSet<>();
	public static Word word;
	public static ArrayList<String> words = new ArrayList<String>();
	public WordCount1Main(String str) { super(str); }
	
	public static void main(String[] args) {
		/* 
		 * Runs IdentifyWordsMain Class:
		 * 
		 * ******************************************************** */
		try {
			IdentifyWordsMain.main(args); // Runs IdentifyWordsMain.
			words = IdentifyWordsMain.words; // Get words ArrayList from IdentifyWordsMain:
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not Found!"
					+ "\n\nError occured within IdentifyWordsMain.java class."
					+ "\nPlease make sure all the files are spelled correctly,"
					+ "\nand can be located by the program."
					+ "\n\nThe file names are case-sensitive.");
		}
		/* ******************************************************** */
		
		for (int i = 0; i < words.size(); i++) {
			word = new Word(words.get(i)); // Create an object of the class Word.
			hashSet.add(word); // Add the object to a set of the type java.util.HashSet.			
			treeSet.add(word); // Add the object to a set of the type java.util.TreeSet.
		}
		
		System.out.println();
		System.out.println("Words in TreeSet: " + treeSet.size());
		System.out.println("Words in HashSet: " + hashSet.size()); // Display set size. (Contains +1 since it also added a blank).
		
		iterator(treeSet.iterator());
	}
	
	public static void iterator(Iterator<Word> it) {
		/* **************************** */
		System.out.print("\n\nIterate over Contents:\n"
				+ "======================");
		/* **************************** */
		for(Word w : treeSet) {
			System.out.println(w.getWord());
		}
	}
}