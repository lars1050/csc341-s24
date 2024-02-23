### Programming Assignment 05 : LIST Sorting and Recursive Binary Search
#### Due Thursday, February 29 end-of-day (link open until Friday, end-of-day)
#### Submit a single zipped file to Moodle

In this lab, you will continue your work of the previous programming assignment on the ADT List and Binary Search. The important distinction is that you will use recursion to implement Binary Search and you will give the user the opportunity to reorder according to a different criteria.

Learning Outcomes:

- Understand how to maintain an ordered list.
- Be able to implement binary search using recursion.
- Be able to implement a sorting algorithm.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

General Requirements:

- Complete the methods outlined below. These are in addition to those implemented in Programming Assignment 04.
- Document all code in List with Javadocs and with comments in the code (about every 3-4 lines).
- Code must be STYLE COMPLIANT according to the Google style guide.

<hr>

#### Java Style Compliance and Documentation

>Style Compliance, Javadocs, and code commenting will be closely examined and graded. Please pay attention to the feedback on programming assignments to ensure that you are understanding and meeting the requirements.

Your code should be compliant with the Google Java style guide. https://google.github.io/styleguide/javaguide.html

In particular, you should:

- Use camelCase for variable and method names.
- Use capitalized CamelCase for classes.
- Use ALL CAPITALS for constants or enumerated types.
- Do not leave extra whitespace (or extra blank lines except to ease readability)
- Always use curly braces for if-else statements.
- Curly braces for the `else` portion should look like this: `} else {`
- Use @Override where appropriate
- Check error or special conditions FIRST in any method and return. Do not use if-else statements to distinguish an error condition (e.g. invalid index) versus a valid index.

Also make sure your code is CLEAN, nicely organized, and well commented.

- Remove all TODOs, unless it is something you still need to do.
- Keep methods structured in this general order:
	- member variable declarations and definitions
	- constructors
	- helper functions (e.g. toString)
	- primary methods
	- setters and getters
- Group similar methods together.

A rule of thumb is to have a comment for about every 3-4 lines of code. The comments should explain WHY the code is doing what it is doing, not _what_ it is doing (because that is redundant - the code is already communicating that information).

<hr>

### IMPLEMENTATION

Start the implementation by duplicating your prog04 folder in your working directory. Move the COPY of that folder up 1 level. 

#### Recursive Binary Search Method

**Binary Search follows a repeated pattern of looking at the middle of a subarray and determining if the element has been found, and if not, looking in a smaller subarray to the right or left of the middle element.**

1. Create the method `int searchRecursive(Auggie auggie)` Locate the auggie using the technique of Binary Search. This method must call a function that uses recursion. Return its location (index) or -1 if it is not present.

Note that you would never normally have 3 versions of a method that have the same behavior! This is for educational purposes only.

Note the signature of `searchRecursive` -- the only parameter is auggie. This method is NOT a recursive method -- it _calls_ the recursive method that will have additional parameters.

#### Ordering Methods

> For any of the methods below, if the list is empty, throw an IllegalOperationException.

1. Create the method `public void reorder(Comparator<Auggie> order)`, which is a setter for orderBy. ADDITIONALLY, you must reorder (sort) the list based on this new Comparator. You may not use any of the built-in Java sorting algorithms. You choose which sorting algorithm you want to implement.

1. Create the method `public Auggie min()` that returns the min value according to the current ordering. DO NOT ITERATE over the list to find this value -- it is not necessary.

1. Create the method `public Auggie max()` that returns the max value according to the current ordering. DO NOT ITERATE over the list to find this value -- it is not necessary.  

1. Create the method `public Auggie min(Comparator<Auggie> order)` that returns the min value according to the passed Comparator. You MUST iterate over the list to find the minimum value. 

1. Create the method `public Auggie max(Comparator<Auggie> order)` that returns the max value according to the passed Comparator. You MUST iterate over the list to find the maximum value. 

#### CONVERT Methods
    
1. Create the method `public Auggie[] toArray(Comparator<Auggie> order)`. Return an array with the values in the List. This array should be ordered (sorted) according to the passed Comparator. You may not use any of the built-in Java sorting algorithms. You choose which sorting algorithm you want to implement.

1. Create the method `public ArrayList<Auggie> query(Role role)`. Return all the students in the list who have the specified major. Note that the return type is an ArrayList, not Auggie[ ]. Return the new ArrayList even if no items were added to the ArrayList.

### Testing

It is your responsibility to ensure your code is correct. Probably the easiest thing to do is to add to TestBinSearch from the last assignment. This is a visual inspection of the results. You will NOT be graded on how you test your code -- only on whether or not your code exhibits the correct behavior. I will not use your tests to check for correctness -- I will have my own tests.






     

