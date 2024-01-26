/** A collection of Auggie objects listed in no particular order. */
public class AuggieList {

    /** Primitive structure for storing the collection of Auggies */
    protected Auggie[] auggies;

    /** Default for maximum number of auggies that can be stored */
    protected static final int DEFAULT_CAPACITY = 100;

    /** The number of auggies stored in the array. */
    private int count = 0;

    // ____________________________________________________
    //              CONSTRUCTORS
    // ____________________________________________________

    /** 
     */
    public AuggieList(int capacity) {
        // TODO
    }

    /** Default Constructor */
    public AuggieList() {
        this(DEFAULT_CAPACITY);
    }

    // ____________________________________________________

    @Override
    public String toString() {
        // Create numbered list of auggies in the collection
        String printedList = "";
        for (int i = 0; i < count; i++) {
            printedList += (i + 1) + ". " + auggies[i].toString() + "\n";
        }
        return printedList;
    } // end toString()


    // ____________________________________________________
    //              LIST STATUS METHODS
    // ____________________________________________________

    /**
     *
     */
    public boolean full() {
        // TODO: fix this (can be 1 line of code) 
        return false;
    }

    /**
     *
     */
    public boolean empty() {
        // TODO: fix this (can be 1 line of code) 
        return false;
    }

    /**
     *
     */
    private boolean valid(int index) {
        // TODO: fix this (a few lines of code) 
        return false;
    }


    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
    */
    public void add(Auggie auggie) throws IllegalOperationException {
        // Default location for adding an auggie is at the end of the array
        // TODO implement this method
    } // end add(Auggie)

    /**
    */
    public void add(Auggie auggie, int index) throws Exception {
        // TODO: implement this method
    } // end add(index,auggie)

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
    */
    public Auggie get(int index) throws ArrayIndexException {
    	// TODO: implement this method
        // Do not remove the Auggie, just return it

        return null;
    } // end get()
    
    public int locate(Auggie auggie) {
		// TODO: implement this method
		return -1;
	}

    
    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

    /**
    */
    public Auggie[] toArray() throws IllegalOperationException {
        // TODO: implement this method
        return null;
    } // end toArray()

    // ____________________________________________________
    //                   SETTERS AND GETTERS
    // ____________________________________________________

    public int count() {
    	return count;
    }

    public int capacity() {
        return auggies.length;
    }

} // end class List
