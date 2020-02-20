package problems.p1;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class HeapTopK {
	
	public List<Integer> heapTopK(int[] heap, int k) {
		List<Integer> list = new LinkedList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> (b[1]-a[1]) );
		pq.add(new int[] { 0, heap[0] });
		while (k > 0) {
			int[] arr = pq.remove();
			list.add(arr[1]);
			k--;
			int left = leftChild(arr[0]);
			if (left < heap.length) {
				pq.add(new int[] { left, heap[left] });
			}
			int right = rightChild(arr[0]);
			if (right < heap.length) {
				pq.add(new int[] { right, heap[right] });
			}
		}
		return list;
	}
	
	public int leftChild(int j) {
		return j * 2 + 1;
	}
	public int rightChild(int j) {
		return j * 2 + 2;
	}
	public int parent(int j) {
		return (j - 1) / 2;
	}

	public static void main(String[] args) {
		int[] heap = { 16,14,10,8,7,9,3,2,4,1 };
		HeapTopK h = new HeapTopK();
		for (int k = 1; k <= heap.length; k++) {
			System.out.println(h.heapTopK(heap, k));
		}
	}

}
