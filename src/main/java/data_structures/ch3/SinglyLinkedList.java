package data_structures.ch3;

public class SinglyLinkedList<E> implements Cloneable {

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
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList() {

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
		return head.getElement();
	}
	
	// returns the last element
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	// update methods
	// adds element to the front
	public SinglyLinkedList<E> addFirst(E element) {
		head = new Node<>(element, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
		return this;
	}
	
	// adds element to the end
	public SinglyLinkedList<E> addLast(E element) {
		Node<E> newest = new Node<>(element, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
		return this;
	}
	
	// removes and returns the first element
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return answer;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "no element";
		}
		StringBuilder answer = new StringBuilder();
		for (Node<E> node = head; node != null; node = node.getNext()) {
			answer.append(node.getElement().toString()).append(" ");
		}
		return answer.toString();
	}
	
	// deep clone
	@SuppressWarnings("unchecked")
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		// always use inherited Object.clone() to create the initial copy
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
		if (size > 0) {
			other.head = new Node<>(head.getElement(), null); // start the deep clone
			Node<E> walk = head.getNext(); // walk through the remainder of original list
			Node<E> otherTail = other.head; // remember most recently created node
			while (walk != null) {
				Node<E> newest = new Node<>(walk.getElement(), null); // make a new node storing the same element
				otherTail.setNext(newest); // link previous node to the new one
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SinglyLinkedList other = (SinglyLinkedList) obj; // use nonparameterized type
		if (size != other.size) {
			return false;
		}
		Node walkA = head; // traverse the primary list
		Node walkB = other.head; // traverse the secondary list
		while (walkA != null) {
			if (!walkA.getElement().equals(walkB.getElement())) {
				return false; // mismatch
			}
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int hashCode() {
		int h = 0;
		for (Node walk = head; walk != null; walk = walk.getNext()) {
			h ^= walk.getElement().hashCode(); // bitwise exclusive-or with element's hashcode
			h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of composite hashcode
		}
		return h;
	}
	
}
