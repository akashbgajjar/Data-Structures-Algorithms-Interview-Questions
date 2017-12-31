package org.datastructures.example.linkedlist;

import java.util.Iterator;

/**
 * 
 * @author Akash Gajjar
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterator<T>{

	public Node<T> head;
	private Node<T> tail;
	private int count = 0;
	private Node<T> focusNode;
	
	public LinkedList(){}
	
	public void add(T element){
		Node<T> node = new Node<T>(element);
		
		if(count == 0){
			head = node;
			tail = head;
			focusNode = head;
		}else{
			tail.next = node;
			tail = node;
		}
		count++;
	}
	
	public int size(){
		return count;
	}
	
	public void reverse(){
		if(head == null || head.next == null)
			return;
		
		Node<T> second = head.next;
		Node<T> third = second.next;
		
		second.next = head;
		head.next = null;
		
		if(third == null){
			head = tail;
			tail = head.next;
			focusNode = head;
			return;
		}
		
		Node<T> currentNode = third;
		Node<T> previousNode = second;
		
		while(currentNode != null){
			Node<T> newNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = newNode;
		}
		
		tail = head;
		head = previousNode;
		focusNode = head;
	}
	
	public void recursiveReverse(Node<T> node){
		if(node == null || node.next == null){
			head = node;
			return;
		}
		
		recursiveReverse(node.next);
		if(node.next != null){
			Node<T> temp = node.next.next;
			node.next.next = node;
			node.next = temp;
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		focusNode = head;
		int _count = 0;
		while(focusNode != null){
			sb.append(focusNode.element);
			if(_count < (count - 1)){
				sb.append(",");
			}
			_count++;
			focusNode = focusNode.next;
		}
		sb.append("]");
		return sb.toString();
	}

	public boolean hasNext() {
		if(focusNode.next != null){
			return true;
		}
		return false;
	}

	public T next() {
		T _traverse = focusNode.element;
		if(focusNode.equals(head)){
			_traverse = focusNode.element;
		}
		focusNode = focusNode.next;
		return _traverse;
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
}
