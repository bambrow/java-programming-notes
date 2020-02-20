package data_structures.ch3;

public class TestDoublyLinkedList {
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> d = new DoublyLinkedList<>();
		System.out.println(d);
		System.out.println("size: " + d.size());
		d.addFirst(3).addFirst(5).addLast(7).addLast(9);
		System.out.println(d);
		System.out.println("size: " + d.size());
		System.out.println("removed: " + d.removeFirst());
		System.out.println(d);
		System.out.println("size: " + d.size());
		System.out.println("removed: " + d.removeLast());
		System.out.println(d);
		System.out.println("size: " + d.size());
	}

}
