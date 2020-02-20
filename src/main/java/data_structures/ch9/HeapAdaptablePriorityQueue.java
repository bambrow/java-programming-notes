package data_structures.ch9;

import java.util.Comparator;

/** An implementation of an adaptable priority queue using an array-based heap. */
public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {

	// ---------- nested AdaptablePQEntry class ----------
	/** Extension of the PQEntry to include location information. */
	protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
		private int index; // entry's current index within the heap
		public AdaptablePQEntry(K key, V value, int index) {
			super(key, value); // sets key and value
			this.index = index; // sets the new field
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
	}
	
	public HeapAdaptablePriorityQueue() {
		super();
	}
	
	public HeapAdaptablePriorityQueue(Comparator<K> comp) {
		super(comp);
	}
	
	// protected utilities
	/** Validates an entry to ensure it is location-aware. */
	protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
		if (!(entry instanceof AdaptablePQEntry)) {
			throw new IllegalArgumentException("Invalid entry");
		}
		AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry; // safe cast
		int index = locator.getIndex();
		if (index >= heap.size() || heap.get(index) != locator) {
			throw new IllegalArgumentException("Invalid entry");
		}
		return locator;
	}
	
	/** Exchanges the entries at indices i and j of the array list. */
	protected void swap(int i, int j) {
		super.swap(i, j); // perform the swap
		((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i); // reset entry's index
		((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j); // reset entry's index
	}
	
	/** Restores the heap property by moving the entry at index j upward/downward. */
	protected void bubble(int j) {
		if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0) {
			upheap(j);
		} else {
			downheap(j); // although it might not need to move
		}
	}
	
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); // might throw an exception
		Entry<K, V> newest = new AdaptablePQEntry<>(key, value, heap.size());
		heap.add(newest); // add to the end of the list
		upheap(heap.size() - 1); // upheap newly added entry
		return newest;
	}
	
	@Override
	public void remove(Entry<K, V> entry) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		int j = locator.getIndex();
		if (j == heap.size() - 1) { // entry is at last position
			heap.remove(heap.size() - 1); // so just remove it
		} else {
			swap(j, heap.size() - 1); // swap entry to last position
			heap.remove(heap.size() - 1); // then remove it
			bubble(j); // and fix entry displaced by the swap
		}
	}

	@Override
	public void replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		checkKey(key); // might throw an exception
		locator.setKey(key); // method inherited from PQEntry
		bubble(locator.getIndex()); // with new key, we might need to move entry
	}

	@Override
	public void replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		locator.setValue(value); // method inherited from PQEntry
	}

	public HeapAdaptablePriorityQueue(K[] keys, V[] values) {
		super();
		for (int j = 0; j < Math.min(keys.length, values.length); j++) {
			heap.add(new AdaptablePQEntry<>(keys[j], values[j], j));
		}
		heapify();
	}
	
	public HeapAdaptablePriorityQueue(K[] keys, V[] values, Comparator<K> comp) {
		super(comp);
		for (int j = 0; j < Math.min(keys.length, values.length); j++) {
			heap.add(new AdaptablePQEntry<>(keys[j], values[j], j));
		}
		heapify();
	}
	
}
