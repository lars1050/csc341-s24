### Programming Assignment 02 : Building a LIST Abstract Data Type
#### Due Thursday, February 8 end-of-day
#### Submit a single zipped file to Moodle

In this programming assignment, you will continue to create a LIST Abstract Data Type (ADT) with the same functionality that is provided by the Java ArrayList<>. This will give you insight into how structures for data collections are implemented and how the choice of implementation impacts the efficiency with respect to both time and space.

In addition to learning about the List ADT, you will be working on UNIT TESTING, which is the industry standard. Typically, one uses a formal framework that is built for the language being used (e.g. JUnit). We will use a "homegrown" version for transparency and ease of use.

One distinction between ArrayList<> and what you are developing is the use of _Generics_, which is indicated by the "<>" symbols. This allows you as the user to store any type of object. In our implementation (for now), we will only be storing Auggie objects.

Learning Outcomes:

- Understand and implement the primary operation of remove for a _List_ implemented with an array.
- Understand the practice of _Test-Driven Development_.
- Use Exceptions to manage erroneous input or operations.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

General Requirements:

- Complete the methods as outlined below.
- Run the tests to make sure the code is working.
- Document all code with Javadocs and compile the javadocs.
- Write a unit test for the _replace_ method.

<hr>

### LISTS

The Abstract Data Type (ADT) **_List_** refers to a collection of elements, which is maintained with primary operators that add, remove, find, and sort elements. 

It is important to have a shared understanding of the list qualities and how the operators modify the list. For this lab:
- The list may have duplicate elements. 
- The list is not sorted.
- If positional information is not provided, the `add()` method will add after the last element in the list, as long as the list is not full.
- If positional information is provided, the `add()` method will add at the INDEX indicated, shifting elements to make room, as long as the index is valid.
- The `remove()` method can remove at a particular index or remove a particular item.

### Javadocs Documentation

AS you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the prog02-list folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:
  ```
  mkdir docs
  cd docs
  javadoc ../*.java
  ```
  You can view the results by opening the index.html file in your browser.

<hr>

### Testing Your Work

Testing is an essentail part of coding. In this assignment, you will use the provided unit tests to ensure your code is working properly.

To run the tests, compile your code and run the TestListEnhanced.java file. **If you see any output on the screen that have indicates an expected value versus an actual value then your code is wrong** (or my tests are wrong, but I did check them, so I think they are good, but you can always ask to be sure!).

```
> javac *.java
> java TestListEnhanced
```

>There is a "sanity check" that is first run for the tests. If these do not pass, then there is something wrong with either your add or get method. Until this is fixed, do not pay attention to the results of any of the other tests.

>When I test your code, I will copy a fresh TestListEnhanced.java into your directory.

<hr>

### Implementation

In this assignment, you will continue your development of the ADT List of Auggie objects by completing the implementation of the class _AuggieList__. 

Start by 
- pull the repository
- copy the prog03 folder to your working directory
- copy your completed AuggieList.java from prog02 into prog03.
- copy the methods from enhancements.txt into the AuggieList 

>Note: keep your code organized! Place the new methods in their appropriate section in the code. For example `addAdd()` should be placed after the 2 other add methods.

#### REMOVE METHODS

Implement the following:

- `Auggie remove(int index)`
	- if the index is not valid, throw ArrayIndexException.
	- remove the element from the array by shifting items to fill the gap
	- return the removed item
	
- `void remove(Auggie auggie)`
	- if the Auggie is not in the list, throw an IllegalOperationException
	- remove the found auggie
	- NOTE: use your other methods to implement this one!

- `void clearAll()`
	- no need to do anything but reset the count!

#### SEARCH METHODS 

Implement the following:

- `int findUser(String uname)`
	- if the username is found, return its index 
	- otherwise return -1
	
- `void replace(Auggie a1, Auggie a2)`
	- if a1 is not in the list, throw an IllegalOperationException
	- replace a1 with the value a2

#### CONVERT METHODS 

Implement the following:

- `int toArray(Auggie[] array)`
	- if the array is not large enough to hold all list items, throw an IllegalOperationException.
	- copy all list items into the array.
	- return the number of elements copied.
	
- `Auggie[] sublist(int start, int end)`
	- if either index is not valid, throw an ArrayIndexException
	- create a new array that is the size of the number of items to be copied.
	- copy the elements from index start to end (inclusive) into the new array and return.

#### ADD METHODS 

- Implement `void addAll(Auggie[] array)`
	- if ALL the items do not fit in the list, throw an IllegalOperationException
	- add all elements in the array to the list

<hr>
### Test 

In the file TestReplace.java, complete the code to sufficiently test replace. This means there should be test cases for 
- replacing the first element, 
- replacing the last element, 
- replacing an element in the middle of the list, and 
- attempting to replace an Auggie that is not in the list.

<hr>

### Submit Code

Submit Code to Moodle, Turn in Submission Form in Class
Zip the folder and submit via Moodle. You can zip the folder by right clicking the icon and choosing to compress it.

Please complete the programming assignment submission form and hand that in at the next class period.







