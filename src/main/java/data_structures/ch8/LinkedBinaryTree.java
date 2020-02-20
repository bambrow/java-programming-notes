package data_structures.ch8;

import data_structures.ch7.Position;

/**
 * Concrete implementation of a binary tree using a node-based, linked structure.
 * 
 * @author Data Structures & Algorithms in Java, 6ed
 */

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	
	// ---------- nested Node class ----------
	protected static class Node<E> implements Position<E> {
		
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}
		
	}
	
	/** factory function to create a new node storing element e. */
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		// factory method pattern, allowing us to later subclass our tree in order to use a specialized node type
		return new Node<E>(e, parent, left, right);
	}
	
	// instance variables
	protected Node<E> root = null;
	private int size = 0;
	
	public LinkedBinaryTree() {
		
	}
	
	// nonpublic utility
	/** validates the position and returns it as a node. */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Not valid position type");
		}
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getParent() == node) { // our convention for defunct node
			throw new IllegalArgumentException("p is no longer in the tree");
		}
		return node;
	}
	
	// accessor methods not already implemented in AbstractBinaryTree
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Position<E> root() {
		return root;
	}
	
	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}
	
	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	// update methods supported by this class
	/** places element e at the root of an empty tree and returns its new position */
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty()) {
			throw new IllegalStateException("Tree is not empty");
		}
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException("p already has a left child");
		}
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}
	
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException("p already has a right child");
		}
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	/** replaces the element at position p with e and returns the replaced element */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	/** attaches trees left and right as left and right subtrees of external p */
	public void attach(Position<E> p, LinkedBinaryTree<E> left, 
			LinkedBinaryTree<E> right) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (isInternal(p)) {
			throw new IllegalArgumentException("p must be a leaf");
		}
		size += left.size() + right.size();
		if (!left.isEmpty()) { // attach left as left subtree of node
			left.root.setParent(node);
			node.setLeft(left.root);
			left.root = null;
			left.size = 0;
		}
		if (!right.isEmpty()) { // attach right as right subtree of node
			right.root.setParent(node);
			node.setRight(right.root);
			right.root = null;
			right.size = 0;
		}
	}

	/** removes the node at position p and replaces it with its child, if any */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (numChildren(p) == 2) {
			throw new IllegalArgumentException("p has two children");
		}
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if (child != null) {
			child.setParent(node.getParent()); // child's grandparent becomes its parent
		}
		if (node == root) {
			root = child; // child becomes root
		} else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		size--;
		E temp = node.getElement(); // help garbage collection
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node); // our convention for defunct node
		return temp;
	}
	
}
