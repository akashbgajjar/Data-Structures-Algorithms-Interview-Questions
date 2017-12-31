package org.datastructures.example.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Akash Gajjar
 *
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {
	
	private final List<T> array;

	public Heap(){
		this.array = new ArrayList<T>();
	}
	
	public Heap(int capacity){
		this.array = new ArrayList<T>(capacity);
	}
	
	public Heap(T[] _array){
		this(_array.length);
		convertToHeap(_array);
	}
	
	public void add(T element){
		this.array.add(element);
		shiftUp();
	}
	
	public int size(){
		return this.array.size();
	}
	
	public void delete(){
		shiftDown();
	}
	
	public void sort(){
		for(int i=size(); i>0; i--){
			swap(i - 1, 0);
			_maxHeapify(0, i - 1);
		}
	}
	
	public void convertToHeap(T[] array){
		
		if(array == null)
			throw new NullPointerException();
		
		for(int i=0; i<array.length; i++)
			this.add(array[i]);
		
		if(!this.array.isEmpty())
			for(int i=size()/2; i>=0; i--)
				_maxHeapify(i, size());
	}
	
	private void shiftUp(){
		int k = this.array.size() - 1;
		while(k > 0){
			int p = (k - 1)/2;
			if(this.array.get(k).compareTo(this.array.get(p)) > 0){
				swap(k, p);
				k = p;
			}else{
				break;
			}
		}
	}
	
	private void shiftDown(){
		if(!this.array.isEmpty()){
			this.array.set(0, this.array.get(size() - 1));
			this.array.remove(size() - 1);
			_maxHeapify(0, size());
		}
	}
	
	private void _maxHeapify(int i, int size){
		
		int p = ((2*i) + 1);
		int q = ((2*i) + 2);
		
		if(p < size && this.array.get(p).compareTo(this.array.get(i)) > 0){
			swap(i, p);
			_maxHeapify(p, size);
		}
		
		if(q < size && this.array.get(q).compareTo(this.array.get(i)) > 0){
			swap(i, q);
			_maxHeapify(q, size);
		}
		
	}
	
	private void swap(int i, int j){
		T item = this.array.get(i);
		T parent = this.array.get(j);
		this.array.set(i, parent);
		this.array.set(j, item);
	}
	
	public String toString(){
		return this.array.toString();
	}
}
