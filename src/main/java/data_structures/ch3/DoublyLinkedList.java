package data_structures.ch3;

import data_structures.ch6.Deque;

public class DoublyLinkedList<E> implements Deque<E> {
	
	// ---------- nested node class ----------
	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		public E getElement() {
			return this.element;
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
	private Node<E> header;		// header sentinel
	private Node<E> trailer;	// trailer sentinel
	private int size = 0;
	
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
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
		return header.getNext().getElement();
	}
	
	// returns the last element
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return trailer.getPrev().getElement();
	}
	
	// private update methods
	// add element between the given nodes
	private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(element, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	// removes the given node and returns the corresponding element
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
	
	// public update methods
	// adds element to the front
	public Deque<E> addFirst(E element) {
		addBetween(element, header, header.getNext());
		return this;
	}
	
	// adds element to the end
	public Deque<E> addLast(E element) {
		addBetween(element, trailer.getPrev(), trailer);
		return this;
	}
	
	// removes and returns the first element
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		return remove(header.getNext());
	}
	
	// removes and returns the last element
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		return remove(trailer.getPrev());
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "no element";
		}
		StringBuilder answer = new StringBuilder();
		for (Node<E> node = header.getNext(); node != trailer; node = node.getNext()) {
			answer.append(node.getElement().toString()).append(" ");
		}
		return answer.toString();
	}

}
