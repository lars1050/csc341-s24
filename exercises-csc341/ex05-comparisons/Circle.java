/** Represents a circle within an x-y plane */
public class Circle {

	/** Radius (size) of the circle */
	int radius = 1;
	
	/** Position along the x-axis */
	Integer x = 0;
	
	/** Position along the y-axis */
	Integer y = 0;
	
	/** Fill color of the cirlce */
	Color color = Color.WHITE;
	
	/** Default constructor using default values. */
	public Circle() {
	}
	
	/** Constructor defining all aspects of circle
	* @param r radius (size) of the Circle
	* @param x position along x-axis 
	* @param y position along y-axis
	* @param c fill color of the Circle
	*/
	public Circle(int r, Integer x, Integer y, Color c) {
		radius = r;
		this.x = x;
		this.y = y;
		color = c;
	}
	
	@Override
	public String toString() {
		return String.format("[%d,(%d,%d),%s]",radius,x,y,color);
	}
}