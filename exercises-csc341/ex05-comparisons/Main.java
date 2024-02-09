public class Main {

	public static void main(String[] args) {
	
		Circle c1 = new Circle(10,0,0,Color.RED);
		Circle c2 = new Circle(20,50,50,Color.BLUE);
		Circle c3 = c1;
		Circle c4 = new Circle(10,0,0,Color.RED);
		Circle c5 = new Circle(10,-50,50,Color.BLACK);
		
		// ___________________________________________________________
		// Compare c1 to c3 testing for equality
		// use ==, .equals, and compareTo
		
		// Print your results using a similar format shown here
		System.out.println(c1+" == "+c2+" is "+(c1==c2));
		
		// Compare c1 to c4 testing for equality
		// use ==, .equals, and compareTo
		
		// _______________________________________________________
		// Print the value of comparing c1 to c2
		// Print the value of comparing c2 to c1
		// Print c1 and c2 in order (using an if-statement with compareTo)
		System.out.println("\nORDER Based on radius - using compareTo.");
		
		// _______________________________________________________
		// Print c1, c2 in order based on x-position (from min to max)
		System.out.println("\nORDER Based on left to right - using compareTo.");
		
		// _______________________________________________________
		// Print c1, c2 in order based on y-position (from max to min)
		System.out.println("\nORDER Based on top to bottom - using compareTo.");
		
		// _______________________________________________________
		// Print the value of comparing c1 to c2
		// Print c1, c2 in order based on color (using an if-statement)
		System.out.println("\nORDER Based on color - using compareTo.");
		
		// _______________________________________________________
		// Print c1, c5 in order based on y-position (from max to min) 
		//    with x (from min to max) as tie-breaker
		System.out.println("\nORDER Based on top to bottom with tie-breaker.");
	
	
	} // end main()

} // end class Main