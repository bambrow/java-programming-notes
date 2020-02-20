package problems.p1;


public class RemoveForbiddenChar {
	
	public String removeForbiddenCharInString(String s, char c) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != c) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public String removeForbiddenCharInArray(char[] s, char c) {
		int i = 0, j = 0;
		while (i < s.length) {
			if (s[i] != c) {
				s[j] = s[i];
				j++;
			}
			i++;
		}
		return new String(s, 0, j);
	}
	
	public static void main(String[] args) {
		RemoveForbiddenChar r = new RemoveForbiddenChar();
		System.out.println(r.removeForbiddenCharInString("abacadae", 'a'));
		System.out.println(r.removeForbiddenCharInString("abacadae", 'f'));
		System.out.println(r.removeForbiddenCharInArray("abacadae".toCharArray(), 'a'));
		System.out.println(r.removeForbiddenCharInArray("abacadae".toCharArray(), 'f'));
	}

}
