package problems.p1;


import java.util.HashSet;
import java.util.Set;

public class ValidDecrementalWordDeletingOneByOne {
	
	public boolean decrementalWord(String word, Set<String> dict) {
		if (word.length() == 1) {
			return dict.contains(word);
		}
		if (!dict.contains(word)) {
			return false;
		}
		boolean valid = false;
		for (int i = 0; i < word.length(); i++) {
			String subword = word.substring(0, i) + ((i == word.length() - 1) ? "" : word.substring(i+1));
			valid = valid || decrementalWord(subword, dict);
		}
		return valid;
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("print");
		dict.add("pint");
		dict.add("pin");
		dict.add("in");
		dict.add("i");
		dict.add("pig");
		dict.add("pink");
		dict.add("ink");
		ValidDecrementalWordDeletingOneByOne d = new ValidDecrementalWordDeletingOneByOne();
		System.out.println(d.decrementalWord("print", dict));
		System.out.println(d.decrementalWord("pig", dict));
		System.out.println(d.decrementalWord("pink", dict));
	}

}
