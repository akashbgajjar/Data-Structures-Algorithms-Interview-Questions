package org.interviewquestions.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Akash Gajjar
 * 
 */
public class PrintPermutationOfArray {

	public static void main(String[] args){
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		PrintPermutationOfArray permutation = new PrintPermutationOfArray();
		System.out.println(permutation.permutationPrint(list));
	}
	
	/*
	 * This method will recursively remove each element from 1st index of an array and
	 * create LIST of arrays
	 * e.g. {1, 2, 3}
	 * 		{2, 3} -> 1 is removed
	 * 		{3} -> 2 is removed
	 * 		{} -> 3 is removed
	 * 
	 * Later it will add removed element from 1st index to smaller array
	 * on different indexes
	 * 
	 */
	public List<List<Integer>> permutationPrint(List<Integer> list) {

		if(list == null){
			throw new NullPointerException("List should not be null");
		}
		
		List<List<Integer>> returnValue = new ArrayList<List<Integer>>();
		
		if (list == null || list.size() == 0) {
			returnValue.add(new ArrayList<Integer>());
			return returnValue;
		}

		Integer firstElement = list.remove(0);
		
		List<List<Integer>> permutations = permutationPrint(list);
		for (List<Integer> smallerPermutated : permutations) {
			for (int index = 0; index <= smallerPermutated.size(); index++) {
				List<Integer> temp = new ArrayList<Integer>(smallerPermutated);
				temp.add(index, firstElement);
				returnValue.add(temp);
			}
		}
		return returnValue;
	}
}
