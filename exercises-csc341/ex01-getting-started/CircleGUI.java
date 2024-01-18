import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple demonstation of a moving object in a graphics window.
 * @author Amy Larson
 */
public class CircleGUI extends JFrame {

	// Create text, button, and action handler 
    private final JButton play = new JButton("Play");
    private final JLabel playLabel = new JLabel("Push button to move.");
    private EventHandler handler = new EventHandler();

	// the one object moving around
    private Circle circle;
    
    // start with it not moving
    private Boolean moving = false;

    /**
     * Creates a Simulation GUI application.
     * Sets the components and their positions in the gui.
     * @param color should be red, blue, or green
     * @param size radius of circle
     */
    public CircleGUI(String color, Integer size) {

        // Initialize the graphics window
        super("Circle Motion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800,800);
        // You control the layout
        this.getContentPane().setLayout(null);

        
        // Create circle and place in graphics window
        circle = new Circle(color,size);
		circle.setLocation(circle.getX(),circle.getY());
        getContentPane().add(circle);
        circle.setVisible(true);
        
        // Place message to user and play button
        playLabel.setBounds(20,60,150,30);
        add(playLabel);

        play.setBounds(40, 100, 120, 30);
        play.addActionListener(handler);
        getContentPane().add(this.play);   
    } // end CircleGUI
        
    public void run() {   
		while (true) {
        //for (int i=0; i<10; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            if (moving) {
	            circle.step();
    	        circle.setLocation(
        	    	circle.getX(),
            		circle.getY()
            	);
        	}
        }	
    } // end run()

	/** Controls the response of the button pushing. */
    public class EventHandler implements ActionListener {

        // Responds to button being pushed
        @Override
        public void actionPerformed(ActionEvent ae) {
        
        	// if circle is moving then stop, else start moving.
        	if (moving) {
        		// change message: Push to Move
        		playLabel.setText("Push button to move.");
        		moving = false;
        			
        	} else {
        		// change message: Push to play
        		moving = true;
        		playLabel.setText("Push button to pause.");
        	}
        } // end actionPerformed()
     } // end class EventHandler
} // end class CircleGUi