## Programming Assignment 06 : Linked List of Auggies

Due: Thursday, March 7 end-of-day

In this lab, you will again be creating the ADT List, except this time you will be implementing it using a linked list.

A test script has been provided.

### GENERAL REQUIREMENTS

It is important that you comment your code. The Javadocs has been completed for you.

Keep your code style-compliant.

Keep your code CLEAN and organized.

```
Special Constraints: You may not break out of any for loop. If you do not know how many interations there will be, then you should be using a while loop!
```

<hr>

#### LIST IMPLEMENTATION

Any method of a List should have the same behavior, regardless if implemented using an array or a linked list.

**Helper Functions**

- `public boolean empty()` determines whether or not there are any items in the List.

- `public boolean valid(int index)` determines if there is an element at that "index" -- using 0-based indexing

- `@Override public String toString()` overrides Object method for printing.

**Constructors**

- `public List()` default constructor.


**Add Methods**

- `public void add(Auggie auggie)` adds that item to the end.

- `public void add(Auggie auggie, int index)` adds that Auggie at the stated index or throws an ArrayIndexException if the index is not valid.


**Find Methods**

- `public Auggie get(int index)` returns array element at that index or throws ArrayIndexException if the index is not valid.

- `public int locate(Auggie auggie)` returns index (location) of the auggie or -1 if it is not in the list.


**Remove Methods**

- `public void remove(Auggie auggie)` Removes that item from the list or throws IllegalOperationException if it is not in the list.

- `public Auggie remove(int index)` Removes the auggie at that index and returns that value. Throws an ArrayIndexException if the index is not valid.


**Conversion Method**

- `Auggie[] toArray()` returns an array that contains the List elements. If the list is empty, throws an IllegalOperationException.

