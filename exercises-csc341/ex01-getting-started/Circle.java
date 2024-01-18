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

    /** Circels have many random components */
    private Random random = new Random();


    /** Default constructor */
    public Circle(String c, Integer size) {
    
    	radius = size;
    	if (c.equals("red")) {
    		color = new Color(255,0,0);
    	} else if (c.equals("green")) {
    		color = new Color(0,255,0);
    	} else {
    		color = new Color(0,0,255);
    	}

        this.setSize(radius, radius);

        // Make the box/panel on which the circle is drawn transparent
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));

        // Randomly assign values
        //randomXY();
        randomDirection();
        //randomColor();
    }

    /** Randomly assign its location based on the fixed ranges. */
    public void randomXY() {
        // place at random location
        //xy.x = random.nextInt(xMAXRANGE - xMINRANGE) + xMINRANGE;
        //xy.y = random.nextInt(yMAXRANGE - yMINRANGE) + yMINRANGE;
    }

    /** Randomly point it in a direction with random "speed" */
    public void randomDirection() {
        // set in a random direction
        deltaX = random.nextInt(5) - 2;
        deltaY = 2;
    }

    /** Randomly assign the RGB components */
    public void randomColor() {
        // color randomly
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    /** Move the robot the "delta" for 1 timestep */
    public void step() {
    	//System.out.println("moving");
   
    	posX += deltaX;
    	posY += deltaY;
    	
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