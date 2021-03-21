
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends ClosedShape{
    private int height,width;
    public Rect(int insertionTime, int x, int y, int vx, int vy, Color colour, int _height, int _width, boolean isFilled){
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.height = _height;
        this.width = _width;
    }
  
     public String toString () {
         
    	String result = "This is a rectangle\n";
    	result += super.toString ();
	result += "Its height is " + this.height + "\n";
        result += "Its width is " + this.width + "\n";

    	return result;
    }
     
     
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect( x, y,width,height );
    	} 
    	else {
    		g.strokeRect( x, y,width, height );
	    }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
       return height;
    }
    
    public void setHeight (int height) {
    	this.height = height;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
}
