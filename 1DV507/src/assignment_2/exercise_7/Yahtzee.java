package assignment_2.exercise_7;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Yahtzee extends Application {
	
	PossibleRolls possible = new PossibleRolls();
	
	Image[] imageArray = new Image[5];
	ArrayList<Integer> list = new ArrayList<Integer>();
	Random random = new Random();
	int count = 0;
	int MAX_ROLLS = 3;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		primaryStage.setTitle("Yahtzee");
		
		Text title = new Text(10, 20, "Yahtzee");
		title.setFont(Font.font ("Verdana", 30));
		
		GridPane main = new GridPane();
		main.setAlignment(Pos.CENTER);
		main.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
		main.setHgap(5.5);
		main.setVgap(5.5);
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setBlurType(BlurType.GAUSSIAN);
		dropShadow.setColor(Color.GRAY);
		
		Image image1 = new Image("file:images/Dice1.png");
		ImageView imageView1 = new ImageView(image1);
		imageView1.setFitWidth(60);
		imageView1.setFitHeight(60);
		imageView1.setEffect(dropShadow);
		Image image2 = new Image("file:images/Dice2.png");
		ImageView imageView2 = new ImageView(image2);
		imageView2.setFitWidth(60);
		imageView2.setFitHeight(60);
		imageView2.setEffect(dropShadow);
		Image image3 = new Image("file:images/Dice3.png");
		ImageView imageView3 = new ImageView(image3);
		imageView3.setFitWidth(60);
		imageView3.setFitHeight(60);
		imageView3.setEffect(dropShadow);
		Image image4 = new Image("file:images/Dice4.png");
		ImageView imageView4 = new ImageView(image4);
		imageView4.setFitWidth(60);
		imageView4.setFitHeight(60);
		imageView4.setEffect(dropShadow);
		Image image5 = new Image("file:images/Dice5.png");
		ImageView imageView5 = new ImageView(image5);
		imageView5.setFitWidth(60);
		imageView5.setFitHeight(60);
		imageView5.setEffect(dropShadow);
		Image image6 = new Image("file:images/Dice6.png");
		ImageView imageView6 = new ImageView(image6);
		imageView6.setFitWidth(60);
		imageView6.setFitHeight(60);
		imageView6.setEffect(dropShadow);
		
		main.add(imageView1, 0, 1);
		main.add(imageView2, 1, 1);
		main.add(imageView3, 2, 1);
		main.add(imageView4, 3, 1);
		main.add(imageView5, 4, 1);
		
		CheckBox checkbox1 = new CheckBox();
		GridPane.setHalignment(checkbox1, HPos.CENTER);
		checkbox1.setDisable(true);
		CheckBox checkbox2 = new CheckBox();
		GridPane.setHalignment(checkbox2, HPos.CENTER);
		checkbox2.setDisable(true);
		CheckBox checkbox3 = new CheckBox();
		GridPane.setHalignment(checkbox3, HPos.CENTER);
		checkbox3.setDisable(true);
		CheckBox checkbox4 = new CheckBox();
		GridPane.setHalignment(checkbox4, HPos.CENTER);
		checkbox4.setDisable(true);
		CheckBox checkbox5 = new CheckBox();
		GridPane.setHalignment(checkbox5, HPos.CENTER);
		checkbox5.setDisable(true);
		
		main.add(checkbox1, 0, 2);
		main.add(checkbox2, 1, 2);
		main.add(checkbox3, 2, 2);
		main.add(checkbox4, 3, 2);
		main.add(checkbox5, 4, 2);
		
		Button button = new Button("Roll!");
		button.setLayoutX(5);
		button.setLayoutY(120);

		Text status = new Text("- - -");
		status.setLayoutX(100);
		status.setLayoutY(155);
		Text text = new Text("You have " + MAX_ROLLS + " roll(s) remaining!");
		text.setLayoutX(100);
		text.setLayoutY(135);
		
		button.setOnAction(e -> {
			if(count < MAX_ROLLS) {
				checkbox1.setDisable(false);
				checkbox2.setDisable(false);
				checkbox3.setDisable(false);
				checkbox4.setDisable(false);
				checkbox5.setDisable(false);
				
				for (int i = 0; i < 5; i++) {
					int roll = rollDice();
					if(roll == 1) {
						imageArray[i] = image1;
						
					} else if(roll == 2) {
						imageArray[i] = image2;
						
					} else if(roll == 3) {
						imageArray[i] = image3;	
						
					} else if(roll == 4) {
						imageArray[i] = image4;	
						
					} else if(roll == 5) {
						imageArray[i] = image5;	
					
					} else if(roll == 6) {
						imageArray[i] = image6;
					}
				}
				
				updateImage(checkbox1, imageView1, 0);
				updateImage(checkbox2, imageView2, 1);
				updateImage(checkbox3, imageView3, 2);
				updateImage(checkbox4, imageView4, 3);
				updateImage(checkbox5, imageView5, 4);
				
				imageArray[0] = imageView1.getImage();
				imageArray[1] = imageView2.getImage();
				imageArray[2] = imageView3.getImage();
				imageArray[3] = imageView4.getImage();
				imageArray[4] = imageView5.getImage();
				
				count++;
				int remaining = MAX_ROLLS - count;
				text.setText("Remaining Roll(s): " + remaining);
				
				if(remaining != -1) {
					rollStatus(image1, image2, image3, image4, image5, image6);
					updateStatus(status);
				}
			}
		});
		
		Group root = new Group();
		root.getChildren().add(main);
		root.getChildren().add(button);
		root.getChildren().add(text);
		root.getChildren().add(status);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public int rollDice() {
		int roll = random.nextInt(6) + 1;
		return roll;
	}
	
	public boolean isChecked(CheckBox cb) {
		if(cb.isSelected())
			return true;
		return false;
	}
	
	public void updateImage(CheckBox cb, ImageView iv, int value) {
		if(cb.isSelected() != true) {
			iv.setImage(imageArray[value]);
		}
	}
	
	public void rollStatus(Image image1, Image image2, Image image3, Image image4, Image image5, Image image6) {
		if(count >= MAX_ROLLS) {
			for (int i = 0; i < imageArray.length; i++) {
				if(imageArray[i] == image1) {
					list.add(i, 1);
				}
				if(imageArray[i] == image2) {
					list.add(i, 2);
				}
				if(imageArray[i] == image3) {
					list.add(i, 3);
				}
				if(imageArray[i] == image4) {
					list.add(i, 4);
				}
				if(imageArray[i] == image5) {
					list.add(i, 5);
				}
				if(imageArray[i] == image6) {
					list.add(i, 6);
				}
			}
		}
	}
	
	public void updateStatus(Text status) {
		if(possible.yahtzee(list)) {
			status.setText("Yahtzee!");
			
		} else if (possible.fourOfAKind(list)) {
			status.setText("Four of a kind!");
			
		} else if (possible.fullHouse(list)) {
			status.setText("Full House!");
			
		} else if (possible.threeOfAKind(list)) {
			status.setText("Three of a kind!");
			
		} else if (possible.smallStraight(list)) {
			status.setText("Small straight!");
			
		} else if (possible.largeStraight(list)) {
			status.setText("Large straight!");
			
		} else if (possible.pair(list)) {
			status.setText("Pair!");
		
		} else {
			status.setText("Loading...");
		}
	}
}
