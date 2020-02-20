package problems.p1;


public class RepeatedStringMatch {
	
	public int repeatedStringMatch(String A, String B) {
		StringBuilder str = new StringBuilder(A);
		while (str.length() < B.length()) {
			str.append(A);
		}
		int[] look = computeLookArrayForKMP(B);
		int index = 0;
		if (findMatchWithKMP(str, B, look, index)){
			return str.length() / A.length();
		}
		else {
			index = str.length()-B.length()+1;
			str.append(A);
			if (findMatchWithKMP(str, B, look, index)){
				return str.length() / A.length();
			}
		}
		return -1;
	}
	
	private boolean findMatchWithKMP(StringBuilder str, String B, int[] look, int index) {
		int i = index, j = 0; 
		while (i <= str.length()-B.length()+j && j < B.length()) {
			if (str.charAt(i) == B.charAt(j)) { 
				i++;
				j++; 
			} else if (j > 0) { 
				j = look[j-1];
			} else {
				i++;
			}
		}
		return (j == B.length()) ? true : false;
	}
	
	private int[] computeLookArrayForKMP(String B) {
		int[] look = new int[B.length()];
		int i = 1, j = 0;
		while (i < B.length()) { 
			if (B.charAt(i) == B.charAt(j)) {
				look[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = look[j-1];
			} else {
				i++;
			}
		}
		return look;
	}

	public static void main(String[] args) {
		RepeatedStringMatch r = new RepeatedStringMatch();
		System.out.println(r.repeatedStringMatch("abcd", "cdabcdab"));
	}

}
