import java.util.*;

public class Ordering {

	// Define a comparator orderLast that establishes an ordering
	// for Auggies based on their last name with the first name as tie-breaker.
	// Be sure to declare orderLast as public static!
	// TODO	

	
	// Define a comparator orderRole that establishes an ordering
	// for Auggies based on their role with the username as a tie-breaker.
	// Be sure to declare orderRole as public static!	
	// TODO


	
	public static void main(String[] args) {
	
		// Creating an array to sort
		ArrayList<Auggie> auggies = new ArrayList<>();
		
		Auggie a0 = AuggieFactory.makeAuggie("a00");
		Auggie b1 = AuggieFactory.makeAuggie("b01");
		Auggie c2 = AuggieFactory.makeAuggie("c02");
		Auggie d3 = AuggieFactory.makeAuggie("d03");
		Auggie e4 = AuggieFactory.makeAuggie("e04");
		
		// creating a tie to be broken
		a0.last("Larson"); a0.first("Nina");
		b1.last("Larson"); b1.first("Amy");
		
		// Test all your orderings.
		// First we will put in the array.
		
		auggies.add(c2);
		auggies.add(e4);
		auggies.add(b1);
		auggies.add(a0);
		auggies.add(d3);
		
		System.out.println("\nHere they are in added order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}
		
		// Sort using the Collections.sort method for an ArrayList
		// this will use the Auggie.compareTo method
		// TODO
		
		System.out.println("\nNow they should be in username order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}
		
		// Sort using the .sort() for ArrayList with orderLast as the argument.
		// TODO
		
		System.out.println("\nNow they should be in last, first order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}	
		
		// Sort using the .sort() for ArrayList with orderRole as the argument.
		// TODO
		
		System.out.println("\nNow they should be in role, username order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}
	
	}
}
