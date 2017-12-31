package org.datastructures.example.heap;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class Example {
	
	public static void main(String[] args){
		
		Integer[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		
		Heap<Integer> heap = new Heap<Integer>(array);
		
		System.out.println("After Adding array to HEAP ===>");
		System.out.println(heap);
		
		heap.delete();
		
		System.out.println("After Deleting first element in HEAP ===>");
		System.out.println(heap);
		
		heap.sort();
		
		System.out.println("After Sorting ===>");
		System.out.println(heap);
		
	}

}
