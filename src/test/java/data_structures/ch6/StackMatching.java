package data_structures.ch6;

public class StackMatching {
	
	/** Tests if delimiters in the given expression are properly matched. */
	public static boolean isDelimitersMatched(String exp) {
		final String opening = "({["; // opening delimiters
		final String closing = ")}]"; // closing delimiters
		Stack<Character> buffer = new LinkedStack<>();
		for (char c : exp.toCharArray()) {
			if (opening.indexOf(c) != -1) { // this is a left delimiter
				buffer.push(c);
			} else if (closing.indexOf(c) != -1) { // this is a right delimiter
				if (buffer.isEmpty()) { // nothing to match
					return false;
				}
				if (closing.indexOf(c) != opening.indexOf(buffer.pop())) { // mismatch
					return false;
				}
			}
		}
		return buffer.isEmpty(); // there might be remaining opening delimiters unmatched
	}
	
	/** Tests if every opening tag has a matching closing tag in HTML string. */
	public static boolean isHTMLTagsMatched(String html) {
		Stack<String> buffer = new LinkedStack<>();
		int j = html.indexOf('<'); // first index of '<'
		while (j != -1) {
			int k = html.indexOf('>', j+1); // find next '>'
			if (k == -1) {
				return false; // invalid tag
			}
			String tag = html.substring(j+1, k); // strip away < >
			if (!tag.startsWith("/")) { // opening tag
				buffer.push(tag);
			} else { // closing tag
				if (buffer.isEmpty()) {
					return false; // no tag to match
				}
				if (!tag.substring(1).equals(buffer.pop())) {
					return false; // mismatched tag
				}
			}
			j = html.indexOf('<', k+1); // find next '<'
		}
		return buffer.isEmpty(); // there might be remaining opening tags unmatched
	}

	public static void main(String[] args) {

		System.out.println(isDelimitersMatched("()(()){([()])}"));
		System.out.println(isDelimitersMatched("((()(()){([()])}))"));
		System.out.println(isDelimitersMatched("("));
		System.out.println(isDelimitersMatched(")(()){([()])}"));
		System.out.println(isDelimitersMatched("[(5+x)-(y+z)]"));
		
		System.out.println("------------------------------");
		
		System.out.println(isHTMLTagsMatched("<body><h1>hello</h1><p><center>how are you?</center></p></body>"));
		System.out.println(isHTMLTagsMatched("<body><h1>hello</h1><p><center>how are you?</center></p>"));
		
	}

}
