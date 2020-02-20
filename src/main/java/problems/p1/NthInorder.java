package problems.p1;


public class NthInorder {
	
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
	
	public TreeNode nthInorder(TreeNode root, int k) {
		if (root == null || k <= 0 || k > root.num + 1) return null;
		int left = (root.left == null ? 0 : root.left.num + 1);
		if (k <= left) {
			return nthInorder(root.left, k);
		} else if (k == left + 1) {
			return root;
		} else {
			return nthInorder(root.right, k - left - 1);
		}
	}

	public static void main(String[] args) {
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
		NthInorder n = new NthInorder();
		for (int i = 0; i <= p1.num + 2; i++) {
			System.out.println(n.nthInorder(p1, i));
		}
	}

}
