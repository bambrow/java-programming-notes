package data_structures.ch6;

/**
 * A collection of objects that are inserted and removed according to the
 * first-in, first-out principle. Although similar in purpose, this interface
 * differs from java.util.Queue.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public interface Queue<E> {
	
	/**
	 * Returns the number of elements in the queue.
	 * @return number of elements in the queue
	 */
	int size();
	
	/**
	 * Tests whether the queue is empty.
	 * @return true if the queue is empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Inserts an element into the queue.
	 * @param e		the element to be inserted
	 * @return the queue itself
	 */
	Queue<E> enqueue(E e);
	
	/**
	 * Returns, but does not remove, the first element of the queue.
	 * @return first element in the queue (or null if empty)
	 */
	E first();
	
	/**
	 * Removes and returns the first element from the queue.
	 * @return element removed (or null if empty)
	 */
	E dequeue();

}
