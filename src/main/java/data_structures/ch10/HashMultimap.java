package data_structures.ch10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class HashMultimap<K, V> implements Multimap<K, V> {
	
	private Map<K, List<V>> map = new HashMap<>(); // the primary map
	private int total = 0; // total number of entries in the multimap
	
	public HashMultimap() {
		
	}

	@Override
	public int size() {
		return total;
	}

	@Override
	public boolean isEmpty() {
		return (total == 0);
	}

	@Override
	public Iterable<V> get(K key) {
		List<V> secondary = map.get(key);
		if (secondary != null) {
			return secondary;
		}
		return new ArrayList<>(); // return an empty list of values, if the key does not exist
	}

	@Override
	public void put(K key, V value) {
		List<V> secondary = map.get(key);
		if (secondary == null) {
			secondary = new ArrayList<>();
			map.put(key, secondary); // begin using new list as secondary structure
		}
		secondary.add(value);
		total++;
	}

	@Override
	public boolean remove(K key, V value) {
		boolean removed = false;
		List<V> secondary = map.get(key);
		if (secondary != null) {
			removed = secondary.remove(value);
			if (removed) {
				total--;
				if (secondary.isEmpty()) {
					map.remove(key); // remove secondary structure from primary map
				}
			}
		}
		return removed;
	}

	@Override
	public Iterable<V> removeAll(K key) {
		List<V> secondary = map.get(key);
		if (secondary != null) {
			total -= secondary.size();
			map.remove(key);
		} else {
			secondary = new ArrayList<>(); // return empty list of values, if the key does not exist
		}
		return secondary;
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		List<Entry<K, V>> result = new ArrayList<>();
		for (Entry<K, List<V>> secondary : map.entrySet()) {
			K key = secondary.getKey();
			for (V value : secondary.getValue()) {
				result.add(new SimpleEntry<K, V>(key, value));
			}
		}
		return result;
	}

	@Override
	public Iterable<K> keys() {
		List<K> result = new ArrayList<>();
		for (K key : map.keySet()) {
			for (int i = 0; i < map.get(key).size(); i++) {
				result.add(key);
			}
		}
		return result;
	}

	@Override
	public Iterable<K> keySet() {
		return map.keySet();
	}

	@Override
	public Iterable<V> values() {
		List<V> result = new ArrayList<>();
		for (List<V> secondary : map.values()) {
			result.addAll(secondary);
		}
		return result;
	}

}
