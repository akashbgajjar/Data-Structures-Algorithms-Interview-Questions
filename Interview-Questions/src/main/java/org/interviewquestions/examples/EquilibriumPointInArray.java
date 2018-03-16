package org.interviewquestions.examples;

/**
 * 
 * @author Akash Gajjar
 * Given an array A your task is to tell at which position the equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of elements after it.

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
		int a[] = {7,1,8};
		System.out.println(getEquilibriumPoint(a));
	}
	
	private static Integer getEquilibriumPoint(int arr[]){
		
		if(arr != null && arr.length > 0){
			if(arr.length == 1){
				return arr[0];
			}
			
			int l_sum = 0;
			int r_sum = 0;
			for(int i=0,j=(arr.length - 1);i<j;){
				if(i == 0 && j == arr.length - 1){
					l_sum = arr[i];
					r_sum = arr[j];
				}
				if(l_sum > r_sum){
					r_sum += arr[--j];
				}else if(l_sum < r_sum){
					l_sum += arr[++i];
				}else{
					if(i < j){
						if(j-1 == i+1)
							return arr[i+1];
						else{
							r_sum += arr[--j];
							l_sum += arr[++i];
						}
					}else{
						return null;
					}
				}
			}
		}
		
		return null;
	}
	
}
