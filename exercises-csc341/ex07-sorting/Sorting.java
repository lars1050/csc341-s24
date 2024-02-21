public class Sorting {

	public static void main(String[] args) {
	
		// confirm user specified algorithm to test - otherwise bail.
    	if (args.length==0) {
    		System.out.println("Specify algorithm(s) (e.g. >java Sorting v1)");
    		return;
    	}
    	
    	int[] array = {5, 12, 3, 80, 72, 4, 6, 1, 9, 36};
    	System.out.println("Original: {5, 12, 3, 80, 72, 4, 6, 1, 9, 36}");
    	
    	if (args[0].equals("v1")) {
    		sortV1(array);
    	} else if (args[0].equals("v2")) {
    		sortV2(array);
    	} else if (args[0].equals("v3")) {
    		sortV3(array);
    	} else {
    		System.out.println("do not recognize argument");
    	}
    	

    	System.out.print("Sorted: {");
    	for (int x : array) {
    		System.out.print(x+", ");
    	}
    	System.out.println("}");
	}
	
	public static void sortV1(int[] array) {
		System.out.println("Sorting with version 1");
	
	}
	
	public static void sortV2(int[] array) {
		System.out.println("Sorting with version 2");
	
	}
	
	public static void sortV3(int[] array) {
		System.out.println("Sorting with version 3");
	
	}
}