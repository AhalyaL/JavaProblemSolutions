package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinWindowLength {
	public static void main(String[] args) {
		String s1 = "ADOBECODEBANC", s2 = "ABC";
		System.out.println(minWindow(s1, s2));
	}

	public static String minWindow(String s, String t) {

		Map<Character, Integer> m1 = new HashMap<>();
		Map<Character, Integer> m2 = new HashMap<>();
		for (char c : t.toCharArray()) {
			m2.merge(c, 1, Integer::sum);
		}
		int i = 0, min_win_start = 0, min_win_length = Integer.MAX_VALUE;
		for (int j = 0; j < s.length(); j++) {

			m1.put(s.charAt(j), m1.getOrDefault(s.charAt(j), 0) + 1);

			while (containsAll(m1, m2)) {

				if (min_win_length > j - i +1) {
					min_win_start = i;
					min_win_length = j - min_win_start;
				}
				m1.put(s.charAt(i), m1.get(s.charAt(i)) - 1);
				if (m1.get(s.charAt(i)) == 0)
					m1.remove(s.charAt(i));
				i++;

			}

		}

		return s.substring(min_win_start, min_win_start+min_win_length+1);

	}

	private static boolean containsAll(Map<Character, Integer> m1, Map<Character, Integer> m2) {
		for (Entry<Character, Integer> entry : m2.entrySet()) {

			Character key = entry.getKey();
			int value = entry.getValue();

			if (m1.get(key) == null || m1.get(key) < value) {
				return false;
			}

		}

		return true;
	}
}
