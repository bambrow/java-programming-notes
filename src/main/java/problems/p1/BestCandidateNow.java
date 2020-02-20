package problems.p1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class BestCandidateNow {
	
	public String bestCandidateNow(List<String> names, List<Integer> votes, int T) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (!map.containsKey(name)) {
				map.put(name, 0);
			}
			if (votes.get(i) <= T) {
				map.put(name, map.get(name) + 1);
			}
		}
		int maxVote = 0;
		String maxName = null;
		for (String name : map.keySet()) {
			if (map.get(name) > maxVote) {
				maxVote = map.get(name);
				maxName = name;
			}
		}
		return maxName;
	}
	
	public List<String> bestTopKCandidateNow(List<String> names, List<Integer> votes, int T, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (!map.containsKey(name)) {
				map.put(name, 0);
			}
			if (votes.get(i) <= T) {
				map.put(name, map.get(name) + 1);
			}
		}
		LinkedList<String> list = new LinkedList<>();
		PriorityQueue<Entry<String, Integer>> pq = 
				new PriorityQueue<>( (a,b) -> (
						(a.getValue().compareTo(b.getValue()) == 0) ? 
								(b.getKey().compareTo(a.getKey())) : 
									(a.getValue().compareTo(b.getValue())
											)) );
		// Entry<K, V> we can only use getKey() and getValue() methods
		// we cannot directly access .key and .value fields
		for (Entry<String, Integer> entry : map.entrySet()) {
			pq.add(entry);
			if (pq.size() > k) {
				pq.remove();
			}
		}
		while (!pq.isEmpty()) {
			list.addFirst(pq.remove().getKey());
		}
		/*
		Iterator<Entry<String, Integer>> iter = pq.iterator();
		while (iter.hasNext()) {
			list.addFirst(iter.next().getKey());
		}
		*/
		// PriorityQueue iterator does not guarantee any particular order.
		// so using iterator is wrong here.
		return list;
	}

	public static void main(String[] args) {
		List<String> names = Arrays.asList("A", "B", "A", "C", "B", "D", "A", "C", "B", "D", "E", "C", "E", "E", "E", "C");
		List<Integer> votes = Arrays.asList(15, 12, 18, 12, 15, 15, 8, 10, 15, 20, 20, 20, 20, 20, 20, 20);
		BestCandidateNow bcn = new BestCandidateNow();
		System.out.println(bcn.bestCandidateNow(names, votes, 8));
		System.out.println(bcn.bestCandidateNow(names, votes, 12));
		System.out.println(bcn.bestCandidateNow(names, votes, 15));
		System.out.println(bcn.bestCandidateNow(names, votes, 20));
		// System.out.println(bcn.bestTopKCandidateNow(names, votes, 8, 3));
		System.out.println(bcn.bestTopKCandidateNow(names, votes, 12, 3));
		System.out.println(bcn.bestTopKCandidateNow(names, votes, 15, 3));
		System.out.println(bcn.bestTopKCandidateNow(names, votes, 20, 3));
	}

}
