package data_structures.ch3;

public class TestSinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
		System.out.println(l);
		System.out.println("size: " + l.size());
		l.addFirst(5).addLast(7).addFirst(9).addLast(11);
		System.out.println(l);
		System.out.println("size: " + l.size());
		System.out.println("removed: " + l.removeFirst());
		System.out.println(l);
		System.out.println("size: " + l.size());
	}
	
}
