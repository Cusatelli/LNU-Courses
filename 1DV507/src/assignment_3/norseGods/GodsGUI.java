package assignment_3.norseGods;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GodsGUI extends Application implements Constants {	
	
	static NorseGod gods = new NorseGod();
	Names NAMES = new Names();
	Races RACES = new Races();
	Descriptions DESCRIPTIONS = new Descriptions();
	
	public void start(Stage primaryStage) {
		LISTVIEW.setPrefWidth((WIDTH/4));
		LISTVIEW.getItems().addAll(
				NAMES.LOKI,
				NAMES.THOR,
				NAMES.ODIN,
				NAMES.BALDR,
				NAMES.FREYR,
				NAMES.FREYJA,
				NAMES.HEIMDALLR,
				NAMES.BRAGI,
				NAMES.TYR);

		TEXTFLOW.setPadding(new Insets(5, 5, 5, 5));
		TEXTFLOW.setPrefWidth(WIDTH - (WIDTH/3) - 10);
		TEXTFLOW.setTextAlignment(TextAlignment.JUSTIFY);

		SCROLLPANE.setContent(TEXTFLOW);
		SCROLLPANE.setPrefWidth(WIDTH - (WIDTH/3) + 10);
		
		BORDERPANE.setPadding(new Insets(5, 5, 5, 5));				// Padding.
		BORDERPANE.setPrefWidth(WIDTH);								// Width.
		BORDERPANE.setPrefHeight(HEIGHT);							// Height.
		HEADER.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		// Content Alignment:
		BORDERPANE.setLeft(LISTVIEW);								// Left = ListView.
		BORDERPANE.setRight(SCROLLPANE);							// Right = ScrollPane.
		BORDERPANE.setTop(HEADER);									// Top = Header Label.
		
		// Margins:
		BorderPane.setMargin(LISTVIEW, new Insets(12,12,12,12));	// ListView Margins.
		BorderPane.setMargin(SCROLLPANE, new Insets(12,12,12,12));	// ScrollPane Margins.
		BorderPane.setMargin(HEADER, new Insets(12,12,0,12));
		
		listenForAction();
		
		Scene scene = new Scene(BORDERPANE);
		primaryStage.setTitle("Norse Gods");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void listenForAction() {
		LISTVIEW.getSelectionModel().selectedIndexProperty().addListener(ov -> { // Listener.
			gods.setName(NAME.get(LISTVIEW.getSelectionModel().getSelectedIndex())); // Set the Name.
			gods.setRace(RACE.get(LISTVIEW.getSelectionModel().getSelectedIndex()));	// Set the Race.
			gods.setDesc(DESCRIPTION.get(LISTVIEW.getSelectionModel().getSelectedIndex())); // Set the Description.
			TITLE.setText(gods.getName()); // Get the active selections Name.
			SUBTITLE.setText(gods.getRace()); // Get the active selections Race.
			BODY.setText(gods.getDesc()); // Get the active selections Description.
		});
	}
}