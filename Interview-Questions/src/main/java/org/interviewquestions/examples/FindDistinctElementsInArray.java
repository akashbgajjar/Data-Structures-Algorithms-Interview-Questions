package org.interviewquestions.examples;

/**
 * 
 * @author Akash Gajjar
 * 
 * There are two ways to solve following problem
 * 
 * 1. Run two inside for loops
 * TimeComplexity: O(n2)
 * SpaceComplexity: O(n)
 * 
 * 2. Sort the array and iterate once
 * TimeComplexity: O(log n) + O(n) which is lesser then #1
 * SpaceComplexity: O(n) + O(n)
 *
 */
public class FindDistinctElementsInArray {

	public static void main(String[] args){
		
		int[] array = {1, 1, 4, 1, 5, 4, 7, 8, 9, 2, 4, 0, 11};
		
		int[] temp = new int[array.length];
		
		mergeSort(array, temp, 0, array.length);
		
		int[] distinctArray = findDistinctElements(array);
		
		for(int i=0; i<distinctArray.length; i++){
			System.out.print(distinctArray[i] + " ");
		}
	}
	
	private static int[] findDistinctElements(int[] array){
		
		if(array.length < 2)
			return array;
		
		int j = 0;
		int i = 1;
		
		while(i < array.length){
			if(array[i] == array[j]){
				i++;
			}else{
				j++;
				array[j] = array[i];
				i++;
			}
		}
		
		int[] distinctArray = new int[j + 1];
		
		System.arraycopy(array, 0, distinctArray, 0, j + 1);
		
		return distinctArray;
	}
	
	private static void mergeSort(int[] array, int[] temp, int start, int end){
		
		if((end - start) < 2)
			return;
		
		int mid = (start + end)/2;
		
		mergeSort(array, temp, start, mid);
		mergeSort(array, temp, mid, end);
		
		for(int i=start, p=start, q=mid; i<end; i++){
			if(p<mid && (q>=end || array[p] <= array[q])){
				temp[i] = array[p++];
			}else{
				temp[i] = array[q++];
			}
		}
		
		System.arraycopy(temp, start, array, start, (end - start));
	}
}
