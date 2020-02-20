package data_structures.ch9;

import java.util.ArrayList;
import java.util.Comparator;

/** An implementation of a priority queue using an array-based heap. */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	/** Primary collection of priority queue entries. */
	protected ArrayList<Entry<K, V>> heap = new ArrayList<>();
	
	public HeapPriorityQueue() {
		super();
	}
	
	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
	}
	
	// protected utilities
	// the elements stored in array-based list A, and the element at position p
	// is stored in A with index equal to the level number f(p) of p, and:
	// if p is the root, then f(p) = 0;
	// if p is the left child of q, then f(p) = 2*f(q) + 1;
	// if p is the right child of q, then f(p) = 2*f(q) + 2;
	// so in this implementation, the index starts at 0.
	// therefore, if p is the parent of q, then f(p) = (f(q) - 1)/2, and 
	// with Java's integer truncating division, the result is always an integer,
	// just like f(p) = floor((f(q) - 1)/2).
	// moreover, we define a complete heap as follows:
	// a heap T with height h is a complete binary tree if levels 0, 1, ..., h-1 of T
	// has maximal number of nodes possible (namely, level i has 2^i nodes, 0 <= i <= h-1)
	// and the remaining nodes at level h reside in the leftmost possible positions at that level.
	// in this case, for a tree of size n, the elements have contiguous indices
	// in the range[0, n-1] and the last position is always n-1.
	
	protected int parent(int j) {
		return (j - 1) / 2; // truncating division
	}
	
	protected int left(int j) {
		return 2 * j + 1;
	}
	
	protected int right(int j) {
		return 2 * j + 2;
	}
	
	protected boolean hasLeft(int j) {
		return left(j) < heap.size();
	}
	
	protected boolean hasRight(int j) {
		return right(j) < heap.size();
	}
	
	/** Exchanges the entries at indices i and j of the array list. */
	protected void swap(int i, int j) {
		Entry<K, V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	/** Moves the entry at index j higher, if necessary, to restore heap property. */
	protected void upheap(int j) {
		while (j > 0) { // continue until reaching the root
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p)) >= 0) {
				break; // heap property verified
			}
			swap(j, p);
			j = p; // continue from the parent's location
		}
	}
	
	/** Moves the entry at index j lower, if necessary, to restore heap property. */
	protected void downheap(int j) {
		while (hasLeft(j)) { // continue to bottom
			int leftIndex = left(j);
			int smallChildIndex = leftIndex; // although right may be smaller
			if (hasRight(j)) {
				int rightIndex = right(j);
				if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
					smallChildIndex = rightIndex; // right child is smaller
				}
			}
			if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0) {
				break; // heap property has been restored
			}
			swap(j, smallChildIndex);
			j = smallChildIndex; // continue at the position of child
		}
	}
	
	// public methods
	
	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		heap.add(newest); // add to the end of the list
		upheap(heap.size() - 1); // upheap newly added entry
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if (heap.isEmpty()) {
			return null;
		}
		return heap.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		if (heap.isEmpty()) {
			return null;
		}
		Entry<K, V> answer = heap.get(0);
		swap(0, heap.size() - 1); // put minimum item at the end
		heap.remove(heap.size() - 1); // and remove it from the list
		downheap(0); // then fix the new root
		return answer;
	}
	
	// bottom-up heap construction, when all the key-value pairs are given in advance
	/** Creates a priority queue initialized with the given key-value pairs. */
	public HeapPriorityQueue(K[] keys, V[] values) {
		super();
		for (int j = 0; j < Math.min(keys.length, values.length); j++) {
			heap.add(new PQEntry<>(keys[j], values[j]));
		}
		heapify();
	}
	
	public HeapPriorityQueue(K[] keys, V[] values, Comparator<K> comp) {
		super(comp);
		for (int j = 0; j < Math.min(keys.length, values.length); j++) {
			heap.add(new PQEntry<>(keys[j], values[j]));
		}
		heapify();
	}
	
	/** Performs a bottom-up construction of the heap in linear time. */
	protected void heapify() {
		int startIndex = parent(size() - 1); // start at parent of last entry
		for (int j = startIndex; j >= 0; j--) { // loop until processing the root
			downheap(j);
		}
	}

}
