package org.interviewquestions.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Akash Gajjar
 *
 *	Given an array of n positive integers. 
 *	Write a program to find the sum of maximum sum subsequence of the given array such 
 *	that the integers in the subsequence are sorted in increasing order.
 *
 *	Input:

	The first line of input contains an integer T denoting the number of test cases.
	The first line of each test case is N,N is the size of array.
	The second line of each test case contains N input A[].
	
	Output:

	Print the sum of maximum sum sequence of the given array.
	
	Constraints:

	1 <= T <= 100
	1 <= N <= 100
	1 <= A[] <= 1000
	
	Example:

	Input:
	1 101 2 3 100 4 5
	
	Output:
	106
	
	Explanation:
	For input:
	7
	1 101 2 3 100 4 5
	All the increasing subsequences : (1,101); (1,2,3,100); (1,2,3,4,5), out of this (1,2,3,100) has maximum sum,i.e., 106. Hence the output is stated as 106.

 */

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args){
		int a[] = {1, 101, 2, 3, 100, 4, 5, 200, 9};
		List<Integer> list = new ArrayList<Integer>(a.length);
		for(int i : a){
			list.add(i);
		}
		System.out.println(getMaximumSumIncreasingSubsequence(list));
	}
	
	private static Integer getMaximumSumIncreasingSubsequence(List<Integer> arr){
		
		if(arr != null && arr.size() > 0){
			
			List<Integer> list = new ArrayList<Integer>();
			int i = 0;
			int max_sum = arr.get(i);
			while(i < arr.size()){
				if(i + 1 < arr.size() && arr.get(i) < arr.get(i + 1)){
					list.add(arr.get(i));
					i++;
				}else{
					list.add(arr.get(i));
					arr.remove(i);
					if(i < arr.size()){
						i = 0;
					}
					int sum = 0;
					for(Integer a : list){
						sum += a;
					}
					if(max_sum < sum){
						max_sum = sum;
					}
					list = new ArrayList<Integer>();
				}
			}
			return max_sum;
		}
		
		return null;
	}
}
