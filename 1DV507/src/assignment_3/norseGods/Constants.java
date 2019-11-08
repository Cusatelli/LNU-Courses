package assignment_3.norseGods;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public interface Constants {
	/* ****************	SETTINGS ************** */
	/* *************	ARRAYLIST	*********** */
	public ArrayList<String> NAME = new ArrayList<String>();
	public ArrayList<String> RACE = new ArrayList<String>();
	public ArrayList<String> DESCRIPTION = new ArrayList<String>();
	public ListView<String> LISTVIEW = new ListView<>();
	
	/* *************	JAVAFX		*********** */
	public BorderPane BORDERPANE = new BorderPane();
	public Label HEADER = new Label("Norse Gods and other Beings");
	public Text TITLE = new Text();
	public Text SUBTITLE = new Text();
	public Text BODY = new Text();
	public TextFlow TEXTFLOW = new TextFlow(TITLE, SUBTITLE, BODY);
	public ScrollPane SCROLLPANE = new ScrollPane();
	
	/* *************	BORDER	*************** */
	public final int WIDTH = 600;
	public final int HEIGHT = 400;
}