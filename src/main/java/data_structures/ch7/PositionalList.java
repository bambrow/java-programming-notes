package data_structures.ch7;

import java.util.Iterator;

/**
 * An interface for positional lists.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public interface PositionalList<E> {

	/**
	 * Returns the number of elements in the list.
	 * @return the number of elements in the list.
	 */
	int size();
	
	/**
	 * Tests whether the list is empty.
	 * @return true if the list is empty; false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Returns the first Position in the list, or null if empty.
	 * @return the first Position or null if empty
	 */
	Position<E> first();
	
	/**
	 * Returns the last Position in the list, or null if empty.
	 * @return the last Position or null if empty
	 */
	Position<E> last();
	
	/**
	 * Returns the Position immediately before Position p, or null if p is first.
	 * @param p		the current Position
	 * @return the Position before p or null of p is first
	 * @throws IllegalArgumentException
	 */
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Returns the Position immediately after Position p, or null if p is last.
	 * @param p		the current Position
	 * @return the Position after p or null if p is last
	 * @throws IllegalArgumentException
	 */
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Inserts element e at the front of the list and returns its new Position.
	 * @param e		the element to be inserted
	 * @return the new Position of the element
	 */
	Position<E> addFirst(E e);
	
	/**
	 * Inserts element e at the back of the list and returns its new Position.
	 * @param e		the element to be inserted
	 * @return the new Position of the element
	 */
	Position<E> addLast(E e);
	
	/**
	 * Inserts element e immediately before Position p and returns its new Position.
	 * @param p		the proposed position
	 * @param e		the element to be inserted
	 * @return the new Position of the element
	 * @throws IllegalArgumentException
	 */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Inserts element e immediately after Position p and returns its new Position.
	 * @param p		the proposed position
	 * @param e		the element to be inserted
	 * @return the new Position of the element
	 * @throws IllegalArgumentException
	 */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Replaces the element stored at Position p and returns the replaced element.
	 * @param p		the proposed position
	 * @param e		the new element
	 * @return the replaced element
	 * @throws IllegalArgumentException
	 */
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Removes the element stored at Position p and returns it.
	 * @param p		the proposed position
	 * @return the removed element
	 * @throws IllegalArgumentException
	 */
	E remove(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Returns an iterator of the elements stored in the list.
	 * @return the iterator of the elements
	 */
	Iterator<E> iterator();
	
	/**
	 * Returns an iterable representation of the list's positions.
	 * @return the iterable representation
	 */
	Iterable<Position<E>> positions();
	
}
