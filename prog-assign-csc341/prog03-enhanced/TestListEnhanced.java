import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestListEnhanced extends Assert {

	static Auggie s0 = AuggieFactory.makeAuggie("s00");
	static Auggie s1 = AuggieFactory.makeAuggie("s01");
	static Auggie s2 = AuggieFactory.makeAuggie("s02");
	static Auggie s3 = AuggieFactory.makeAuggie("s03");
	static Auggie s4 = AuggieFactory.makeAuggie("s04");
	static Auggie s5 = AuggieFactory.makeAuggie("s05");

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
			testAddAll();
		} catch(Exception e) {
			System.out.println("\n\nAddAll THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testFindUser();
		} catch(Exception e) {
			System.out.println("\n\nFindUser THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}

		try {
			testRemoves();
		} catch(Exception e) {
			System.out.println("\n\nREMOVES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}

		try {
			testConverts();
		} catch(Exception e) {
			System.out.println("\n\nENHANCED CONVERT THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}

	} // end main

	/* __________________________________________________________________ */
	public static void testAddAll() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList constructor ...");

		AuggieList auggies;


		System.out.println("--------------addAll()");
		auggies = new AuggieList(8);

		Auggie[] toAdd = {s0,s1,s2};

		auggies.addAll(toAdd);
		assertEquals(3,auggies.count(),"addAll to empty (count)");
		assertEquals(s0,auggies.get(0),"addAll added to empty (s0)");
		assertEquals(s1,auggies.get(1),"addAll added to empty (s1)");
		assertEquals(s2,auggies.get(2),"addAll added to empty (s2)");

		Auggie[] moreAdds = {s3,s4,s5};
		auggies.addAll(moreAdds);
		assertEquals(6,auggies.count(),"addAll add 3 to 3 (count)");
		assertEquals(s3,auggies.get(3),"addAll add 3 to 3 (s3)");

		// cannot add (over capacity)
		try {
			auggies.addAll(toAdd);
		} catch (IllegalOperationException e) {
				// This is the expected behavior. List should not change.
				assertEquals(6,auggies.count(),"attempt add over capacity");
		}

		// add to limit
		Auggie[] two = {s2,s5};
		auggies.addAll(two);
		assertEquals(8,auggies.count(),"addAll up to capacity");

	} // end testConstructorGetters

	/* __________________________________________________________________ */
	public static void testFindUser() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList search methods ...");

		AuggieList auggies;

		Auggie grace = new Auggie("u1","Grace","Hopper",Role.FACULTY);
		Auggie kate = new Auggie("u2","Katherine","Johnson",Role.STUDENT);
		Auggie neal = new Auggie("u3","Neal","deGrasse Tyson",Role.STAFF);
		Auggie bert = new Auggie("u4","Albert","Baez",Role.STUDENT);

		System.out.println("--------------findUser(person)");
		auggies = new AuggieList(8);
		auggies.add(grace);
		auggies.add(kate);
		auggies.add(neal);
		auggies.add(bert);

		int index;

		// It is at location 0
		index = auggies.findUser(grace.username());
		assertEquals(0,index,"at location 0");

		// It is at location 1
		index = auggies.findUser(kate.username());
		assertEquals(1,index,"at location 1");

		// It is at location 2
		index = auggies.findUser(neal.username());
		assertEquals(2,index,"at location 2");

		// It is at location 3
		index = auggies.findUser(bert.username());
		assertEquals(3,index,"at location 3");

		// user is in there but not part of a stored auggie
		index = auggies.findUser("u1");
		assertEquals(0,index,"grace constant at 0");

		// It is not in there.
		index = auggies.findUser("user10");
		assertEquals(-1,index,"not in there");

	} // end testFindUser

	/* __________________________________________________________________ */
	public static void testRemoves() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList search methods ...");

		// This assumes add, length is working.

		AuggieList auggies;

		System.out.println("--------------remove(index)");
		auggies = new AuggieList(6);
		auggies.add(s0);
		auggies.add(s1);
		auggies.add(s2);
		auggies.add(s3);

		Auggie removed;

		int count = 0;

		// attempt remove invalid at 4
		try {
			count = auggies.count();
			auggies.remove(4);
		} catch(ArrayIndexException e) {
			// expected behavior
			assertEquals(count,auggies.count(),"count changed but invalid index 4.");
		}

		// attempt remove invalid at -1
		try {
			count = auggies.count();
			auggies.remove(-1);
		} catch(ArrayIndexException e) {
			// expected behavior
			assertEquals(count,auggies.count(),"count changed but invalid index -1.");
		}

		Auggie aug;

		// remove middle (s1) == {s0,s2,s3}
		removed = auggies.remove(1);
		assertEquals(3,auggies.count(),"remove middle (length)");
		assertEquals(s1,removed,"remove middle (value)");

		// remove last (s3) == {s0,s2}
		removed = auggies.remove(2);
		assertEquals(2,auggies.count(),"remove last (length)");
		assertEquals(s3,removed,"remove last (value)");

		// remove first (s0) == {s2}
		removed = auggies.remove(0);
		assertEquals(1,auggies.count(),"remove first (length)");
		assertEquals(s0,removed,"remove first (value)");

		// remove only (s2)
		removed = auggies.remove(0);
		assertEquals(0,auggies.count(),"remove only (length)");
		assertEquals(s2,removed,"remove only (value)");

		Auggie grace = new Auggie("u1","Grace","Hopper",Role.FACULTY);
		Auggie kate = new Auggie("u2","Katherine","Johnson",Role.STUDENT);
		Auggie neal = new Auggie("u3","Neal","deGrasse Tyson",Role.STAFF);
		Auggie bert = new Auggie("u4","Albert","Baez",Role.STUDENT);

		// _________________________________________________________
		System.out.println("--------------remove(Auggie)");
		auggies = new AuggieList(6);
		
		// remove from empty
		try {
			count = auggies.count();
			auggies.remove(s0);
			System.out.println("toArray for empty list. Expect Exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior. all good.
			assertEquals(count,auggies.count(),"count changed but invalid auggie");
		}
		
		auggies.add(grace);
		auggies.add(kate);
		auggies.add(neal);
		auggies.add(bert);

		// attempt remove not in list
		try {
			count = auggies.count();
			auggies.remove(s0);
			System.out.println("toArray for empty list. Expect Exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior. all good.
			assertEquals(count,auggies.count(),"count changed but invalid auggie");
		}

		// remove middle (neal) ==> {grace,kate,bert}
		auggies.remove(neal);
		assertEquals(3,auggies.count(),"remove middle (neal)");

		// remove last (bert) ==> {grace,kate}
		auggies.remove(bert);
		assertEquals(2,auggies.count(),"remove last (bert)");

		// remove first (grace) ==> {kate}
		auggies.remove(grace);
		assertEquals(1,auggies.count(),"remove first (grace)");

		// remove only (kate) ==> {}
		auggies.remove(kate);
		assertEquals(0,auggies.count(),"remove only student (length)");
		

		System.out.println("--------------clearAll()");
		auggies = new AuggieList(6);
		auggies.add(s0);
		auggies.add(s1);
		auggies.add(s2);
		auggies.add(s3);

		auggies.clearAll();
		assertEquals(0,auggies.count(),"remove all (length)");

		auggies.clearAll();
		assertEquals(0,auggies.count(),"remove all empty (length)");


	} // end testRemoves

	/* __________________________________________________________________ */
	public static void testConverts() throws Exception {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing AuggieList convert methods ...");

		AuggieList auggies;
		Auggie[] array;

		System.out.println("--------------Testing toArray(Auggie[])");
		
		auggies = new AuggieList(4);
		
		auggies.add(s0);
		auggies.add(s1);
		auggies.add(s2);
		
		// Fill array larger than count of list
		array = new Auggie[10];
		int copied = 0;
		
		copied = auggies.toArray(array);
		assertEquals(3,copied,"copy into larger array");
		assertEquals(s0,array[0],"copy into larger (s0)");
		assertEquals(s1,array[1],"copy into larger (s1)");
		assertEquals(s2,array[2],"copy into larger (s2)");
		
		// Fill array same size as count
		array = new Auggie[3];
		copied = auggies.toArray(array);
		assertEquals(3,copied,"copy into same size array");
		assertEquals(s0,array[0],"copy into same size (s0)");
		assertEquals(s1,array[1],"copy into same size (s1)");
		assertEquals(s2,array[2],"copy into same size (s2)");

		// copy into smaller - not allowed
		int count = auggies.count();
		array = new Auggie[2];
		try {
			copied = auggies.toArray(array);
			System.out.println("toArray for empty list. Expect Exception. None thrown.");
		} catch(IllegalOperationException e) {
			// expected behavior. all good.
			assertEquals(count,auggies.count(),"count changed but array too small.");
		}
		
		System.out.println("--------------Testing sublist()");
		
		auggies = new AuggieList(10);
		auggies.add(s0);
		auggies.add(s1);
		auggies.add(s2);
		auggies.add(s3);
		auggies.add(s4);
		auggies.add(s5);
		
		Auggie[] sublist;
		
		// copy all the elements
		sublist = auggies.sublist(0,5);
		assertEquals(6,sublist.length,"copied all (count)");
		assertEquals(s0,sublist[0],"copied all (s0)");
		assertEquals(s5,sublist[5],"copied all (s5)");
		
		// copy some of the elements in the middle
		sublist = auggies.sublist(2,4);
		assertEquals(3,sublist.length,"copied middle elements (count)");
		assertEquals(s2,sublist[0],"copied middle (s2)");
		assertEquals(s4,sublist[2],"copied middle (s4)");
		
		// copy front of list
		sublist = auggies.sublist(0,2);
		assertEquals(3,sublist.length,"copied front elements (count)");
		assertEquals(s0,sublist[0],"copied front (s0)");
		assertEquals(s2,sublist[2],"copied front (s2)");
		
		// copy end of list
		sublist = auggies.sublist(3,5);
		assertEquals(3,sublist.length,"copied end elements (count)");
		assertEquals(s3,sublist[0],"copied end (s3)");
		assertEquals(s5,sublist[2],"copied end (s5)");
		
		// Invalid index -1
		try {
			auggies.sublist(-1,4);
			System.out.println("sublist with -1 index. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// expected behavior. all good.
		}
		
		// invalid index 8
		try {
			auggies.sublist(2,8);
			System.out.println("sublist with 8 index. Expect Exception. None thrown.");
		} catch(ArrayIndexException e) {
			// expected behavior. all good.
		}
	} // end testConvert
} // end class Main
