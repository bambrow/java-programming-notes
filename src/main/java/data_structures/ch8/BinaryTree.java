package data_structures.ch8;

import data_structures.ch7.Position;

/**
 * An interface for a binary tree, in which each node has at most two children.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public interface BinaryTree<E> extends Tree<E> {

	/**
	 * Returns the Position of p's left child, or null if no child exists.
	 * @param p		the current position
	 * @return p's left child, or null if no child exists.
	 * @throws IllegalArgumentException
	 */
	Position<E> left(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Returns the Position of p's right child, or null if no child exists.
	 * @param p		the current position
	 * @return p's right child, or null if no child exists.
	 * @throws IllegalArgumentException
	 */
	Position<E> right(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Returns the Position of p's sibling, or null if no sibling exists.
	 * @param p		the current position
	 * @return p's sibling, or null if no sibling exists.
	 * @throws IllegalArgumentException
	 */
	Position<E> sibling(Position<E> p) throws IllegalArgumentException;
	
}
