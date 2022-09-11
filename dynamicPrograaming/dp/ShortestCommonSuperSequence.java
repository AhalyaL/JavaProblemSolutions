package dynamicPrograaming.dp;

public class ShortestCommonSuperSequence {
	public static void main(String args[]) {

		String x = "AGGTB";
		String y = "GXTXAYB";
//	      String X = "AGGTB";
//	        String Y = "GXTXAYB";

		int m = x.length();
		int n = y.length();

		int[][] dp = new int[m + 1][n + 1];

		String lcs = longestCmnSubSequence(dp, m, n, x, y);
		int len = shortestCommonSuperSeq(0, 0, x, y, 0, lcs);
		System.out.println(len);

	}

	private static int shortestCommonSuperSeq(int i, int j, String x, String y, int k, String lcs) {
		StringBuilder sb = new StringBuilder();
		while (i < x.length() && j < y.length() && k < lcs.length()) {

			if (x.charAt(i) == lcs.charAt(k)) {

				while (y.charAt(j) != lcs.charAt(k)) {
					sb.append(y.charAt(j));
					j++;
				}

				sb.append(y.charAt(j));
				i++;
				k++;
				j++;

			} else {
				sb.append(x.charAt(i));
				i++;

			}

		}
		while (i < x.length()) {
			sb.append(x.charAt(i));
			i++;
		}
		while (j < y.length()) {
			sb.append(y.charAt(j));
			j++;
		}
		System.out.println(sb.toString());
		return sb.toString().length();
	}

	private static String longestCmnSubSequence(int[][] dp, int m, int n, String x, String y) {

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0)
					dp[i][j] = 0;

				else {

					if (x.charAt(i - 1) == y.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}

			}
		}

		int result = dp[m][n];
		char[] res = new char[result];
		int i = m, j = n;
		--result;
		while (i > 0 && j > 0 && result >= 0) {

			if (dp[i - 1][j] == dp[i][j - 1]) {

				if (dp[i][j] > dp[i - 1][j - 1]) {
					res[result] = x.charAt(i - 1);
					--result;

					--i;
					--j;

				} else {
					--i;
				}
			} else if (dp[i - 1][j] > dp[i][j - 1]) {

				--i;
			} else {
				--j;
			}

		}

		return new String(res);
	}
}
