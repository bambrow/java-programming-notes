package data_structures.ch6;

public class TestCircularQueue {

	public static void main(String[] args) {
		
		CircularQueue<Integer> q = new LinkedCircularQueue<>();
		System.out.println(q);
		q.enqueue(3).enqueue(5).enqueue(7);
		System.out.println(q);
		System.out.println("size: " + q.size());
		System.out.println("removed: " + q.dequeue());
		System.out.println(q);
		q.enqueue(9).enqueue(11).rotate();
		System.out.println(q);
		System.out.println("size: " + q.size());
		System.out.println("removed: " + q.rotate().dequeue());
		System.out.println(q);
		
	}
	
}
