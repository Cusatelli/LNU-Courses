package ev222hh_lab1;

import java.util.Random;

public class Slumpsumma {
	public static void main(String[] args) {
		
		Random slump = new Random();
		
		//slump.nextInt(100) is the maximum numb. and +1 is to increase our minimum from 0 to 1.
		//to get 1-100 instead of 0-99.
		int s1 = slump.nextInt(100) +1;
		int s2 = slump.nextInt(100) +1;
		int s3 = slump.nextInt(100) +1;
		int s4 = slump.nextInt(100) +1;
		int s5 = slump.nextInt(100) +1;
		
		int sTot = s1 + s2 + s3 + s4 + s5;
		
		System.out.println("Fem genererade slumptal: " + s1 + ", "  + s2 + ", "  + s3 + ", "  + s4 + ", "  + s5);
		
		System.out.println("Slumptalens summa är: " + sTot);
	}
}
