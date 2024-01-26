### Programming Assignment 02 : Building a LIST Abstract Data Type
#### Due Thursday, February 1 end-of-day
#### Submit a single zipped file to Moodle

In this programming assignment, you will begin to create a LIST Abstract Data Type (ADT) with the same functionality that is provided by the Java ArrayList<>. This will give you insight into how structures for data collections are implemented and how the choice of implementation impacts the efficiency with respect to both time and space.

In addition to learning about the List ADT, you will also be introduced to UNIT TESTING, which is the formal mechanism by which all commercial code is tested. Typically, one uses a formal framework that is built for the language being used. We will use a "homegrown" version for transparency and ease of use.

One distinction between ArrayList<> and what you are developing is the use of _Generics_, which is indicated by the "<>" symbols. This allows you as the user to store any type of object. In our implementation (for now), we will only be storing Auggie objects.

Look for "TODO" in the code, which highlights what you need to implement.

Learning Outcomes:

- Understand and implement the primary operations that add and find elements in a _List_ implemented with an array.
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

<hr>

### LISTS

The Abstract Data Type (ADT) **_List_** refers to a collection of elements, which is maintained with primary operators that add, remove, find, and sort elements. In your reading, they distinguish between a list, bag, and set. I make no such distinctions and refer to all of them as a List, but I will be specific in whether or not those elements are unique (i.e. a set) or in a sorted order. The operators applied to a list must be specified by the user, unlike with queues in which elements are added and removed from specific locations.

It is important to have a shared understanding of the list qualities and how the operators modify the list. For this lab:
- The list may have duplicate elements. 
- The list is not sorted.
- If positional information is not provided, the `add()` method will add after the last element in the list, as long as the list is not full.
- If positional information is provided, the `add()` method will add at the INDEX indicated, shifting elements to make room, as long as the index is valid.

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

To run the tests, compile your code and run the TestList.java file. **If you see any output on the screen that starts with "ERROR," then your code is wrong** (or my tests are wrong, but I did check them, so I think they are good, but you can always ask to be sure!).

```
> javac *.java
> java TestList
```

>There is a "sanity check" that is first run for the tests. If these do not pass, then there is something wrong with either your add or get method. Until this is fixed, do not pay attention to the results of any of the other tests.

>When I test your code, I will copy a fresh TestList.java into your directory.

<hr>

### Implementation

In this assignment, you will be creating an ADT List of Auggie objects by completing the implementation of the class _AuggieList__. An Auggie is a student, faculty, or staff member (indicated by the `enum Role`). Take a moment to look at the class definition for Auggie.

The instantiation of an AuggieList will create an array for storing Auggies. It has a fixed capacity, therefor it can get full and no longer be able to add elements to the List.

The List has a capacity (i.e. the length of the array that is storing Auggies) and it has a count (i.e. the number of Auggies in the array). **When traversing the array, you should only iterate to count, not to capacity.** If you are throwing NullPointer exceptions, check your for loop.

In the requirements, you will also notice that some situations will throw one of the defined exceptions. Take a moment to look at ArrayIndexException and IllegalOperationException. Typically, you would use Java's built-in exceptions, but this gives you practice with user-defined exceptions, and these can be tested with the provided unit tests.

#### ESSENTIALS and HELPERS

Implement the following ...

- `AuggieList(int capacity)` constructor with a set capacity for data.
- `boolean full()` determines whether or not there is capacity for more students.
- `boolean empty()` determines whether or not there are any students in the List.
- `boolean valid(int index)` determines if the given index corresponds to an element stored in the List.

#### ADD Methods

- Implement the method `void add(Auggie auggie)`.
    - If the structure is full, throw an IllegalOperationException and return.
    - If the structure is not full, add to the end of the list. (The _end_ of the list refers to the last element in the list.)
    - Maintain the count.

- Implement the method `void add(Auggie auggie, int index)`.
    - If the structure is full, throw an IllegalOperationException and return.
    - If the index is invalid (i.e. there is not a current element at the specified index), throw an ArrayIndexException and return.
    - If the structure is not full and the index is valid, add the element at the index indicated. Shift all elements as appropriate BEFORE adding the element to make space for it. **Hint: Start at the end of the List and shift right until the index is reached.**
    - Maintain the count.

<hr>

#### SEARCH Methods

- Implement the method `Auggie get(int index)`.
    - If the index is not valid, throw ArrayIndexException and return.
    - If the index is valid, return the element at that index. It should not be removed, just returned.

- Implement the method `int locate(Auggie auggie)`.
    - If the Auggie is in the list, return its index. Note that you should use _equals_ to determine if auggie is in the List.
    - If the auggie is not in the list, return -1 (no error message required).

<hr>

#### CONVERT Methods

- Implement the method `Auggie[] toArray()`.
	- If the list is empty, throw an IllegalOperationException and return.
	- If the list is not empty, create an array the size of count (not capacity) and copy the contents of the List into the new array. 
<hr>

### Submit Code

Submit Code to Moodle, Turn in Submission Form in Class
Zip the folder and submit via Moodle. You can zip the folder by right clicking the icon and choosing to compress it.

Please complete the programming assignment submission form and hand that in at the next class period.

<hr>

### Assessment

You can earn a maximum of 5 points on this assignment. Here is the breakdown:

- 1/2 point for turning it in AND it compiles
- 1/2 point for Javadocs complete AND compiled (i.e. docs folder is submitted)
- 2 points for passing all the tests of constructor, status, get, and add(student)
- 2 points for passing all the tests of add(student, index), find, toArray(). 

There is no partial credit for code that is partially complete. A given method is correct only when it passes all the tests for that method. You may earn partial credit for methods that pass all the tests. For example, if you pass all the tests for all but 1 method in the list, you will get partial credit.





