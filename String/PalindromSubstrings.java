package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PalindromSubstrings {
	public static void main(String[] args) {
		String s = "aaa";
		System.out.println(longestPalindrome(s));
	}

	private static List<String> longestPalindrome(String s) {
		List<String> hm = new ArrayList<String>();
		if (s.length() < 2) {
			hm.add(s);
		}

		int low = 0, high = 0;
		for (int i = 0; i < s.length(); i++) {
			hm.add(String.valueOf(s.charAt(i)));
			low = i - 1;
			high = i + 1;
			while (low >= 0 && s.charAt(i) == s.charAt(low)) {
				hm.add(s.substring(low, i + 1));
				low--;
			}
			while (high < s.length() && s.charAt(i) == s.charAt(high)) {
				hm.add(s.substring(i, high + 1));
				high++;
			}
			while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
				hm.add(s.substring(low, high + 1));
				low--;
				high++;

			}

		}

		return hm;

	}
}