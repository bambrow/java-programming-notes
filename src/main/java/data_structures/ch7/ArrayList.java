package data_structures.ch7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Iterable<E> {

	public static final int CAPACITY = 16; // default array capacity
	private E[] data;
	private int size = 0;
	
	public ArrayList() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}
	
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	
	@Override
	public List<E> add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size+1);
		if (size == data.length) {
			resize(2 * data.length);
		}
		for (int k = size-1; k >= i; k--) {
			data[k+1] = data[k];
		}
		data[i] = e;
		size++;
		return this;
	}
	
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size-1; k++) {
			data[k] = data[k+1];
		}
		data[size-1] = null;
		size--;
		if (size < 4 * data.length) {
			resize(data.length / 2);
		}
		return temp;
	}
	
	/**
	 * Checks whether the given index is in the range [0, n-1].
	 * @param i		the index to be checked
	 * @param n		the upper bound of index
	 * @throws IndexOutOfBoundsException
	 */
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + i);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}
		data = temp; // start using the new array
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "no element";
		}
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < size; i++) {
			answer.append(data[i].toString()).append(" ");
		}
		return answer.toString();
	}
	
	// ---------- nested ArrayIterator class ----------
	/**
	 * A (nonstatic) inner class. Note well that each instance contains an
	 * implicit reference to the containing list, allowing it to access
	 * the list's members.
	 */
	private class ArrayIterator implements Iterator<E> {
		private int j = 0; // index of the next element to report
		private boolean removable = false; // whether remove can be called at this time
		/** Tests whether the iterator has a next object. */
		@Override
		public boolean hasNext() {
			return j < size;
		}
		/** Returns the next object in the iterator. */
		@Override
		public E next() throws NoSuchElementException {
			if (j == size) {
				throw new NoSuchElementException("No next element");
			}
			removable = true; // this element can be subsequently removed
			return data[j++]; // post-increment j, so it is ready for future call to next
		}
		/** Removes the element returned by most recent call to next. */
		@Override
		public void remove() throws IllegalStateException {
			if (!removable) {
				throw new IllegalStateException("Nothing to remove");
			}
			ArrayList.this.remove(j-1); // that was the last one returned
			j--; // next element has shifted one cell to the left
			removable = false; // do not allow removing again until next is called
		}
	}
	
	/** Returns an iterator of the elements stored in the list. */
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}
	
}
