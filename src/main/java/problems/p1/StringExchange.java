package problems.p1;


public class StringExchange {
	
	public boolean stringExchange(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				sb1.append(s1.charAt(i));
				sb2.append(s2.charAt(i));
			}
		}
		if (sb1.length() != 2) return false;
		return (sb1.charAt(0) == sb2.charAt(1) && sb2.charAt(0) == sb1.charAt(1));
	}

	public static void main(String[] args) {
		StringExchange s = new StringExchange();
		System.out.println(s.stringExchange("abcdefg", "abdcefg"));
		System.out.println(s.stringExchange("abcdefg", "agcdefb"));
		System.out.println(s.stringExchange("abcdefg", "badcefg"));
	}

}
