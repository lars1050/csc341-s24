import java.util.Random;
import java.util.ArrayList;
import java.io.*;

/**
 * 
 */
public class Main {  
    
    public static void main(String[] args) {
    	
    	if (args.length < 2) {
    		System.out.println("Error: need color and size");
    		return;
    	}
    	
    	String color = args[0];
    	Integer size = Integer.valueOf(args[1]);
    	
		// Start the graphics window
		CircleGUI gui = new CircleGUI(color,size);
		gui.setVisible(true);
		gui.run();
		
		// To stop the program, close the popup window

    }
}
