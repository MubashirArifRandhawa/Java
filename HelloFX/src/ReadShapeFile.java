
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class ReadShapeFile{
        private static GraphicsContext gc;
        public ReadShapeFile(GraphicsContext gc){
               this.gc = gc;
        }
        // TODO: You will likely need to write four methods here. One method to
        
    	// construct each shape
        
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.
	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in 
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readLineByLine(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
                
                while (in.hasNextLine()) {
                    String data = in.nextLine();    
                    
                    if(data.contains("circle")){
                        String[] array = data.split(" ");
                        shapeQueue.enqueue(makeCircle(array));
                    }
                    else if(data.contains("oval")){
                        String[] array = data.split(" ");
                        shapeQueue.enqueue(makeOval(array));     
                    }
                    else if(data.contains("square")){
                        String[] array = data.split(" ");
                        shapeQueue.enqueue(makeSquare(array));
                    }
                    else if(data.contains("rect")){
                        String[] array = data.split(" ");
                        shapeQueue.enqueue( makeRectangle(array));
                    }
                    else if(data.contains("triangle")){
                        String[] array = data.split(" ");
                        shapeQueue.enqueue( makeTrianlge(array));
                    }
                }
                //read in the shape files and place them on the Queue
                
                //Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}


        public static Circle makeCircle(String[] array){
                int insertionTime = Integer.valueOf (array[10]);
                int x = Integer.valueOf(array[1]);
                int y = Integer.valueOf(array[2]);
                int vx = Integer.valueOf(array[3]);
                int vy = Integer.valueOf(array[4]);
                boolean isFilled =  Boolean.parseBoolean(array[5]);
                int diameter = Integer.valueOf(array[6]);
                Color colour = Color.rgb(Integer.valueOf(array[7]), Integer.valueOf(array[8]), Integer.valueOf(array[9]));
                Circle circle = new Circle(insertionTime,x,y,vx,vy,diameter,colour,isFilled);
                return circle;
        }

        private static Oval makeOval(String[] array){
            int insertionTime = Integer.valueOf (array[11]);
                int x = Integer.valueOf(array[1]);
                int y = Integer.valueOf(array[2]);
                int vx = Integer.valueOf(array[3]);
                int vy = Integer.valueOf(array[4]);
                Color colour = Color.rgb(Integer.valueOf(array[8]), Integer.valueOf(array[9]), Integer.valueOf(array[10]));
                boolean isFilled =  Boolean.parseBoolean(array[5]);
                int width = Integer.valueOf(array[6]);
                int height = Integer.valueOf(array[7]);
                Oval oval = new Oval(insertionTime,x,y,vx,vy,width,height,colour,isFilled);  
                return oval;
        }
        private static Square makeSquare(String[] array){
                int insertionTime = Integer.valueOf (array[10]);
                int x = Integer.valueOf(array[1]);
                int y = Integer.valueOf(array[2]);
                int vx = Integer.valueOf(array[3]);
                int vy = Integer.valueOf(array[4]);
                Color colour = Color.rgb(Integer.valueOf(array[7]), Integer.valueOf(array[8]), Integer.valueOf(array[9]));
                boolean isFilled =  Boolean.parseBoolean(array[5]);
                int side = Integer.valueOf(array[6]);
                Square square = new Square(insertionTime,x,y,vx,vy,colour,side,isFilled);  
                return square;
        }
        private static Rect makeRectangle(String[] array){
                int insertionTime = Integer.valueOf (array[11]);
                int x = Integer.valueOf(array[1]);
                int y = Integer.valueOf(array[2]);
                int vx = Integer.valueOf(array[3]);
                int vy = Integer.valueOf(array[4]);
                Color colour = Color.rgb(Integer.valueOf(array[8]), Integer.valueOf(array[9]), Integer.valueOf(array[10]));
                boolean isFilled =  Boolean.parseBoolean(array[5]);
                int width = Integer.valueOf(array[6]);
                int height = Integer.valueOf(array[7]);
                Rect rectangle = new Rect(insertionTime,x,y,vx,vy,colour,width,height,isFilled);  
                return rectangle;
        }
        private static Triangle makeTrianlge(String[] array){
             int insertionTime = Integer.valueOf (array[11]);
                int x = Integer.valueOf(array[1]);
                int y = Integer.valueOf(array[2]);
                int vx = Integer.valueOf(array[3]);
                int vy = Integer.valueOf(array[4]);
                Color colour = Color.rgb(Integer.valueOf(array[8]), Integer.valueOf(array[9]), Integer.valueOf(array[10]));
                boolean isFilled =  Boolean.parseBoolean(array[5]);
                int width = Integer.valueOf(array[6]);
                int height = Integer.valueOf(array[7]);
                Triangle triangle = new Triangle(insertionTime,x,y,vx,vy,width,height,colour,isFilled);
                triangle.setXCoords(100, 200, 150);
                triangle.setYCoords(100,100,300);
                return triangle;
        }
	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
      	public static Queue<ClosedShape> readDataFile(String filename) {
	   try{
            File newFile = new File(filename);
            Scanner in = new Scanner(newFile);           
            return ReadShapeFile.readLineByLine(in);
           }
           catch(FileNotFoundException e){
                System.out.println("Could not find "+filename);
                System.exit(0);
           }
           return null;
	}

}
