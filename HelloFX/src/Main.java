
import java.util.ArrayList;

/**
 * The class that starts the program.  The class simply creates a window and displays it given
 * a filename submitted from the command line.
 * @author archam
 *
 */

import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final String FRAME_TITLE = "Shape Booooiiinggg Frame";
	   
	public static void main(String[] args) {
		launch(args);
	}
	 @Override
	    public void start(Stage primaryStage) {
		try{
                Scanner input = new Scanner (System.in);
		System.out.println ("Please enter a shape file to open:");	
                String filename = input.nextLine();
	        primaryStage.setTitle(FRAME_TITLE);
	        Group root = new Group();
	        Canvas canvas = new Canvas(600, 600);
	        GraphicsContext gc = canvas.getGraphicsContext2D();
                
	        new BouncingShapesWindow(gc,filename);        
                
                input.close();
                root.getChildren().add(canvas);
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
                }
                catch(Exception e){
                    e.printStackTrace();
            }
	}
}

