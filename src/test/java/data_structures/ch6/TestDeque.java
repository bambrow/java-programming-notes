package data_structures.ch6;

public class TestDeque {
	
	public static void main(String[] args) {
		
		Deque<Integer> d1 = new ArrayDeque<>();
		System.out.println(d1);
		d1.addFirst(1).addLast(3).addFirst(5).addLast(7);
		System.out.println(d1);
		System.out.println("size: " + d1.size());
		System.out.println("removed: " + d1.removeFirst());
		System.out.println("removed: " + d1.removeLast());
		System.out.println(d1);
		d1.addFirst(9).addLast(11);
		System.out.println(d1);
		System.out.println("size: " + d1.size());
		System.out.println("first: " + d1.first());
		System.out.println("last: " + d1.last());
		
		System.out.println("-----------------------------------");
		
		Deque<Integer> d2 = new LinkedDeque<>();
		System.out.println(d2);
		d2.addFirst(1).addLast(3).addFirst(5).addLast(7);
		System.out.println(d2);
		System.out.println("size: " + d2.size());
		System.out.println("removed: " + d2.removeFirst());
		System.out.println("removed: " + d2.removeLast());
		System.out.println(d2);
		d2.addFirst(9).addLast(11);
		System.out.println(d2);
		System.out.println("size: " + d2.size());
		System.out.println("first: " + d2.first());
		System.out.println("last: " + d2.last());
		
	}

}
