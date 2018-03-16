package org.interviewquestions.examples;

/**
 * 
 * @author Akash Gajjar
 * 
 * 
 * Given an array, reverse every sub-array formed by consecutive k elements.

	Input:
	
	The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array.The second line of each test case contains N space separated integers denoting array elements.The third line of each test case consists of an integer K.
	
	Output:
	Corresponding to each test case, in a new line, print the modified array.
	
	Constraints:
	
	1 <= T <= 100
	1 <= N <= 500
	1 <= A[i] <= 500
	
	Example:
	
	Input
	1
	5
	1 2 3 4 5
	3
	
	Output
	3 2 1 5 4
 *
 */

public class ReverseArrayInGroups {

	public static void main(String[] args){
		int a[] = new int[500];
		for(int i=1; i<=500; i++){
			a[i-1] = i; 
		}
		int k = 320;
		long start = System.currentTimeMillis();
		int b[] = getReverseArrayInGroups(a, k);
		System.out.println(System.currentTimeMillis() - start);
		
		for(int i=0; i<b.length; i++){
			System.out.print(b[i]);
			if(i < b.length - 1){
				System.out.print(" ");
			}
		}
		
	}
	
	private static int[] getReverseArrayInGroups(int arr[], int k){
		
		if(arr != null && arr.length > 0){
			
			Integer position = getPositionOfKthElement(arr, 0, arr.length - 1, k);
			
			if(position != null){
				for(int i=0,j=position; i<position+1 && j>0 && i<j; i++,j--){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				for(int i=position+1,j=arr.length-1; i<arr.length && j>position && i<j; i++,j--){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		
		return arr;
	}
	
	private static Integer getPositionOfKthElement(int arr[], int s_index, int e_index, int k){
		int find = ((e_index + s_index) + 1)/2;
		
		if(find < arr.length && find >= 0){
			if(arr[find] == k){
				return find;
			}else if(arr[find] < k){
				s_index = find + 1;
				return getPositionOfKthElement(arr, s_index, e_index, k);
			}else if(arr[find] > k){
				e_index = find - 1;
				return getPositionOfKthElement(arr, s_index, e_index, k);
			}
		}
		
		return null;
	}
}
