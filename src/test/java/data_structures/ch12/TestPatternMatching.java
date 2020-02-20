package data_structures.ch12;

public class TestPatternMatching {

	public static void main(String[] args) {
		
		System.out.println(PatternMatching.findBruteForce("catdogandnothing", "ogandn"));
		System.out.println(PatternMatching.findKMP("catdogandnothing", "ogandn"));
		System.out.println(PatternMatching.findBruteForce("whatdowedonow", "dowedoo"));
		System.out.println(PatternMatching.findKMP("whatdowedonow", "dowedoo"));
		String text = "If we start with an initially empty heap, n successive calls to the insert operation will run in O(nlogn) time in the worst case. However, if all n key-value pairs to be stored in the heap are given in advance, such as during the first phase of the heap-sort algorithm, there is an alternative bottom-up construction method that runs in O(n) time.";
		String pattern = "alternative";
		System.out.println(PatternMatching.findBruteForce(text, pattern));
		System.out.println(PatternMatching.findKMP(text, pattern));
		
		// FIXME tests for other algorithms need to be added
		
	}

}
