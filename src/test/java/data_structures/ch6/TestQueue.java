package data_structures.ch6;

public class TestQueue {

	public static void main(String[] args) {
		
		Queue<Integer> q1 = new ArrayQueue<>();
		System.out.println(q1);
		q1.enqueue(3).enqueue(5).enqueue(7);
		System.out.println(q1);
		System.out.println("size: " + q1.size());
		System.out.println("removed: " + q1.dequeue());
		System.out.println(q1);
		q1.enqueue(9).enqueue(11);
		System.out.println(q1);
		System.out.println("size: " + q1.size());
		System.out.println("removed: " + q1.dequeue());
		System.out.println(q1);
		
		System.out.println("-----------------------------------");

		Queue<Integer> q2 = new LinkedQueue<>();
		System.out.println(q2);
		q2.enqueue(3).enqueue(5).enqueue(7);
		System.out.println(q2);
		System.out.println("size: " + q2.size());
		System.out.println("removed: " + q2.dequeue());
		System.out.println(q2);
		q2.enqueue(9).enqueue(11);
		System.out.println(q2);
		System.out.println("size: " + q2.size());
		System.out.println("removed: " + q2.dequeue());
		System.out.println(q2);
		
	}

}
