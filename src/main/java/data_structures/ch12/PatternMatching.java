package data_structures.ch12;

public class PatternMatching {

	/**
	 * Returns the lowest index at which substring pattern begins in text (or else, -1).
	 * O(m*n)
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static int findBruteForce(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		for (int i = 0; i <= n-m; i++) { // try every starting index
			int j = 0; // index of the pattern string
			while (j < m && text.charAt(i+j) == pattern.charAt(j)) { // while there is a match
				j++;
			}
			if (j == m) return i; // if we reach the end of pattern, then there must be a match
		}
		return -1; // search completes and fails
	}
	
	public static int findBruteForceTwo(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int i = 0, j = 0;
		for ( ; i < n && j < m; i++) {
			if (text.charAt(i) == pattern.charAt(j)) {
				j++;
			} else {
				i -= j; // reset i, notice that because of i++, the whole effect will lead i to the next char
				j = 0; // reset j
			}
		}
		if (j == m) return i - m; // there is a match (in this case the loop ended by satisfying j == m)
		else return -1; // no match
	}
	
	/**
	 * Returns the lowest index at which substring pattern begins in text (or else, -1).
	 * O(m+n)
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static int findKMP(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		if (m == 0 || n < m) return -1;
		int[] fail = computeFailKMP(pattern); // obtain fail array
		int i = 0, j = 0; // i is index to text and j is index to pattern
		while (i < n) {
			if (text.charAt(i) == pattern.charAt(j)) { // pattern[0..j] matched thus far
				if (j == m-1) return i-m+1; // match is complete; return the starting index
				i++;
				j++; // increment both i and j
			} else if (j > 0) { // mismatch; move j to the correct place, if applicable
				j = fail[j-1];
			} else { // no match and we have to start over; no saved information is useful
				i++;
			}
		}
		return -1;
	}
	
	private static int[] computeFailKMP(String pattern) {
		int m = pattern.length();
		int[] fail = new int[m]; // by default, all overlaps are 0
		int i = 1, j = 0;
		while (i < m) { // compute fail[i] during this pass, if nonzero
			if (pattern.charAt(i) == pattern.charAt(j)) { // we have j+1 chars matched thus far
				fail[i] = j + 1;
				i++;
				j++; // increment both i and j
			} else if (j > 0) { // mismatch; but we might find a smaller match, so jump to the matching place of fail[j-1]
				j = fail[j-1]; // for more explanation please read the textbook
			} else { // no match found starting at i
				i++;
			}
		}
		return fail;
	}
	
	// TODO Boyer-Moore
	
}
