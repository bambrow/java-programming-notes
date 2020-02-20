package problems.p1;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringDividedPatternMatch {
	
	public List<String> stringPatternReturn(List<String> input, String pattern) {
		List<String> list = new LinkedList<>();
		for (String str : input) {
			if (stringMatch(str, pattern)) {
				list.add(str);
			}
		}
		return list;
	}
	
	private boolean stringMatch(String str, String pattern) {
		int i = 0, j = 0;
		while (i < str.length() && j < pattern.length()) {
			if (str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}
		return j == pattern.length();
	}

	public static void main(String[] args) {
		List<String> input = Arrays.asList("FooBar", "FooBarTest", "FooBarRed", "FeeBar");
		StringDividedPatternMatch s = new StringDividedPatternMatch();
		System.out.println(s.stringPatternReturn(input, "FB"));
		System.out.println(s.stringPatternReturn(input, "FoB"));
		System.out.println(s.stringPatternReturn(input, "FoBT"));
	}

}
