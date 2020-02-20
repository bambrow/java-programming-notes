package data_structures.ch10;

import java.util.Scanner;

import data_structures.ch9.Entry;

public class WordCount {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Map<String, Integer> freq = new ChainHashMap<>(); // or any concrete map
		// scan input for words, using all nonletters as delimiters
		Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
		while (doc.hasNext()) {
			String word = doc.next().toLowerCase(); // convert to lowercase
			Integer count = freq.get(word); // get the previous count for this word
			if (count == null) {
				count = 0; // if not in map, previous count is zero
			}
			freq.put(word, count+1); // assign new count for this word
		}
		int maxCount = 0;
		String maxWord = "no word";
		for (Entry<String, Integer> entry : freq.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxWord = entry.getKey();
				maxCount = entry.getValue();
			}
		}
		System.out.println("The most frequent word is " + maxWord);
		System.out.println("The count of this word is " + maxCount);
		doc.close();
	}

}
