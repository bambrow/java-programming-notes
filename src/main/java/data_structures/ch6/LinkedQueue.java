package data_structures.ch6;

import data_structures.ch3.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {

	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public LinkedQueue() {

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
	public Queue<E> enqueue(E e) {
		list.addLast(e);
		return this;
	}
	
	@Override
	public E first() {
		return list.first();
	}
	
	@Override
	public E dequeue() {
		return list.removeFirst();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
}
