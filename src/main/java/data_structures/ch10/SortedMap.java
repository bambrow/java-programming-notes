package data_structures.ch10;

import data_structures.ch9.Entry;

public interface SortedMap<K, V> extends Map<K, V> {

	/** Return the entry with smallest key value. */
	Entry<K, V> firstEntry();
	
	/** Return the entry with largest key value.*/
	Entry<K, V> lastEntry();
	
	/** Returns the entry with the least key value greater than or equal to key. */
	Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException;
	
	/** Returns the entry with the greatest key value less than or equal to key. */
	Entry<K, V> floorEntry(K key) throws IllegalArgumentException;
	
	/** Returns the entry with the greatest key value strictly less than key. */
	Entry<K, V> lowerEntry(K key) throws IllegalArgumentException;
	
	/** Returns the entry with the least key value strictly greater than key. */
	Entry<K, V> higherEntry(K key) throws IllegalArgumentException;
	
	/** Returns an iterable of all entries with key greater than or equal to fromKey but strictly less than toKey. */
	Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException;
	
}
