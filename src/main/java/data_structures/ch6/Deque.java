package data_structures.ch6;

/**
 * Interface for a double-ended queue: a collection of elements that can be
 * inserted and removed at both ends; this interface is a simplified version
 * of java.util.Deque.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public interface Deque<E> {

	/**
	 * Returns the number of elements in the deque.
	 * @return number of elements in the deque
	 */
	int size();
	
	/**
	 * Tests whether the deque is empty.
	 * @return true if the deque is empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Returns, but does not remove, the first element of the deque.
	 * @return first element in the deque (or null if empty)
	 */
	E first();
	
	/**
	 * Returns, but does not remove, the last element of the deque.
	 * @return last element in the deque (or null if empty)
	 */
	E last();
	
	/**
	 * Inserts an element as the first element into the deque.
	 * @param e		the element to be inserted
	 * @return the deque itself
	 */
	Deque<E> addFirst(E e);
	
	/**
	 * Inserts an element as the last element into the deque.
	 * @param e		the element to be inserted
	 * @return the deque itself
	 */
	Deque<E> addLast(E e);
	
	/**
	 * Removes and returns the first element from the deque.
	 * @return element removed (or null if empty)
	 */
	E removeFirst();
	
	/**
	 * Removes and returns the last element from the deque.
	 * @return element removed (or null if empty)
	 */
	E removeLast();
	
}
