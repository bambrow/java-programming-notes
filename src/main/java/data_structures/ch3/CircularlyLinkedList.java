package data_structures.ch3;

public class CircularlyLinkedList<E> {

	// ---------- nested node class ----------
	private static class Node<E> {
		private E element;
		private Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		public E getElement() {
			return this.element;
		}
		public Node<E> getNext() {
			return this.next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	// instance variables
	private Node<E> tail = null;
	private int size = 0;
	
	public CircularlyLinkedList() {

	}
	
	// access methods
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	// returns the first element
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return tail.getNext().getElement();
	}
	
	// returns the last element
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	// update methods
	// rotate the first element to the back
	public CircularlyLinkedList<E> rotate() {
		if (tail != null) {
			tail = tail.getNext();
		}
		return this;
	}
	
	// adds element to the front
	public CircularlyLinkedList<E> addFirst(E element) {
		if (isEmpty()) {
			tail = new Node<>(element, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<>(element, tail.getNext());
			tail.setNext(newest);
		}
		size++;
		return this;
	}
	
	// adds element to the end
	public CircularlyLinkedList<E> addLast(E element) {
		addFirst(element);
		tail = tail.getNext();
		return this;
	}
	
	// removes and returns the first element
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		Node<E> head = tail.getNext();
		if (head == tail) {
			tail = null;
		} else {
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "no element";
		}
		StringBuilder answer = new StringBuilder();
		int index = 0;
		for (Node<E> node = tail.getNext(); index < size(); node = node.getNext(), index++) {
			answer.append(node.getElement().toString()).append(" ");
		}
		return answer.toString();
	}

}
