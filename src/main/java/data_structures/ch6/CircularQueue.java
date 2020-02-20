package data_structures.ch6;

public interface CircularQueue<E> extends Queue<E> {
	
	/**
	 * Inserts an element into the queue.
	 * @param e		the element to be inserted
	 * @return the queue itself
	 */
	CircularQueue<E> enqueue(E e);

	/**
	 * Rotates the front element of the queue to the back of the queue.
	 * This does nothing if the queue is empty.
	 */
	CircularQueue<E> rotate();
	
}
