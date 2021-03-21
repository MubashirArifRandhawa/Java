
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Triangle extends ClosedShape{
    private int height,width;
    double[] xCoordinates;
    double[] yCoordinates;
    
    public Triangle(int insertionTime,int x,int y,int vx,int vy,int _width,int _height,Color colour, boolean isFilled)
    {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
      
    	this.height = _height;
        this.width = _width;
//        
//        this.calcXCoordinates();
//        this.calcYCoordinates();
    }
    
    public void setXCoords(double ax, double bx, double cx){
        xCoordinates  = new double[]{ax,bx,cx};
    }
    public void calcXCoordinates(){
        //height is read from file
        //x is read from file
        double ax  = height ;
        double bx  = height + x;
        double cx  = (ax + bx )/ 2;
        xCoordinates  = new double[]{ax,bx,cx};
    }
    public void setYCoords(double ay, double by, double cy){
        yCoordinates = new double[]{ay,by,cy};
    }
    public void calcYCoordinates(){
        double ay = 0;
        double by = 0;
        double cy = 0 + height;
        yCoordinates = new double[]{ay,by,cy};
    }
    double[] getXCoords(){
        return this.xCoordinates;
    }
    double[] getYCoords(){
        return this.yCoordinates;
    }
    
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillPolygon(getXCoords(),getYCoords(),3);
    	} 
    	else 
        {
    		g.strokePolygon(getXCoords(),getYCoords(),3);
	}
    }

    @Override
    public int getWidth() {
        return this.width;
    }
    @Override
    public int getHeight() {
        return this.height;
    }
     public String toString () {
    	
        String result = "This is a Triangle\n";
    	result += super.toString ();
        result += "Its height is " + this.height + "\n";
        result += "Its width is " + this.width + "\n";
        
    	return result;
    }
}
