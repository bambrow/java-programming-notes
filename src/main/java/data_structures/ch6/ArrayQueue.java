package data_structures.ch6;

public class ArrayQueue<E> implements Queue<E> {

	public static final int CAPACITY = 1000; // default array capacity
	private E[] data;
	private int f = 0; // index of the front element
	private int sz = 0; // current number of elements
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
	}
	
	@Override
	public int size() {
		return sz;
	}
	
	@Override
	public boolean isEmpty() {
		return sz == 0;
	}
	
	@Override
	public Queue<E> enqueue(E e) throws IllegalStateException {
		if (sz == data.length) {
			throw new IllegalStateException("Queue is full");
		}
		int avail = (f + sz) % data.length; // use modular arithmetic
		data[avail] = e;
		sz++;
		return this;
	}
	
	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return data[f];
	}
	
	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		sz--;
		return answer;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "no element";
		}
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < sz; ++i) {
			int avail = (f + i) % data.length;
			answer.append(data[avail].toString()).append(" ");
		}
		return answer.toString();
	}
	
}
