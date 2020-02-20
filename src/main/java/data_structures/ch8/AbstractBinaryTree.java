package data_structures.ch8;

import java.util.ArrayList;
import java.util.List;
import data_structures.ch7.Position;

/**
 * An abstract base class providing some functionality of the BinaryTree interface.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	
	// a binary tree is proper if each node has either 0 or 2 children
	// some people refer to such trees as full binary trees
	// in a proper binary tree, every internal node has exactly 2 children
	// a binary tree that is not proper is improper
	
	// let T be a nonempty binary tree, and let n, ne, ni and h denotes the number of nodes,
	// the number of external nodes, the number of internal nodes and the height
	// then
	// h+1 <= n <= 2^(h+1) - 1
	// 1 <= ne <= 2^h
	// h <= ni <= 2^h - 1
	// log(n+1) - 1 <= h <= n-1
	
	// also if T is proper, then
	// 2h+1 <= n <= 2^(h+1) - 1
	// h+1 <= ne <= 2^h
	// h <= ni <= 2^h - 1
	// log(n+1) - 1 <= h <= (n-1)/2
	
	// in a nonempty proper binary tree T, we have ne = ni + 1
	
	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = parent(p);
		if (parent == null) {
			return null; // p must be the root
		}
		if (p == left(parent)) {
			return right(parent); // p is a left child
		} else {
			return left(parent); // p is a right child
		}
	}
	
	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		int count = 0;
		if (left(p) != null) {
			count++;
		}
		if (right(p) != null) {
			count++;
		}
		return count;
	}
	
	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
		if (left(p) != null) {
			snapshot.add(left(p));
		}
		if (right(p) != null) {
			snapshot.add(right(p));
		}
		return snapshot;
	}
	
	// tree traversal algorithms
	/** Adds positions of the subtree rooted at Position p to the given snapshot. */
	private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		if (left(p) != null) {
			inorderSubtree(left(p), snapshot);
		}
		snapshot.add(p);
		if (right(p) != null) {
			inorderSubtree(right(p), snapshot);
		}
	}
	
	/** Returns an iterable collection of positions of the tree, reported in inorder. */
	public Iterable<Position<E>> inorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			inorderSubtree(root(), snapshot); // fill the snapshot recursively
		}
		return snapshot;
	}
	
	/** Overrides positions to make inorder the default order for binary trees. */
	@Override
	public Iterable<Position<E>> positions() {
		return inorder();
	}

}
