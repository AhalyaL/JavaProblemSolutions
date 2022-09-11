package dynamicPrograaming.dp;

public class LongestCommonSubSequence {
	public static void main(String args[]) {

		String x = "AG";
		String y = "GXTXAYB";

		int m = x.length();
		int n = y.length();

		int[][] dp = new int[m + 1][n + 1];

		int val = longestCmnSubSequence(dp, m, n, x, y);
		System.out.println(val);

	}

	private static int longestCmnSubSequence(int[][] dp, int m, int n, String x, String y) {

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

		return dp[m][n];
	}
}
