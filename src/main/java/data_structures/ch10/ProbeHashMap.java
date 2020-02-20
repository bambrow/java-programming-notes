package data_structures.ch10;

import java.util.ArrayList;

import data_structures.ch9.Entry;

public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
	
	private MapEntry<K, V>[] table; // a fixed array of entries, all initially null
	private MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null); // sentinel, marking as deactivated location
	
	public ProbeHashMap() {
		super();
	}
	
	public ProbeHashMap(int capacity) {
		super(capacity);
	}
	
	public ProbeHashMap(int capacity, int prime) {
		super(capacity, prime);
	}
	
	/** Returns true if location is either empty or defunct. */
	private boolean isAvailable(int j) {
		return (table[j] == null || table[j] == DEFUNCT);
	}
	
	/** Returns index with key k, or -(a+1) such that k could be added at index a. */
	private int findSlot(int h, K k) {
		// if the key exists, return the index
		// if the key does not exist and there is available location at index a, return -(a+1)
		// -(a+1) is guaranteed to be a negative integer
		// if the key does not exist and there is no available location ... this situation is impossible
		// because the load factor will never be greater than 0.5
		// therefore, non-negative value returned --> key exists
		// 				  negative value returned --> key does not exist
		int avail = -1; // no slot available (thus far)
		int j = h; // index while scanning table
		do {
			if (isAvailable(j)) { // may be either empty or defunct
				if (avail == -1) {
					avail = j; // this is the first available slot!
				}
				if (table[j] == null) {
					break; // if empty, search fails immediately
				}
			} else if (table[j].getKey().equals(k)) {
				return j; // successful match
			}
			j = (j+1) % capacity; // keep looking circularly
		} while (j != h); // stop if we return to the start ... worst case
		return -(avail+1); // guarantee to return a negative value in this case
	}

	/** Returns an iterable collection of all key-value entries of the map. */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>();
		for (int h = 0; h < capacity; h++) {
			if (!isAvailable(h)) {
				buffer.add(table[h]);
			}
		}
		return buffer;
	}

	/** Creates an empty table having length equal to current capacity. */
	@SuppressWarnings("unchecked")
	@Override
	protected void createTable() {
		table = (MapEntry<K, V>[]) new MapEntry[capacity]; // safe cast
	}

	/** Returns value associated with key k in bucket with hash value h, or else null. */
	@Override
	protected V bucketGet(int h, K k) {
		int j = findSlot(h, k);
		if (j < 0) {
			return null; // no match found
		}
		return table[j].getValue();
	}

	/** Associates key k with value v in bucket with hash value h; returns old value. */
	@Override
	protected V bucketPut(int h, K k, V v) {
		int j = findSlot(h, k);
		if (j >= 0) { // this key exists
			return table[j].setValue(v);
		}
		table[-(j+1)] = new MapEntry<>(k, v); // convert to proper index
		n++;
		return null;
	}

	/** Removes entry having key k from bucket with hash value h, if any. */
	@Override
	protected V bucketRemove(int h, K k) {
		int j = findSlot(h, k);
		if (j < 0) {
			return null; // nothing to remove
		}
		V answer = table[j].getValue();
		table[j] = DEFUNCT; // mark this slot as deactivated
		n--;
		return answer;
	}

}
