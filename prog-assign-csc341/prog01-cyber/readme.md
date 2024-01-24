## Programming Assignment #01 Cybersecurity (Getting Started)

<h4>
DUE Thursday, January 25 end-of-day.
<br>Submissions will no longer be accepted once the Moodle link closes on Friday, end-of-day.
<br>Zip code and submit on Moodle.
</h4>

In this programming assignment, you will write code to complete the login verification process in the
provided code. Along the way, you will be introduced to many of the tools that we will be using in class, including

- _Git_, one of the most popular code repositories
- _GitHub_, cloud service with GUI to remotely store your Git repo
- command-line operations in a shell for file management, compilation and execution
- _BBedit_ (Mac) or _notepad++_ (Windows) text editor for writing code -- or your favorite!
- JAVA Style Guide, https://google.github.io/styleguide/javaguide.html
- Unit Testing (automated and formal testing procedure)

Testing and code documentation will be emphasized throughout the semester. These are part of the coding process and they are both just as important as the logic and syntax. This week, you will perform a visual inspection of the code to make sure it is correct. Next week, we will look at formal automated unit testing.


### Data Structures and ADTs

Consider the data structures being used in this assignment. You are using a LinkedList, ArrayList, HashMap, enum, basic arrays with [ ], and user-defined Abstract Data Types (ADTs). Throughout the semester, we will be *implementing* these data structures, not just using them.

<hr>

### Getting Started

Review the instructions at the top level of this repository to get your system ready.
When you are done, you should have _Java_, _git_ and your favorite editor installed on your machine.

>Note that we were using VS Code, which used to be a fanatastic editor. But it has become unweildy, and we no longer recommend it for basic code editing.

#### Clone This Repository

Open a terminal. Navigate to where you would like your repo for this course to go and clone it. I would recommend changing the name so that it is clear this is the repo.

Here is an example from Dr. Larson's machine:

```
cd ~/courses
mkdir cs341
cd cs341
git clone https://github.com/lars1050/csc341-s24
mv csc341-s24 csc341-class-repo 
```

In the repo on Github, code for each programming assignment and in-class exercises will be posted.

You do not want to edit inside of this repo on your machine because it will interfere with your ability to download future assignments. Instead, create another directory at this location (or elsewhere). I recommend naming it something that makes it clear that this is your working directory. Then copy the programming assignment folder into your working directory. DO NOT MAKE A COPY of the repo and use that as your working directory because it is tied to that specific repo, and it will interfere with your ability to (potentially) store your work in your own repo.

Here is an example from Dr. Larson's machine:

```
mkdir csc341-working
cd csc341-working
mkdir Programming
mkdir Exercises
```

Personally, I would then go to my Finder or Explorer and copy files from csc341-class-repo into the appropriate folder in csc341-working. For example, place the folder "prog01-cyber" inside `csc341-working/Programming`.


#### Open in Editor

If you see the BBedit or notepad++ icon with the .java files in your Finder or Explorer, then you can double-click 
any of the files in the prog01 folder that you just copied into your working directory and it will open in that editor. 
If there is a different icon, then right-click the file and choose to open it with the editor.

#### Open Terminal

Open a terminal so that you can do command-line compilation in Java. Inside of BBedit, you can go to View->Go Here in Terminal and it will open a terminal and place you inside the current directory. Otherwise, you need to navigate to your working directory.

<hr>

### Cybersecurity and Safe Passwords

Companies have a responsibility to store your passwords so that hackers do not have access to that information. This doesn't mean that all companies take that responsibility seriously, and they are not under any legal obligation, so do be careful. 

One of the worst things a company could do is store the usernames and corresponding passwords in a text file such that anyone with (hacked) access to the file can read it! To keep your passwords safe from hackers, passwords are transformed into a different string of characters, which are "impossible" to reverse engineer back to the original password. Impossible is in quotes, because it does depend on how good your method is for transforming the password. And if hackers can try some common passwords that people use, for example "password", and reverse engineer just 1 of the passwords, they can reverse engineer them all. There are many computer scientists who work in the area of cryptography and develop algorithms that do indeed make it impossible (very math intensive)!

There are 2 approaches to transforming passwords. We typically say that the transformed password is encrypted, but technically, passwords are often hashed. The difference is that an encryption is "two way" meaning that if you have the right key, the encrypted password can be transformed back to the original. Hashing is "one way" and you cannot transform the hashed password back to the original. 

