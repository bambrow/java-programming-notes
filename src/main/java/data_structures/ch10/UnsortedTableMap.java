package data_structures.ch10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import data_structures.ch9.Entry;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
	
	/** Underlying storage for the map of entries. */
	private ArrayList<MapEntry<K, V>> table = new ArrayList<>();
	
	public UnsortedTableMap() {

	}
	
	/** Returns the index of an entry with equal key, or -1 if none found. */
	private int findIndex(K key) {
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return table.size();
	}

	@Override
	public V get(K key) {
		int index = findIndex(key);
		if (index == -1) {
			return null; // not found
		}
		return table.get(index).getValue();
	}

	@Override
	public V put(K key, V value) {
		int index = findIndex(key);
		if (index == -1) {
			table.add(new MapEntry<K, V>(key, value)); // add new entry
			return null;
		} else { // key already exists
			return table.get(index).setValue(value); // replaced value is returned
		}
	}

	@Override
	public V remove(K key) {
		int index = findIndex(key);
		int n = size();
		if (index == -1) {
			return null; // not found
		}
		V answer = table.get(index).getValue();
		if (index != n - 1) {
			table.set(index, table.get(n-1)); // replace the entry to be removed to the last position
		}
		table.remove(n-1); // remove last entry of table
		return answer;
	}
	
	// support for public entrySet method...
	private class EntryIterator implements Iterator<Entry<K, V>> {
		private int j = 0;
		@Override
		public boolean hasNext() {
			return j < table.size();
		}
		@Override
		public Entry<K, V> next() {
			if (j == table.size()) {
				throw new NoSuchElementException();
			}
			return table.get(j++);
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class EntryIterable implements Iterable<Entry<K, V>> {
		@Override
		public Iterator<Entry<K, V>> iterator() {
			return new EntryIterator();
		}
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return new EntryIterable();
	}

}
