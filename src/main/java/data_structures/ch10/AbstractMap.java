package data_structures.ch10;

import java.util.Iterator;

import data_structures.ch9.Entry;

public abstract class AbstractMap<K, V> implements Map<K, V> {

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// ---------- nested MapEntry class ----------
	protected static class MapEntry<K, V> implements Entry<K, V> {
		private K key;
		private V value;
		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		protected void setKey(K key) {
			this.key = key;
		}
		protected V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
	}
	
	// support for public keySet method...
	private class KeyIterator implements Iterator<K> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet
		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}
		@Override
		public K next() {
			return entries.next().getKey(); // return key!
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class KeyIterable implements Iterable<K> {
		@Override
		public Iterator<K> iterator() {
			return new KeyIterator();
		}
	}
	
	@Override
	public Iterable<K> keySet() {
		return new KeyIterable();
	}
	
	// support for public values method...
	private class ValueIterator implements Iterator<V> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet
		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}
		@Override
		public V next() {
			return entries.next().getValue(); // return value!
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class ValueIterable implements Iterable<V> {
		@Override
		public Iterator<V> iterator() {
			return new ValueIterator();
		}
	}
	
	@Override
	public Iterable<V> values() {
		return new ValueIterable();
	}
	
}
