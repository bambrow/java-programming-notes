package data_structures.ch9;

import java.util.Comparator;

/** A DefaultComparator class that implements a comparator based upon the natural ordering of its element type. */
public class DefaultComparator<E> implements Comparator<E> {
	@SuppressWarnings("unchecked")
	@Override
	public int compare(E a, E b) throws ClassCastException {
		return ((Comparable<E>) a).compareTo(b);
	}
}
