
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape{
    private int side;
    public Square(int insertionTime, int x, int y, int vx, int vy, Color colour, int _side, boolean isFilled){
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = _side;
    }
  
     public String toString () {
         
    	String result = "This is a Square\n";
    	result += super.toString ();
	result += "Its sides are " + this.side + "\n";

    	return result;
    }
     
     
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect( x, y,side,side );
    	} 
    	else {
    		g.strokeRect( x, y,side, side );
	    }
    }

    @Override
    public int getWidth() {
        return side;
    }

    @Override
    public int getHeight() {
       return side;
    }
    
    public void setSide (int side) {
    	this.side = side;
    }
    
    
}
