package String;

public class LongestSubStringWithoutRepeatingChars {
	public static void main(String[] args) {
		String s = "pwwkew";
		int val = lengthOfLongestSubstring(s);
		System.out.println(val);
	}

	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 1, max = 0;
		if (s == null || "".equals(s))
			return max;
		while (j < s.length()) {
			String n = s.substring(i, j);
			int in = n.indexOf(s.charAt(j));
			if (in != -1) {
				i = s.indexOf(s.charAt(j), i)+1;
				max = Math.max(max, n.length());
			}
			j++;
		}
		max = Math.max(max, s.substring(i, j).length());
		return max;
	}
}
