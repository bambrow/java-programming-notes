package data_structures.ch9;

import java.util.Comparator;

import data_structures.ch7.LinkedPositionalList;
import data_structures.ch7.Position;
import data_structures.ch7.PositionalList;

/** An implementation of a priority queue with a sorted list. */
public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	
	/** Primary collection of priority queue entries. */
	private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();
	
	public SortedPriorityQueue() {
		super();
	}
	
	public SortedPriorityQueue(Comparator<K> comp) {
		super(comp);
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
		Position<Entry<K, V>> walk = list.last();
		// walk backward, looking for smaller key
		while (walk != null && compare(newest, walk.getElement()) < 0) {
			walk = list.before(walk);
		}
		if (walk == null) {
			list.addFirst(newest); // new key is smallest
		} else {
			list.addAfter(walk, newest); // newest goes after walk
		}
		return newest;
	}

	/** Returns, but not remove, an entry with minimal key. */
	@Override
	public Entry<K, V> min() {
		if (list.isEmpty()) {
			return null;
		}
		return list.first().getElement();
	}

	/** Removes and returns an entry with minimal key. */
	@Override
	public Entry<K, V> removeMin() {
		if (list.isEmpty()) {
			return null;
		}
		return list.remove(list.first());
	}

}
