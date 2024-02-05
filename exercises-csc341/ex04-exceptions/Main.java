public class Main {

	public static void main(String[] args) {
	
		MyClass mc = new MyClass();
		
		// make this work so that everything exits "gracefully"

		System.out.println("\nCalling funC from main");
		mc.funC();

		System.out.println("\nCalling funB from main");
		mc.funB();

		System.out.println("\nCalling funA from main");
		mc.funA();
	
	}
}

