package problems.p1;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CyclicIterator {
	
	LinkedList<Iterator<Integer>> iters;

	public CyclicIterator(List<List<Integer>> list) {
		iters = new LinkedList<>();
		for (List<Integer> li : list) {
			iters.addLast(li.iterator());
		}
	}
	
	public int next() {
		Iterator<Integer> iter = iters.removeFirst();
		int val = iter.next();
		if (iter.hasNext()) {
			iters.addLast(iter);
		}
		return val;
	}
	
	public boolean hasNext() {
		return !iters.isEmpty();
	}
	
	public static void main(String[] args) {
		List<List<Integer>> list = new LinkedList<>();
		list.add(Arrays.asList(1,4,7,10));
		list.add(Arrays.asList(2,5,8));
		list.add(Arrays.asList(3,6));
		CyclicIterator c = new CyclicIterator(list);
		while (c.hasNext()) {
			System.out.println(c.next());
		}
	}

}
