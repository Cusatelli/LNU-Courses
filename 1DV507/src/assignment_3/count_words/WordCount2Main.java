package assignment_3.count_words;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import assignment_3.count_words.hashSet.HashWordSet;
import assignment_3.count_words.treeSet.TreeWordSet;

public class WordCount2Main extends Word {
//	public static Set<Word> hashSet = new HashSet<>();
//	public static Set<Word> treeSet = new TreeSet<>();
//	public static TreeWordSet tws = new TreeWordSet();
	public static HashWordSet hws = new HashWordSet(1);
	public static TreeWordSet tws = new TreeWordSet();
	public static Word word;
	public static ArrayList<String> words = new ArrayList<String>();
	public WordCount2Main(String str) { super(str); }
	
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
			hws.add(word); // Add the object to a set of the type java.util.HashSet.			
			tws.add(word); // Add the object to a set of the type java.util.TreeSet.
		}
		
		System.out.println();
		System.out.println("Words in TreeSet: " + tws.size());
		System.out.println("Words in HashSet: " + hws.size()); // Display set size. (Contains +1 since it also added a blank).
		
		tws.toString();
		tws.toArray(TreeWordSet.root);
		iterator();
	}
	
	public static void iterator() {
		/* **************************** */
		System.out.print("\n\nIterate over Contents:\n"
				+ "======================");
		/* **************************** */
		Collections.sort(tws.temp);
		for (int i = 0; i < tws.temp.size(); i++) {
			System.out.println(" " + tws.temp.get(i));
		}		
	}
}