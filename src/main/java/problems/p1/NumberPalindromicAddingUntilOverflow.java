package problems.p1;


public class NumberPalindromicAddingUntilOverflow {
	
	public boolean numberPalindromicAdding(int k) {
		while (!isPalindromicNumber(k) && k > 0) {
			k += getPalindromicNumber(k);
		}
		return isPalindromicNumber(k);
	}
	
	private long getPalindromicNumber(int k) {
		StringBuilder str = new StringBuilder();
		str.append(k);
		return Long.parseLong(str.reverse().toString());
	}
	
	private boolean isPalindromicNumber(int k) {
		String str = String.valueOf(k);
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NumberPalindromicAddingUntilOverflow n = new NumberPalindromicAddingUntilOverflow();
		System.out.println(n.numberPalindromicAdding(123));
		System.out.println(n.numberPalindromicAdding(401));
		System.out.println(n.numberPalindromicAdding(1387));
		System.out.println(n.numberPalindromicAdding(2277));
		System.out.println(n.numberPalindromicAdding(16384));
		System.out.println(n.numberPalindromicAdding(99998));
		System.out.println(n.numberPalindromicAdding(2147483647));
	}

}
