package problems.p1;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CountRemainingTreesAfterDeletion {
	
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
	}
	
	public List<TreeNode> countRemainingTrees(TreeNode root, List<TreeNode> delete) {
		Set<TreeNode> set = new HashSet<>();
		Set<TreeNode> deleted = new HashSet<>();
		set.add(root);
		for (TreeNode node : delete) {
			set.remove(node);
			deleted.add(node);
			if (!deleted.contains(node.left)) {
				set.add(node.left);
			}
			if (!deleted.contains(node.right)) {
				set.add(node.right);
			}
		}
		set.remove(null);
		List<TreeNode> list = new LinkedList<>(set);
		return list;
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
		CountRemainingTreesAfterDeletion c = new CountRemainingTreesAfterDeletion();
		LinkedList<TreeNode> delete = new LinkedList<>();
		delete.addLast(p1);
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.addLast(p3);
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.addLast(p5);
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.addLast(p4);
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.addLast(p2);
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.removeFirst();
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.removeFirst();
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.removeFirst();
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.removeFirst();
		System.out.println(c.countRemainingTrees(p1, delete));
		delete.removeFirst();
		System.out.println(c.countRemainingTrees(p1, delete));
	}

}
