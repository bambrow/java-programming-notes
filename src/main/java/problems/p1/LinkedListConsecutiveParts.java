package problems.p1;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LinkedListConsecutiveParts {
	
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
	
	public int linkedListConsecutiveParts(List<ListNode> list) {
		Set<ListNode> set = new HashSet<>();
		for (ListNode node : list) {
			set.add(node);
		}
		int size = set.size();
		for (ListNode node : list) {
			if (set.contains(node.next)) {
				size--;
			}
		}
		return size;
	}

	public static void main(String[] args) {
		LinkedListConsecutiveParts l = new LinkedListConsecutiveParts();
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(7);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(8);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(5);
		ListNode n8 = new ListNode(1);
		ListNode n9 = new ListNode(3);
		n1.next = n8;
		n8.next = n4;
		n4.next = n9;
		n9.next = n2;
		n2.next = n7;
		n7.next = n6;
		n6.next = n3;
		n3.next = n5;
		List<ListNode> list = new LinkedList<>();
		list.add(n4);
		System.out.println(l.linkedListConsecutiveParts(list));
		list.add(n2);
		System.out.println(l.linkedListConsecutiveParts(list));
		list.add(n5);
		System.out.println(l.linkedListConsecutiveParts(list));
		list.add(n3);
		System.out.println(l.linkedListConsecutiveParts(list));
		list.add(n9);
		System.out.println(l.linkedListConsecutiveParts(list));
		list.add(n1);
		System.out.println(l.linkedListConsecutiveParts(list));
		list.add(n8);
		System.out.println(l.linkedListConsecutiveParts(list));
		list.add(n6);
		System.out.println(l.linkedListConsecutiveParts(list));
		list.add(n7);
		System.out.println(l.linkedListConsecutiveParts(list));
	}

}
