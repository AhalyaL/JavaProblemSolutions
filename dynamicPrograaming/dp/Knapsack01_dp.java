package dynamicPrograaming.dp;

public class Knapsack01_dp {
	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120, 1000 };
		int wt[] = new int[] { 10, 20, 30, 60 };
		int W = 50;
		int[][] dp = new int[val.length + 1][W + 1];
		System.out.println(knapSack(W, wt, val, 0, dp));
	}

	private static int knapSack(int w, int[] wt, int[] val, int ind, int[][] dp) {

		for (int i = 0; i <= val.length; i++) {
			for (int j = 0; j <= w; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (wt[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);

			}
		}

		return dp[val.length][w];

	}
}
