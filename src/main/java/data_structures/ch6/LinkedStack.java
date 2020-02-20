package data_structures.ch6;

import data_structures.ch3.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public LinkedStack() {

	}
	
	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override
	public Stack<E> push(E e) {
		list.addFirst(e);
		return this;
	}
	
	@Override
	public E top() {
		return list.first();
	}
	
	@Override
	public E pop() {
		return list.removeFirst();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
}
