package org.interviewquestions.examples.sortbyiterator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class Example {

	public static void main(String[] args){
		List<List<Integer>> mList = new ArrayList<List<Integer>>();
		
		List<Integer> list_1 = new ArrayList<Integer>();
		list_1.add(1);
		list_1.add(4);
		list_1.add(5);
		list_1.add(8);
		list_1.add(9);
		
		List<Integer> list_2 = new ArrayList<Integer>();
		list_2.add(3);
		list_2.add(4);
		list_2.add(4);
		list_2.add(6);
		
		List<Integer> list_3 = new ArrayList<Integer>();
		list_3.add(0);
		list_3.add(2);
		list_3.add(8);
		
		System.out.println(list_1);
		System.out.println(list_2);
		System.out.println(list_3);
		
		mList.add(list_1);
		mList.add(list_2);
		mList.add(list_3);
		
		Comparator<Integer> comparator = new Comparator<Integer>(){

			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
			
		};
		
		CustomListIterator<Integer> customListIterator = new CustomListIterator<Integer>(comparator);
		for(List<Integer> list : mList){
			customListIterator.addIterator(list.listIterator());
		}
		
		while(customListIterator.hasNext()){
			System.out.println(customListIterator.next());
		}
	}
	
}
