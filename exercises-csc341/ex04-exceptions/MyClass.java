public class MyClass {


	public void funA() {
	
		/*
		In this function, make the following work ...
		- call funC
		
		- call funB: 
			* Catch the SPECIFIC thrown exception from funB. 
			
		- call funB another way (after you have the above working)
			* Do not catch it, just call the function.
		*/	
	}
	
	public void funB() {
	
		/* 
		In this function, throw your new exception, but do not catch it.
		In the message, indicate it was thrown from funB.
		*/
	
	}
	
	public void funC() {
	
		/* 
		In this function, both throw AND catch your new exception.
		 
		In the catch, BE SURE TO CATCH THE SPECIFIC EXCEPTION!!
		- in a print statement, indicate that the exception happened in funC.
		- call e.printStackTrace();
		- Do not return. Catch it and continue.
		*/
		
		System.out.println("I made it to the end of funC.");
	}
}