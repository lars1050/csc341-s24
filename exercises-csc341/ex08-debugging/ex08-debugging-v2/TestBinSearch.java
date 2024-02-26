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

	public static void main(String[] args) {

		// Code can be verified with this test file through visual inspection.

		// _____________________________________________________________
		// Test constructors
		try {
			AuggieList list1 = new AuggieList();
		} catch (Exception e) {
			System.out.println("ERROR: Constructor is not working.");
			System.out.println("No use continuing testing until it is fixed.");
			e.printStackTrace();
			return;
		}

		// _____________________________________________________________
		// Is add working with default ordering?
		AuggieList alist = new AuggieList();
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
		// Is locate working?
		System.out.println("___ LINEAR SEARCH ____");		System.out.println("Locating a0, b1, ...");
		System.out.println("Expect to see 0 1 2 ...");
		for (int i=0; i<alist.count(); i++) {
			try {
				System.out.print(alist.locate(aus[i])+" ");
			} catch (Exception e) {
				System.out.println();
				System.out.println("ERROR: Just crashed on locate("+aus[i]+")");
				System.out.println("Testing on pause until you fix it.");
				e.printStackTrace();
				return;
			}
		}
		System.out.println();

		// _____________________________________________________________
		// How is that sublist working?
		AuggieList blist = new AuggieList();
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
			System.out.println("\nsublist expect b1 c2 d3");
			sublist = blist.sublist(a1,e4);
			for (Auggie a : sublist) {
				System.out.println(a);
			}

			// Takes the first to middle
			System.out.println("\nsublist expect a1 b1 c2");
			sublist = blist.sublist(a0,d3);
			for (Auggie a : sublist) {
				System.out.println(a);
			}

			// Takes the middle to last
			System.out.println("\nsublist expect d3 e4");
			sublist = blist.sublist(c2,z1);
			for (Auggie a : sublist) {
				System.out.println(a);
			}

			// Takes none of the list
			System.out.println("\nsublist range before [0] - expect nothing.");
			sublist = blist.sublist(a0,a1);
			for (Auggie a : sublist) {
				System.out.println(a);
			}

			System.out.println("\nsublist range after end - expect nothing.");
			sublist = blist.sublist(e4,z1);
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
