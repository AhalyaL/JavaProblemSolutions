package dynamicPrograaming.recursion;

public class LongestCommonSubSeq_rec {
	public static void main(String args[]) {

		String x = "AYB";
		String y = "GXTXAYB";

		int m = x.length();
		int n = y.length();

		int val = longestCmnSubSequence(0, 0, x, y);
		System.out.println(val);

	}

	private static int longestCmnSubSequence(int m, int n, String x, String y) {

		if (m == x.length() || n == y.length())
			return 0;
		if (x.charAt(m) == y.charAt(n))
			return 1 + longestCmnSubSequence(m + 1, n + 1, x, y);
		else {
			return Math.max(longestCmnSubSequence(m + 1, n, x, y), longestCmnSubSequence(m, n + 1, x, y));
		}
	}
}
