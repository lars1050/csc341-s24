import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestList extends Assert {

	static Auggie s0 = AuggieFactory.makeAuggie("s00");
	static Auggie s1 = AuggieFactory.makeAuggie("s01");
	static Auggie s2 = AuggieFactory.makeAuggie("s02");
	static Auggie s3 = AuggieFactory.makeAuggie("s03");
	static Auggie s4 = AuggieFactory.makeAuggie("s04");
	
	public static void assertEquals(Auggie expect, Auggie result, String msg) {
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
		}}

	public static void main(String[] args) {

		// Initial add() and get() test
		/* It is a bit of a chicken-and-egg problem.
		* To test add(), get() needs to be correct to confirm auggie was added.
		* To test get(), add() needs to be correct to confirm location of auggie.
		*/

		System.out.println("\n\nSanity check test of add, count, get.");
		System.out.println("If these initial tests do not pass, the rest of the tests are irrelevant!\n");
		
		try {
			AuggieList auggies = new AuggieList(5);
			auggies.add(s1);
			assertEquals(1,auggies.count(),"First Add (count)");
			assertEquals(s1,auggies.get(0),"First Add (s1)");
		} catch (Exception e) {
			System.out.println("Sanity Check FAILED ... DO NOT PROCEED.");
			e.printStackTrace();
		}
		System.out.println("\nSanity Check complete!");

		/* Once the above are confirmed to be working, the testing can proceed.
		*/
		
		try {
			testConstructorGetters();
		} catch(Exception e) {
			System.out.println("\n\n*** STOP HERE -- something wrong with constructor!!\n\n");
		}
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
			testConvert();
		} catch(Exception e) {
			System.out.println("\n\nCONVERT THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
	} // end main

	/* __________________________________________________________________ */
	public static void testConstructorGetters() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList constructor ...");

		AuggieList auggies;

		// Test default constructor and getters
		auggies = new AuggieList();
		assertEquals(100, auggies.capacity(), "AuggieList() capacity");
		assertEquals(0, auggies.count(), "AuggieList() count");
		assertEquals(true, auggies.empty(), "AuggieList() empty");

		// Test constructor with size parameter
		auggies = new AuggieList(5);
		assertEquals(0, auggies.count(), "AuggieList(5) count");
		assertEquals(5, auggies.capacity(), "AuggieList(5) capacity");
		assertEquals(true, auggies.empty(), "AuggieList(5) empty");

		// Test count getter (testing greater than 0)
		try {
			auggies.add(s1);
			assertEquals(1,auggies.count(),"count()");
			auggies.add(s2);
			assertEquals(2,auggies.count(),"count()");
		} catch(Exception e) {
			// passing exception along to caller
			throw e;
		}

		// Test empty and null.
		try {
		auggies = new AuggieList(3);
		assertEquals(false, auggies.full(), "test full when empty");
		assertEquals(true, auggies.empty(), "test empty when empty");

		auggies.add(s1);
		assertEquals(false, auggies.full(), "test full - 1 of 3");
		assertEquals(false, auggies.empty(), "test empty - 1 of 3");

		auggies.add(s1);
		auggies.add(s1);
		assertEquals(true, auggies.full(), "test full - 3 of 3");
		assertEquals(false, auggies.empty(), "test empty - 3 of 3");

		// test count getter when full
		assertEquals(3,auggies.count(),"count()");
		} catch(Exception e) {
			// passing exception along to caller
			throw e;
		}

	} // end testConstructorGetters
	
	/* __________________________________________________________________ */
	public static void testAdds() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList add methods ...");

		AuggieList auggies;

		System.out.println("--------------add(Auggie)");
		auggies = new AuggieList(3);

		// 0 of 3 added
		assertEquals(0,auggies.count(),"pre-add (count)");
		
		// adding 1 of 3
		try {
			auggies.add(s0);
			assertEquals(1,auggies.count(),"add first (count)");
			assertEquals(s0,auggies.get(0),"add first (value)");
		} catch(Exception e) {
			throw e;
		}
		
		// adding 2 of 3
		try {
			auggies.add(s1);
			assertEquals(2,auggies.count(),"add 2nd (count)");
			assertEquals(s1,auggies.get(1),"add 2nd (value)");
		} catch(Exception e) {
			throw e;
		}
		
		// adding 3 of 3
		try {
			auggies.add(s2);
			assertEquals(3,auggies.count(),"add to capacity (count)");
			assertEquals(s2,auggies.get(2),"add to capacity (value)");
		} catch(Exception e) {
			throw e;
		}
		
		// attempt add 4 of 3
		try {
			auggies.add(s3);
			System.out.println("Add over capacity. Expect Exception. None thrown.");
		} catch (IllegalOperationException e) {
			// This is the expected behavior. List should not change.
			assertEquals(3,auggies.count(),"add attempt over capacity (count)");
			assertEquals(s2,auggies.get(2),"add attempt over capacity (value)");
		}

		System.out.println("--------------add(auggie,index)");
		auggies = new AuggieList(6);

		// attempt to add at 0 in empty array. it should fail to add.
		try {
			auggies.add(s1,0);
			System.out.println("Add past count 0. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// This is the expected behavior. List should not change.
			assertEquals(0,auggies.count(),"attempt add to empty - invalid index (count)");
		}
		
		// setup to add at index. adding 1 element.
		try {
			auggies.add(s0);	// s0 should now be in list
		} catch(Exception e) {
			throw e;
		}
		
		// again fail to add past count of 1
		try {
			auggies.add(s1,1);
			System.out.println("Add past count 1. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. List should not change. 
			// Contains only s0 at index 0.
			assertEquals(1,auggies.count(),"attempt add at 1 (count)");
			assertEquals(s0,auggies.get(0),"attempt add at 1 (value)");
		}
		
		// add at index 0. Will contain {s1,s0}
		try {
			auggies.add(s1,0); 
			assertEquals(2,auggies.count(),"add at 0 (count)");
			assertEquals(s1,auggies.get(0),"add at 0 (value)");
			assertEquals(s0,auggies.get(1),"add at 0 (2nd auggie)");
		} catch(Exception e) {
			throw e;
		}

		// test other invalid indices
		try {
			auggies.add(s4,-1);
			System.out.println("Add at index -1. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. List should not change
			assertEquals(2,auggies.count(),"add at index -1 (count)");
		}
		// test other invalid indices
		try {
			auggies.add(s4,5);
			System.out.println("Add at index 5. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. List should not change
			assertEquals(2,auggies.count(),"add at index 5 (count)");
		}
	}
	
	/* __________________________________________________________________ */
	public static void testSearches() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList search methods ...");

		AuggieList auggies;

		Auggie s = AuggieFactory.makeAuggie("userx");

		auggies = new AuggieList(5);
		
		try {
			auggies.add(s0);
			auggies.add(s1);
			auggies.add(s2);
		} catch(Exception e) {
			throw e;
		}

		System.out.println("------------testing get()");
		try { // all valid gets
			assertEquals(s0,auggies.get(0),"get at index 0");
			assertEquals(s1,auggies.get(1),"get at index 1");
			assertEquals(s2,auggies.get(2),"get at index 2");
		} catch(Exception e) {
			throw e;
		}
		
		// get one past the end
		try {
			auggies.get(3);
			System.out.println("Get at count. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. All good.
		}

		// get at capacity
		try {
			auggies.get(5);
			System.out.println("Get at capacity. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. All good.
		}
		
		// get at -1
		try {
			auggies.get(-1);
			System.out.println("Get at -1. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// Expected behavior. All good.
		}

		System.out.println("------------Testing locate()");
		assertEquals(0, auggies.locate(s0), "locate first");
		assertEquals(1, auggies.locate(s1), "locate middle");
		assertEquals(2, auggies.locate(s2), "locate last");
		assertEquals(-1, auggies.locate(s3), "locate but not in AuggieList");

	} // end testSearches
	
	/* __________________________________________________________________ */
	public static void testConvert() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList convert methods ...");

		AuggieList auggies;
		Auggie[] array;

		System.out.println("--------------Testing toArray()");
		auggies = new AuggieList(4);
		
		// toArray with empty list - not allowed
		try {
			auggies.toArray();
			System.out.println("toArray for empty list. Expect Exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior. all good.
		}

		// toarray with 1 element
		try {
			auggies.add(s0);
			array = auggies.toArray();
			if (null==array) {
				System.out.println("ERROR: toArray 1 element. Returns null.");
			} else {
				assertEquals(1,array.length,"toArray 1 element (count)");
				assertEquals(array[0], s0, "toArray 1 element (value)");
			}
		} catch(Exception e) {
			throw e;
		}

		// toarray with more elements
		try {
			auggies.add(s1);
			array = auggies.toArray();
			if (null==array) {
				System.out.println("ERROR: toArray 2 elements. Returns null.");
			} else {
				assertEquals(2,array.length,"toArray 2 elements (count)");
				assertEquals(array[0], s0, "toArray 2 elements (auggie 0)");
				assertEquals(array[1], s1, "toArray 2 elements (auggie 1)");
			}
		} catch(Exception e) {
			throw e;
		}
	} // end testConvert
} // end class Main