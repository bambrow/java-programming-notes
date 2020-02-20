package data_structures.ch6;

public class ArrayStack<E> implements Stack<E> {
	
	public static final int CAPACITY = 1000; // default array capacity
	private E[] data;
	private int t = -1; // index of the top element in stack
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
	}
	
	@Override
	public int size() {
		return t + 1;
	}
	
	@Override
	public boolean isEmpty() {
		return t == -1;
	}
	
	@Override
	public Stack<E> push(E e) throws IllegalStateException {
		if (size() == data.length) {
			throw new IllegalStateException("Stack is full");
		}
		data[++t] = e;
		return this;
	}
	
	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return data[t];
	}
	
	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[t];
		data[t--] = null;
		return answer;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "no element";
		}
		StringBuilder answer = new StringBuilder();
		for (int i = t; i >= 0; --i) {
			answer.append(data[i].toString()).append(" ");
		}
		return answer.toString();
	}
	
}
