package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupAnagram {
	public static void main(String[] args) {

		//String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		String[] strs = { "", "", "", "", "", " " };
		List<List<String>> l = groupAnagrams(strs);
		System.out.println(l);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = Arrays.toString(ch);
			if (hm.get(s) == null) {
				ArrayList<String> l = new ArrayList<String>();
				hm.put(s, l);
			}
			hm.get(s).add(str);
		}
		return hm.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

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
