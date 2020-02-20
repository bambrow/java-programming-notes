package data_structures.ch8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import data_structures.ch6.LinkedQueue;
import data_structures.ch6.Queue;
import data_structures.ch7.Position;

/**
 * An abstract base class providing some functionality of the Tree interface.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public abstract class AbstractTree<E> implements Tree<E> {
	
	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) > 0;
	}
	
	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) == 0;
	}
	
	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		return p == root();
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Returns the number of levels separating Position p from the root.
	 * @param p		the current position
	 * @return the depth of the position
	 */
	public int depth(Position<E> p) {
		// if p is the root, then the depth of p is 0;
		// otherwise, the depth of p is 1 + the depth of parent of p
		// O(d+1) running time when d denotes the depth of p
		// O(n) worst case time
		if (isRoot(p)) {
			return 0;
		} else {
			return 1 + depth(parent(p));
		}
	}
	
	/** Returns the height of the tree. */
	@SuppressWarnings("unused")
	private int heightBad() { // works, but quadratic worst-case time
		// the entire iteration runs O(n) time, where n is the number of positions
		// running time O(n+sum(d+1)), and the sum is called on all leaf positions
		// worst case sum(d+1) for leaf positions is O(n^2), so O(n^2) total
		int h = 0;
		for (Position<E> p : positions()) {
			if (isExternal(p)) { // only consider leaf positions
				h = Math.max(h, depth(p));
			}
		}
		return h;
	}
	
	/** Returns the height of the subtree rooted at Position p. */
	public int height(Position<E> p) {
		// compute the height of the tree efficiently in O(n) worst case time
		// we define the height of a position p in a tree T as follows
		// 1. if p is a leaf, then the height of p is 0
		// 2. if not, the height of p is more than the maximum of the heights of p's children
		// then the overall height of a nonempty tree can be computed by sending the root as parameter
		// this algorithm is recursive in a top-down fashion
		// if the method is called on the root of T, it will eventually be called once for each position of T
		// we assume the method children(p) costs O(c+1) time,where c is the number of children of p
		// height(p) spends O(c+1) time at each position p to compute the maximum
		// overall running time O(sum(c+1)) = O(n+sum(c)), and sum(c) = n-1
		// because each position of T, with exception of the root, is the child of another position, and contributes one unit to sum(c)
		// so the overall running time is O(n)
		int h = 0;
		for (Position<E> c : children(p)) {
			h = Math.max(h, 1 + height(c));
		}
		return h;
	}
	
	// ---------- nested ElementIterator class ----------
	/** This class adapts the interation produced by positions() to return elements. */
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> postIterator = positions().iterator();
		@Override
		public boolean hasNext() {
			return postIterator.hasNext();
		}
		@Override
		public E next() {
			return postIterator.next().getElement(); // return element
		}
		@Override
		public void remove() {
			postIterator.remove();
		}
	}
	
	/** Returns an iterator of the elements stored in the tree. */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	/** Returns an iterable of all the positions in the tree. */
	@Override
	public Iterable<Position<E>> positions() {
		return preorder(); // preorder is the default
	}
	
	// tree traversal algorithms
	/** Adds positions of the subtree rooted as Position p to the given snapshot. */
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p); // for preorder, we add position p before exploring subtrees
		for (Position<E> c : children(p)) {
			preorderSubtree(c, snapshot);
		}
	}
	
	/** Returns an iterable collection of positions of the tree, reported in preorder. */
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root(), snapshot); // fill the snapshot recursively
		}
		return snapshot;
	}
	
	/** Adds positions of the subtree rooted as Position p to the given snapshot. */
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for (Position<E> c : children(p)) {
			postorderSubtree(c, snapshot);
		}
		snapshot.add(p); // for postorder, we add position p after exploring subtrees
	}
	
	/** Returns an iterable collection of positions of the tree, reported in postorder. */
	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			postorderSubtree(root(), snapshot); // fill the snapshot recursively
		}
		return snapshot;
	}
	
	/** Returns an iterable collection of positions of the tree in breadth-first order. */
	public Iterable<Position<E>> breadthfirst() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			Queue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root()); // start with the root
			while (!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue(); // remove from the front of the queue
				snapshot.add(p); // report this position
				for (Position<E> c : children(p)) {
					fringe.enqueue(c); // add children to back of the queue
				}
			}
		}
		return snapshot;
	}
	
}
