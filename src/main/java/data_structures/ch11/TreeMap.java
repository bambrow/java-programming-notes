package data_structures.ch11;

import java.util.ArrayList;
import java.util.Comparator;

import data_structures.ch10.AbstractSortedMap;
import data_structures.ch7.Position;
import data_structures.ch8.LinkedBinaryTree;
import data_structures.ch9.Entry;

/** An implementation of a sorted map using a binary search tree. */
public class TreeMap<K, V> extends AbstractSortedMap<K, V> {
	
	// to represent the underlying tree structure, we use a specialized subclass of the 
	// LinkedBinaryTree class that we name BalanceableBinaryTree
	// ---------- nested BalanceableBinaryTree class
	/** A specialized version of LinkedBinaryTree with support for balancing. */
	protected static class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>> {
		
		// ---------- nested BSTNode class ----------
		// this extends the inherited LinkedBinaryTree.Node class
		protected static class BSTNode<E> extends Node<E> {
			int aux = 0; // auxiliary value that can help in the subclasses (for balancing information)
			public BSTNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
				super(e, parent, left, right);
			}
			public int getAux() {
				return this.aux;
			}
			public void setAux(int aux) {
				this.aux = aux;
			}
		}
		
		// positional-based methods related to aux field
		public int getAux(Position<Entry<K, V>> p) {
			return ((BSTNode<Entry<K, V>>) p).getAux();
		}
		
		public void setAux(Position<Entry<K, V>> p, int aux) {
			((BSTNode<Entry<K, V>>) p).setAux(aux);
		}
		
		// override node factory function to produce a BSTNode rather than a Node
		@Override
		protected Node<Entry<K, V>> createNode(Entry<K, V> e, 
				Node<Entry<K, V>> parent, Node<Entry<K, V>> left, 
				Node<Entry<K, V>> right) {
			return new BSTNode<>(e, parent, left, right);
		}
		
