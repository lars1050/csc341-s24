## Programming Assignem 7 - Binary Search Trees

<hr>

DUE THURSDAY, March 28 <br>
Note: We do not have class on Friday, March 29 <br>
Moodle link will stay open until Sunday, March 31 (yes, on Easter Sunday)

In this lab, you will again create the Abstract Data Type List, except this time you will use a Binary Search Tree for implementation. The List will be storing elements of type Simple.

Learning Outcomes:
- Understand the structure of a binary tree.
- Understand the structure of a binary search tree.
- Know how to implement a binary search tree.
- Know how to implement a class that uses the Comparator interface.
- Use iteration to traverse a binary search tree.
- Use recursion to traverse a binary search tree.

<hr>

> If you are searching for an element based on the ordering of the tree, then you can use binary search. However, if you need to access every element in the tree or perform a "linear" search, you must use recursion. This is the ONLY way to traverse the tree (unless you maintain your own stack, which we will not do until a few weeks from now).

> Please make sure your code is STYLE COMPLIANT. Use the method empty() when you need to check that -- not repeatedly check if root is null. REASON: if you ever change how you checked if a list was empty, you have to change it in only 1 place!

>Javadocs has been completed for you. But PLEASE add appropriate (NOT REDUNDANT) comments to your code ABOVE the code it refers to. Use about 1 comment per 3-4 lines of code.

<hr>


### General Requirements

Note that in this implementation, you will be using a "dummy" or sentinal node to mark the bottom of the tree. Use the SAME dummy node as both the left and right child of ALL leaf nodes. This means that as you traverse to the bottom of the tree, watch for dummy, not null.

Implement the following:

- `String toString()` : Create a string of values in order
- `int height()`

- `void add(Simple value)`
- `private void adjustHeight(Node n)`

- `boolean contains(Simple value)`
- `Simple min()` : based on order of tree
- `Simple max()` : based on order of tree

- `ArrayList<Simple> query(String alpha)`
- `Simple findFirst(Integer value)`



- `Simple[] toArray()` : place elements in the tree into the array IN SORTED ORDER. You cannot use any Java functions to do this for you. You must declare the array, and individually place each element into the array. **This is a challenging method to write! You have to keep track of where the next element is to be added. It will have to be passed around as you traverse the tree (recursively).


There is a little bit of code in Main to add elements to the tree and check its height. That is all that will be provided. It is your responsibility to make sure your code is working. How you test your grade will not be assessed -- only the behavior of your methods.

<hr>

### Resources 

- zyBooks Trees and Binary Search Trees










