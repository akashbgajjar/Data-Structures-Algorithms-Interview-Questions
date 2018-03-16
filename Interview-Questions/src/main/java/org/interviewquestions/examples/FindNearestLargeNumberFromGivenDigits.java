package org.interviewquestions.examples;

/**
 * 
 * @author Akash Gajjar
 * 
 * I/P: 4394
 * O/P: 4439
 * 
 * I/P: 43942
 * O/P: 44239
 * 
 * Approach:
 * 
 * 1. Convert into array. [4, 3, 9, 4, 2]
 * 2. Use two INDEXES and search for two numbers where left side is smaller than right side
 * 	  In this example 3 and 4 are such numbers. Say index a and b respectively.
 * 3. Swipe the numbers at index a and b [4, 4, 9, 3, 2]
 * 4. Sort all the numbers from index of a + 1.
 * 5. Final Output: [4, 4, 2, 3, 9]
 * 6. Convert array into number.
 *
 */
public class FindNearestLargeNumberFromGivenDigits {

	
	public static void main(String[] args){
		
	}
	
}
