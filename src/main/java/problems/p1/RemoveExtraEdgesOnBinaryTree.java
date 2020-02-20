package problems.p1;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveExtraEdgesOnBinaryTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	public void removeExtraEdges(TreeNode root) {
		Set<TreeNode> set = new HashSet<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
        pushDownLeft(cur, null, true, stack, set);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            pushDownLeft(cur.right, cur, false, stack, set);
        }
	}
	
	private void pushDownLeft(TreeNode cur, TreeNode prev, boolean left, Stack<TreeNode> stack, Set<TreeNode> set) {
		while (cur != null) {
			if (set.contains(cur)) {
				if (left) {
					prev.left = null;
				} else {
					prev.right = null;
				}
				break;
			} else {
				stack.push(cur);
	            set.add(cur);
	            prev = cur;
	            left = true;
	            cur = cur.left;
			}
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
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p2.right = p5;
		p3.right = p4;
		p4.left = p1;
		p5.left = p3;
		p4.right = p3;
		p5.right = p1;
		RemoveExtraEdgesOnBinaryTree r = new RemoveExtraEdgesOnBinaryTree();
		// r.printTree(p1);
		r.removeExtraEdges(p1);
		r.printTree(p1);
	}

}
