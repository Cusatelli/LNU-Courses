package assignment_2.exercise_5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Snowman extends Application {
	
	@Override
	public void start (Stage stage) {
		
		Group root = new Group();
		
		// Background:
		Rectangle sky = new Rectangle(0, 0, 800, 400);			// Create Sky
		sky.setFill(Color.SKYBLUE);								// Color SkyBlue.
		
		Circle sun = new Circle(760, 40, 100);					// Create Sun
		sun.setFill(Color.YELLOW);								// Color Yellow
		
		// Snowman:
		Circle bottom = new Circle(400, 360, 60);				// Create Bottom part of Snowman
		bottom.setFill(Color.WHITE); 							// Color of White!
		
		Circle middle = new Circle(400, 300, 40);				// Create Middle part of Snowman
		middle.setFill(Color.WHITE); 							// Color of White!
		
		Circle top = new Circle(400, 250, 25);					// Create Top part of Snowman
		top.setFill(Color.WHITE); 								// Color of White!
		
		// Buttons:
		Circle buttonBottom = new Circle(400, 320, 5.5);		// Create Bottom Button
		buttonBottom.setFill(Color.BLACK);						// Color of Black!
		
		Circle buttonMiddle = new Circle(400, 300, 5);			// Create Middle Button
		buttonMiddle.setFill(Color.BLACK);						// Color of Black!
			
		Circle buttonTop = new Circle(400, 280, 4.5);			// Create Top Button
		buttonTop.setFill(Color.BLACK);							// Color of Black!
		
		// Mouth:
		Circle mouthBlack = new Circle(400, 250, 20);			// Create Black Part of Mouth
		mouthBlack.setFill(Color.BLACK);						// Color of Black!
		
		Circle mouthCoverUp = new Circle(400, 247, 21);			// Create Part outlining Mouth
		mouthCoverUp.setFill(Color.WHITE);						// Color of White!
		
		// Eyes:
		Circle leftEye = new Circle(410, 249, 5.5);				// Create Left Eye
		leftEye.setFill(Color.BLACK);							// Color of Black!
		
		Circle rightEye = new Circle(390, 249, 5.5);			// Create Right Eye
		rightEye.setFill(Color.BLACK);							// Color of Black!
		
		// Eye Shine:
		Circle leftEyeShine = new Circle(411.5, 246.5, 1);		// Create Left Eye Shine
		leftEyeShine.setFill(Color.WHITE);						// Color of White!

		Circle rightEyeShine = new Circle(391.5, 246.5, 1);		// Create Right Eye Shine
		rightEyeShine.setFill(Color.WHITE);						// Color of White!
		
		// Nose:
		Circle carrotBack = new Circle(400, 258, 5);			// Create Carrot Nose Back Side
		carrotBack.setFill(Color.DARKORANGE);					// Color of DarkOrange!
		
		Circle carrotFront = new Circle(400, 258, 3);			// Create Carrot Nose Front Side
		carrotFront.setFill(Color.ORANGE);						// Color of Orange!
		
		// Arm Elbow:
		Line leftElbow = new Line(370, 285, 350, 300);			// Create Left Elbow
		leftElbow.setStrokeWidth(3);							// Set Stroke Width to 3
		leftElbow.setStroke(Color.SADDLEBROWN);					// Color of SaddleBrown.
		
		Line rightElbow = new Line(430, 285, 450, 300);			// Create Right Elbow
		rightElbow.setStrokeWidth(3);							// Set Stroke Width to 3
		rightElbow.setStroke(Color.SADDLEBROWN);				// Color of SaddleBrown.
		
		// Arm:
		Line leftArm = new Line(375, 340, 350, 300);			// Create Left Arm
		leftArm.setStrokeWidth(3);								// Set Stroke Width to 3
		leftArm.setStroke(Color.SADDLEBROWN);					// Color of SaddleBrown.
		
		Line rightArm = new Line(425, 340, 450, 300);			// Create Right Arm
		rightArm.setStrokeWidth(3);								// Set Stroke Width to 3
		rightArm.setStroke(Color.SADDLEBROWN);					// Color of SaddleBrown.
		
		// Hat:
		Rectangle topHat = new Rectangle(380, 202, 40, 35);		// Create the Top of Hat
																// Use Default Settings (Test).
		
		Line lineHat = new Line(430, 235, 370, 235);			// Create Line of Hat
		lineHat.setStrokeWidth(5);								// Set Stroke Width to 5
		lineHat.setStroke(Color.BLACK);							// Color of Black.
		
		// Add all elements to "drawing":
		root.getChildren().addAll(sky, sun, bottom, middle, 
				top, buttonBottom, buttonMiddle, buttonTop,
				mouthBlack, mouthCoverUp, leftEye, rightEye,
				leftEyeShine, rightEyeShine, carrotBack, carrotFront,
				leftElbow, rightElbow, leftArm, rightArm, 
				topHat, lineHat);
		
		// Setup the scene where drawing is painted:
		Scene scene = new Scene(root, 800, 600);				// Sets new Scene
		stage.setTitle("Snowman"); 								// Title of Scene
		stage.setScene(scene);									// Which Scene
		stage.show();											// Show Graphics
		
	}
	
	public static void main(String[] args) {
		launch(args);											// Run Program
	}
}