package data_structures.ch6;

public class Josephus {

	/**
	 * Computes the winner of the Josephus problem using a circular queue.
	 */
	public static <E> E runJosephus(CircularQueue<E> queue, int k) {
		if (queue.isEmpty()) {
			return null;
		}
		while (queue.size() > 1) {
			for (int i = 0; i < k-1; i++) {
				queue.rotate(); // skip past k-1 elements
			}
			E e = queue.dequeue(); // remove the front element
			System.out.println("    " + e.toString() + " is out");
		}
		return queue.dequeue();
	}
	
	/**
	 * Builds a circular queue from an array of objects.
	 */
	public static <E> CircularQueue<E> buildQueue(E a[]) {
		CircularQueue<E> queue = new LinkedCircularQueue<>();
		for (int i = 0; i < a.length; i++) {
			queue.enqueue(a[i]);
		}
		return queue;
	}
	
	/**
	 * Tester method
	 */
	public static void main(String[] args) {
		String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
		String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
		String[] a3 = {"Mike", "Roberto"};
		System.out.println("First winner is " + runJosephus(buildQueue(a1), 3));
		System.out.println("Second winner is " + runJosephus(buildQueue(a2), 10));
		System.out.println("Third winner is " + runJosephus(buildQueue(a3), 7));
	}
	
}
