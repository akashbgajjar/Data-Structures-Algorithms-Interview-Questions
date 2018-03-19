package org.interviewquestions.examples;

/**
 * 
 * @author Akash Gajjar
 * 
 *         Given n non-negative integers in array representing an elevation map
 *         where the width of each bar is 1, compute how much water it is able
 *         to trap after raining. 
 *         For example: 
 *         Input: 
 *         3 
 *         2 0 2 
 *         Output: 
 *         2
 *         Structure is like below 
 *         | | 
 *         |_| 
 *         We can trap 2 units of water in the
 *         middle gap.
 * 
 *         Below is another example.
 * 
 *         Input: The first line of input contains an integer T denoting the
 *         number of test cases. The description of T test cases follows. Each
 *         test case contains an integer N followed by N numbers to be stored in
 *         array.
 * 
 *         Output: Print trap units of water in the middle gap.
 * 
 *         Constraints: 
 *         1<=T<=100 
 *         3<=N<=100 
 *         0<=Arr[i]<10
 * 
 *         Example: 
 *         Input: 
 *         2 
 *         4 
 *         7 4 0 9 
 *         3 
 *         6 9 9
 * 
 *         Output: 
 *         10 
 *         0
 * 
 *         https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
 * 
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int a[] = { 10, 1, 6, 5, 2, 0, 8, 3, 0, 1 };
		System.out.println(getUnitsOfWater(a));
	}

	private static int getUnitsOfWater(int arr[]) {
		
		int n = arr.length;
		int left[] = new int[n];

		int right[] = new int[n];

		int water = 0;

		left[0] = arr[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

		for (int i = 0; i < n; i++) {
			water += Math.min(left[i], right[i]) - arr[i];
		}

		return water;
	}
}
