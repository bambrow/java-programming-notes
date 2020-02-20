package data_structures.ch9;

import java.util.Comparator;

/** An abstract base class to assist implementations of the PriorityQueue interface. */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
	
	// ---------- nested PQEntry class ----------
	protected static class PQEntry<K, V> implements Entry<K, V> {
		private K key;
		private V value;
		public PQEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		// utilities not exposed as part of the Entry interface
		protected void setKey(K key) {
			this.key = key;
		}
		protected void setValue(V value) {
			this.value = value;
		}
	}

	// instance variable for an AbstractPriorityQueue
	/** The comparator defining the ordering of keys in the priority queue. */
	private Comparator<K> comp;
	
	/** Creates an empty priority queue using the given comparator to order keys. */
	protected AbstractPriorityQueue(Comparator<K> comp) {
		this.comp = comp;
	}
	
	/** Creates an empty priority queue based on the natural ordering of its keys. */
	protected AbstractPriorityQueue() {
		this(new DefaultComparator<K>());
	}
	
	/** Method for comparing two entries according to key. */
	protected int compare(Entry<K, V> a, Entry<K, V> b) {
		return comp.compare(a.getKey(), b.getKey());
	}
	
	/** Determines whether a key is valid. */
	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comp.compare(key, key) == 0); // see if key can be compared to itself
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
	/** Tests whether the priority queue is empty. */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

}
