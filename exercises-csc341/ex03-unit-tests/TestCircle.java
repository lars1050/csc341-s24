import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestList extends Assert {

	
	public static void assertEquals(Circle expect, Circle result, String msg) {
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
	
		// place tests here to test the overlap method
		
	
	}
	
}