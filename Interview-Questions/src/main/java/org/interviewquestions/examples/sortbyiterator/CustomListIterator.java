package org.interviewquestions.examples.sortbyiterator;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class CustomListIterator<E> implements Iterator<E>{

	private boolean canAddIterators = true;
    private boolean balanceTreeIteratorFlag = false;
    private E f_element;
    private E s_element;
    private Iterator<E> left;
    private Iterator<E> right;
    private final Comparator<E> comparator;
	
	public CustomListIterator(Comparator<E> comparator){
		this.comparator = comparator;
	}
	
	public CustomListIterator(Iterator<E> left, Iterator<E> right, Comparator<E> comparator){
		this.left = left;
		this.right = right;
		this.comparator = comparator;
	}
	
	public void addIterator(Iterator<E> iterator){
        if (!canAddIterators)
            throw new ConcurrentModificationException();
        
        if (right == null){
            right = iterator;
            return;
        }else if (left == null){
            left = iterator;
            return;
        }
 
        if (!balanceTreeIteratorFlag){
            right = balanceTreeOfIterators(iterator, right);
        }else{
            left = balanceTreeOfIterators(iterator, left);
        }
        
        balanceTreeIteratorFlag = !balanceTreeIteratorFlag;
    }
	
	private Iterator<E> balanceTreeOfIterators(Iterator<E> iterator_1, Iterator<E> iterator_2){
        if (iterator_2 instanceof CustomListIterator){
            ((CustomListIterator<E>)iterator_2).addIterator(iterator_1);
        } else{
        	iterator_2 = new CustomListIterator<E>(iterator_1, iterator_2, comparator);
        }
        return iterator_2;
    }
	
	public boolean hasNext() {
		if (canAddIterators){
            if (left != null && left.hasNext()){
                f_element = left.next();
            }
            if (right != null && right.hasNext()){
                s_element = right.next();
            }
        }
		canAddIterators = false;
        return f_element != null || s_element != null;
	}

	public E next() {
		E next;
        if (canAddIterators){
            if (left.hasNext()){
                f_element = left.next();
            }
            if (right.hasNext()){
                s_element = right.next();
            }
        }
        
        canAddIterators = false;
        
        if (s_element == null && f_element == null){
            throw new NoSuchElementException();
        }
        
        if (f_element == null){
            next = s_element;
            s_element = right.hasNext() ? right.next() : null;
            return next;
        }
        
        if (s_element == null){
            next = f_element;
            f_element = left.hasNext() ? left.next() : null;
            return next;
        }
        
        return findNext();
	}

	public void remove() {
		/*
		 * Very complex to implement
		 */
	}

	private E findNext(){
        E next;
        if (comparator.compare(f_element, s_element) < 0){
            next = f_element;
            f_element = left.hasNext() ? left.next() : null;
            return next;
        }
        next = s_element;
        s_element = right.hasNext() ? right.next() : null;
        return next;
    }
	
}
