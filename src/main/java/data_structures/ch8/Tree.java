package data_structures.ch8;

import java.util.Iterator;

import data_structures.ch7.Position;

/**
 * An interface for a tree where nodes can have an arbitrary number
 * of children.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public interface Tree<E> extends Iterable<E> {
	
	// accessor methods
	
	/**
	 * Returns the position of the root.
	 * @return the position of the root, or null if empty
	 */
	Position<E> root();
	
	/**
	 * Returns the parent position of the current position.
	 * @param p		current position
	 * @return the parent position, or null of the current position is root
	 * @throws IllegalArgumentException
	 */
	Position<E> parent(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Returns an Iterable collection containing all children positions of the current position.
	 * @param p		current position
	 * @return the Iterable of all children positions, if any
	 * @throws IllegalArgumentException
	 */
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Returns the number of children of the current position.
	 * @param p		current position
	 * @return the number of children
	 * @throws IllegalArgumentException
	 */
	int numChildren(Position<E> p) throws IllegalArgumentException;
	
	// query methods
	
	/**
	 * Tests if the current position has one or more children.
	 * @param p		current position
	 * @return true if the current position has one or more children; false otherwise
	 * @throws IllegalArgumentException
	 */
	boolean isInternal(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Tests if the current position has no children.
	 * @param p		current position
	 * @return true if the current position has no children; false otherwise
	 * @throws IllegalArgumentException
	 */
	boolean isExternal(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Tests if the current position is root position.
	 * @param p		current position
	 * @return true if the current position is root position; false otherwise
	 * @throws IllegalArgumentException
	 */
	boolean isRoot(Position<E> p) throws IllegalArgumentException;
	
	// general methods
	
	/**
	 * Returns the size of the tree.
	 * @return the size of the tree
	 */
	int size();
	
	/**
	 * Tests if the tree is empty.
	 * @return true if the tree is empty; false otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns an iterator of the tree's elements.
	 */
	Iterator<E> iterator();
	
	/**
	 * Returns an iterable representation of the tree's positions.
	 */
	Iterable<Position<E>> positions();

}
