package problems.p1;


public class FirstInvalidPrefix {
	
	public int firstInvalidPrefix(String[] dict, String prefix) {
		int lo = 0, hi = dict.length - 1;
		while (lo < hi) {
			int mid = lo + (hi-lo) / 2;
			if (!dict[lo].startsWith(prefix)) {
				return lo;
			} else if (dict[mid].startsWith(prefix)) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		String[] dict = { "aa", "aaa", "aaaa", "aab", "aac", "ax", "baa", "bx" };
		FirstInvalidPrefix f = new FirstInvalidPrefix();
		System.out.println(f.firstInvalidPrefix(dict, "aa"));
		System.out.println(f.firstInvalidPrefix(dict, "a"));
		System.out.println(f.firstInvalidPrefix(dict, "b"));
	}

}
