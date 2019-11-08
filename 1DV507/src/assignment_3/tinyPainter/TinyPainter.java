package assignment_3.tinyPainter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TinyPainter extends Application implements Constants {
	Rectangle2D bounds = Screen.getPrimary().getBounds(); // Get screen size.
	Canvas canvas = new Canvas(bounds.getMaxX()/2, bounds.getMaxY()/2); // Canvas Size is same as program size.
	
	GraphicsContext graphics;
	ColorPicker colorPicker = new ColorPicker();
	
	Slider slider = new Slider();
	GridPane grid = new GridPane();
	ComboBox<String> shapeMenu = new ComboBox<String>();
	ComboBox<Integer> strokeSizeMenu = new ComboBox<Integer>();
	
	StackPane pane = new StackPane();
	Scene scene = new Scene(pane, bounds.getMaxX()/2, bounds.getMaxY()/2); // Divide bounds by 2.
	
	double originX;
	double originY;
	double finalX;
	double finalY;
	double currentX;
	double currentY;
	double circleWH;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		try {
			graphics = canvas.getGraphicsContext2D();
			graphics.setStroke(Color.BLACK);
			graphics.setLineWidth(1);
			
			shapeMenu(); 		// Initialize Shape Menu.
			strokeSizeMenu(); 	// Initialize Size Menu.
			colorMenu(); 		// Initialize Color Menu.
			
			onMousePress();		// Listen for Mouse Press.
			//testCase();
			onMouseRelease();	// Listen for Mouse Release.
			
			grid.add(shapeMenu, 		0, 0, 1, 1);
			grid.add(strokeSizeMenu, 	1, 0, 1, 1);
			grid.add(colorPicker, 		2, 0, 1, 1);
			grid.add(slider, 			1, 1, 1, 1);
			
			grid.setHgap(5);
			grid.setVgap(5);
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setPadding(new Insets(5, 5, 5, 5));
			
			pane.getChildren().addAll(canvas, grid);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tiny Painter");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Shape Menu:
	public void shapeMenu() {
		shapeMenu.setValue(LINE);
		shapeMenu.getItems().addAll(
				LINE, 
				DOT, 
				RECTANGLE, 
				CIRCLE);
		
		// Shape Menu Action Listener:
		shapeMenu.valueProperty().addListener(e -> {
			shapeMenu.getValue();
		});
	}
	
	// Size Menu:
	public void strokeSizeMenu() {
		strokeSizeMenu.setValue(1); // Default size value is 1.
		strokeSizeMenu.getItems().addAll( // Add 1 - 40 size options.
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 
				12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 
				22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 
				32, 33, 34, 35, 36, 37, 38, 39, 40);
		
		// Stroke Size Action Listener:
		strokeSizeMenu.valueProperty().addListener(e -> {
			graphics.setLineWidth(strokeSizeMenu.getValue()); // Set size to strokeSize Value.
			
			slider.setValue(strokeSizeMenu.getValue());
		});
		
		// If slider is prefered over integer size Drop Down Box.
		slider.setMin(1);
		slider.setMax(40);
		
		// Slider Action Listener:
		slider.valueProperty().addListener(e -> {
			double value = slider.getValue();
			graphics.setLineWidth(value);
			strokeSizeMenu.setValue((int) slider.getValue());
		});
	}
	
	// Color Menu:
	public void colorMenu() {
		colorPicker.setValue(Color.BLACK); // Default color is Black.
		// Action Listener for color Picker:
		colorPicker.setOnAction(e -> {		
			
			graphics.setStroke(colorPicker.getValue()); // Set stroke color.
			graphics.setFill(colorPicker.getValue());	// Set fill color.
		});
	}
	
	// On Mouse Press Listener:
	public void onMousePress() {
		// Drawing Function:
		scene.setOnMousePressed(e -> {			
			originX = e.getSceneX();
			originY = e.getSceneY();
			graphics.beginPath(); // Begins Tracing (Kind of disables line connecting between strokes).
			
			// LINE:
			if (shapeMenu.getValue() == LINE) {
				graphics.lineTo(originX, originY); // Get mouse pos in scene (x,y).
			}
			
			// DOT:
			if (shapeMenu.getValue() == DOT) {
				graphics.lineTo(originX, originY);
			}
		});
	}
	
	// On Mouse Release Listener:
	public void onMouseRelease() {
		// Drawing Function:
		scene.setOnMouseReleased(e -> {
			finalX = e.getSceneX();
			finalY = e.getSceneY();
			
			// LINE:
			if (shapeMenu.getValue() == LINE) {
				graphics.lineTo(finalX, finalY); // Get mouse pos in scene (x,y).
			}
			
			// RECTANGLE:
			if (shapeMenu.getValue() == RECTANGLE) {
				graphics.fillRect(originX, originY, (finalX - originX), (finalY - originY));
			}
			
			// CIRCLE:
			if (shapeMenu.getValue() == CIRCLE) {
				if((finalX - originX) >= (finalY - originY)) { circleWH = finalX - originX; } 	// Ensure it is a circle and not an oval.
				else { circleWH = finalY - originY; }											// Adapt width/height to the highest value.
				graphics.fillOval(originX, originY, circleWH, circleWH);
			}
			graphics.stroke();
		});
		//
	}
}