package laboration_3;

public class MultiDisplay {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MultiDisplay md = new MultiDisplay();
		
		md.setDisplayMessage("Hello World!");
		md.setDisplayCount(3);
		md.display();                           // ==> print-out
				
		md.display("Goodbye cruel world!", 2);  // ==> print-out
				
		System.out.println("Current Message: "+ md.getDisplayMessage());
	}

	private void display(String string, int i) {
		String[] md = null;
		main(md);
	}

	private String getDisplayMessage() {
		String[] md = null;
		main(md);
		
		return null;
	}

	private void display() {
		String[] md = null;
		main(md);
	}

	private void setDisplayCount(int i) {
		String[] md = null;
		main(md);
	}

	private static String setDisplayMessage(String str) {
		str = "Hello World!";
		return str;
	}
}
