package data_structures.ch7;

import java.util.Iterator;

/**
 * A simplified version of the java.util.List interface.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public interface List<E> {

	/**
	 * Returns the number of elements in the list.
	 * @return the number of elements in the list
	 */
	int size();
	
	/**
	 * Returns whether the list is empty.
	 * @return true if the list is empty; false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Returns, but does not remove, the element at index i.
	 * @param i		the index of the element
	 * @return the element at index i
	 * @throws IndexOutOfBoundsException
	 */
	E get(int i) throws IndexOutOfBoundsException;
	
	/**
	 * Replaces the element at index i with e, and returns the replaced element.
	 * @param i		the index of the element to be replaced
	 * @param e		the new element
	 * @return the replaced element
	 * @throws IndexOutOfBoundsException
	 */
	E set(int i, E e) throws IndexOutOfBoundsException;
	
	/**
	 * Inserts element e to be at index i, shifting all subsequent elements later.
	 * @param i		the index of the new element
	 * @param e		the element to be inserted
	 * @return the list itself
	 * @throws IndexOutOfBoundsException
	 */
	List<E> add(int i, E e) throws IndexOutOfBoundsException;
	
	/**
	 * Removes and returns the element at index i, shifting all subsequent element earlier.
	 * @param i		the index of the element to be removed
	 * @return the removed element
	 * @throws IndexOutOfBoundsException
	 */
	E remove(int i) throws IndexOutOfBoundsException;
	
	/**
	 * Returns an iterator of the elements stored in the list.
	 * @return the iterator of the elements
	 */
	Iterator<E> iterator();
	
}
