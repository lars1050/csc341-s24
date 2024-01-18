## Getting Started

<h4>
In-Class Exercise due at the end of the class.

This exercise will help ensure that you are ready for the first lab.
You will run javadocs and make minor edits to the actionListener.

Follow the directions on programming assignment 1 to get your system ready.

### Compile and Run

Navigate to the working folder with this exercise. Compile the code. 

To run it, you have to supply a color and radius size for the circle. Color options are "red", "blue", and "green". It might look like this ...

```
amylarson@MacBook-Pro-110 ex01-getting-started %java Main red 40
```

Close the graphics window to stop the program.

In the file _CircleGUI.java_, make a change in the function actionPerformed.
- Change the string `Push button to move` to `Push to go`.
- Change the string `Push button to pause` to `Push to pause`.

Compile and run again to see the change.

### Javadocs

**Compile the javadocs** to generate the web pages for the code. You will want to place all the documentation in a separate folder so that it doesn't clutter your source directory. After completing the commands below, open up the index.html page and see how it looks.

```
mkdir docs
cd docs
javadoc ../*.java
```

> NOTE: If you are on a Windows machine, you will have to add the javadoc command to your path.

View the javadocs in your browser. From your finder/explorer, open the docs folder and double-click index.html. 

Add javadocs to the Circle constructor. Be sure to add @param for both parameters and include a description.

Recompile and see how that addition is displayed in the web pages.

<hr>

### Submit Code to Moodle

Zip the folder and submit via Moodle. You can zip the folder by right clicking the icon and choosing to compress it.

<hr>


