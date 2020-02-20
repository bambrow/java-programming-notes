package data_structures.ch6;

import data_structures.ch3.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {
	
	private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();
	
	public LinkedCircularQueue() {

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
	public CircularQueue<E> enqueue(E e) {
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
	public CircularQueue<E> rotate() {
		list.rotate();
		return this;
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
}
