import java.lang.reflect.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class TestBinSearch {

	static Auggie a0 = AuggieFactory.makeAuggie("a00");
	static Auggie b1 = AuggieFactory.makeAuggie("b01");
	static Auggie c2 = AuggieFactory.makeAuggie("c02");
	static Auggie d3 = AuggieFactory.makeAuggie("d03");
	static Auggie e4 = AuggieFactory.makeAuggie("e04");
	static Auggie a1 = AuggieFactory.makeAuggie("a01");
	static Auggie z1 = AuggieFactory.makeAuggie("z01");
	
	/** Comparator for testing purposes. */
	private static Comparator<Auggie> orderCompareTo = new Comparator<Auggie>() {
    	@Override
    	public int compare(Auggie a1, Auggie a2) {
        	return a1.compareTo(a2);
    	}
	};

	public static void main(String[] args) {

		// Code can be verified with this test file through visual inspection.

		// _____________________________________________________________
		// Test constructors
		try {
			AuggieList list1 = new AuggieList();
			AuggieList list2 = new AuggieList(10);
			AuggieList list3 = new AuggieList(orderCompareTo);
			AuggieList list4 = new AuggieList(orderCompareTo, 10);	
		} catch (Exception e) {
			System.out.println("ERROR: Constructors are not working.");
			System.out.println("No use in continuing to test until it is fixed.");
			e.printStackTrace();
			return;
		}
		
		// _____________________________________________________________
		// Is add working with default ordering?
		AuggieList alist = new AuggieList(10);
		try {
			alist.add(c2);
			alist.add(b1);
			alist.add(a0);
			alist.add(e4);
			alist.add(d3);
		} catch(Exception e) {
			System.out.println("ERROR: Add is not working.");
			System.out.println("Go fix it!");
			e.printStackTrace();
			return;
		}
		
		// These should print in order a0, b1, ...
		System.out.println("Added with default ordering of username.");
		System.out.println("Expect a0, b1, ...");
		System.out.println(alist);
		
		// _____________________________________________________________
		// Is Binary Search working?
		Auggie[] aus = {a0,b1,c2,d3,e4};
		System.out.println("Searching for a0, b1, ...");
		System.out.println("Expect to see 0 1 2 ...");
		for (int i=0; i<alist.count(); i++) {
			try {
				System.out.print(alist.search(aus[i])+" ");
			} catch (Exception e) {
				System.out.println();
				System.out.println("ERROR: Just crashed on search("+aus[i]+")");
				System.out.println("Testing on pause until you fix it.");
				e.printStackTrace();
				return;
			}
		}
		System.out.println();
		
		// And one more search for something not there
		try {
			System.out.print("Search for something not there.");
			System.out.println(" Should be -1 -1");
			System.out.println("Returned "+alist.search(a1)+" "+alist.search(z1));
		} catch(Exception e) {
			System.out.println("ERROR: Crashing on something not there");
			e.printStackTrace();
		}
		
		// _____________________________________________________________
		// Is add working with different ordering?
		AuggieList rlist = new AuggieList(Ordering.orderRole,10);
		try {
			rlist.add(c2);
			rlist.add(b1);
			rlist.add(a0);
			rlist.add(e4);
			rlist.add(d3);
		} catch(Exception e) {
			System.out.println("ERROR: Add with role ordering is not working.");
			System.out.println("Go fix it!");
			e.printStackTrace();
			return;
		}
		
		// These should print in order a0, b1, ...
		System.out.println("\n\nAdded with role-username ordering.");
		System.out.println("Expect student - staff - faculty");
		System.out.println(rlist);
		
		// _____________________________________________________________
		// Is Binary Search working with different ordering?
		System.out.println("Searching for a0, b1, ...");
		System.out.println("Not sure what will be there -- role is randomized");
		System.out.println("but you can tell from the above list.");
		for (int i=0; i<alist.count(); i++) {
			try {
				System.out.print(rlist.search(aus[i])+" ");
			} catch (Exception e) {
				System.out.println();
				System.out.println("ERROR: Just crashed on search("+aus[i]+")");
				System.out.println("Testing on pause until you fix it.");
				e.printStackTrace();
				return;
			}
		}
		System.out.println();
		
		// And one more search for something not there
		try {
			System.out.print("Search for something not there.");
			System.out.println(" Should be -1 -1");
			System.out.println("Returned "+rlist.search(a1)+" "+rlist.search(z1));
		} catch(Exception e) {
			System.out.println("ERROR: Crashing on something not there");
			e.printStackTrace();
		}
		
		// _____________________________________________________________
		// How is that sublist working?
		AuggieList blist = new AuggieList(10);
		try {
			blist.add(a1);
			blist.add(b1);
			blist.add(c2);
			blist.add(d3);
			blist.add(e4);
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		Auggie[] sublist = null;

		try {
			// Takes the middle of the list b1 to d3
			sublist = blist.sublist(a1,e4);
			System.out.println("\nsublist expect b1 c2 d3");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
		
			// Takes the first to middle
			sublist = blist.sublist(a0,d3);
			System.out.println("\nsublist expect a1 b1 c2");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
		
			// Takes the middle to last
			sublist = blist.sublist(c2,z1);
			System.out.println("\nsublist expect d3 e4");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
		
			// Takes none of the list
			sublist = blist.sublist(a0,a1);
			System.out.println("\nsublist range before [0] - expect nothing.");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
		
			sublist = blist.sublist(e4,z1);
			System.out.println("\nsublist range after end - expect nothing.");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("\nsomething awry with sublists.");
			e.printStackTrace();
		}
	}		
}
