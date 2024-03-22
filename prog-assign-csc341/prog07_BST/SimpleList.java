import java.util.*;

/** 
* ADT List that is Ordered. 
* Default ordering is the compareTo method of Simple.
* User can set the ordering by passing in a Comparator.
*/
class SimpleList {

	/** Primary entry point into the tree */
	private Node root = null;

    /** Count of elements in the List */
    private int count = 0;

    /** Comparator for ordering tree. Uses compareTo of Track by default */
    private Comparator<Simple> ordering = new Comparator<Simple>() {
        @Override
        public int compare(Simple simple1, Simple simple2) {
            return simple1.compareTo(simple2);
        }
    };

    // Sentinel for leaf nodes. 
    // This node should be both the left and right child of all leaf nodes.
    // The parent of root should remain null (do not use this sentinel)
    private Node dummy = new Node(null);

	/** Default Constructor */
    public SimpleList() {
    	// height of the dummy node is -1, following the convention of 
    	// calculating the balance factor for ADT trees (see zyBooks)
    	dummy.height = -1;
    	
    	// IMPORTANT: dummy.parent = null 
    	// --> you cannot travel back up the tree from the dummy node!!
    }

	/** 
	* Constructor with user-specified ordering.
	* @param order User-specified comparator for ordering the tree.
	*/
    public SimpleList(Comparator<Simple> order) {
    	// call default constructor so dummy node height gets set
    	this();
        ordering = order;
    }

    // ________________________________________________________________
    //                HELPERS
    // _________________________________________________________________

    @Override
    public String toString() {
    	// TODO ... You have to use recursion
        return null;

    }
    
    /** Return true if the list has no elements, false otherwise. */
    public boolean empty() {
    	return root==null;
    }
    
    /**
    * The height of the tree (i.e. height of the root node).
    * @return Height of the tree
    * @throws IllegalOperationException if tree is empty.
    */
    public int height() {
    	// NOTE that this should be a private method because it is related
    	// to the implementation. However, for testing purposes, this is public.
    	// TODO ...
    	
    	return 0;
    }

    // ________________________________________________________________
    //                ADD
    // _________________________________________________________________
  
  	/** 
  	* Add the specified element to the list.
  	* @param simple Element to add to the list (in order)
  	*/
    public void add(Simple simple) {
    	// TODO ... (clean this up after you are done coding!)
    	// Things to note ...
    	// 1) The left and right child of the new node should be the dummy node (the same dummy node is used for ALL leaf nodes).
    	// 2) The depth should be set once the node is added.
    	// 3) After the node is added, call adjustHeight(new node).
    }
    
    // Helper function to adjust height of nodes (as is appropriate)
    private void adjustHeight(Node n) {
    	// TODO ...
    	// NOTE: traverse the tree back towards the root. 
    	// Only traverse as far as necessary - stop once height is not changed.
    
    }

    // ________________________________________________________________
    //                SEARCH
    // _________________________________________________________________
    
    /**
    * Determine if specified object is in the List.
    * @param simple Object searching for in list.
    * @return true if specified object is in list, false otherwise
    */
    public boolean contains(Simple simple) {
    	// TODO .. Use BINARY SEARCH (iterative or recursive)
    
        return false;
    }

    /**
    * Determine the minimum value in the List based on ordering.
    * @return Minimum value (based on ordering) of the List.
    * @throws IllegalOperationException if list is empty.
    */
    public Simple min() {
    	// TODO .. traverse to the location of the minimum value!
        return null;
    }

    /**
    * Determine the maximum value in the List based on ordering.
    * @return Maximum value (based on ordering) of the List.
    * @throws IllegalOperationException if list is empty.
    */
    public Simple max() {
    	// TODO .. traverse to the location of the maximum value.
        return null;
    }
    
    /**
    * Find ALL Simple objects in the List whose alpha matches specified value.
    * @param alpha value to match for elements in the List.
    * @return All matching simple objects with matching value. If nothing matches, returns an empty ArrayList.
    */
    public ArrayList<Simple> query(String alpha) {
    	// TODO ...
    	// Need to use recursion.
    	return null;
    }
        
    /** 
    * Find the first Simple object whose number matches specified value.
    * @param number Value to match for elements in the List.
    * @return First matching value in List (based on ordering), null if no match
    */
    public Simple findFirst(Integer number) {
    	// TODO ...
    	// Think carefully about this!!
    	// It must return the first occurence based on ordering (ie. tree order)
    	// Need to use recursion (similar to toString)
    	// This is extra challenging.
    	return null;
    }
    
    // ________________________________________________________________
    //                CONVERT
    // _________________________________________________________________
        
	/**
	* Place all elements of the list in a Simple array in order.
	* @return array of all elements in the list. Return an empty array if list empty.
	*/
    Simple[] toArray() {
    	// SPECIAL CONSTRAINT. You cannot use ArrayList.
    	// Use recursion (similar to the toString method)
    	// The array to be filled is one of the parameters.
    	//
    	// This is an extra challenge -- don't spend too much time on it!!
    	// Not a big deal if you don't get it right.
        return null;
    }
    
    // ________________________________________________________________
    //                private NODE CLASS
    // _________________________________________________________________

    private class Node {
		// pointers to children and parent
    	Node left = null;
    	Node right = null;
    	Node parent = null;

		// node value and information
    	Simple value = null;
    	int height = 0;
    	int depth = 0;

		// Default constructor 
		Node() {
			// this will create a Node with a null value
			left = dummy;
    		right = dummy;
		}
		
		// Constructor
    	Node(Simple v) {
    		this();
    		value = v;

    	}
    	
    	@Override
		public String toString() {
			// both are null
			if ((left == null) && (right == null)) {
				return value + "->(" + left + "|" + right+")";
			}
			// neither are null
			if ((left != null) && (right != null)) {
				return value + "->(" + left.value + "|" + right.value+")";
			}
			// only left is null
			if ((left == null)) {
				return value + "->(" + left + "|" + right.value+")";
			}
			// only right is null
			return value + "->(" + left.value + "|" + right+")";
		}
    } // end class Node
} // end class List

