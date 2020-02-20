package problems.p1;


public class StringNumberPatternMatch {
	
	public boolean stringPatternMatch(String pattern, String s) {
		int i = 0, j = 0;
		while (i < pattern.length() && j < s.length()) {
			char c = pattern.charAt(i);
			if (isDigit(c)) {
				int digit = c - '0';
				int k = i + 1;
				while (k < pattern.length() && isDigit(pattern.charAt(k))) {
					digit = digit * 10 + (pattern.charAt(k) - '0');
					k++;
				}
				i = k;
				j = j + digit;
			} else {
				if (c != s.charAt(j)) {
					return false;
				}
				i++;
				j++;
			}
		}
		return i == pattern.length() && j == s.length();
	}
	
	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String[] args) {
		StringNumberPatternMatch s = new StringNumberPatternMatch();
		System.out.println(s.stringPatternMatch("1oc3", "pocedc"));
		System.out.println(s.stringPatternMatch("1oc3", "podcdc"));
		System.out.println(s.stringPatternMatch("1o1c2c", "podcdcc"));
		System.out.println(s.stringPatternMatch("1o1c2c", "podcdc"));
		System.out.println(s.stringPatternMatch("a12b13", "apxpxpxpxpxpxbpxpxpxpxpxpxp"));
		System.out.println(s.stringPatternMatch("a12b13", "apxpxpxpxpxpxbpxpxpxppxpxp"));
		System.out.println(s.stringPatternMatch("a12b13", "apxpxpxpxxpxbpxpxpxpxpxpxp"));
		System.out.println(s.stringPatternMatch("a12b13", "apxpxpxppxpxbbpxpxpxpxpxpxp"));
	}

}