The hashed password stored by a company provides a means to check the validity of your credentials when you login. It simply applies the transformation algorithm to the password that you entered and can perform string-matching to see if it matches the stored hashed password. _That is the functionality that you will be writing as part of this assignment._ 

There are a lot of resources online that talk about encryption and hashing passwords. In the provided code, the essence of this process has been captured, but of course it isn't really an algorithm that is impossible to reverse engineer.

- https://auth0.com/blog/encoding-encryption-hashing/ 
- https://www.geeksforgeeks.org/difference-between-hashing-and-encryption/
- https://www.baeldung.com/cs/hashing-vs-encryption

Also included in this folder is a UML diagram demonstrating how the various classes are related. Recall that the various arrows and connectors refer to inheritance, composition, aggregation, and association.

<hr>

## Deliverables

### Write Database.loadUsers()

Included in the assignment is a text file that contains the usernames and hashed password in csv (comma separated value) form. Complete the method in Database that reads this information from the file and stores it in the ArrayList<Pair> users.

- https://www.w3schools.com/java/java_files_read.asp
- https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
- https://www.baeldung.com/java-try-with-resources

- https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
- https://www.w3schools.com/java/java_arraylist.asp

### Write Database.loadStudents()

Included in the assignment is a text csv file that contains student information, including their username. Complete the method in Database that reads this information from the file and stores it in the ArrayList<Student> students.

### Write Database.valid()

In `Database.java`, complete the method that validates the entered credentials. The steps for validation are

1. Traverse the users ArrayList, searching for the username and the associated hashed password.
2. Compare the hashed password entered by the user (using the hash method in Hasher) to the one in the database. If they are the same, return true; otherwise return false.

### Complete LoginWindow.actionPerformed()

In the EventHandler in the `LoginWindow.java` file, manage the login attempt. The method `actionPerformed()` will be called when the user presses the login button. The contents of the username and password text boxes are captured. 

Write the code to validate the credentials. If the credentials are valid, say hello to the user using their name (which you can find in the associated Student record that is stored in the Database). You can change the message in the login window or you can simplify this process and print in the terminal (by using System.out.println()).

**Implement the method Database.getStudent:** find the student associated with the username passed to the method.

If the credentials are not valid, then use the message provided.

- https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionListener.html
- https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
- https://www.tutorialspoint.com/awt/awt_event_handling.htm

<hr>

### Testing Your Work

Testing is an essentail part of coding. In this assignment, you will be doing a visual inspection of the results. This means you look at the behavior and results and check that it is correct. Next week, we will look at automated techniques where the computer checks for you.

Included in the assignment is the file users-cleartext-BAD.txt which contains username and actual passwords in clear text. These are also stored in hashed form in the other file. These can be used to test if your system is working. The test cases that you should try are:

1. Enter a username and password from the users-cleartext file and confirm the credentials are valid. Also confirm that the greeting appears and has the correct name (not username).

2. Enter a valid username but an incorrect password. Confirm that the message indicates it is not valid and the text boxes are cleared.

3. Enter an invalid username (valid are user1000 to user1999). Confirm the message indicates it is not valid and the text boxes are cleared.

<hr>

### Complete Javadocs

*Complete the Javadocs for the Database class only*. Each method should have a general description that includes a
list of parameters and return value, each with a short description. Please use the `@param` and `@return` tags
within the description. You do NOT have to document the setters and getters.

**Compile the javadocs** to generate the web pages for the code. You will want to place all the documentation in a separate folder so that it doesn't clutter your source directory. After completing the commands below, open up the index.html page and see how it looks.

```
mkdir docs
cd docs
javadoc ../*.java
```

> NOTE: If you are on a Windows machine, you probably have to add the javadoc command to your path. Ask me about that.

<hr>


<hr>

### Submit Code to Moodle, Turn in Submission Form in Class

Zip the folder and submit via Moodle. You can zip the folder by right clicking the icon and choosing to compress it.

Please complete the programming assignment submission form and hand that in at the next class period.

<hr>

### Assessment

You can earn a maximum of 4 points on this assignment. Here is the breakdown:
- 1/2 point for turning it in AND it compiles
- 1/2 point for Javadocs complete AND compiled (i.e. docs folder is submitted)
- 3 points for passing the three test cases (meaning they meet the requirements). If you have a minor error that you describe in the submission form, then you may still earn 3 points, depending on the severity of the error.

If all the code is complete and it compiles, but ANY of the tests do not pass, you will have earned 2 of the 3 points.

If you have demonstrated effort of working on the code, you will have earned 1 of the 3 points.
       
