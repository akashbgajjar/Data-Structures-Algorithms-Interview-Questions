package org.interviewquestions.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Akash Gajjar
 * 
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

	Input:
	The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
	The first line of each test case contains a single integer 'N' denoting the size of array and the size of subarray 'k'.
	The second line contains 'N' space-separated integers A1, A2, ..., AN denoting the elements of the array.
	
	Output:
	Print the maximum for every subarray of size k.
	
	Constraints:
	1 <= T <= 200
	1 <= N <= 100
	1 <= k <= N
	0 <= A[i] < 1000
	
	Example:
	
	Input:
	2
	9 3
	1 2 3 1 4 5 2 3 6
	10 4
	8 5 10 7 9 4 15 12 90 13
	
	Output:
	3 3 4 5 5 5 6
	10 10 10 15 15 90 90
 *
 */

public class MaximumOfAllSubarraysOfSizeK {

	public static void main(String[] args){
		
		int a[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int k = 3;
		
		System.out.println(getMaximumOfAllSubarraysOfSizeK(a, k));
	}
	
	private static List<Integer> getMaximumOfAllSubarraysOfSizeK(int a[], int k){
		
		if(a != null && a.length > 0){
			List<Integer> maxElements = new ArrayList<Integer>();
			int max = a[0];
			int start_over = 0;
			for(int i=0; i<a.length; i++){
				if(max < a[i]){
					max = a[i];
				}
				if((i - start_over) == (k - 1)){
					maxElements.add(max);
					start_over = (i + 1) - (k - 1);
					i = start_over - 1;
					max = a[start_over < a.length ? start_over : i];
				}
			}
			return maxElements;
		}
		return null;
	}
}
