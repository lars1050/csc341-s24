/*
 * Inspired by https://www.youtube.com/watch?v=zCiMlbu1-aQ&ab_channel=choobtorials
 * 
 * AUTHOR: Amy C. Larson, Ph.D.
 * copyrighted 2022
 */

 import java.awt.*;
 import javax.swing.*;
 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 public class LoginWindow extends JFrame {
 
 	private Database db;

    // Window Size
    private final int loginWidth = 500;
    private final int loginHeight = 200;
 
    // Create labels and fields for login window so that user can enter username and password
    private final JLabel message = new JLabel("Please enter username and password.");

    //--------- username
    private final JLabel usernameLabel = new JLabel("Username");
    private final JTextField userField = new JTextField(25);

    //--------- password
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField passwordField = new JTextField(25);

    //---------- login button to verify password
    private final JButton loginButton = new JButton("LOGIN");
    private EventHandler handler = new EventHandler();
 
    /** Constructor creates window and places all labels, fields, and buttons in the frame. */
     public LoginWindow(Database database) {
        // Appears at the top of the window
        super("Augsburg Login");
        
        db = database;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(loginWidth,loginHeight);
        setResizable(false);			// user cannot control size of window
        setLocationRelativeTo(null);    // places pop-up in middle of screen
        setLayout(null);                // manual placement of all elements

        //-------- Message Area SetUp
        message.setBounds(20,20,480,30);
        message.setBackground(new Color(255,255,255));
        add(message);

        //-------- Username Area SetUP
        usernameLabel.setBounds(20,60,150,30);
        add(usernameLabel);
        userField.setBounds(100,60,150,30);
        userField.setBackground(new Color(255,255,255));
        add(userField);

        //-------- Password Area SetUp
        passwordLabel.setBounds(20,100,150,30);
        add(passwordLabel);
        passwordField.setBounds(100,100,150,30);
        passwordField.setBackground(new Color(255,255,255));
        add(passwordField);

        //-------- Message Area SetUp
        loginButton.setBounds(200,140,75,25);
        add(loginButton);
        loginButton.addActionListener(handler);
     }

     /** Handles the entry of data and the request to login (i.e the button press)
      * Event handlers are called when the user interacts with some element in the window.
      * In this app, actionPerformed() will be called when the user presses the "login" button.
      */
     public class EventHandler implements ActionListener {

        /** Handler for loginButton activation. */
        @Override
        public void actionPerformed(ActionEvent ae) {

            // Retrieve the text currently entered in the username and password text boxes
            String username = userField.getText();
            String password = passwordField.getText();

            // Reset the text boxes to blank
            userField.setText("");
            passwordField.setText("");
            System.out.println("ENTERED "+username+" "+password);

            // TODO ************
            // Here is where you need to verify if the username+password are correct.
            // Complete the verifyCredentials() function in database and call it here.

            // If valid, say hello (using their first name)

            // If not valid, clear the textfields and display a message.
            // Here is an example of how to set the text in the window
            // message.setText("Username and/or password does not match our records. Try again.");

        }
     } 
 }