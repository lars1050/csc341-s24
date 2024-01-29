import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.util.Random;

/** Circle for drawing in a JFrame
 *
 * @author Amy Larson
 */
public class Circle extends JPanel {

    private int radius = 30;
    
    /** Color specified in RGB */
    private Color color = new Color(10, 10, 10);

    /** Location of the JPanel in which the circle is drawn */
    private int posX = 300;
    private int posY = 300;

    /** Delta of location at each timestep */
   	private int deltaX = 1;
   	private int deltaY = 1;

    /** Circels have random direction */
    private Random random = new Random();


    public Circle(String c, Integer size) {
    
    	// set according user specifications
    	radius = size;
    	if (c.equals("red")) {
    		color = new Color(255,0,0);
    	} else if (c.equals("green")) {
    		color = new Color(0,255,0);
    	} else {
    		color = new Color(0,0,255);
    	}
		// set the bounding box of the circle
        this.setSize(radius, radius);

        // Make the box/panel on which the circle is drawn transparent
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));

		// it moves in a random direction
        deltaX = random.nextInt(5) - 2;
        deltaY = 2;
    }

    /** Move the robot in each x-y direction by step size (staying in boundary) */
    public void step() {
   
   		// Move it
    	posX += deltaX;
    	posY += deltaY;
    	
    	// check if it is up against any of the 4 "walls"
        if (posX<=50) {
            posX = 50;
            deltaX = -deltaX;
        }
        if (posY<=150) {
            posY = 150;
            deltaY = -deltaY;
        }
        if (posX>=750-radius*2) {
            posX = 750-radius*2;
            deltaX = -deltaX;
        }
        if (posY>=750-radius*2) {
            posY = 750-radius*2;
            deltaY = -deltaY;
        }
    }
    
	// getters
    public int getX() {
        return posX;
    }
    public int getY() {
    	return posY;
    }

    @Override
    public void paintComponent(Graphics g) {
        // This is called every time the circle location is reset
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, radius, radius);
    }
}