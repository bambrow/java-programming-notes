package data_structures.ch9;

import java.util.Comparator;

import data_structures.ch7.LinkedPositionalList;
import data_structures.ch7.Position;
import data_structures.ch7.PositionalList;

/** An implementation of a priority queue with an unsorted list. */
public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	/** Primary collection of priority queue entries. */
	private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();
	
	public UnsortedPriorityQueue() {
		super();
	}
	
	public UnsortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}
	
	/** Returns the position of an entry having minimal key. */
	private Position<Entry<K, V>> findMin() { // only called when nonempty
		Position<Entry<K, V>> small = list.first();
		for (Position<Entry<K, V>> walk : list.positions()) {
			if (compare(walk.getElement(), small.getElement()) < 0) {
				small = walk; // found an smaller key
			}
		}
		return small;
	}
	
	/** Returns the number of items in the priority queue. */
	@Override
	public int size() {
		return list.size();
	}

	/** Inserts a key-value pair and returns the entry created. */
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); // auxiliary key-checking method, could throw exception
		Entry<K, V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}

	/** Returns, but not remove, an entry with minimal key. */
	@Override
	public Entry<K, V> min() {
		if (list.isEmpty()) {
			return null;
		}
		return findMin().getElement();
	}

	/** Removes and returns an entry with minimal key. */
	@Override
	public Entry<K, V> removeMin() {
		if (list.isEmpty()) {
			return null;
		}
		return list.remove(findMin());
	}

}
