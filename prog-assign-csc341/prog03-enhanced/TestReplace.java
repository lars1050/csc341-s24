import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestReplace extends Assert {

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

		System.out.println("TESTING REPLACE _______________");
		
		/*
			Add your tests here for each of the required test cases.
			
			Javadocs is NOT required for tests.
			
			Use the tests in TestListEnhanced to write your tests.
			
			Make sure your error messages are UNIQUE and provide useful information about what the error was.
		*/
		
} // end class Main
