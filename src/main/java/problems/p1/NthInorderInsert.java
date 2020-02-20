package problems.p1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NthInorderInsert {
	
	public static class TreeNode {
		int val;
		int num;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x, int y) {
			val = x;
			num = y;
		}
		@Override
		public String toString() {
			return "(" + val + "," + num + ")";
		}
	}
	
	private List<TreeNode> nthInorder(TreeNode root, int k) {
		List<TreeNode> list = new ArrayList<>();
		if (root == null || k <= 0 || k > root.num + 1) return list;
		list.add(root);
		int left = (root.left == null ? 0 : root.left.num + 1);
		if (k <= left) {
			list.addAll(nthInorder(root.left, k));
		} else if (k > left + 1) {
			list.addAll(nthInorder(root.right, k - left - 1));
		}
		return list;
	}
	
	public TreeNode nthInorderInsert(TreeNode root, int k, TreeNode newNode) {
		if (root == null || k <= 0 || k > root.num + 2) return null;
		if (k == 1) {
			TreeNode cur = root;
			while (cur.left != null) {
				cur.num++;
				cur = cur.left;
			}
			cur.num++;
			cur.left = newNode;
			return root;
		}
		List<TreeNode> prevList = nthInorder(root, k-1);
		TreeNode prev = prevList.get(prevList.size() - 1);
		if (prev.right != null) {
			newNode.right = prev.right;
			newNode.num = prev.right.num + 1;
		}
		prev.right = newNode;
		for (TreeNode node : prevList) {
			node.num++;
		}
		return root;
	}
	
	public List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        pushDownLeft(cur, stack);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            list.add(cur);
            pushDownLeft(cur.right, stack);
        }
        return list;
    }
	
    private void pushDownLeft(TreeNode cur, Stack<TreeNode> stack) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
    
    private TreeNode getNewTree() {
    	TreeNode p1 = new TreeNode(5, 6);
		TreeNode p2 = new TreeNode(3, 2);
		TreeNode p3 = new TreeNode(7, 2);
		TreeNode p4 = new TreeNode(2, 0);
		TreeNode p5 = new TreeNode(4, 0);
		TreeNode p6 = new TreeNode(6, 0);
		TreeNode p7 = new TreeNode(8, 0);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = p6;
		p3.right = p7;
		return p1;
    }

	public static void main(String[] args) {
		NthInorderInsert n = new NthInorderInsert();
		for (int i = 0; i <= 9; i++) {
			System.out.println(n.inorderTraversal(n.nthInorderInsert(n.getNewTree(), i, new TreeNode(0, 0))));
		}
	}

}
