package data_structures.ch9;

/** Interface for a key-value pair. */
public interface Entry<K, V> {
	K getKey();
	V getValue();
}
