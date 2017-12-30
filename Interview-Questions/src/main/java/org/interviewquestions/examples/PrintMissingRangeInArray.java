package org.interviewquestions.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Akash Gajjar
 * 
 * Write a program that will print missing range
 * 
 * Example1
 * input: [4,56,78,91]
 * output: [{0-3},{5-55},{57-77},{79-90},{92-100}]
 * 
 * Example2
 * input: [0,10,50,99]
 * output: [{1-9},{11-49},{51-98},{100}]
 * 
 * NOTE: Input array will always be sorted.
 *
 */
public class PrintMissingRangeInArray {

	public static void main(String[] args){
		
		int a[] = {1,44,78,99};
		
		int lower = 0;
		int upper = 99;
		
		PrintMissingRangeInArray missingRange = new PrintMissingRangeInArray();
		System.out.println(missingRange.findMissingRange(a, lower, upper));
		
	}

	private List<String> findMissingRange(int[] array, int lb, int ub){
		if(array == null || array.length == 0){
			return Collections.emptyList();
		}
		
		List<String> range = new ArrayList<String>();
		
		for(int i=0,j=0; i<array.length; i++,j=i-1){
			if(array[i] > lb && i == 0){
				range.add(createPattern(lb, array[i] - 1));
			}
			if(((array[j] < array[i]) || (array[i] < ub && i == array.length - 1)) && array[i] - array[j] > 1){
				range.add(createPattern(array[j] + 1, array[i] - 1));
			}
			if(array[i] < ub && i == array.length - 1){
				range.add(createPattern(array[i] + 1, ub));
			}
		}
		
		return range;
	}
	
	private String createPattern(int first, int second){
		if(second - first == 0){
			return String.valueOf(first);
		}
		return String.valueOf(first + "-" + second);
	}
}
