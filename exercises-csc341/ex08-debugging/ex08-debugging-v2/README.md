### Programming Assignment 04 : Binary Search with an Ordered List
#### Due Thursday, February 23 end-of-day
#### Submit a single zipped file to Moodle

In this programming assignment, you will continue your implementation of a List using an array. The primary difference is that the sorted order of the List must be maintained. Furthermore, to make search more efficient, you will be implementing Binary Search to locate an element in the list. 

Learning Outcomes:

- Know how to implement a sorted List.
- Know how to implement Binary Search on a sorted List.
- Know how to implement and use a Comparator and the Comparable interface to order class objects.
- Use Java built-in sorting methods.
- Create code that is style compliant and well documented.

>A note about testing. There are test files for this lab, but they do not use AssertEquals. Instead, you will be testing through a visual inspection of the output. In other words, you look at what is displayed on the screen and make sure it is what is expected. The print statements and comments in the test file tell you what to expect.

<hr>

### Getting Started

- Pull the repo.
- Copy the contents of this programming assignment into your working directory.
- Copy your AuggieList.java file into this programming assignment folder of your working directory.

<hr>

### Style Compliance

Organizations establish rules about how to style your code. The style rules might discuss whitespace, variable naming conventions, curly brace placement, etc. In this lab (and all labs going forward), your code should be compliant with the Google Java style guide.

https://google.github.io/styleguide/javaguide.html

In particular, you should:

- Use camelCase for variable and method names.
- Use capitalized CamelCase for classes.
- Use ALL CAPITALS for constants or enumerated types.
- Do not leave extra whitespace (or extra blank lines except to ease readability)
- Always use curly braces for if-else statements.
- Curly braces for the else portion should look like this: } else {
- Use @Override where appropriate
- Check error or special conditions FIRST in any method and return. Do not use - if-else statements to distinguish an error condition (e.g. invalid index) versus a valid index.
- Also make sure your code is CLEAN, nicely organized, and well commented.
- Remove all TODOs, unless it is something you still need to do.
- Group similar methods together. Keep methods structured in this general order:
	- member variable declarations and definitions
	- constructors
	- helper functions (e.g. toString)
	- primary methods
	- setters and getters

<hr>

### LISTS

### Implementation for Ordering

First, focus on the Auggie.java and the file Ordering.java. In there, you need to create 2 Comparators and sort an ArrayList in 3 ways

- Modify Auggie.java so that it implements Comparable. The default comparison for an Auggie should be based on the username (which should be unique, thus there are no ties to break).

- In Ordering.java, create a Comparator<Auggie> called orderLast. It orders Auggies by last name, using the first name as a tie-breaker.

- In Ordering.java, create a Comparator<Auggie> called orderRole. It orders Auggies by their Role, using the username as a tie-breaker.

- In Ordering.java, follow the directions to sort the ArrayList using 1) the Auggie compareTo method, 2) orderLast, and 3) orderRole.

Compile and run the Ordering.java file and look carefully at the results. Did everything get sorted as expected? If not, fix it.


### Implementation of AuggieList

Add this to the top of the file inside the class definition, grouped with other member variable definitions.

```
/** Comparator for ordering array. Uses compareTo of Auggie by default */
private Comparator<Auggie> orderBy = new Comparator<Auggie>() {
    @Override
    public int compare(Auggie a1, Auggie a2) {
        return a1.compareTo(a2);
    }
};
```

Implement or modify the following methods in AuggieList.

>Advice: Add the comparator above, write the constructors, and create the stubs for search and sublist. Now you can incrementally code (a little) and test.

- `AuggieList(ordering)`: Use the default capacity -- you can do this by calling the default constructor, then set orderBy to ordering.

- `AuggieList(ordering,capacity)`: Call the constructor passing the capacity, then set orderBy to ordering.

- modify `void add(Auggie a)`: You can no longer simply add at the end of the list. You have to determine where to add the element to maintain order. Iterate from count towards 0, shifting as you go until you find the right spot to add.

- `int search(Auggie a)`: write binary search to locate the auggie a. Remember to use the orderBy.compare, not the compareTo method!

- `Auggie[] sublist(Auggie astart, Auggie aend)`: extract a sublist of elements that fall between astart and aend (exclusive), based on orderBy. Notice that the astart and/or aend do not have to be in the list. Consider an example with a list of numbers {2,5,8,12,17}. The sublist that falls between 7 and 15 are {8,12}. Once you have established the start and last index, you can call your other sublist. Do not throw an Exception for this one if there is nothing in the sublist -- instead return an array of size 0.

>Note that add(value,index) and replace(a1,a2) should no longer be available to users as this can break the ordering of the List. Do not do anything to these methods -- the tests do not call them and we will pretend they do not exist.

<hr>

### Submit Code

**Look carefully at the test results.** You have to determine whether or not your code is functional by comparing the displayed results to the expected results.

**Did you remember to make your code style compliant?**

Submit Code to Moodle, turn in the Submission Form in class.








