package StringCombAndPerm;

public class StringPermutations {
	public static void main(String[] args) {

		String str = "ABC";

		backtrack(str, 0, str.length() - 1);
	}

	private static void backtrack(String s, int idx, int N) {
		if (idx == N)
			System.out.println(s);
		else {
			for (int i = idx; i <= N; i++) {
				s = swap(s, idx, i);
				backtrack(s, idx + 1, N);
				s = swap(s, idx, i);
			}
		}
	}

	private static String swap(String str, int fix, int i) {
		char temp = str.charAt(i);
		char tempFix = str.charAt(fix);
		str = str.substring(0, i) + tempFix + str.substring(i + 1);
		str = str.substring(0, fix) + temp + str.substring(fix + 1);
		return str;
	}

}
