package org.datastructures.example.linkedlist;

/**
 * 
 * @author Akash Gajjar
 *
 * @param <T>
 */
public class Node<T> {

	T element;
	Node<T> next;
	
	public Node(T element){
		this.element = element;
	}
	
	public String toString(){
		return this.element.toString();
	}
}