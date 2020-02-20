package problems.p1;


import java.util.ArrayList;
import java.util.List;

public class CarSwarm {
	
	public List<Integer> carSwarm(int[] cars) {
		List<Integer> list = new ArrayList<>();
		if (cars == null || cars.length == 0) {
			return list;
		}
		int swarmFirst = cars[0];
		int cnt = 1;
		for (int i = 1; i < cars.length; i++) {
			if (cars[i] >= swarmFirst) {
				cnt++;
			} else {
				list.add(cnt);
				swarmFirst = cars[i];
				cnt = 1;
			}
		}
		list.add(cnt);
		return list;
	}
	
	public List<List<Integer>> carSwarmFastest(int[] cars) {
		List<List<Integer>> list = new ArrayList<>();
		ArrayList<Integer> sub = (ArrayList<Integer>) carSwarm(cars);
		sub.add(0, 1);
		list.add(new ArrayList<Integer>(sub));
		sub.remove(0);
		for (int i = 0; i < sub.size(); i++) {
			sub.set(i, sub.get(i) + 1);
			list.add(new ArrayList<Integer>(sub));
			sub.set(i, sub.get(i) - 1);
		}
		return list;
	}

	public static void main(String[] args) {
		CarSwarm c = new CarSwarm();
		int[] arr1 = new int[] { 2,4,1,3 };
		int[] arr2 = new int[] { 5,4,8,9,6,2,1,4,8,5,6,3,2,1,4,7,8,5 };
		int[] arr3 = new int[] { 5,5,5,5,5,4,4,5,5,5,6,6,5,5,5,7,7,5,5,5,8,8,5,5,5,9,9,5,5,5,6,6,6,2,2,2,3,3,3,4,4,4,5,5,5,1,1,1 };
		System.out.println(c.carSwarm(arr1));
		System.out.println(c.carSwarm(arr2));
		System.out.println(c.carSwarm(arr3));
		System.out.println(c.carSwarmFastest(arr1));
		System.out.println(c.carSwarmFastest(arr2));
		System.out.println(c.carSwarmFastest(arr3));
	}

}
