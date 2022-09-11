package String;

public class LongestStringReplacement {
	public static void main(String[] args) {
		String a = "aabab";
		System.out.println(charReplacement(a.toUpperCase(), 3));
	}

	private static int charReplacement(String a, int k) {

		int j = 0, i = 0, max = 0, s = 0,result=0;
		char[] chars = new char[26];

		while (j < a.length() ) {
			max = Math.max(max, ++chars[a.charAt(j) - 'A']);

			s = j - i - max;

			if (s >= k) {
				chars[a.charAt(i) - 'A']--;
				i++;

			}
			result = Math.max(result, j-i+1);

			j++;
		}

		return result;
	}
}
