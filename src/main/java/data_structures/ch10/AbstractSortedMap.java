package data_structures.ch10;

import java.util.Comparator;

import data_structures.ch9.DefaultComparator;
import data_structures.ch9.Entry;

public abstract class AbstractSortedMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V> {

	private Comparator<K> comp; // the comparator defining the ordering
	
	public AbstractSortedMap(Comparator<K> comp) {
		this.comp = comp;
	}
	
	public AbstractSortedMap() {
		this(new DefaultComparator<K>()); // default is natural ordering of keys
	}
	
	protected int compare(K a, K b) {
		return comp.compare(a, b);
	}
	
	protected int compare(Entry<K, V> a, Entry<K, V> b) {
		return comp.compare(a.getKey(), b.getKey());
	}
	
	protected int compare(K a, Entry<K, V> b) {
		return comp.compare(a, b.getKey());
	}
	
	protected int compare(Entry<K, V> a, K b) {
		return comp.compare(a.getKey(), b);
	}
	
	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comp.compare(key, key) == 0); // check if the key can compare to itself
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
}