		// methods for rotating and restructuring
		// those methods are not revoked by the standard TreeMap operations
		// however, they are avaliable for all balanced-tree subclasses
		/** Relinks a parent node with its oriented child node. */
		private void relink(Node<Entry<K, V>> parent, 
				Node<Entry<K, V>> child, boolean makeLeftChild) {
			child.setParent(parent);
			if (makeLeftChild) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		
		/** Rotates position p above its parent. */
		public void rotate(Position<Entry<K, V>> p) {
			Node<Entry<K, V>> x = validate(p);
			Node<Entry<K, V>> y = x.getParent(); // we assume this exists
			Node<Entry<K, V>> z = y.getParent(); // grandparent, possibly null
			if (z == null) {
				root = x;
				x.setParent(null); // x becomes root
			} else {
				relink(z, x, y == z.getLeft()); // x becomes direct child of z
			}
			// now rotate x and y, including transfer of middle subtree
			if (x == y.getLeft()) {
				relink(y, x.getRight(), true); // x's right child becomes y's left
				relink(x, y, false); // y becomes x's right child
			} else {
				relink(y, x.getLeft(), false); // x's left child becomes y's right
				relink(x, y, true); // y becomes x's left child
			}
		}
		
		/** Performs a trinode restructuring of position x with its parent/grandparent. */
		public Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
			Position<Entry<K, V>> y = parent(x);
			Position<Entry<K, V>> z = parent(y);
			if ((x == right(y)) == (y == right(z))) { // matching alignments
				rotate(y); // single rotation of y
				return y; // y is new subtree root
			} else { // opposite alignments
				rotate(x);
				rotate(x); // double rotation of x
				return x; // x is new subtree root
			}
		}
		
	}
	
	// representation of the underlying tree structure
	// note that TreeMap class is designed so that it can be subclassed to 
	// implement various forms of balances search trees
	protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();
	
	public TreeMap() {
		super(); // the AbstractSortedMap constructor
		tree.addRoot(null); // create a sentinel leaf as root
	}
	
	public TreeMap(Comparator<K> comp) {
		super(comp); // the AbstractSortedMap constructor
		tree.addRoot(null); // create a sentinel leaf as root
	}
	
	/** Utility used when inserting a new entry at a leaf of the tree. */
	private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
		tree.set(p, entry); // store new entry at p
		tree.addLeft(p, null); // add new sentinel leaves as children
		tree.addRight(p, null);
	}
	
	// protected methods providing notational shorthands to wrap operations on the 
	// underlying linked binary tree
	protected Position<Entry<K,V>> root() { return tree.root(); }
	protected Position<Entry<K,V>> parent(Position<Entry<K,V>> p) { return tree.parent(p); }
	protected Position<Entry<K,V>> left(Position<Entry<K,V>> p) { return tree.left(p); }
	protected Position<Entry<K,V>> right(Position<Entry<K,V>> p) { return tree.right(p); }
	protected Position<Entry<K,V>> sibling(Position<Entry<K,V>> p) { return tree.sibling(p); }
	protected boolean isRoot(Position<Entry<K,V>> p) { return tree.isRoot(p); }
	protected boolean isExternal(Position<Entry<K,V>> p) { return tree.isExternal(p); }
	protected boolean isInternal(Position<Entry<K,V>> p) { return tree.isInternal(p); }
	protected void set(Position<Entry<K,V>> p, Entry<K,V> e) { tree.set(p, e); }
	protected Entry<K,V> remove(Position<Entry<K,V>> p) { return tree.remove(p); }
	protected void rotate(Position<Entry<K,V>> p) { tree.rotate(p); }
	protected Position<Entry<K,V>> restructure(Position<Entry<K,V>> x) { return tree.restructure(x); }
	
	/** Returns the position in p's subtree having given key (or else the terminal leaf). */
	private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
		// this method, if found exact match, will return that position;
		// otherwise, it will return the position where the position should be 
		// after direct insertion (when no rotation has been performed yet)
		if (isExternal(p)) {
			return p; // key not found; return the final leaf
		}
		int comp = compare(key, p.getElement());
		if (comp == 0) {
			return p; // key found; return its position
		} else if (comp < 0) {
			return treeSearch(left(p), key); // search left subtree
		} else {
			return treeSearch(right(p), key); // search right subtree
		}
	}
	
	/** Returns the position with the maximun key in subtree rooted at position p. */
	protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
		Position<Entry<K, V>> walk = p;
		while (isInternal(walk)) {
			walk = right(walk);
		}
		return parent(walk); // we want the parent of the leaf
	}
	
	/** Returns the position with the maximun key in subtree rooted at position p. */
	protected Position<Entry<K, V>> treeMin(Position<Entry<K, V>> p) {
		Position<Entry<K, V>> walk = p;
		while (isInternal(walk)) {
			walk = left(walk);
		}
		return parent(walk); // we want the parent of the leaf
	}
	
	// hooks for balanced search tree operations; to be overwritten in subclasses
	// they do not do anything in TreeMap class, only trivial declarations
	// this is an example of template method design pattern
	protected void rebalanceInsert(Position<Entry<K,V>> p) { }
	protected void rebalanceDelete(Position<Entry<K,V>> p) { }
	protected void rebalanceAccess(Position<Entry<K,V>> p) { }

	@Override
	public Entry<K, V> firstEntry() {
		if (isEmpty()) {
			return null;
		}
		return treeMin(root()).getElement();
	}

	@Override
	public Entry<K, V> lastEntry() {
		if (isEmpty()) {
			return null;
		}
		return treeMax(root()).getElement();
	}

	@Override
	public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K, V>> p = treeSearch(root(), key);
		if (isInternal(p)) {
			return p.getElement(); // exact match
		}
		while (!isRoot(p)) {
			if (p == left(parent(p))) {
				return parent(p).getElement(); // now the parent has next greater key compared to the input key
				// because the input key, if in the tree, will be the largest key in the left subtree of p's parent
				// in other words, if in the tree, the input key will be the predecessor of p's parent
				// and thus p's parent will be the successor of the input key
				// because the input key is not in the tree, and there's no element between them
			} else {
				p = parent(p); // continue to test the parent key until find a lesser one
			}
		}
		return null; // no such ceiling exists, because all keys in the tree are smaller than the given key
	}

	@Override
	public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K, V>> p = treeSearch(root(), key);
		if (isInternal(p)) {
			return p.getElement(); // exact match
		}
		while (!isRoot(p)) {
			if (p == right(parent(p))) {
				return parent(p).getElement(); // now the parent has next lesser key compared to the input key
				// because the input key, if in the tree, will be the smallest key in the right subtree of p's parent
				// in other words, if in the tree, the input key will be the successor of p's parent
				// and thus p's parent will be the predecessor of the input key
				// because the input key is not in the tree, and there's no element between them
			} else {
				p = parent(p); // continue to test the parent key until find a lesser one
			}
		}
		return null; // no such floor exists, because all keys in the tree are larger than the given key
	}

	@Override
	public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K, V>> p = treeSearch(root(), key);
		if (isInternal(p) && isInternal(left(p))) {
			return treeMax(left(p)).getElement(); // this is the predecessor to p
		}
		// otherwise, we have failed search, or match with no left child
		// now we can follow the steps in floorEntry()
		// for detailed explanations, see floorEntry() method
		while (!isRoot(p)) {
			if (p == right(parent(p))) {
				return parent(p).getElement();
			} else {
				p = parent(p);
			}
		}
		return null;
	}

	@Override
	public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K, V>> p = treeSearch(root(), key);
		if (isInternal(p) && isInternal(right(p))) {
			return treeMin(right(p)).getElement(); // this is the successor to p
		}
		// otherwise, we have failed search, or match with no right child
		// now we can follow the steps in ceilingEntry()
		// for detailed explanations, see ceilingEntry() method
		while (!isRoot(p)) {
			if (p == left(parent(p))) {
				return parent(p).getElement();
			} else {
				p = parent(p);
			}
		}
		return null;
	}
	
	/** Utility to fill subMap buffer recursively, while maintaining order. */
	private void subMapRecurse(K fromKey, K toKey, 
			Position<Entry<K, V>> p, ArrayList<Entry<K, V>> buffer) {
		if (isInternal(p)) {
			if (compare(p.getElement(), fromKey) < 0) {
				// p's key is less than fromKey, so any relevant entries are to the right
				subMapRecurse(fromKey, toKey, right(p), buffer);
			} else {
				subMapRecurse(fromKey, toKey, left(p), buffer); // first consider left subtree
				if (compare(p.getElement(), toKey) < 0) { // p is within range
					buffer.add(p.getElement()); // so add it to buffer
					subMapRecurse(fromKey, toKey, right(p), buffer); // and consider right subtree as well
				}
			}
		}
	}

	@Override
	public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
		if (compare(fromKey, toKey) < 0) { // ensure that fromKey < toKey
			subMapRecurse(fromKey, toKey, root(), buffer);
		}
		return buffer;
	}

	@Override
	public int size() {
		return (tree.size() - 1) / 2; // only internal nodes have entries
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K, V>> p = treeSearch(root(), key);
		rebalanceAccess(p); // hook for balanced tree subclasses
		if (isExternal(p)) {
			return null; // no match
		}
		return p.getElement().getValue(); // match found
	}

	@Override
	public V put(K key, V value) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Entry<K, V> newEntry = new MapEntry<>(key, value);
		Position<Entry<K, V>> p = treeSearch(root(), key);
		if (isExternal(p)) {
			expandExternal(p, newEntry); // key is new
			rebalanceInsert(p); // hook for balanced tree subclasses
			return null;
		} else {
			V old = p.getElement().getValue();
			set(p, newEntry); // replace existing key
			rebalanceAccess(p); // hook for balanced tree subclasses
			return old;
		}
		
	}

	@Override
	public V remove(K key) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K, V>> p = treeSearch(root(), key);
		if (isExternal(p)) {
			rebalanceAccess(p); // hook for balanced tree subclasses
			return null; // no match
		} else {
			V old = p.getElement().getValue();
			if (isInternal(left(p)) && isInternal(right(p))) { // both children are internal
				Position<Entry<K, V>> replacement = treeMax(left(p));
				set(p, replacement.getElement());
				p = replacement;
			} // now p has at most one child that is an internal node
			Position<Entry<K, V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
			Position<Entry<K, V>> sib = sibling(leaf);
			remove(leaf);
			remove(p); // sib is promoted in p's place
			rebalanceDelete(sib); // hook for balanced tree subclasses
			return old;
		}
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
		for (Position<Entry<K, V>> p : tree.inorder()) {
			if (isInternal(p)) {
				buffer.add(p.getElement());
			}
		}
		return buffer;
	}

}
