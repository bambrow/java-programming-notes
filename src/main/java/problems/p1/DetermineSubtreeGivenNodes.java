package problems.p1;


import java.util.Stack;

public class DetermineSubtreeGivenNodes {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
		@Override
		public String toString() {
			return "" + val;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TreeNode other = (TreeNode) obj;
			if (val != other.val)
				return false;
			return true;
		}
	}
	
	public boolean predictSubTrees(TreeNode root, TreeNode sub) {
		TreeNode node = findNode(root, sub);
		if (node == null) {
			return false;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		TreeNode cur1 = node;
		TreeNode cur2 = sub;
		pushDownLeft(cur1, s1);
		pushDownLeft(cur2, s2);
		while (!s1.isEmpty() && !s2.isEmpty()) {
			cur1 = s1.pop();
			cur2 = s2.pop();
			if (!cur1.equals(cur2)) {
				return false;
			}
			pushDownLeft(cur1.right, s1);
			pushDownLeft(cur2.right, s2);
		}
		return s1.isEmpty() && s2.isEmpty();
	}
	
	private TreeNode findNode(TreeNode root, TreeNode sub) {
		Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        pushDownLeft(cur, stack);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.equals(sub)) {
				return cur;
			}
            pushDownLeft(cur.right, stack);
        }
        return null;
	}
	
	private void pushDownLeft(TreeNode cur, Stack<TreeNode> stack) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
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
		q1.left = q2;
		q1.right = q3;
		q2.left = q4;
		q3.left = q5;
		DetermineSubtreeGivenNodes p = new DetermineSubtreeGivenNodes();
		p.printTree(p1);
		System.out.println(p.predictSubTrees(p1, p1));
		System.out.println(p.predictSubTrees(p1, p2));
		System.out.println(p.predictSubTrees(p1, p5));
		p.printTree(q1);
		System.out.println(p.predictSubTrees(p1, q1));
		System.out.println(p.predictSubTrees(p1, q2));
		System.out.println(p.predictSubTrees(p1, q5));
		q2.left = null;
		p.printTree(q1);
		System.out.println(p.predictSubTrees(p1, q1));
		System.out.println(p.predictSubTrees(p1, q5));
	}

}
