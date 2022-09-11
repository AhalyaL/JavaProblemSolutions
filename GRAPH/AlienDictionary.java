package GRAPH;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class AlienDictionary {

	public static void main(String[] args) {

		String[] arr = { "caa", "aaa", "aab" };

		getAlienDict(arr);
	}

	private static void getAlienDict(String[] arr) {
		StringBuilder res = new StringBuilder();
		PriorityQueue<Character> result = new PriorityQueue<Character>();
		HashMap<Character, LinkedList<Character>> hm = new HashMap<Character, LinkedList<Character>>();
		int[] count = new int[26];
		Set<Character> letters = new HashSet<>();
		for (String s : arr) {
			for (char c : s.toCharArray()) {
				letters.add(c);
			}
		}

		for (int i = 0; i < arr.length - 1; i++) {
			String word = arr[i];
			String nextWord = arr[i + 1];
			for (int k = 0; k < Math.min(word.length(), nextWord.length()); k++) {
				if (word.charAt(k) != nextWord.charAt(k)) {
					if (hm.get(word.charAt(k)) == null) {
						hm.put(word.charAt(k), new LinkedList());

					}
					hm.get(word.charAt(k)).add(nextWord.charAt(k));
					count[nextWord.charAt(k) - 'a']++;
				}

			}

		}

		for (char c : letters) {
			if (count[c - 'a'] == 0)
				result.offer(c);
		}

		while (!result.isEmpty()) {
			char c = result.poll();
			res.append(c);

			if (hm.get(c)==null)
				continue;

			for (char ch : hm.get(c)) {
				if (--count[ch - 'a'] == 0)
					result.offer(ch);

			}

		}
      System.out.println(res.toString());
	}
}