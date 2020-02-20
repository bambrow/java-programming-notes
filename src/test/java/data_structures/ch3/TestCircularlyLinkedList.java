package data_structures.ch3;

public class TestCircularlyLinkedList {

	public static void main(String[] args) {
		CircularlyLinkedList<Integer> c = new CircularlyLinkedList<>();
		System.out.println(c);
		System.out.println("size: " + c.size());
		c.addFirst(5);
		System.out.println(c);
		System.out.println("size: " + c.size());
		c.addFirst(7).addLast(9).addFirst(11);
		System.out.println(c);
		System.out.println("size: " + c.size());
		c.addLast(13).rotate();
		System.out.println(c);
		System.out.println("size: " + c.size());
		System.out.println("removed: " + c.rotate().rotate().removeFirst());
		System.out.println(c);
		System.out.println("size: " + c.size());
	}
	
}
