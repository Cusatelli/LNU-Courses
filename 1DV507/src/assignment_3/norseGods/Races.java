package assignment_3.norseGods;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class Races implements Constants  {
	public final String AESIR = "Aesir\n\n";
	public final String VANIR = "Vanir\n\n";
	public final String GIANT = "Giant\n\n";
	
	public Races() {
		SUBTITLE.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
	}
}
