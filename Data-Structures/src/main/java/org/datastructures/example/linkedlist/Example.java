package org.datastructures.example.linkedlist;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class Example {

	public static void main(String[] args){
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(1);
		
		list.add(7);
		list.add(9);
		list.add(2);
		list.add(5);
		list.add(3);
		
		//System.out.println(list.size());
		System.out.println(list);
		
		//list.reverse();
		list.recursiveReverse(list.head);
		
		System.out.println(list);
	}
}