package problems.p1;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class ListInnerProductsWithRepeat {
	
	/*
	public static class MyEntry<K, V> implements Entry<K, V> {
	    private final K key;
	    private V value;
	    public MyEntry(final K key) {
	        this.key = key;
	    }
	    public MyEntry(final K key, final V value) {
	        this.key = key;
	        this.value = value;
	    }
	    public K getKey() {
	        return key;
	    }
	    public V getValue() {
	        return value;
	    }
	    public V setValue(final V value) {
	        final V oldValue = this.value;
	        this.value = value;
	        return oldValue;
	    }
	}
	*/
	
	public int listInnerProducts(List<Entry<String, Integer>> l1, List<Entry<String, Integer>> l2) {
		Map<String, List<Integer>> map1 = new HashMap<>();
		Map<String, List<Integer>> map2 = new HashMap<>();
		for (Entry<String, Integer> entry : l1) {
			String key = entry.getKey();
			if (!map1.containsKey(key)) {
				map1.put(key, new LinkedList<>());
			}
			map1.get(key).add(entry.getValue());
		}
		for (Entry<String, Integer> entry : l2) {
			String key = entry.getKey();
			if (!map2.containsKey(key)) {
				map2.put(key, new LinkedList<>());
			}
			map2.get(key).add(entry.getValue());
		}
		int sum = 0;
		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {
				for (int x : map1.get(key)) {
					for (int y : map2.get(key)) {
						sum += x * y;
					}
				}
			}
		}
		return sum;
	}
	

	public static void main(String[] args) {
		List<Entry<String, Integer>> l1 = new LinkedList<>();
		List<Entry<String, Integer>> l2 = new LinkedList<>();
		ListInnerProductsWithRepeat l = new ListInnerProductsWithRepeat();
		System.out.println(l.listInnerProducts(l1, l2));
		l1.add(new SimpleEntry<String, Integer>("apple", 1));
		l2.add(new SimpleEntry<String, Integer>("apple", 2));
		System.out.println(l.listInnerProducts(l1, l2));
		l1.add(new SimpleEntry<String, Integer>("bee", 3));
		l2.add(new SimpleEntry<String, Integer>("cat", 3));
		System.out.println(l.listInnerProducts(l1, l2));
		l1.add(new SimpleEntry<String, Integer>("apple", 4));
		l2.add(new SimpleEntry<String, Integer>("apple", 3));
		System.out.println(l.listInnerProducts(l1, l2));
		l1.add(new SimpleEntry<String, Integer>("bee", 2));
		l2.add(new SimpleEntry<String, Integer>("bee", 4));
		System.out.println(l.listInnerProducts(l1, l2));
	}

}
