package ev222hh_lab2;

public class TartLjus {
	public static void main(String[] args) {
		
		int boxes = 0;
		int boxesCount = 0;
		int candles = 0;
		int years = 1;
		
		// Every year:
		// Until 100.
		while (years <= 100) {
			boxes = 0;
			
			// If too little candles:
			// Buy box.
			// 1 Box = 24 Candles.
			if (candles < years) {
				while (candles < years) {
					candles = (candles + 24);			
					boxes++;
					boxesCount++;
				}
				
			// If enough Candles:
			// Remove Candles used. (Candles - Years).
			// Reset Boxes.
			} else if (candles >= years) {
				candles = candles - years;
				years++;
				
			} else {
				System.err.println("ERROR: Something went wrong!");
			}
			
			// If you bought Boxes:
			// Add them to "Cart".
			// & Print.
			if (boxes > 0) {
				System.out.println("Before birthday " + years + ", buy " + boxes + " box(es)");
			}
		}
		// Print Results:
		System.out.println("\nTotal number of boxes: " + boxesCount + ", Remaining candles: " + candles);
	}
}
