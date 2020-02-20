package problems.p1;


import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayAddedUpToZero {
	
	public int longestSubarray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] sums = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sums[i+1] += (sums[i] + nums[i]);
		}
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < sums.length; i++) {
			if (!map.containsKey(sums[i])) {
				map.put(sums[i], i);
			} else {
				max = Math.max(max, i - map.get(sums[i]));
			}
		}
		return max;
	}
	
	public int longestSubarrayUpToK(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] sums = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sums[i+1] += (sums[i] + nums[i]);
		}
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < sums.length; i++) {
			if (!map.containsKey(sums[i])) {
				map.put(sums[i], i);
			}
			if (map.containsKey(sums[i] - k)) {
				max = Math.max(max, i - map.get(sums[i] - k));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubarrayAddedUpToZero l = new LongestSubarrayAddedUpToZero();
		System.out.println(l.longestSubarray(new int[] { -1, 1, -2, 2, -3, 3 }));
		System.out.println(l.longestSubarray(new int[] { -1, 1, -2, 1, 2, -3, 3 }));
		System.out.println(l.longestSubarray(new int[] { -1, 1, -2, 2, 2, -3, 3 }));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 2, -3, 3 }, 0));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 1, 2, -3, 3 }, 0));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 2, 2, -3, 3 }, 0));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 2, -3, 3 }, -1));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 1, 2, -3, 3 }, -1));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 2, 2, -3, 3 }, -1));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 2, -3, 3 }, 1));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 1, 2, -3, 3 }, 1));
		System.out.println(l.longestSubarrayUpToK(new int[] { -1, 1, -2, 2, 2, -3, 3 }, 1));
	}

}
