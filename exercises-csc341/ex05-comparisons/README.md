### Exercise Comparing Class Objects

In this exercise, you will learn how to tell the compiler how to order elements. This is necessary for maintaining a sorted list, which is used in Binary Search.

You will compare Circle objects using `==`, `.equals`, `compareTo()`, and `compare()`.

1. Implement the .equals method for Circle. The method signature is below. Note that the parameter is of type **Object**.

```
@Override
public boolean equals(Object other)
```

2. Implement the .compareTo method for Circle. The method signature is below. This method is using the `Comparable` interface. See zyBooks Figure 4.1.2 for an example.

```
@Override
public int compareTo(Circle other)
```

In this first version, use the radius to order elements.
	
3. In Main, complete the first set of comparisons, comparing c1 to c3 and then to c4. Pay attention to the different results. Answer the question on the worksheet.

4. In Main, complete the print statements and comparisons in Main using your compareTo method. Answer the questions on the worksheet.

5. Change the compareTo method to compare the position along the x-axis ordering from minimum to maximum. Complete the print statements and comparisons in Main. Answer the question on the worksheet.

6. Change the compareTo method to compare the position along the y-axis ordering from **maximum** to **minimum**. Complete the print statements and comparisons in Main. Answer the question on the worksheet.

7. Change the compareTo method to compare based on color. Complete the print statements and comparisons in Main. Answer the question on the worksheet.

8. Change the compareTo method to compare the position along the y-axis ordering from **maximum** to **minimum** AND using the x position as a tie-breaker. Complete the print statements and comparisons in Main. Answer the question on the worksheet.
 


