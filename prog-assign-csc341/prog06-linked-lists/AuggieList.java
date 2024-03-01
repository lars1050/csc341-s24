/**
ADT List maintaining a List of Auggies.
Auggies are added to the end of the list by default.
The first element of the list is at "index" 0. This is to match the behavior of a List implemented with an array.
*/
public class AuggieList {

    /** Reference to first element of the list. */
    private Node head = null;

    /** Reference to last element of the list. */
    private Node tail = null;

    /** Number of elements in the list. */
    private int count = 0;
    
    // ____________________________________________________
    //                  PRIVATE NODE CLASS
    // ____________________________________________________
    /*
    This is a Node class private to the AuggieList class because it is an implementation detail. Users of AuggieList do not need access.
    Because it is part of the AuggieList, it is not necessary to create setters and getters -- everything in the class has direct access.

    There are no javadocs for this class because it is private.
    */
    private class Node {
        // Hold a List item
        Auggie value;
        // Reference to the next element in the list.
        Node next;

        // Only constructor for a new Node
        Node(Auggie a) {
            value = a;
        }
    } // end class Node

    // ____________________________________________________
    //              CONSTRUCTORS and toString
    // ____________________________________________________

    /** Default constructor */
    public AuggieList() {
        // nothing to do here
        // all member variables initialized at declaration
    }

    @Override
    public String toString() {
        // TODO 
        return "";   
    }

    // ____________________________________________________
    //              LIST STATUS METHODS
    // ____________________________________________________

    /** Reports status of List. */
    public boolean empty() {
    	// TODO
        return true;
    }

    /**
    * Determine validity of index (not out of bounds)
    * @return true if in bounds, false otherwise
    */
    private boolean valid(int index) {
    	// TODO
        return false;
    }

    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
    * Add specified item to the end of the List.
    * @param auggie item to be added to the List.
    */
    public void add(Auggie auggie) {

    } // end add(auggie)

    /**
    * Add specified item to the List at specified location (if index valid)
    *
    * @param index Location within the List (0-based indexing)
    * @param auggie item to be added to the List
    * @return true if item added, else false.
    * @throws ArrayIndexException if index is out of bounds.
    */
    public void add(Auggie auggie, int index) throws ArrayIndexException {

    } // end add(auggie,index)

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
    * Retrieve the first element in the list (without removing).
    *
    * @return auggie at the front of the list.
    * @throws IllegalOperationException if list is empty.
    */
    public Auggie peekFirst() throws IllegalOperationException {
        if (head==null) {
            throw new IllegalOperationException("List is empty. No peeking.");
        }
        return head.value;
    }
    
    /**
    * Retrieve the last element in the list (without removing).
    *
    * @return auggie at the end of the list.
    * @throws IllegalOperationException if list is empty.
    */
    public Auggie peekLast() throws IllegalOperationException {
        if (head==null) {
            throw new IllegalOperationException("List is empty. No peeking.");
        }
        return tail.value;
    }
    
    
    /**
    * Retrieve auggie at specified index, without removing it.
    *
    * @param index Location within the list (0-based indexing)
    * @return auggie at index if index valid
    * @throws ArrayIndexException if index is out of bounds.
    */
    public Auggie get(int index) throws ArrayIndexException {
        
        return null;
        
    } // end get(index)



    /**
    * Determine location of specified auggie (0-based indexing).
    *
    * @param auggie item searching for in List.
    * @return location (0-based) of item, or -1 if not in list
    */
    public int locate(Auggie auggie) {

        return -1;
        
    } // end locate(auggie)

    // ____________________________________________________
    //                   REMOVE METHODS
    // ____________________________________________________

    /**
    * Remove specified item from the List
    *
    * @param auggie item to be removed from the List (if in the List)
    * @throws IllegalOperationException if auggie is not in the list
    */
    public void remove(Auggie auggie) throws IllegalOperationException {

        // do NOT call the locate method here -- it is inefficient

    } // end remove(auggie)

    /**
    * Remove item at specified index
    *
    * @param index Location within List (0-based indexing)
    * @return auggie at specified location
    * @throws ArrayIndexException if index out of bounds
    */
    public Auggie remove(int index) throws ArrayIndexException {
       
       return null;
       
    } // end remove(index)

    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

    /**
    * Fills a new Auggie array with List items.
    *
    * @return Auggie array with current List items. The size of the array is equal to the number of elements.
    * @throws IllegalOperationException if the List is empty
    */
    public Auggie[] toArray() throws IllegalOperationException {
    	
        return null;
    } // end toArray
    
     // ____________________________________________________
    //                  Getters
    // ____________________________________________________
    
    public int count() {
    	return count;
    }
}
