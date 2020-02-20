package problems.p1;


import java.util.TreeSet;

public class KEmptySlots {
	
	public int kEmptySlots(int[] flowers, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		set.add(flowers.length+1);
		for (int i = 0; i < flowers.length; i++) {
			int slot = flowers[i];
			int lo = set.lower(slot);
			int hi = set.higher(slot);
			if (slot-lo-1 == k) return i + 1;
			if (hi-slot-1 == k) return i + 1;
			set.add(slot);
		}
		return -1;
	}
	
	public int kEmptySlotsTwo(int[] flowers, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < flowers.length; i++) {
			int slot = flowers[i];
			Integer lo = set.lower(slot);
			Integer hi = set.higher(slot);
			if (lo != null && slot-lo-1 == k) return i + 1;
			if (hi != null && hi-slot-1 == k) return i + 1;
			set.add(slot);
		}
		return -1;
	}
	
	public int kEmptySlotsUpdated(int[] flowers, int k) {
		int[] bloomOnDay = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++) {
			bloomOnDay[flowers[i]-1] = i+1;
		}
		int l = -1, r = k;
		int day = Integer.MAX_VALUE;
		for (int i = 0; r <= bloomOnDay.length; i++) {
			if (getDay(bloomOnDay, i) > getDay(bloomOnDay, l) && getDay(bloomOnDay, i) > getDay(bloomOnDay, r)) {
				continue;
			}
			if (i == r) {
				day = Math.min(day, Math.max(getDay(bloomOnDay, l), getDay(bloomOnDay, r)));
			}
			l = i;
			r = i+k+1;
		}
		return (day != Integer.MAX_VALUE) ? day : -1;
	}
	
	private int getDay(int[] bloomOnDay, int index) {
		if (index == -1 || index == bloomOnDay.length) return 0;
		return bloomOnDay[index];
	}
	
	public int kEmptySlotsTwoUpdated(int[] flowers, int k) {
		int[] bloomOnDay = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++) {
			bloomOnDay[flowers[i]-1] = i+1;
		}
		int l = 0, r = k+1;
		int day = Integer.MAX_VALUE;
		for (int i = 1; r < bloomOnDay.length; i++) {
			if (bloomOnDay[i] > bloomOnDay[l] && bloomOnDay[i] > bloomOnDay[r]) {
				continue;
			}
			if (i == r) {
				day = Math.min(day, Math.max(bloomOnDay[l], bloomOnDay[r]));
			}
			l = i;
			r = i+k+1;
		}
		return (day != Integer.MAX_VALUE) ? day : -1;
	}

	public static void main(String[] args) {

		KEmptySlots k = new KEmptySlots();
		int[] flowers = {1,3,2};
		System.out.println(k.kEmptySlotsTwo(flowers, 1));
		System.out.println(k.kEmptySlots(flowers, 1));
		System.out.println(k.kEmptySlotsTwoUpdated(flowers, 1));
		System.out.println(k.kEmptySlotsUpdated(flowers, 1));
		flowers = new int[] {1,2,3};
		System.out.println(k.kEmptySlotsTwo(flowers, 1));
		System.out.println(k.kEmptySlots(flowers, 1));
		System.out.println(k.kEmptySlotsTwoUpdated(flowers, 1));
		System.out.println(k.kEmptySlotsUpdated(flowers, 1));
		flowers = new int[] {6,5,8,9,7,1,10,2,3,4};
		System.out.println(k.kEmptySlotsTwo(flowers, 2));
		System.out.println(k.kEmptySlots(flowers, 2));
		System.out.println(k.kEmptySlotsTwoUpdated(flowers, 2));
		System.out.println(k.kEmptySlotsUpdated(flowers, 2));
		
	}

}
