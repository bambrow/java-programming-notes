package problems.p1;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricTrees {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	public static class TNode {
		int val;
		List<TNode> children;
		public TNode(int x) {
			val = x;
			children = new ArrayList<>();
		}
	}
	
	public boolean symmetricBinaryTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		Stack<TreeNode> pStack = new Stack<>();
		Stack<TreeNode> qStack = new Stack<>();
		pStack.push(p);
		qStack.push(q);
		while (!pStack.isEmpty()) {
			TreeNode pCur = pStack.pop();
			TreeNode qCur = qStack.pop();
			if (pCur.val != qCur.val) return false;
			if (pCur.left != null) pStack.push(pCur.left);
			if (qCur.right != null) qStack.push(qCur.right);
			if (pStack.size() != qStack.size()) return false;
			if (pCur.right != null) pStack.push(pCur.right);
			if (qCur.left != null) qStack.push(qCur.left);
			if (pStack.size() != qStack.size()) return false;
		}
		return pStack.size() == qStack.size();
	}
	
	public void printTree(TreeNode root) {
		printTree(root, "", true);
	}
	
	private void printTree(TreeNode node, String prefix, boolean right) {
		System.out.println(prefix + (right ? "└── " : "├── ") + (node == null ? "null" : node.val));
		if (node != null) {
			printTree(node.left, prefix + (right ? "    " : "│   "), false);
			printTree(node.right, prefix + (right ? "    " : "│   "), true);
		}
	}
	
	public boolean symmetricTree(TNode p, TNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.val != q.val) return false;
		if (p.children.size() != q.children.size()) return false;
		boolean symmetric = true;
		for (int i = 0; i < p.children.size(); i++) {
			int j = q.children.size() - i - 1;
			symmetric = symmetric && symmetricTree(p.children.get(i), q.children.get(j));
		}
		return symmetric;
	}
	
	public void printTree(TNode root) {
		printTree(root, "", true);
	}
	
	private void printTree(TNode node, String prefix, boolean last) {
		System.out.println(prefix + (last ? "└── " : "├── ") + (node == null ? "null" : node.val));
		if (node != null) {
			for (int i = 0; i < node.children.size() - 1; i++) {
				printTree(node.children.get(i), prefix + (last ? "    " : "│   "), false);
			}
			if (node.children.size() > 0) {
				printTree(node.children.get(node.children.size() - 1), prefix + (last ? "    " : "│   "), true);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		TreeNode p4 = new TreeNode(4);
		TreeNode p5 = new TreeNode(5);
		TreeNode q1 = new TreeNode(1);
		TreeNode q2 = new TreeNode(2);
		TreeNode q3 = new TreeNode(3);
		TreeNode q4 = new TreeNode(4);
		TreeNode q5 = new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		q1.left = q3;
		q1.right = q2;
		q3.right = q5;
		q2.right = q4;
		SymmetricTrees s = new SymmetricTrees();
		System.out.println(s.symmetricBinaryTree(p1, q1));
		s.printTree(p1);
		s.printTree(q1);
		q3.right = null;
		System.out.println(s.symmetricBinaryTree(p1, q1));
		s.printTree(p1);
		s.printTree(q1);
		q3.right = new TreeNode(8);
		System.out.println(s.symmetricBinaryTree(p1, q1));
		s.printTree(p1);
		s.printTree(q1);
		
		TNode r1 = new TNode(1);
		TNode r2 = new TNode(2);
		r1.children.add(r2);
		r1.children.add(new TNode(3));
		r1.children.add(new TNode(4));
		r1.children.add(new TNode(5));
		r2.children.add(new TNode(6));
		r2.children.add(new TNode(7));
		TNode s1 = new TNode(1);
		TNode s2 = new TNode(2);
		s1.children.add(new TNode(5));
		s1.children.add(new TNode(4));
		s1.children.add(new TNode(3));
		s1.children.add(s2);
		s2.children.add(new TNode(7));
		s2.children.add(new TNode(6));
		
		System.out.println(s.symmetricTree(r1, s1));
		s.printTree(r1);
		s.printTree(s1);
		s2.children.remove(1);
		System.out.println(s.symmetricTree(r1, s1));
		s.printTree(r1);
		s.printTree(s1);
		s2.children.add(new TNode(8));
		System.out.println(s.symmetricTree(r1, s1));
		s.printTree(r1);
		s.printTree(s1);
	}

}
