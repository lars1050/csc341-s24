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
	
3. In Main, complete the first set of comparisons, comparing c1 to either  


