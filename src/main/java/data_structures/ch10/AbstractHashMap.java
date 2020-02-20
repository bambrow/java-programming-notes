package data_structures.ch10;

import java.util.ArrayList;
import java.util.Random;

import data_structures.ch9.Entry;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {

	protected int n = 0; // number of entries in the dictionary
	protected int capacity; // length of the hash table
	private int prime; // prime factor for hashing
	private long scale, shift; // the shift and scaling factors for MAD method
	
	public AbstractHashMap(int capacity, int prime) {
		this.capacity = capacity;
		this.prime = prime;
		Random rand = new Random();
		scale = rand.nextInt(prime-1) + 1;
		shift = rand.nextInt(prime);
		createTable();
	}
	
	public AbstractHashMap(int capacity) {
		this(capacity, 109345121); // default prime
	}
	
	public AbstractHashMap() {
		this(17); // default capacity
	}
	
	@Override
	public int size() {
		return n;
	}
	
	@Override
	public V get(K key) {
		return bucketGet(hashValue(key), key);
	}
	
	@Override
	public V remove(K key) {
		return bucketRemove(hashValue(key), key);
	}
	
	@Override
	public V put(K key, V value) {
		V answer = bucketPut(hashValue(key), key, value);
		if (n > capacity / 2) { // keep load factor <= 0.5
			resize(2 * capacity - 1); // (or find a nearby prime)
		}
		return answer;
	}
	
	// private utilities
	/**
	 * Return the hash value of the key using Multiply-Add-and-Divide (MAD) method.
	 * Instead of the division method, MAD method helps eliminate repeated patterns in
	 * a set of integer keys. This method maps integer i to:
	 * [(ai+b) mod p] mod N
	 * where N is the size of bucket array, p is a prime number larger than N, and a and b
	 * are integers chosen at random from the interval [0, p-1], with a > 0. 
	 * This compression function is chosen in order to eliminate repeated patterns in the 
	 * set of hash codes and get us closer to having a "good" hash function, that is, one
	 * such that the probability any two different keys collide is 1/N. 
	 * 
	 * @param key	the input key
	 * @return the hash value of the key
	 */
	private int hashValue(K key) {
		return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
	}
	
	private void resize(int newCapacity) {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
		for (Entry<K, V> entry : entrySet()) {
			buffer.add(entry);
		}
		capacity = newCapacity;
		createTable(); // based on updated capacity
		n = 0; // will be recomputed while reinserting entries
		for (Entry<K, V> entry : buffer) {
			put(entry.getKey(), entry.getValue());
		}
	}
	
	// protected abstract methods to be implemented by subclasses
	protected abstract void createTable();
	protected abstract V bucketGet(int h, K k);
	protected abstract V bucketPut(int h, K k, V v);
	protected abstract V bucketRemove(int h, K k);
	
}
