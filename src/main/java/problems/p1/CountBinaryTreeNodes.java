package problems.p1;


import java.util.Stack;

public class CountBinaryTreeNodes {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	public int countBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int cnt = 0;
		Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        pushDownLeft(cur, stack);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            cnt++;
            pushDownLeft(cur.right, stack);
        }
        return cnt;
	}
	
	private void pushDownLeft(TreeNode cur, Stack<TreeNode> stack) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
	
	public int countBinaryTreeRecursive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countBinaryTreeRecursive(root.left) + countBinaryTreeRecursive(root.right);
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
		CountBinaryTreeNodes c = new CountBinaryTreeNodes();
		System.out.println(c.countBinaryTreeRecursive(p1));
		System.out.println(c.countBinaryTree(p1));
	}

}
