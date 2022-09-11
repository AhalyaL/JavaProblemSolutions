package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramInAnotherString {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> l = findAnagrams(s, p);
		System.out.println(l);
	}

	public static List<Integer> findAnagrams(String s, String p) {
        
		List<Integer> l = new ArrayList<Integer>();
		if(s==null || p==null || s.length()==0 || p.length()==0) return l;
		char[] s2 = p.toCharArray();
		for (int i = 0, j = p.length(); i<= (s.length()-p.length()) && j <= s.length(); i++, j++) {
			String s1 = s.substring(i, j);
			if (checkAnagram(s1.toCharArray(), s2)) {
				l.add(i);
			}

		}

		return l;

	}

	private static boolean checkAnagram(char[] s1, char[] s2) {
		Arrays.sort(s1);
		Arrays.sort(s2);

		for (int k = 0; k < s1.length; k++) {
			if (s1[k] != s2[k])
				return false;
		}
		return true;

	}
}
