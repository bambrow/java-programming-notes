package problems.p1;


public class CompareAfterKeyboardDeletion {
	
	public boolean compareAfterKeyboardDeleting(String s1, String s2) {
		int i = s1.length()-1, j = s2.length()-1;
		while (i >= 0 && j >= 0) {
			if (s1.charAt(i) == '<') {
				int k = 1;
				while (--i >= 0 && s1.charAt(i) == '<') {
					k++;
				}
				i -= k;
			} else if (s2.charAt(j) == '<') {
				int k = 1;
				while (--j >= 0 && s2.charAt(j) == '<') {
					k++;
				}
				j -= k;
			} else {
				if (s1.charAt(i) != s2.charAt(j)) {
					return false;
				}
				i--;
				j--;
			}
		}
		if (i >= 0 && s1.charAt(i) == '<') {
			int k = 1;
			while (--i >= 0 && s1.charAt(i) == '<') {
				k++;
			}
			i -= k;
		}
		if (j >= 0 && s2.charAt(j) == '<') {
			int k = 1;
			while (--j >= 0 && s2.charAt(j) == '<') {
				k++;
			}
			j -= k;
		}
		return i < 0 && j < 0;
	}

	public static void main(String[] args) {
		CompareAfterKeyboardDeletion c = new CompareAfterKeyboardDeletion();
		System.out.println(c.compareAfterKeyboardDeleting("abc<c", "ab<bc"));
		System.out.println(c.compareAfterKeyboardDeleting("a<abb<<c", "abcd<<<ab<<c"));
		System.out.println(c.compareAfterKeyboardDeleting("<<a<abb<<c", "<abcd<<<ab<<c"));
		System.out.println(c.compareAfterKeyboardDeleting("abc<<<<", "cba<<<<<"));
		// System.out.println(c.compareAfterKeyboardDeleting("abc<ab<<<", "ab<bc<<<a"));
	}

}
