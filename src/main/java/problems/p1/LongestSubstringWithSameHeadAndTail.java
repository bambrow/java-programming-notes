package problems.p1;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameHeadAndTail {
	
	public int longestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
			} else {
				max = Math.max(max, i - map.get(c) + 1);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithSameHeadAndTail l = new LongestSubstringWithSameHeadAndTail();
		System.out.println(l.longestSubstring("abdcbe"));
		System.out.println(l.longestSubstring("abcddd"));
		System.out.println(l.longestSubstring("abracadabra"));
	}

}
