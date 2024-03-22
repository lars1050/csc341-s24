import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.Random;

/** BST Tester - visual inspection */
public class Main {

	// Default comparison is by alpha (with number as tie-breaker)
	// This is the opposite -- ordering by number with alpha as tie-breaker
	public static Comparator<Simple> byNumber = new Comparator<Simple>() {
		@Override
		public int compare(Simple s1, Simple s2) {
			if (s1.number().compareTo(s2.number())==0) {
				return s1.alpha().compareTo(s2.alpha());
			} else {
				return s1.number().compareTo(s2.number());
			}
		}
	};

    public static void main(String[] args) {
    
     	Random random = new Random(10);

        // Create a BST of Simple using default "alpha" ordering
        // This is a list used for testing
        ArrayList<Simple> simples = new ArrayList<>();
        for (int i=0; i<20; i++) {
        	Simple s = new Simple(String.valueOf((char)(i+'a')),20-i);
        	simples.add(s);
        }
        System.out.println("Adding the following elements");
        for (Simple s: simples) {
        	System.out.print(s+" ");
        }
        System.out.println();
        
        SimpleList slist = new SimpleList();
        slist.add(simples.get(10));
        for (int i=0; i<simples.size(); i+=2) {
        	if (i!=10) {
	        	slist.add(simples.get(i));
	        }
        }
        for (int i=1; i<simples.size(); i+=2) {
        	slist.add(simples.get(i));
        }
        
        System.out.println(slist);
        
        try {
	        System.out.println("Height is "+slist.height());
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
    } // end main()
} // end class Main
