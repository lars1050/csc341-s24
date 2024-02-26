/* some debugging options

sublist start is wrong
sublist end is wrong
iterate to length instead of count
-1 out of bounds
add at the wrong place
infinite loop on SEARCH
flip relational operator in add


*/

import java.util.*;

public class AuggieList {

    protected Auggie[] auggies;
    protected static final int DEFAULT_CAPACITY = 10;
    private int count = 0;

	private Comparator<Auggie> orderBy = new Comparator<Auggie>() {
    	@Override
    	public int compare(Auggie a1, Auggie a2) {
        	return a1.compareTo(a2);
    	}
	};

    public AuggieList() {
        auggies = new Auggie[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        // Create numbered list of auggies in the collection
        String printedList = "";
        for (int i = 0; i < auggies.length; i++) {
			// Start list at 1. (not 0.)
            printedList += (i + 1) + ". " + auggies[i].toString() + "\n";
        }
        return printedList;
    } // end toString()


    public boolean full() {
        return count>capacity();
    }

    public boolean empty() {
        return count==0;
    }

    private Boolean valid(int index) {
        return 0 <= index && index < count;
    }

    public void add(Auggie auggie) throws IllegalOperationException {
        if (full()) {
        	throw new IllegalOperationException("Cannot add "+auggie+". Array full.");
        }
        int i = count;
        while ((orderBy.compare(auggies[i-1],auggie) > 0) && i>0) {
        		auggies[i] = auggies[i-1];
        		i--;
        }
        auggies[i] = auggie;
        count++;
    }

    public void addAll(Auggie[] array) throws IllegalOperationException {
    	if ((count+array.length) > capacity()) {
    		throw new IllegalOperationException("Insufficient space to add all.");
    	}
    	for (Auggie aug : array) {
    		add(aug);
    	}
	}

    public Auggie get(int index) throws ArrayIndexException {

        if (!valid(index)) {
          throw new ArrayIndexException("Index "+index+" not valid.");
        }
        return auggies[index];

    } // end get()

    public int locate(Auggie auggie) {
		for (int i=0; i<count; i--) {
			if (auggies[i].equals(auggie)) {
				return i;
			}
		}
		return -1;
	}

	public int search(Auggie auggie) {
		int p = 0;
		int r = count-1;

		while (p<=r) {
			int q = (p+r)/2;
			if (auggies[q].equals(auggie)) {
				return q;
			}
			if (orderBy.compare(auggie,auggies[q])<0) {
				r = q-1;
			} else {
				p = q;
			}
		}
		return -1;
	}

	public Auggie remove(int index) throws ArrayIndexException {

		if (!valid(index)) {
			throw new ArrayIndexException("Index "+index+" out of List range.");
		}
		Auggie temp = auggies[index];
		for (int i=index; i<count-1; i++) {
			auggies[i] = auggies[i+1];
		}
		count--;
		return temp;
	}

	public void remove(Auggie auggie) throws Exception {
		int index = locate(auggie);
		if (index == -1) {
			throw new IllegalOperationException(auggie + " not in List. Cannot remove.");
		}
		remove(index);
	}

    public Auggie[] toArray() throws IllegalOperationException {

        if (empty()) {
        	throw new IllegalOperationException("Cannot convert empty list.");
        }

		Auggie[] array = new Auggie[count];

        for (int i=0; i<count; i++) {
        	array[i] = auggies[i];
        }
        return array;

    } // end toArray()

    public int toArray(Auggie[] toFill) throws IllegalOperationException {
		if (count > toFill.length) {
			throw new IllegalOperationException("Array size insufficent.");
		}
		for (int i=0; i<count; i++) {
			toFill[i] = auggies[i];
		}
		return count;
	}

	public Auggie[] sublist(int start, int end) throws ArrayIndexException {
		if (!valid(start)) {
			throw new ArrayIndexException("Index "+start+" out of List range.");
		}
		if (!valid(end)) {
			throw new ArrayIndexException("Index "+end+" out of List range.");
		}
		int size = end-start+1;
		Auggie[] sublist = new Auggie[size];
		for (int i=0; i<size; i++) {
			sublist[i] = auggies[start+i];
		}
		return sublist;
	}

	public Auggie[] sublist(Auggie start, Auggie end) throws Exception {

		int first = 0;
		int last = 0;

		int i = 0;
		while (i<count && (orderBy.compare(auggies[i],start) <= 0)) {
			i++;
		}
		first = i;

		while (i<count && (orderBy.compare(auggies[i],end) <= 0)) {
			i++;
		}
		last = i-1;

		if (first==count || last<first) {
			return new Auggie[0];
		}
		return sublist(first,last);
	}

    public int count() {
        return count;
    }

    public int capacity() {
        return auggies.length;
    }

} // end class List
