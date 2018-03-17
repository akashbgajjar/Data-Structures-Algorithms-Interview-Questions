package org.interviewquestions.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Akash Gajjar
 * 
 *         Write a program to print all the LEADERS in the array. An element is
 *         leader if it is greater than all the elements to its right side. The
 *         rightmost element is always a leader.
 * 
 *         Input: The first line of input contains an integer T denoting the
 *         number of test cases. The description of T test cases follows. The
 *         first line of each test case contains a single integer N denoting the
 *         size of array. The second line contains N space-separated integers
 *         A1, A2, ..., AN denoting the elements of the array.
 * 
 *         Output: Print all the leaders.
 * 
 *         Constraints: 1 <= T <= 100 1 <= N <= 100 0 <= A[i]<=100
 * 
 *         Example: Input: 2 6 16 17 4 3 5 2 5 1 2 3 4 0 Output: 17 5 2 4 0
 * 
 */
public class LeadersInAnArray {

	public static void main(String[] args) {
		int[] a = { 16, 18, 11, 10, 9, 20, 15, 17, 11, 10, 9, 8, 7 };
		System.out.println(getLeadersInAnArray(a));
	}

	private static List<Integer> getLeadersInAnArray(int arr[]) {

		if (arr != null && arr.length > 0) {
			List<Integer> queue = new ArrayList<Integer>();
			int tracker = 0;
			for (int i = 0; i < arr.length; i++) {
				if (queue.isEmpty() && i == 0) {
					queue.add(arr[i]);
					tracker = i;
				} else {

					for (int j = 0; j < queue.size(); j++) {
						if (queue.get(j) < arr[i]) {
							if (j == 0) {
								queue = new ArrayList<Integer>();
							} else {
								queue.remove(j);
							}
							queue.add(arr[i]);
							tracker = i;
						}
					}

					if (i - tracker == 1) {
						queue.add(arr[i]);
					} else {
						queue.remove(queue.size() - 1);
						queue.add(arr[i]);
					}
				}
			}

			return queue;
		}
		return null;
	}

}
