package data_structures.ch7;

public interface Position<E> {

	/**
	 * Returns the element stored at this position.
	 * @return the stored element
	 * @throws IllegalStateException
	 */
	E getElement() throws IllegalStateException;
	
}
