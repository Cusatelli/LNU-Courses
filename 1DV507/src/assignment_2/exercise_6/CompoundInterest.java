package assignment_2.exercise_6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CompoundInterest extends Application {
	
	private double frequency = 1;
	private double startAmount;
	private double interest;
	private double numberOfYears;
	private double total;
	
	//*** Main method to start application: ******************************************************//
	public static void main(String[] args) {
		launch(args); // Starts the program.
	}
	
	//*** Converts double to an integer value: ***************************************************//
	public int toInteger(double input) {
		int output = (int) Math.round(input);
		return output;
	}
	
	//*** Builds the Scene ***********************************************************************//
	//*** Calculates the result from user input using the formula: *******************************//
	//*** Formula: P = 1500, r = 0.043 (4.3%), n = 4, and t = 6 **********************************//
	//*** P = startAmount * Math.pow((1 + (interest/frequency)) ^ (frequency * numberOfYears)) ***//
	private int calculateResult() {
		total = getStartAmount() * Math.pow((1 + (getInterest()/frequency)), (frequency * getNumberOfYears()));
		return toInteger(total);
	}
	
	//*** Builds and starts the application ******************************************************//
	//*** Also contains most of the data: ********************************************************//
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create Button for Compound Interest Calculation:
		Button calculate = new Button("Calculate");

		// Create Labels to indicate what data to input:
		Label heading = new Label("Compound Interest");
		heading.setFont(new Font("Comfortaa", 26)); // Set font type and size.
		
		Label startAmountLabel = new Label("Start amount: ");
		Label interestLabel = new Label("Interest: ");
		Label numberOfYearsLabel = new Label("Number of years: ");
		Label result = new Label("");

		// Create TextField for user to input data:
		TextField startAmountField = new TextField();
		TextField interestField = new TextField();
		TextField numberOfYearsField = new TextField();

		// Optional feature:
		// Create Sliders in case keyboard input is unavailable:
//		Slider startAmountSlider = new Slider();
//		Slider interestSlider = new Slider();
//		Slider numberOfYearsSlider = new Slider();	
		
		// Create Window:
		VBox window = new VBox();
		window.setPadding(new Insets(5));
		window.setSpacing(5);
		
		// Layout Management:
		// Header of Window:
		GridPane headerPane = new GridPane();
		headerPane.setAlignment(Pos.CENTER);
		headerPane.setHgap(5.5);
		headerPane.setVgap(5.5);
		//************* Header *************//
		headerPane.add(heading, 0, 0);
		
		// Body of Window:
		GridPane bodyPane = new GridPane();
		bodyPane.setAlignment(Pos.CENTER);
		bodyPane.setPadding(new Insets(5));
		bodyPane.setHgap(5.5);
		bodyPane.setVgap(5.5);
		//************ Row One *************//
		bodyPane.add(startAmountLabel, 1, 0);
		bodyPane.add(startAmountField, 2, 0);
		//************ Row Two *************//
		bodyPane.add(interestLabel, 1, 1);
		bodyPane.add(interestField, 2, 1);
		//*********** Row Three ************//
		bodyPane.add(numberOfYearsLabel, 1, 2);
		bodyPane.add(numberOfYearsField, 2, 2);
		//************ Row Four ************//
		bodyPane.add(calculate, 1, 3);
		//********** Final Result **********//
		bodyPane.add(result, 1, 4);
		
		// Display all Children in Window:
		window.getChildren().addAll(headerPane, bodyPane);
		
		// Registers Button Click and returns the Result:
		calculate.setOnAction(e -> {
			if (check(startAmountField) && check(interestField) && check(numberOfYearsField)) {
				setStartAmount(convert(startAmountField));
				setInterest(convert(interestField));
				setNumberOfYears(convert(numberOfYearsField));
				
				result.setText("In total that will be " + calculateResult());
				
			} else {
				result.setText("Please make sure your value\nis a positive Integer!");
			}
		});
		
		//********** Builds the Scene *************************************************************//
		Scene scene = new Scene(window, 425, 275);
		primaryStage.setTitle("Compound Interest");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//*** Check if TextField only contains Digits ************************************************//
	private boolean check(TextField field) { // Private Help Method
		boolean pass = false;
		for (int i = 0; i < field.getText().length(); i++) {
			char tmp = field.getText().charAt(i);
			if (!Character.isDigit(tmp)) {
				return false;
				
			} else {
				pass = true;
			}
		}
		return pass;
	}

	//*** Convert TextField to Double ************************************************************//
	private double convert(TextField field) { // Private Help Method
		double output = Double.parseDouble(field.getText());
		return output;
	}
	
	//*** Getters and Setters ********************************************************************//
	private double getStartAmount() {
		return startAmount;
	}
	
	private void setStartAmount(double startAmount) {
		this.startAmount = startAmount;
	}
	
	
	private double getInterest() {
		return interest;
	}

	private void setInterest(double interest) {
		this.interest = interest / 100;
	}
	

	private double getNumberOfYears() {
		return numberOfYears;
	}

	private void setNumberOfYears(double numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
}