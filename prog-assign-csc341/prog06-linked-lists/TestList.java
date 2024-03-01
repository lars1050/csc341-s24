import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestList extends Assert {

	static Auggie a0 = AuggieFactory.makeAuggie("a0");
	static Auggie a1 = AuggieFactory.makeAuggie("a1");
	static Auggie a2 = AuggieFactory.makeAuggie("a2");
	static Auggie a3 = AuggieFactory.makeAuggie("a3");
	static Auggie a4 = AuggieFactory.makeAuggie("a4");
	
	public static int assertEquals(Auggie expect, Auggie result, String msg) {
		boolean match = true;
		// First test for nulls to avoid Exceptions
		if ((null==expect) && (null!=result)) {
			match = false;
		} else if ((null==expect) && (null==result)) {
			match = true;
		} else {
			match = (expect.equals(result));
		}
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
			return 0;
		}
		return 1;
	}

	// __________________________________________________________________ 
	//                  MAIN and SANITY CHECK
	// __________________________________________________________________ 

	public static void main(String[] args) {

		System.out.println("\nSanity check test of add and count.");
		
		try {
		
			int passed = 0;
			
			// Test Constructor and Empty
			AuggieList auggies = new AuggieList();
			passed += assertEquals(true,auggies.empty(),"empty() at initialization.");

			// Test an add
			auggies.add(a1);
			passed += assertEquals(1,auggies.count(),"Sanity check (count)");
			passed += assertEquals(a1,auggies.peekFirst(),"Add a1. peekFirst.");
			passed += assertEquals(a1,auggies.peekLast(),"Add a1. peekLast.");
			
			// And one more
			auggies.add(a2);
			passed += assertEquals(2,auggies.count(),"Sanity check (count)");
			passed += assertEquals(a1,auggies.peekFirst(),"Add a2. peekFirst.");
			passed += assertEquals(a2,auggies.peekLast(),"Add a2. peekLast.");
			
			// Test the get
			passed += assertEquals(a1,auggies.get(0),"Sanity check get(0).");
			passed += assertEquals(a2,auggies.get(1),"Sanity check get(1).");
			
			if (passed == 9) {
				System.out.println("Sanity Check PASSED.");
			} else {
				throw new Exception();
			}
			
			// And how is that toString looking?
			auggies.add(a3);
			System.out.println("\nResults of your toString() -- Expect a1, a2, a3m.");
			System.out.println(auggies);
			
		} catch (Exception e) {
			System.out.println("Sanity Check FAILED ... FIX YOUR CODE!!.\n");
			e.printStackTrace();
			return;
		}

		// _____________________ CALLS TO ALL TESTS _______________________
		
		/* Once the above are confirmed to be working, the testing can proceed.
		*/
		try {
			testAdds();
		} catch(Exception e) {
			System.out.println("\n\nADDS THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testSearches();
		} catch(Exception e) {
			System.out.println("\n\nSEARCHES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testRemoveAuggie();
		} catch(Exception e) {
			System.out.println("\n\nREMOVE Auggie THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testRemoveIndex();
		} catch(Exception e) {
			System.out.println("\n\nREMOVE at Index THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testConvert();
		} catch(Exception e) {
			System.out.println("\n\nCONVERT THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
	} // end main

	// __________________________________________________________________ 
	//                  TEST ADDS
	// __________________________________________________________________ 
	
	public static void testAdds() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList add methods ...");

		AuggieList auggies;
		
		System.out.println("--------------add(Auggie)");
		auggies = new AuggieList();
		
		// already tested adding a1 and a2 in Sanity Check
		auggies.add(a1);
		auggies.add(a2);
		
		// add 1 more to be sure
		auggies.add(a3);
		assertEquals(3,auggies.count(),"add 3rd item (count)");
		assertEquals(a3,auggies.get(2),"add 3rd item (value)");
		assertEquals(a1,auggies.peekFirst(),"add 3rd. peekFirst");
		assertEquals(a3,auggies.peekLast(),"add 3rd. peekLast");
		

		System.out.println("--------------add(auggie,index)");
		auggies = new AuggieList();

		// attempt to add at 0 in empty array. it should fail to add.
		try {
			auggies.add(a0,0);
			System.out.println("Add past count 0. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// This is the expected behavior. List should not change.
			assertEquals(0,auggies.count(),"attempt add to empty - invalid index (count)");
		}
		
		// create a list of length 1 for testing
		auggies.add(a0);
		
		// again fail to add past count of 1
		try {
			auggies.add(a1,1);
			System.out.println("Add past count 1. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. List should not change. 
			// Contains only a1 at index 0.
			assertEquals(1,auggies.count(),"attempt add at 1 (count)");
			assertEquals(a0,auggies.get(0),"attempt add at 1 (value)");
		}
		
		// add at index 0. Will contain {a1,a0}
		auggies.add(a1,0); 
		assertEquals(2,auggies.count(),"add at 0 (count)");
		assertEquals(a1,auggies.get(0),"add at 0 (value)");
		assertEquals(a1,auggies.peekFirst(),"add at 0. peekFirst");
		assertEquals(a0,auggies.peekLast(),"add at 0. peekLast");
		
		// add in the middle. Will contain {a1,a2,a0}
		auggies.add(a2,1); 
		assertEquals(3,auggies.count(),"add middle (count)");
		assertEquals(a2,auggies.get(1),"add middle (value)");
		assertEquals(a1,auggies.peekFirst(),"add middle. peekFirst");
		assertEquals(a0,auggies.peekLast(),"add middle. peekLast");
		
		// add at end. Will contain {a1,a2,a3,a0}
		auggies.add(a3,2); 
		assertEquals(4,auggies.count(),"add at last (count)");
		assertEquals(a3,auggies.get(2),"add at last (value)");
		assertEquals(a1,auggies.peekFirst(),"add at last. peekFirst");
		assertEquals(a0,auggies.peekLast(),"add at last. peekLast");

		// test other invalid indices
		try {
			auggies.add(a4,-1);
			System.out.println("Add at index -1. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. List should not change
		}
		
		// test other invalid indices
		try {
			auggies.add(a4,4);
			System.out.println("Add at index 4. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. 
		}
		
	} // end testAdds
	
	// __________________________________________________________________ 
	//                  TEST SEARCHES
	// __________________________________________________________________ 
	
	public static void testSearches() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList search methods ...");
		
		// If testAdds is passing, then get(index) must be working.
		// just need to test locate

		AuggieList auggies = new AuggieList();
		
		// Adds were presumably tested so these should work
		auggies.add(a0);
		auggies.add(a1);
		auggies.add(a2);

		System.out.println("------------Testing locate()");
		assertEquals(0, auggies.locate(a0), "locate first");
		assertEquals(1, auggies.locate(a1), "locate middle");
		assertEquals(2, auggies.locate(a2), "locate last");
		assertEquals(-1, auggies.locate(a3), "locate but not in AuggieList");
		
	} // end testSearches

	// __________________________________________________________________ 
	//                  TEST REMOVE at INDEX
	// __________________________________________________________________ 
	
	public static void testRemoveIndex() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList remove(index) ...");

		AuggieList auggies = new AuggieList();
		
		auggies.add(a0);
		auggies.add(a1);
		auggies.add(a2);
		auggies.add(a3);
		
		/*
		The remove methods can cause all kinds of trouble. These tests will do a series of adds and removes to ensure the links are maintained, as well as the head and tail.
		*/
		System.out.println("--------------remove(index)");

		// attempt remove at count
		try {
			auggies.remove(auggies.count());
			System.out.println("ERROR ... remove at count. Expect exception. None thrown.");
		} catch(ArrayIndexException e) {
			// expected behavior
		}

		// attempt remove invalid at -1
		try {
			auggies.remove(-1);
			System.out.println("ERROR ... remove at index -1. Expect exception. None thrown.");
		} catch(ArrayIndexException e) {
			// expected behavior
		}

		// Starting with {a0,a1,a2,a3}
		Auggie removed = null;
		
		// after remove middle (a1) ==> {a0,a2,a3}
		removed = auggies.remove(1);
		assertEquals(3,auggies.count(),"remove middle (count)");
		assertEquals(a1,removed,"remove middle (value)");
		assertEquals(a0,auggies.peekFirst(),"remove middle. peekFirst");
		assertEquals(a3,auggies.peekLast(),"remove middle. peekLast");
		
		// is the chain still intact??
		auggies.add(a1,1);
		assertEquals(a1,auggies.get(1),"add after remove middle (value).");
		
		// back to {a0,a1,a2,a3}
		// after remove tail (a3) ==> {a0,a1,a2}
		removed = auggies.remove(3);
		assertEquals(3,auggies.count(),"remove tail (length)");
		assertEquals(a3,removed,"remove tail (value)");
		assertEquals(a0,auggies.peekFirst(),"remove tail. peekFirst");
		assertEquals(a2,auggies.peekLast(),"remove tail. peekLast");
		
		// is the chain still intact??
		auggies.add(a3,1);
		assertEquals(a3,auggies.get(1),"add after remove middle (value).");
		// how about later in the chain...
		auggies.add(a4,3);
		auggies.add(a1);
		// after these adds ==> {a0,a3,a1,a4,a2,a1}
		assertEquals(a3,auggies.get(1),"add after remove tail (1)");
		assertEquals(a1,auggies.get(2),"add after remove tail (2)");
		assertEquals(a4,auggies.get(3),"add after remove tail (3)");
		assertEquals(a2,auggies.get(4),"add after remove tail (4)");
		assertEquals(a0,auggies.peekFirst(),"add after remove tail. peekFirst");
		assertEquals(a1,auggies.peekLast(),"add after remove tail. peekLast");

		// remove first ==> {a3,a1,a4,a2,a1}
		removed = auggies.remove(0);
		assertEquals(5,auggies.count(),"remove first (length)");
		assertEquals(a0,removed,"remove first (value)");
		assertEquals(a3,auggies.peekFirst(),"remove first. peekFirst");
		assertEquals(a1,auggies.peekLast(),"remove first. peekLast");

		// remove when only 1 element in the list
		auggies = new AuggieList();
		auggies.add(a0);
		removed = auggies.remove(0);
		assertEquals(0,auggies.count(),"remove only (length)");
		assertEquals(a0,removed,"remove only (value)");
		try {
			auggies.peekFirst();
			System.out.println("Peeking at head when empty. Expect exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior
		}
		try {
			auggies.peekLast();
			System.out.println("Peeking at tail when empty. Expect exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior
		}
	} // end TestRemoveIndex
	 
	// __________________________________________________________________ 
	//                  TEST REMOVE Auggie
	// __________________________________________________________________ 
	
	public static void testRemoveAuggie() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList remove(auggie) ...");

		AuggieList auggies = new AuggieList();
		
		/*
		The remove methods can cause all kinds of trouble. These tests will do a series of adds and removes to ensure the links are maintained, as well as the head and tail.
		*/
		System.out.println("--------------remove(auggie)");

		// attempt remove from empty list
		try {
			auggies.remove(a4);
			System.out.println("ERROR ... remove from empty. Expect exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior
		}
			
		auggies.add(a0);
		auggies.add(a1);
		auggies.add(a2);
		auggies.add(a3);

		// attempt remove something not in the list
		try {
			auggies.remove(a4);
			System.out.println("ERROR ... remove not in list. Expect exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior
		}

		// Starting with {a0,a1,a2,a3}
		
		// after remove middle (a1) ==> {a0,a2,a3}
		auggies.remove(a1);
		assertEquals(3,auggies.count(),"remove middle (count)");
		assertEquals(a0,auggies.peekFirst(),"remove middle. peekFirst");
		assertEquals(a3,auggies.peekLast(),"remove middle. peekLast");
		
		// is the chain still intact??
		auggies.add(a1,1);
		assertEquals(a1,auggies.get(1),"add after remove middle (value).");
		
		// back to {a0,a1,a2,a3}
		// after remove tail (a3) ==> {a0,a1,a2}
		auggies.remove(a3);
		assertEquals(3,auggies.count(),"remove tail (length)");
		assertEquals(a0,auggies.peekFirst(),"remove tail. peekFirst");
		assertEquals(a2,auggies.peekLast(),"remove tail. peekLast");
		
		// is the chain still intact??
		auggies.add(a3,1);
		assertEquals(a3,auggies.get(1),"add after remove middle (value).");
		// how about later in the chain...
		auggies.add(a4,3);
		auggies.add(a1);
		// after these adds ==> {a0,a3,a1,a4,a2,a1}
		assertEquals(a3,auggies.get(1),"add after remove tail (1)");
		assertEquals(a1,auggies.get(2),"add after remove tail (2)");
		assertEquals(a4,auggies.get(3),"add after remove tail (3)");
		assertEquals(a2,auggies.get(4),"add after remove tail (4)");
		assertEquals(a0,auggies.peekFirst(),"add after remove tail. peekFirst");
		assertEquals(a1,auggies.peekLast(),"add after remove tail. peekLast");

		// remove first ==> {a3,a1,a4,a2,a1}
		auggies.remove(a0);
		assertEquals(5,auggies.count(),"remove first (length)");
		assertEquals(a3,auggies.peekFirst(),"remove first. peekFirst");
		assertEquals(a1,auggies.peekLast(),"remove first. peekLast");

		// remove when only 1 element in the list
		auggies = new AuggieList();
		auggies.add(a0);
		auggies.remove(a0);
		assertEquals(0,auggies.count(),"remove only (length)");
		try {
			auggies.peekFirst();
			System.out.println("Peeking at head when empty. Expect exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior
		}
		try {
			auggies.peekLast();
			System.out.println("Peeking at tail when empty. Expect exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior
		}
	} // end testRemoveAuggie

	// __________________________________________________________________ 
	//                  TEST CONVERT (toArray)
	// __________________________________________________________________ 

	public static void testConvert() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList convert methods ...");
		
		AuggieList auggies;
		Auggie[] array;

		System.out.println("--------------Testing toArray()");
		auggies = new AuggieList();
		
		// toArray with empty list - not allowed
		try {
			auggies.toArray();
			System.out.println("toArray for empty list. Expect Exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior. all good.
		}

		// toarray with 1 element
		auggies.add(a0);
		array = auggies.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 1 element. Returns null.");
		} else {
			assertEquals(1,array.length,"toArray 1 element (count)");
			assertEquals(array[0], a0, "toArray 1 element (value)");
		}

		// toarray with more elements
		auggies.add(a1);
		auggies.add(a2);
		array = auggies.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 3 elements. Returns null.");
		} else {
			assertEquals(3,array.length,"toArray 3 elements (count)");
			assertEquals(array[0], a0, "toArray 3 elements (auggie 0)");
			assertEquals(array[1], a1, "toArray 3 elements (auggie 1)");
			assertEquals(array[2], a2, "toArray 3 elements (auggie 2)");
		}

	} // end testConvert
} // end class Main