package org.interviewquestions.examples;

/**
 * 
 * @author Akash Gajjar
 * Given an array A your task is to tell at which position the equilibrium first occurs in the array. 
 * Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of elements after it.

 * Input:
 * The first line of input contains an integer T denoting the no of test cases then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.
	
 * Output:
 * For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.
	
 * Constraints:
 * 1<=T<=100
 * 1<=N<=100
 *
 */

public class EquilibriumPointInArray {

	public static void main(String[] args){
		int a[] = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(getEquilibriumPoint(a));
	}
	
	private static Integer getEquilibriumPoint(int arr[]){
		
		if(arr != null && arr.length > 0){
			if(arr.length == 1){
				return arr[0];
			}
			
			int sum = 0;
			int left_sum = 0;
			
			for(int i=0; i<arr.length; i++){
				sum += arr[i];
			}
			
			for(int i=0; i<arr.length; i++){
				
				sum -= arr[i];
				
				if(left_sum == sum){
					return arr[i];
				}
				
				left_sum += arr[i];
			}
		}
		
		return -1;
	}
	
}
