package String;

public class longestPalindrom {
	public static void main(String[] args) {
		String s = "babdghhf";
		System.out.println(longestPalindrome(s));
	}

	private static String longestPalindrome(String s) {
		if (s.length() < 2)
		     	return s;

		int low = 0, high = 0, start = 0, length = 0;
		for (int i = 0; i < s.length(); i++) {
			low = i - 1;
			high = i + 1;
			while (low >= 0 && s.charAt(i) == s.charAt(low))
				low--;
			while (high < s.length() && s.charAt(i) == s.charAt(high))
				high++;
			while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
				low--;
				high++;

			}

			if (i != 0 && length < high - low - 1) {
				length = high - low - 1;
				start = low + 1;
			}
			//i++;
		}

		return s.substring(start, length + start);

	}
}