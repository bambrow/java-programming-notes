package data_structures.ch11;

import java.util.Comparator;

import data_structures.ch7.Position;
import data_structures.ch9.Entry;

/** An implementation of a sorted map using an AVL tree. */
public class AVLTreeMap<K, V> extends TreeMap<K, V> {

	public AVLTreeMap() {
		super();
	}
	
	public AVLTreeMap(Comparator<K> comp) {
		super(comp);
	}
	
	// we uses the node's auxiliary balancing variable to store the height of the subtree
	/** Returns the height of the given tree position. */
	protected int height(Position<Entry<K, V>> p) {
		return tree.getAux(p);
	}
	
	/** Recomputes the height of the given position based on its children's heights. */
	private void recomputeHeight(Position<Entry<K, V>> p) {
		tree.setAux(p, 1 + Math.max(height(left(p)), height(right(p))));
	}
	
	/** Returns whether a position has balance factor between -1 and 1 inclusive. */
	protected boolean isBalanced(Position<Entry<K, V>> p) {
		return Math.abs(height(left(p)) - height(right(p))) <= 1;
	}
	
	/** Returns a child of p with height no smaller than the other child. */
	protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> p) {
		if (height(left(p)) > height(right(p))) {
			return left(p);
		}
		if (height(left(p)) < height(right(p))) {
			return right(p);
		}
		// equal height children; break tie while matching parent's orientation
		if (isRoot(p)) {
			return left(p); // choice is irrelevant, so just return the left child
		}
		if (p == left(parent(p))) {
			return left(p); // return aligned child
		} else {
			return right(p);
		}
	}
	
	/**
	 * Utility used to rebalance after an insert or removal operation.
	 * This traverses the path upward from p, performing a trinode restructuring
	 * when imbalance is found, continuing until balance is restored.
	 */
	protected void rebalance(Position<Entry<K, V>> p) {
		int oldHeight, newHeight;
		do {
			oldHeight = height(p); // not yet recaculated if internal
			if (!isBalanced(p)) { // imbalance detected
				// perform trinode restructuring, setting p to resulting root,
				// and recompute new local heights after the restructuring
				p = restructure(tallerChild(tallerChild(p)));
				recomputeHeight(left(p));
				recomputeHeight(right(p));
			}
			recomputeHeight(p);
			newHeight = height(p);
			p = parent(p);
		} while (oldHeight != newHeight && p != null);
	}
	
	/** Overrides the TreeMap rebalancing hook that is called after an insertion. */
	@Override
	protected void rebalanceInsert(Position<Entry<K, V>> p) {
		rebalance(p);
	}
	
	/** Overrides the TreeMap rebalancing hook thay is called after a deletion. */
	@Override
	protected void rebalanceDelete(Position<Entry<K, V>> p) {
		if (!isRoot(p)) {
			rebalance(parent(p));
		}
	}
	
}
