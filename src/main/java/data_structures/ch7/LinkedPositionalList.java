package data_structures.ch7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a positional list stored as a doubly linked list.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E> {

	// ---------- nested node class ----------
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		public E getElement() throws IllegalStateException {
			if (next == null) {
				throw new IllegalStateException("Position is no longer valid");
			}
			return this.element;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public Node<E> getPrev() {
			return this.prev;
		}
		public Node<E> getNext() {
			return this.next;
		}
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	// instance variables
	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int size = 0;
	
	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	// private utilities
	/**
	 * Validates the position and returns it as a node.
	 * @param p		the position that needs validation
	 * @return the node corresponding to the position
	 * @throws IllegalArgumentException
	 */
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Invalid p");
		}
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getNext() == null) {
			throw new IllegalArgumentException("p is no longer in the list");
		}
		return node;
	}
	
	/**
	 * Returns the given node as a position, or null if it is a sentinel.
	 * @param node		the proposed node
	 * @return the position corresponding to the node
	 */
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer) {
			return null; // do not expose user to the sentinels
		}
		return (Position<E>) node;
	}
	
	/**
	 * Adds element e to the linked list between the given nodes.
	 * @param e			the element to be added
	 * @param pred		predecessor
	 * @param succ		successor
	 * @return the position of the new element
	 */
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return (Position<E>) newest;
	}
	
	// public accessor methods
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public Position<E> first() {
		return position(header.getNext());
	}
	
	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}
	
	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}
	
	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	// public update methods
	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}
	
	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}
	
	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	
	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}
	
	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	
	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null); // help with garbage collection
		node.setNext(null); // and convention for defunct node
		node.setPrev(null);
		return answer;
	}
	
	// ---------- nested PositionIterator class ----------
	private class PositionIterator implements Iterator<Position<E>> {
		private Position<E> cursor = first(); // position of the next element to report
		private Position<E> recent = null; // position of last reported element
		/** Tests whether the iterator has a next object. */
		@Override
		public boolean hasNext() {
			return cursor != null;
		}
		/** Returns the next position in the iterator. */
		@Override
		public Position<E> next() throws NoSuchElementException {
			if (cursor == null) {
				throw new NoSuchElementException("Nothing left");
			}
			recent = cursor; // element at this position might later be removed
			cursor = after(cursor);
			return recent;
		}
		/** Removes the element returned by most recent call to next. */
		@Override
		public void remove() throws IllegalStateException {
			if (recent == null) {
				throw new IllegalStateException("Nothing to remove");
			}
			LinkedPositionalList.this.remove(recent); // remove from outer list
			recent = null; // do not allow removing again until next is called
		}
	}
	
	// ---------- nested PositionIterable class ----------
	private class PositionIterable implements Iterable<Position<E>> {
		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator(); // returns an iterator of positions
		}
	}
	
	/** Returns an iterable representation of the list's positions. */
	public Iterable<Position<E>> positions() {
		return new PositionIterable(); // returns an iterable for compatibility of for-each loops
	}
	
	// ---------- nested ElementIterator class ----------
	/** This class adapts the iteration produced by positions() and return elements. */
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> positionIterator = new PositionIterator();
		@Override
		public boolean hasNext() {
			return positionIterator.hasNext();
		}
		@Override
		public E next() {
			return positionIterator.next().getElement();
		}
		@Override
		public void remove() {
			positionIterator.remove();
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(); // returns an iterator of elements
	}

}
