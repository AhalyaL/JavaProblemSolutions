package slidingWindow;

public class LongRepeatingcahr {
	public static void main(String[] args) {
		String a = "aabab";
		System.out.println(characterReplacement(a.toUpperCase(), 3));
	}

	public static int characterReplacement(String s, int k) {
		char[] chars = new char[26];
		int wins = 0, max = 0, i = 0, maxCount = 0;

		while (i < s.length()) {
			maxCount = Math.max(maxCount, ++chars[s.charAt(i) - 'A']);

			int diffChars = i - wins - maxCount;
			if (diffChars >= k) {
				chars[s.charAt(wins) - 'A']--;
				wins++;
			}

			max = Math.max(max, i - wins + 1);
			i++;
		}

		return max;
	}

	public static int characterReplacement1(String s, int k) {
		int start = 0, max = 0, end = 0, currentLength = 0, dist = 0;
		char[] chars = new char[26];
		while (end < s.length()) {

			chars[s.charAt(end) - 'A']++;

			if (chars[s.charAt(end) - 'A'] == 1)
				dist++;

		//	System.out.println('1' + s.substring(start, end + 1));
			if (dist > k) {

				while (dist > k) {
			//		System.out.println('2' + s.substring(start, end + 1));
					chars[s.charAt(start) - 'A']--;

					if (chars[s.charAt(start) - 'A'] == 0)
						dist--;
					// end--;
					start++;
				}
				// System.out.println('3'+s.substring(start, end+1));

			}
			if (dist == k) {
				int i = start, dist1 = dist;
				//System.out.println('4' + s.substring(start, end + 1));

				char[] local = new char[26];

				for (int k1 = 0; k1 < chars.length; k1++) {
					local[k1] = chars[k1];
				}

				while (dist1 == k) {
					System.out.println(s.substring(i, end + 1));
					local[s.charAt(i) - 'A']--;

					if (local[s.charAt(i) - 'A'] == 0)
						dist1--;
					// end--;
					i++;
				}
				
			}

			end++;
		}

		return max;
	}

}
