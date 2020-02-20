package problems.p1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ListDifferenceSubstraction {
	
	public <T> List<T> listDifference(List<T> l1, List<T> l2) {
		Map<T, Integer> map = new HashMap<>();
		for (T ele : l1) {
			if (!map.containsKey(ele)) {
				map.put(ele, 0);
			}
			map.put(ele, map.get(ele) + 1);
		}
		for (T ele : l2) {
			if (map.containsKey(ele)) {
				map.put(ele, map.get(ele) - 1);
				if (map.get(ele) == 0) {
					map.remove(ele);
				}
			}
		}
		List<T> list = new ArrayList<>();
		for (T ele : map.keySet()) {
			int cnt = map.get(ele);
			for (int i = 0; i < cnt; i++) {
				list.add(ele);
			}
		}
		return list;
	}
	
	public <T extends Comparable<T>> List<T> listDifferenceNew(List<T> l1, List<T> l2) {
		Collections.sort(l1);
		Collections.sort(l2);
		List<T> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < l1.size() && j < l2.size()) {
			T e1 = l1.get(i);
			T e2 = l2.get(j);
			if (e1.equals(e2)) {
				i++;
				j++;
			} else if (e1.compareTo(e2) > 0) {
				j++;
			} else {
				list.add(e1);
				i++;
			}
		}
		while (i < l1.size()) {
			list.add(l1.get(i));
			i++;
		}
		return list;
	}

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(2,1,2,2);
		List<Integer> l2 = Arrays.asList(3,1,3,2,3);
		ListDifferenceSubstraction l = new ListDifferenceSubstraction();
		System.out.println(l.listDifference(l1, l2));
		System.out.println(l.listDifference(l2, l1));
		System.out.println(l.listDifferenceNew(l1, l2));
		System.out.println(l.listDifferenceNew(l2, l1));
	}

}
