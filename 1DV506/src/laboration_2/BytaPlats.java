package laboration_2;

public class BytaPlats {
	public static void main(String[] args) {
		char[] text = { 't', 't', 'ä', 'l', ' ', 'r', 'a', 'v', ' ', 'a', 
				't', 't', 'e', 'D' };
		
		// Print Original Array:
		System.out.print("Original: ");
		System.out.print(text);
		
		int first = 0;
		int last = text.length - 1;
		
		// Create new empty array:
		char[] newText = new char[text.length];
		
		// Place array items into new array:
		for (int i = 0; i < text.length; i++) {
			newText[last] = text[i];
			last--;
		}
		
		// Place new array items into original array.
		for (int i = 0; i < text.length; i++) {
			text[i] = newText[first];
			first++;
		}
		
		// Print Results:
		System.out.print("\nNya: ");
		System.out.print(text);
	}
}