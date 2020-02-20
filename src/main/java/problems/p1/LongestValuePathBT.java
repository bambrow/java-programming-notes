package problems.p1;


import java.util.Queue;
import java.util.LinkedList;

public class LongestValuePathBT {
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) {
			this.val = x;
			this.left = null;
			this.right = null;
		}
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(this);
			while (!queue.isEmpty()) {
				TreeNode cur = queue.poll();
				if (cur == null) {
					str.append(-1);
				} else {
					str.append(cur.val);
					queue.offer(cur.left);
					queue.offer(cur.right);
				}
				str.append(" ");
			}
			return str.toString();
		}
	}
	
	private int val = 0;
	
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        depthSameValue(root, root.val);
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);
        return val;
    }
    
    private int depthSameValue(TreeNode node, int value) {
        if (node == null || node.val != value) return 0;
        int l = depthSameValue(node.left, value);
        int r = depthSameValue(node.right, value);
        val = Math.max(val, l + r);
        return Math.max(l, r) + 1;
    }
    
    // assume all the val of nodes are larger or equal than 0
    // so, -1 is used to represent null node
    public TreeNode constructTree(int[] arr) {
    	if (arr.length == 0) return null;
		TreeNode root = constructNode(arr[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int prev = queue.size()*2, i = 1;
		while (i < arr.length) {
			for (int j = 0; j < prev; j++,i+=2) {
				TreeNode cur = queue.poll();
				TreeNode left = i < arr.length ? constructNode(arr[i]) : null;
				TreeNode right = i+1 < arr.length ? constructNode(arr[i+1]) : null;
				if (left != null) {
					cur.left = left;
					queue.offer(left);
				}
				if (right != null) {
					cur.right = right;
					queue.offer(right);
				}
			}
			prev = queue.size()*2;
		}
		return root;
	}
    
    private TreeNode constructNode(int v) {
    	if (v < 0) return null;
    	return new TreeNode(v);
    }

	public static void main(String[] args) {
		LongestValuePathBT l1 = new LongestValuePathBT();
		TreeNode r1 = l1.constructTree(new int[] {5,4,5,1,1,-1,5});
		System.out.println(r1.toString());
		System.out.println(l1.longestUnivaluePath(r1));
		
		LongestValuePathBT l2 = new LongestValuePathBT();
		TreeNode r2 = l2.constructTree(new int[] {1,3,2,2,1,3,-1,2,4,3,-1,3,2,4,2,-1,4,1,3,-1,3,2,-1,5,-1,2,3,4,-1,3,1,3,1,-1,-1,-1,2});
		System.out.println(r2.toString());
		System.out.println(l2.longestUnivaluePath(r2));
		
		LongestValuePathBT l3 = new LongestValuePathBT();
		TreeNode r3 = l3.constructTree(new int[] {1,4,5,4,4,-1,5,-1,-1,3,3,2});
		System.out.println(r3.toString());
		System.out.println(l3.longestUnivaluePath(r3));
	}

}
