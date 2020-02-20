package data_structures.ch10;

import java.util.Map.Entry;

public interface Multimap<K, V> {
	int size();
	boolean isEmpty();
	Iterable<V> get(K key);
	void put(K key, V value);
	boolean remove(K key, V value);
	Iterable<V> removeAll(K key);
	Iterable<Entry<K, V>> entries();
	Iterable<K> keys(); // returns a (duplicate) collection of all keys for all entries
	Iterable<K> keySet(); // returns a non-duplicate collection of all keys
	Iterable<V> values();
}
